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

    // We track errors globally in a way similar to Lox's "hadError" mechanism.
    static boolean hadError = false;
    static String inputFilename = ""; // For error messages

    private static void printTokens(List<DecafToken> tokens, OutputStream outputStream) {
        // If outputStream is System.out, cast is safe. Otherwise, wrap in a PrintStream.
        PrintStream printStream;
        if (outputStream instanceof PrintStream) {
            printStream = (PrintStream) outputStream;
        } else {
            printStream = new PrintStream(outputStream);
        }

        for (DecafToken token : tokens) {
            if (token.tokenType == DecafTokenType.EOF) continue; // Skip EOF
            
            switch (token.tokenType) {
                case LONGLITERAL, INTLITERAL, STRINGLITERAL, CHARLITERAL ->
                    printStream.printf("%d %s %s%n", token.line, token.tokenType, token.lexeme);

                case IDENTIFIER ->
                    printStream.printf("%d IDENTIFIER %s%n", token.line, token.lexeme);

                case INT, LONG, BOOL, IF, ELSE, FOR, WHILE, RETURN,
                    BREAK, CONTINUE, TRUE, FALSE, IMPORT, VOID, LEN ->
                    printStream.printf("%d %s%n", token.line, token.lexeme);

                default ->
                    printStream.printf("%d %s%n", token.line, token.lexeme);
            }
        }
    }

    public static void main(String[] args) {
        CommandLineInterface.parse(args, new String[0]);

        // Prepare input and output streams
        try (InputStream inputStream = (CommandLineInterface.infile == null)
                ? System.in
                : Files.newInputStream(Path.of(CommandLineInterface.infile));
             OutputStream outputStream = (CommandLineInterface.outfile == null)
                ? System.out
                : new PrintStream(new FileOutputStream(CommandLineInterface.outfile))) {

            // Remember the file name for error reporting
            inputFilename = (CommandLineInterface.infile == null)
                    ? "<stdin>"
                    : CommandLineInterface.infile;

            // Read entire input into a single string
            String source = readAll(inputStream);

            // Dispatch based on the requested target
            switch (CommandLineInterface.target) {
                case SCAN -> {
                    // 1) Scan the input into tokens
                    DecafScanner scanner = new DecafScanner(source);
                    List<DecafToken> tokens = scanner.scanTokens();

                    if (!hadError) {
                        printTokens(tokens, outputStream);
                    } else {
                        System.exit(1);
                    }
                }
                case PARSE -> {
                    // Placeholder for future parser integration
                }
                case INTER -> {
                    // Placeholder for IR generation or intermediate representation
                }
                case ASSEMBLY -> {
                    // Placeholder for assembly code generation
                }
            }

        } catch (IOException ioe) {
            System.err.printf("IOException encountered while processing file: %s%n", CommandLineInterface.infile);
            System.exit(1);
        }
    }

    /**
     * Utility: Read the entire InputStream into a single String.
     */
    private static String readAll(InputStream in) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] tmp = new byte[4096];
        int n;
        while ((n = in.read(tmp)) != -1) {
            buffer.write(tmp, 0, n);
        }
        return buffer.toString();
    }

    /**
     * Report a lexical error (or any error) in a manner similar to Lox.error.
     */
    public static void error(int line, int column, String message) {
        // Adjust this format as needed to match your lab or test harness expectations
        System.err.printf("%s line %d:%d: %s%n", inputFilename, line, column, message);
        hadError = true;
    }

}

/* --------------------------------------------------------------------------
 * Below is a Lox-inspired scanner for Decaf, with an updated charLiteral()
 * that will produce errors when encountering newlines or multi-char sequences.
 * -------------------------------------------------------------------------- */

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
    TRUE, FALSE, IMPORT, VOID, LEN,

    // Operators and punctuation
    PLUS, MINUS, STAR, SLASH, PERCENT,
    EQUAL, PLUS_EQUAL, MINUS_EQUAL, STAR_EQUAL, SLASH_EQUAL, PERCENT_EQUAL,
    EQUAL_EQUAL, BANG_EQUAL, GREATER, GREATER_EQUAL, LESS, LESS_EQUAL,
    AND_AND, OR_OR, BANG,
    PLUS_PLUS, MINUS_MINUS,
    LEFT_PAREN, RIGHT_PAREN,
    LEFT_BRACE, RIGHT_BRACE,
    LEFT_BRACKET, RIGHT_BRACKET,
    SEMICOLON, COMMA,
    // We'll add an EOF token to mark end-of-file, but skip printing it.
    EOF
}

class DecafToken {
    final DecafTokenType tokenType;
    final String lexeme;   // The raw substring from the source
    final Object literal;  // Parsed value if applicable (e.g., int value)
    final int line;        // 1-based line number
    final int column;      // 1-based column number

    DecafToken(DecafTokenType tokenType, String lexeme, Object literal, int line, int column) {
        this.tokenType = tokenType;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
        this.column = column;
    }

    @Override
    public String toString() {
        // For debugging or extended output
        return String.format("%s %s %s (line %d, col %d)",
                tokenType, lexeme, literal, line, column);
    }
}

class DecafScanner {

    private final String source;
    private final List<DecafToken> tokens = new ArrayList<>();

    // Cursor positions
    private int start = 0;   // Start index of the current token
    private int current = 0; // Current index as we scan forward
    private int line = 1;    // 1-based line number
    private int col = 1;     // 1-based column number

    // A basic keyword map
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
        keywords.put("true", DecafTokenType.TRUE);
        keywords.put("false", DecafTokenType.FALSE);
        keywords.put("import", DecafTokenType.IMPORT);
        keywords.put("void", DecafTokenType.VOID);
        keywords.put("len", DecafTokenType.LEN);
    }

    DecafScanner(String source) {
        this.source = source;
    }

    /**
     * Main entry point: scans the entire source and returns a list of tokens.
     */
    List<DecafToken> scanTokens() {
        while (!isAtEnd()) {
            start = current;
            scanToken();
        }
        // Add an EOF token for clarity (but we'll skip printing it in the main loop)
        tokens.add(new DecafToken(DecafTokenType.EOF, "", null, line, col));
        return tokens;
    }

    private void scanToken() {
        char c = advance();
        switch (c) {
            case '(': addToken(DecafTokenType.LEFT_PAREN); break;
            case ')': addToken(DecafTokenType.RIGHT_PAREN); break;
            case '{': addToken(DecafTokenType.LEFT_BRACE); break;
            case '}': addToken(DecafTokenType.RIGHT_BRACE); break;
            case '[': addToken(DecafTokenType.LEFT_BRACKET); break;
            case ']': addToken(DecafTokenType.RIGHT_BRACKET); break;
            case ';': addToken(DecafTokenType.SEMICOLON); break;
            case ',': addToken(DecafTokenType.COMMA); break;
            case '+':
                if (match('+')) {
                    addToken(DecafTokenType.PLUS_PLUS);
                } else if (match('=')) {
                    addToken(DecafTokenType.PLUS_EQUAL);
                } else {
                    addToken(DecafTokenType.PLUS);
                }
                break;
            case '-':
                if (match('-')) {
                    addToken(DecafTokenType.MINUS_MINUS);
                } else if (match('=')) {
                    addToken(DecafTokenType.MINUS_EQUAL);
                } else {
                    addToken(DecafTokenType.MINUS);
                }
                break;
            case '*':
                if (match('=')) {
                    addToken(DecafTokenType.STAR_EQUAL);
                } else {
                    addToken(DecafTokenType.STAR);
                }
                break;
            case '/':
                if (match('/')) {
                    // Line comment: consume until EOL
                    while (peek() != '\n' && !isAtEnd()) advance();
                } else if (match('*')) {
                    // Block comment (no nesting)
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
                } else if (match('=')) {
                    addToken(DecafTokenType.SLASH_EQUAL);
                } else {
                    addToken(DecafTokenType.SLASH);
                }
                break;
            case '%':
                if (match('=')) {
                    addToken(DecafTokenType.PERCENT_EQUAL);
                } else {
                    addToken(DecafTokenType.PERCENT);
                }
                break;
            case '!':
                addToken(match('=') ? DecafTokenType.BANG_EQUAL : DecafTokenType.BANG);
                break;
            case '=':
                addToken(match('=') ? DecafTokenType.EQUAL_EQUAL : DecafTokenType.EQUAL);
                break;
            case '<':
                addToken(match('=') ? DecafTokenType.LESS_EQUAL : DecafTokenType.LESS);
                break;
            case '>':
                addToken(match('=') ? DecafTokenType.GREATER_EQUAL : DecafTokenType.GREATER);
                break;
            case '&':
                if (match('&')) {
                    addToken(DecafTokenType.AND_AND);
                } else {
                    DecafCompiler.error(line, col, "Unexpected character '&' (did you mean '&&'?).");
                }
                break;
            case '|':
                if (match('|')) {
                    addToken(DecafTokenType.OR_OR);
                } else {
                    DecafCompiler.error(line, col, "Unexpected character '|' (did you mean '||'?).");
                }
                break;
            case ' ':
            case '\r':
            case '\t':
                // Skip whitespace
                break;
            case '\n':
                line++;
                col = 0;
                break;
            case '"':
                stringLiteral();
                break;
            case '\'':
                charLiteral();
                break;
            default:
                if (isDigit(c)) {
                    numberOrLongLiteral(c);
                } else if (isAlpha(c)) {
                    identifierOrKeyword();
                } else {
                    // Unknown character
                    DecafCompiler.error(line, col, "Unexpected character '" + c + "'.");
                }
                break;
        }
    }

    /**
     * Handle string literals, e.g., "Hello".
     * We don't handle advanced escape sequences here, but you could expand it.
     */
    private void stringLiteral() {
        while (peek() != '"' && !isAtEnd()) {
            if (peek() == '\n') {
                line++;
                col = 0;
            }
            advance();
        }
        if (isAtEnd()) {
            DecafCompiler.error(line, col, "Unterminated string literal.");
            return;
        }
        // Consume the closing quote
        advance();
        String value = source.substring(start, current);
        addToken(DecafTokenType.STRINGLITERAL, value);
    }

    /**
     * Strict charLiteral: exactly one character or one escape.
     * If more than one char or a newline is present, we report an error.
     */
    private void charLiteral() {
        // If at end, it's an immediate error
        if (isAtEnd()) {
            DecafCompiler.error(line, col, "Unterminated char literal (no character after opening quote).");
            return;
        }
    
        char next = peek();
    
        // If the next character is a newline, error out
        if (next == '\n') {
            DecafCompiler.error(line, col, "unexpected char: 0xA");
            consumeUntilCharOrEOF('\'');
            if (!isAtEnd() && peek() == '\'') advance(); // Skip the closing quote if present
            return;
        }
    
        // If the next character is a double quote, treat it as invalid.
        if (next == '"') {
            DecafCompiler.error(line, col, "unexpected char: '\"'");
            consumeUntilCharOrEOF('\'');
            if (!isAtEnd() && peek() == '\'') advance();
            return;
        }
    
        boolean sawEscape = (next == '\\');
        advance(); // consume the next character
    
        // If it's an escape, consume one more character
        if (sawEscape) {
            if (isAtEnd()) {
                DecafCompiler.error(line, col, "Incomplete escape in char literal.");
                return;
            }
            if (peek() == '\n') {
                DecafCompiler.error(line, col, "unexpected char: 0xA inside escape");
                consumeUntilCharOrEOF('\'');
                if (!isAtEnd() && peek() == '\'') advance();
                return;
            }
            // Read the escaped char (e.g. 'n' in '\n')
            advance();
        }
    
        // Now we expect the closing quote
        if (isAtEnd()) {
            DecafCompiler.error(line, col, "Unterminated char literal (missing closing single quote).");
            return;
        }
    
        // Another check for newline (in case the second char was a newline?)
        if (peek() == '\n') {
            DecafCompiler.error(line, col, "unexpected char: 0xA");
            consumeUntilCharOrEOF('\'');
            if (!isAtEnd() && peek() == '\'') advance();
            return;
        }
    
        // If we see the closing single quote, good. Otherwise, more than one char => error
        if (peek() == '\'') {
            advance(); // consume it
            String value = source.substring(start, current);
            addToken(DecafTokenType.CHARLITERAL, value);
        } else {
            // More than one character
            consumeUntilCharOrEOF('\'');
            if (!isAtEnd() && peek() == '\'') {
                advance();
            }
            DecafCompiler.error(line, col, "Too many characters in char literal or missing closing quote.");
        }
    }

    /**
     * Helper to consume until a certain character or EOF.
     */
    private void consumeUntilCharOrEOF(char endChar) {
        while (!isAtEnd() && peek() != endChar) {
            if (peek() == '\n') {
                line++;
                col = 0;
            }
            advance();
        }
    }

    /**
     * Distinguish between decimal or hex integer vs. long literal (ending in L).
     */
    private void numberOrLongLiteral(char firstDigit) {
        if (firstDigit == '0' && (peek() == 'x' || peek() == 'X')) {
            // Hex literal
            advance(); // consume 'x'
            while (isHexDigit(peek())) {
                advance();
            }
        } else {
            // Decimal literal
            while (isDigit(peek())) {
                advance();
            }
        }

        // Check if the next character is 'L' => long
        if (peek() == 'L') {
            advance(); // consume L
            addToken(DecafTokenType.LONGLITERAL, source.substring(start, current));
        } else {
            addToken(DecafTokenType.INTLITERAL, source.substring(start, current));
        }
    }

    private void identifierOrKeyword() {
        while (isAlphaNumeric(peek())) {
            advance();
        }
        String text = source.substring(start, current);
        DecafTokenType type = keywords.getOrDefault(text, DecafTokenType.IDENTIFIER);
        addToken(type, text);
    }

    // ----- Utility Methods -----

    private boolean match(char expected) {
        if (isAtEnd()) return false;
        if (source.charAt(current) != expected) return false;
        current++;
        col++;
        return true;
    }

    private char peek() {
        if (isAtEnd()) return '\0';
        return source.charAt(current);
    }

    private char peekNext() {
        if (current + 1 >= source.length()) return '\0';
        return source.charAt(current + 1);
    }

    private boolean isAtEnd() {
        return current >= source.length();
    }

    private char advance() {
        char c = source.charAt(current);
        current++;
        col++;
        return c;
    }

    private void addToken(DecafTokenType type) {
        addToken(type, null);
    }

    private void addToken(DecafTokenType type, Object literal) {
        String text = source.substring(start, current);
        tokens.add(new DecafToken(type, text, literal, line, col));
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
}
