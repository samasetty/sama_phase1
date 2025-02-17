package decaf;

import decaf.utils.CommandLineInterface;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecafCompiler {

    static boolean hadError = false;
    static String inputFilename = "";

    private static void printTokens(List<DecafToken> tokens, OutputStream outputStream) {
        PrintStream ps = (outputStream instanceof PrintStream)
                ? (PrintStream) outputStream
                : new PrintStream(outputStream);

        for (DecafToken token : tokens) {
            if (token.tokenType == DecafTokenType.EOF) continue; // skip EOF

            switch (token.tokenType) {
                case LONGLITERAL, INTLITERAL, STRINGLITERAL, CHARLITERAL, BOOLEANLITERAL ->
                    ps.printf("%d %s %s%n", token.line, token.tokenType, token.lexeme);

                case IDENTIFIER ->
                    ps.printf("%d IDENTIFIER %s%n", token.line, token.lexeme);

                case INT, LONG, BOOL, IF, ELSE, FOR, WHILE, RETURN,
                     BREAK, CONTINUE, IMPORT, VOID, LEN ->
                    // Print the keyword as is, e.g. "int", "bool", etc.
                    ps.printf("%d %s%n", token.line, token.lexeme);

                default ->
                    // Operators, punctuation, etc.
                    ps.printf("%d %s%n", token.line, token.lexeme);
            }
        }
    }

    public static void main(String[] args) {
        CommandLineInterface.parse(args, new String[0]);

        try (InputStream inputStream =
                (CommandLineInterface.infile == null)
                   ? System.in
                   : Files.newInputStream(Path.of(CommandLineInterface.infile));
             OutputStream outputStream =
                (CommandLineInterface.outfile == null)
                   ? System.out
                   : new FileOutputStream(CommandLineInterface.outfile)) {

            inputFilename = (CommandLineInterface.infile == null)
                ? "<stdin>"
                : CommandLineInterface.infile;

            String source = readAll(inputStream);

            switch (CommandLineInterface.target) {
                case SCAN -> {
                    DecafScanner scanner = new DecafScanner(source);
                    List<DecafToken> tokens = scanner.scanTokens();
                    if (!hadError) {
                        printTokens(tokens, outputStream);
                    } else {
                        System.exit(1);
                    }
                }
                case PARSE -> { /* Placeholder for parser */ }
                case INTER -> { /* Placeholder for IR gen */ }
                case ASSEMBLY -> { /* Placeholder for assembly gen */ }
            }

        } catch (IOException ioe) {
            System.err.printf("IOException reading '%s': %s%n", inputFilename, ioe.getMessage());
            System.exit(1);
        }
    }

    private static String readAll(InputStream in) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] tmp = new byte[4096];
        int n;
        while ((n = in.read(tmp)) != -1) {
            buffer.write(tmp, 0, n);
        }
        return buffer.toString();
    }

    public static void error(int line, int column, String message) {
        System.err.printf("%s line %d:%d: %s%n", inputFilename, line, column, message);
        hadError = true;
    }
}

// ------------------------------------------------------------------
// Token Types
// ------------------------------------------------------------------
enum DecafTokenType {
    // Basic language constructs
    IDENTIFIER,

    // Literals
    INTLITERAL,
    LONGLITERAL,
    CHARLITERAL,
    STRINGLITERAL,
    BOOLEANLITERAL,

    // Keywords
    INT, LONG, BOOL, IF, ELSE, FOR, WHILE, RETURN, BREAK, CONTINUE,
    IMPORT, VOID, LEN,

    // Operators
    PLUS, MINUS, STAR, SLASH, PERCENT,
    EQUAL, PLUS_EQUAL, MINUS_EQUAL, STAR_EQUAL, SLASH_EQUAL, PERCENT_EQUAL,
    EQUAL_EQUAL, BANG_EQUAL, GREATER, GREATER_EQUAL, LESS, LESS_EQUAL,
    AND_AND, OR_OR, BANG, PLUS_PLUS, MINUS_MINUS,
    LEFT_PAREN, RIGHT_PAREN, LEFT_BRACE, RIGHT_BRACE,
    LEFT_BRACKET, RIGHT_BRACKET, SEMICOLON, COMMA,
    EOF
}

class DecafToken {
    final DecafTokenType tokenType;
    final String lexeme;
    final Object literal;
    final int line;
    final int column;

    DecafToken(DecafTokenType tokenType, String lexeme, Object literal,
               int line, int column) {
        this.tokenType = tokenType;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
        this.column = column;
    }

    public String toString() {
        return String.format("%s %s (line %d, col %d)",
                tokenType, lexeme, line, column);
    }
}

// ------------------------------------------------------------------
// Scanner
// ------------------------------------------------------------------
class DecafScanner {
    private final String source;
    private final List<DecafToken> tokens = new ArrayList<>();

    private int start = 0;
    private int current = 0;
    private int line = 1;
    private int col = 1;

    // We do NOT include "true" / "false" here. They are recognized as BOOLEANLITERAL
    private static final Map<String, DecafTokenType> keywords = new HashMap<>();
    static {
        keywords.put("int", DecafTokenType.INT);
        keywords.put("long", DecafTokenType.LONG);
        keywords.put("bool", DecafTokenType.BOOL);
        keywords.put("if", DecafTokenType.IF);
        keywords.put("else", DecafTokenType.ELSE);
        keywords.put("for", DecafTokenType.FOR);
        keywords.put("while", DecafTokenType.WHILE);
        keywords.put("return", DecafTokenType.RETURN);
        keywords.put("break", DecafTokenType.BREAK);
        keywords.put("continue", DecafTokenType.CONTINUE);
        keywords.put("import", DecafTokenType.IMPORT);
        keywords.put("void", DecafTokenType.VOID);
        keywords.put("len", DecafTokenType.LEN);
    }

    DecafScanner(String source) {
        this.source = source;
    }

    List<DecafToken> scanTokens() {
        while (!isAtEnd()) {
            start = current;
            scanToken();
        }
        tokens.add(new DecafToken(DecafTokenType.EOF, "", null, line, col));
        return tokens;
    }

    private void scanToken() {
        char c = advance();
        switch (c) {
            case '(' -> addToken(DecafTokenType.LEFT_PAREN);
            case ')' -> addToken(DecafTokenType.RIGHT_PAREN);
            case '{' -> addToken(DecafTokenType.LEFT_BRACE);
            case '}' -> addToken(DecafTokenType.RIGHT_BRACE);
            case '[' -> addToken(DecafTokenType.LEFT_BRACKET);
            case ']' -> addToken(DecafTokenType.RIGHT_BRACKET);
            case ';' -> addToken(DecafTokenType.SEMICOLON);
            case ',' -> addToken(DecafTokenType.COMMA);
            case '+' -> {
                if (match('+')) addToken(DecafTokenType.PLUS_PLUS);
                else if (match('=')) addToken(DecafTokenType.PLUS_EQUAL);
                else addToken(DecafTokenType.PLUS);
            }
            case '-' -> {
                if (match('-')) addToken(DecafTokenType.MINUS_MINUS);
                else if (match('=')) addToken(DecafTokenType.MINUS_EQUAL);
                else addToken(DecafTokenType.MINUS);
            }
            case '*' -> {
                if (match('=')) addToken(DecafTokenType.STAR_EQUAL);
                else addToken(DecafTokenType.STAR);
            }
            case '/' -> {
                if (match('/')) {
                    // line comment
                    while (!isAtEnd() && peek() != '\n') advance();
                } else if (match('*')) {
                    // block comment
                    while (!isAtEnd()) {
                        if (peek() == '*' && peekNext() == '/') {
                            advance();
                            advance();
                            break;
                        }
                        if (peek() == '\n') {
                            line++;
                            col = 0;
                        }
                        advance();
                    }
                } else if (match('=')) addToken(DecafTokenType.SLASH_EQUAL);
                else addToken(DecafTokenType.SLASH);
            }
            case '%' -> {
                if (match('=')) addToken(DecafTokenType.PERCENT_EQUAL);
                else addToken(DecafTokenType.PERCENT);
            }
            case '!' -> {
                if (match('=')) addToken(DecafTokenType.BANG_EQUAL);
                else addToken(DecafTokenType.BANG);
            }
            case '=' -> {
                if (match('=')) addToken(DecafTokenType.EQUAL_EQUAL);
                else addToken(DecafTokenType.EQUAL);
            }
            case '<' -> {
                if (match('=')) addToken(DecafTokenType.LESS_EQUAL);
                else addToken(DecafTokenType.LESS);
            }
            case '>' -> {
                if (match('=')) addToken(DecafTokenType.GREATER_EQUAL);
                else addToken(DecafTokenType.GREATER);
            }
            case '&' -> {
                if (match('&')) addToken(DecafTokenType.AND_AND);
                else DecafCompiler.error(line, col, "Unexpected character '&'. Maybe '&&'?");
            }
            case '|' -> {
                if (match('|')) addToken(DecafTokenType.OR_OR);
                else DecafCompiler.error(line, col, "Unexpected character '|'. Maybe '||'?");
            }
            case ' ', '\r', '\t', '\f' -> { /* skip whitespace */ }
            case '\n' -> {
                line++;
                col = 0;
            }
            case '"' -> scanStringLiteral();
            case '\'' -> scanCharLiteral();

            default -> {
                if (isDigit(c)) {
                    scanNumberOrLongLiteral(c);
                } else if (isAlpha(c)) {
                    scanIdentifierOrKeyword();
                } else {
                    DecafCompiler.error(line, col,
                        "Unexpected character '" + c + "'.");
                }
            }
        }
    }

    // ---------- BOOLEANS & KEYWORDS ----------
    // For "true"/"false", we yield BOOLEANLITERAL. For "int"/"bool" etc., we yield keywords.
    private void scanIdentifierOrKeyword() {
        while (isAlphaNumeric(peek())) {
            advance();
        }
        String text = source.substring(start, current);
        
        // If it's "true" or "false", treat it as a BOOLEANLITERAL
        if (text.equals("true") || text.equals("false")) {
            addToken(DecafTokenType.BOOLEANLITERAL, text);
            return;
        }
        // Otherwise, check if it's a known keyword
        DecafTokenType type = keywords.getOrDefault(text, DecafTokenType.IDENTIFIER);
        addToken(type, text);
    }

    // ---------- STRING LITERAL ---------------
    private void scanStringLiteral() {
        StringBuilder sb = new StringBuilder();
        sb.append('"'); // opening quote

        while (!isAtEnd()) {
            char c = peek();
            if (c == '"') {
                // closing quote
                advance();
                sb.append('"');
                addToken(DecafTokenType.STRINGLITERAL, sb.toString());
                return;
            }
            if (c == '\n') {
                DecafCompiler.error(line, col, "Unterminated string literal before newline.");
                advance();
                return;
            }
            if (c == '\\') {
                advance(); // consume '\'
                if (isAtEnd()) {
                    DecafCompiler.error(line, col, "Unfinished escape at EOF.");
                    return;
                }
                char esc = peek();
                switch (esc) {
                    case '"':
                        sb.append("\\\"");
                        advance();
                        break;
                    case '\\':
                        sb.append("\\\\");
                        advance();
                        break;
                    case 't':
                        sb.append("\\t");
                        advance();
                        break;
                    case 'n':
                        sb.append("\\n");
                        advance();
                        break;
                    case 'r':
                        sb.append("\\r");
                        advance();
                        break;
                    case 'f':
                        sb.append("\\f");
                        advance();
                        break;
                    case '\'':
                        sb.append("\\\'");
                        advance();
                        break;
                    default:
                        DecafCompiler.error(line, col,
                            "Invalid escape sequence '\\" + esc + "' in string literal.");
                        advance();
                }
            }
            else {
                if (!isPrintableChar(c)) {
                    DecafCompiler.error(line, col, "Non-printable char in string: code=" + (int)c);
                } else if (c == '\'' || c == '\\') {
                    DecafCompiler.error(line, col, "Must escape '" + c + "' in string literal.");
                }
                sb.append(c);
                advance();
            }
        }
        DecafCompiler.error(line, col, "Unterminated string literal at EOF.");
    }

    // ---------- CHAR LITERAL ------------------
    private void scanCharLiteral() {
        if (isAtEnd()) {
            DecafCompiler.error(line, col, "Empty char literal.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('\'');

        char c = advance();
        if (c == '\\') {
            if (isAtEnd()) {
                DecafCompiler.error(line, col, "Incomplete escape in char literal.");
                return;
            }
            char esc = peek();
            switch (esc) {
                case 'n', 't', 'r', 'f', '\\', '"', '\'' -> {
                    sb.append('\\').append(esc);
                    advance();
                }
                default -> {
                    DecafCompiler.error(line, col,
                        "Illegal backslashed char '\\"
                        + esc + "' in char literal.");
                    advance();
                }
            }
        } else {
            // normal char => ASCII 32..126, not ' " \
            if (!isPrintableChar(c)) {
                DecafCompiler.error(line, col, "Non-printable char code=" + (int)c + " in char literal.");
            } else if (c == '\'' || c == '"' || c == '\\') {
                DecafCompiler.error(line, col, "Char '" + c + "' must be escaped in char literal.");
            }
            sb.append(c);
        }

        // Now expect closing single quote
        if (isAtEnd()) {
            DecafCompiler.error(line, col, "Unterminated char literal (missing closing ').");
            return;
        }
        if (peek() == '\'') {
            advance();
            sb.append('\'');
            addToken(DecafTokenType.CHARLITERAL, sb.toString());
        } else {
            consumeUntilCharOrEOF('\'');
            if (!isAtEnd() && peek() == '\'') {
                advance(); 
            }
            DecafCompiler.error(line, col, "Too many characters in char literal or missing closing quote.");
        }
    }

    // ---------- NUMBER LITERAL ----------------
    private void scanNumberOrLongLiteral(char firstDigit) {
        // If it's 0x => hex
        // (Note we ONLY check for lowercase 'x'. If you want to allow uppercase 'X',
        //  you would handle that here. But the spec says uppercase is NOT recognized as hex.)
        if (firstDigit == '0' && peek() == 'x') {
            // consume the 'x'
            advance();
            // read hex digits
            while (isHexDigit(peek())) {
                advance();
            }
            // check for 'L'
            if (peek() == 'L') {
                advance();
                addToken(DecafTokenType.LONGLITERAL, source.substring(start, current));
            } else {
                addToken(DecafTokenType.INTLITERAL, source.substring(start, current));
            }
        } else {
            // decimal literal
            while (isDigit(peek())) {
                advance();
            }
            // check for 'L'
            if (peek() == 'L') {
                advance();
                addToken(DecafTokenType.LONGLITERAL, source.substring(start, current));
            } else {
                addToken(DecafTokenType.INTLITERAL, source.substring(start, current));
            }
        }
    }
    

    private void consumeUntilCharOrEOF(char endChar) {
        while (!isAtEnd() && peek() != endChar) {
            if (peek() == '\n') {
                line++;
                col = 0;
            }
            advance();
        }
    }

    private boolean isPrintableChar(char c) {
        return (c >= 32 && c <= 126);
    }

    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z')
            || (c >= 'A' && c <= 'Z')
            || c == '_';
    }

    private boolean isAlphaNumeric(char c) {
        return isAlpha(c) || isDigit(c);
    }

    private boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }

    private boolean isHexDigit(char c) {
        return isDigit(c)
            || (c >= 'a' && c <= 'f')
            || (c >= 'A' && c <= 'F');
    }

    private char peek() {
        if (isAtEnd()) return '\0';
        return source.charAt(current);
    }

    private char peekNext() {
        if (current + 1 >= source.length()) return '\0';
        return source.charAt(current+1);
    }

    private boolean match(char expected) {
        if (isAtEnd()) return false;
        if (source.charAt(current) != expected) return false;
        current++;
        col++;
        return true;
    }

    private char advance() {
        char c = source.charAt(current);
        current++;
        col++;
        return c;
    }

    private boolean isAtEnd() {
        return current >= source.length();
    }

    private void addToken(DecafTokenType type) {
        addToken(type, null);
    }

    private void addToken(DecafTokenType type, Object literal) {
        String text = source.substring(start, current);
        tokens.add(new DecafToken(type, text, literal, line, col));
    }
}
