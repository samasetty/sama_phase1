package decaf;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class DecafParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, BOOL=2, BREAK=3, IMPORT=4, CONTINUE=5, ELSE=6, FALSE=7, FOR=8, WHILE=9, 
		INT=10, LONG=11, RETURN=12, LEN=13, TRUE=14, VOID=15, PLUS=16, MINUS=17, 
		STAR=18, SLASH=19, PERCENT=20, EQUAL=21, PLUS_EQ=22, MINUS_EQ=23, STAR_EQ=24, 
		SLASH_EQ=25, PERCENT_EQ=26, EQUAL_EQ=27, BANG_EQ=28, GREATER=29, GREATER_EQ=30, 
		LESS=31, LESS_EQ=32, AND_AND=33, OR_OR=34, BANG=35, PLUS_PLUS=36, MINUS_MINUS=37, 
		LPAREN=38, RPAREN=39, LBRACE=40, RBRACE=41, LBRACK=42, RBRACK=43, SEMI=44, 
		COMMA=45, IDENTIFIER=46, INTLITERAL=47, LONGLITERAL=48, CHARLITERAL=49, 
		STRINGLITERAL=50, WS=51, LINE_COMMENT=52, BLOCK_COMMENT=53;
	public static final int
		RULE_program = 0, RULE_importDecl = 1, RULE_fieldDecl = 2, RULE_fieldItem = 3, 
		RULE_methodDecl = 4, RULE_param = 5, RULE_block = 6, RULE_type = 7, RULE_statement = 8, 
		RULE_forUpdate = 9, RULE_assignExpr = 10, RULE_assignOp = 11, RULE_increment = 12, 
		RULE_methodCall = 13, RULE_callArgs = 14, RULE_callArg = 15, RULE_methodName = 16, 
		RULE_location = 17, RULE_expr = 18, RULE_binOp = 19, RULE_literal = 20, 
		RULE_id = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "importDecl", "fieldDecl", "fieldItem", "methodDecl", "param", 
			"block", "type", "statement", "forUpdate", "assignExpr", "assignOp", 
			"increment", "methodCall", "callArgs", "callArg", "methodName", "location", 
			"expr", "binOp", "literal", "id"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'bool'", "'break'", "'import'", "'continue'", "'else'", 
			"'false'", "'for'", "'while'", "'int'", "'long'", "'return'", "'len'", 
			"'true'", "'void'", "'+'", "'-'", "'*'", "'/'", "'%'", "'='", "'+='", 
			"'-='", "'*='", "'/='", "'%='", "'=='", "'!='", "'>'", "'>='", "'<'", 
			"'<='", "'&&'", "'||'", "'!'", "'++'", "'--'", "'('", "')'", "'{'", "'}'", 
			"'['", "']'", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "BOOL", "BREAK", "IMPORT", "CONTINUE", "ELSE", "FALSE", "FOR", 
			"WHILE", "INT", "LONG", "RETURN", "LEN", "TRUE", "VOID", "PLUS", "MINUS", 
			"STAR", "SLASH", "PERCENT", "EQUAL", "PLUS_EQ", "MINUS_EQ", "STAR_EQ", 
			"SLASH_EQ", "PERCENT_EQ", "EQUAL_EQ", "BANG_EQ", "GREATER", "GREATER_EQ", 
			"LESS", "LESS_EQ", "AND_AND", "OR_OR", "BANG", "PLUS_PLUS", "MINUS_MINUS", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", 
			"IDENTIFIER", "INTLITERAL", "LONGLITERAL", "CHARLITERAL", "STRINGLITERAL", 
			"WS", "LINE_COMMENT", "BLOCK_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Decaf.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DecafParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(DecafParser.EOF, 0); }
		public List<ImportDeclContext> importDecl() {
			return getRuleContexts(ImportDeclContext.class);
		}
		public ImportDeclContext importDecl(int i) {
			return getRuleContext(ImportDeclContext.class,i);
		}
		public List<FieldDeclContext> fieldDecl() {
			return getRuleContexts(FieldDeclContext.class);
		}
		public FieldDeclContext fieldDecl(int i) {
			return getRuleContext(FieldDeclContext.class,i);
		}
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(44);
				importDecl();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(50);
					fieldDecl();
					}
					} 
				}
				setState(55);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35844L) != 0)) {
				{
				{
				setState(56);
				methodDecl();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportDeclContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(DecafParser.IMPORT, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(DecafParser.SEMI, 0); }
		public ImportDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterImportDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitImportDecl(this);
		}
	}

	public final ImportDeclContext importDecl() throws RecognitionException {
		ImportDeclContext _localctx = new ImportDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(IMPORT);
			setState(65);
			id();
			setState(66);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<FieldItemContext> fieldItem() {
			return getRuleContexts(FieldItemContext.class);
		}
		public FieldItemContext fieldItem(int i) {
			return getRuleContext(FieldItemContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(DecafParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public FieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterFieldDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitFieldDecl(this);
		}
	}

	public final FieldDeclContext fieldDecl() throws RecognitionException {
		FieldDeclContext _localctx = new FieldDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fieldDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			type();
			setState(69);
			fieldItem();
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(70);
				match(COMMA);
				setState(71);
				fieldItem();
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldItemContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(DecafParser.LBRACK, 0); }
		public TerminalNode INTLITERAL() { return getToken(DecafParser.INTLITERAL, 0); }
		public TerminalNode RBRACK() { return getToken(DecafParser.RBRACK, 0); }
		public FieldItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterFieldItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitFieldItem(this);
		}
	}

	public final FieldItemContext fieldItem() throws RecognitionException {
		FieldItemContext _localctx = new FieldItemContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fieldItem);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				id();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				id();
				setState(81);
				match(LBRACK);
				setState(82);
				match(INTLITERAL);
				setState(83);
				match(RBRACK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodDeclContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(DecafParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(DecafParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(DecafParser.VOID, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitMethodDecl(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case INT:
			case LONG:
				{
				setState(87);
				type();
				}
				break;
			case VOID:
				{
				setState(88);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(91);
			id();
			setState(92);
			match(LPAREN);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3076L) != 0)) {
				{
				setState(93);
				param();
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(94);
					match(COMMA);
					setState(95);
					param();
					}
					}
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(103);
			match(RPAREN);
			setState(104);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			type();
			setState(107);
			id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(DecafParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(DecafParser.RBRACE, 0); }
		public List<FieldDeclContext> fieldDecl() {
			return getRuleContexts(FieldDeclContext.class);
		}
		public FieldDeclContext fieldDecl(int i) {
			return getRuleContext(FieldDeclContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(LBRACE);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3076L) != 0)) {
				{
				{
				setState(110);
				fieldDecl();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 70368744182570L) != 0)) {
				{
				{
				setState(116);
				statement();
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(DecafParser.INT, 0); }
		public TerminalNode LONG() { return getToken(DecafParser.LONG, 0); }
		public TerminalNode BOOL() { return getToken(DecafParser.BOOL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3076L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public AssignExprContext assignExpr() {
			return getRuleContext(AssignExprContext.class,0);
		}
		public List<TerminalNode> SEMI() { return getTokens(DecafParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(DecafParser.SEMI, i);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public TerminalNode IF() { return getToken(DecafParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(DecafParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(DecafParser.RPAREN, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(DecafParser.ELSE, 0); }
		public TerminalNode FOR() { return getToken(DecafParser.FOR, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(DecafParser.EQUAL, 0); }
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(DecafParser.WHILE, 0); }
		public TerminalNode RETURN() { return getToken(DecafParser.RETURN, 0); }
		public TerminalNode BREAK() { return getToken(DecafParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(DecafParser.CONTINUE, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		int _la;
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				location();
				setState(127);
				assignExpr();
				setState(128);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				methodCall();
				setState(131);
				match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				match(IF);
				setState(134);
				match(LPAREN);
				setState(135);
				expr(0);
				setState(136);
				match(RPAREN);
				setState(137);
				block();
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(138);
					match(ELSE);
					setState(139);
					block();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(142);
				match(FOR);
				setState(143);
				match(LPAREN);
				setState(144);
				id();
				setState(145);
				match(EQUAL);
				setState(146);
				expr(0);
				setState(147);
				match(SEMI);
				setState(148);
				expr(0);
				setState(149);
				match(SEMI);
				setState(150);
				forUpdate();
				setState(151);
				match(RPAREN);
				setState(152);
				block();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(154);
				match(WHILE);
				setState(155);
				match(LPAREN);
				setState(156);
				expr(0);
				setState(157);
				match(RPAREN);
				setState(158);
				block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(160);
				match(RETURN);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1055840400469120L) != 0)) {
					{
					setState(161);
					expr(0);
					}
				}

				setState(164);
				match(SEMI);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(165);
				match(BREAK);
				setState(166);
				match(SEMI);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(167);
				match(CONTINUE);
				setState(168);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForUpdateContext extends ParserRuleContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public AssignExprContext assignExpr() {
			return getRuleContext(AssignExprContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterForUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitForUpdate(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			location();
			setState(172);
			assignExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignExprContext extends ParserRuleContext {
		public AssignOpContext assignOp() {
			return getRuleContext(AssignOpContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IncrementContext increment() {
			return getRuleContext(IncrementContext.class,0);
		}
		public AssignExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitAssignExpr(this);
		}
	}

	public final AssignExprContext assignExpr() throws RecognitionException {
		AssignExprContext _localctx = new AssignExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignExpr);
		try {
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EQUAL:
			case PLUS_EQ:
			case MINUS_EQ:
			case STAR_EQ:
			case SLASH_EQ:
			case PERCENT_EQ:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				assignOp();
				setState(175);
				expr(0);
				}
				break;
			case PLUS_PLUS:
			case MINUS_MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				increment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignOpContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(DecafParser.EQUAL, 0); }
		public TerminalNode PLUS_EQ() { return getToken(DecafParser.PLUS_EQ, 0); }
		public TerminalNode MINUS_EQ() { return getToken(DecafParser.MINUS_EQ, 0); }
		public TerminalNode STAR_EQ() { return getToken(DecafParser.STAR_EQ, 0); }
		public TerminalNode SLASH_EQ() { return getToken(DecafParser.SLASH_EQ, 0); }
		public TerminalNode PERCENT_EQ() { return getToken(DecafParser.PERCENT_EQ, 0); }
		public AssignOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterAssignOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitAssignOp(this);
		}
	}

	public final AssignOpContext assignOp() throws RecognitionException {
		AssignOpContext _localctx = new AssignOpContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assignOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 132120576L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IncrementContext extends ParserRuleContext {
		public TerminalNode PLUS_PLUS() { return getToken(DecafParser.PLUS_PLUS, 0); }
		public TerminalNode MINUS_MINUS() { return getToken(DecafParser.MINUS_MINUS, 0); }
		public IncrementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_increment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterIncrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitIncrement(this);
		}
	}

	public final IncrementContext increment() throws RecognitionException {
		IncrementContext _localctx = new IncrementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_increment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_la = _input.LA(1);
			if ( !(_la==PLUS_PLUS || _la==MINUS_MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallContext extends ParserRuleContext {
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(DecafParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(DecafParser.RPAREN, 0); }
		public CallArgsContext callArgs() {
			return getRuleContext(CallArgsContext.class,0);
		}
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitMethodCall(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_methodCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			methodName();
			setState(185);
			match(LPAREN);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2181740307311744L) != 0)) {
				{
				setState(186);
				callArgs();
				}
			}

			setState(189);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallArgsContext extends ParserRuleContext {
		public List<CallArgContext> callArg() {
			return getRuleContexts(CallArgContext.class);
		}
		public CallArgContext callArg(int i) {
			return getRuleContext(CallArgContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public CallArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterCallArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitCallArgs(this);
		}
	}

	public final CallArgsContext callArgs() throws RecognitionException {
		CallArgsContext _localctx = new CallArgsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_callArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			callArg();
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(192);
				match(COMMA);
				setState(193);
				callArg();
				}
				}
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallArgContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode STRINGLITERAL() { return getToken(DecafParser.STRINGLITERAL, 0); }
		public CallArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterCallArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitCallArg(this);
		}
	}

	public final CallArgContext callArg() throws RecognitionException {
		CallArgContext _localctx = new CallArgContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_callArg);
		try {
			setState(201);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FALSE:
			case INT:
			case LONG:
			case LEN:
			case TRUE:
			case MINUS:
			case BANG:
			case LPAREN:
			case IDENTIFIER:
			case INTLITERAL:
			case LONGLITERAL:
			case CHARLITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				expr(0);
				}
				break;
			case STRINGLITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				match(STRINGLITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodNameContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public MethodNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterMethodName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitMethodName(this);
		}
	}

	public final MethodNameContext methodName() throws RecognitionException {
		MethodNameContext _localctx = new MethodNameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_methodName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LocationContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(DecafParser.LBRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(DecafParser.RBRACK, 0); }
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitLocation(this);
		}
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_location);
		try {
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				id();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				id();
				setState(207);
				match(LBRACK);
				setState(208);
				expr(0);
				setState(209);
				match(RBRACK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode INT() { return getToken(DecafParser.INT, 0); }
		public TerminalNode LPAREN() { return getToken(DecafParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(DecafParser.RPAREN, 0); }
		public TerminalNode LONG() { return getToken(DecafParser.LONG, 0); }
		public TerminalNode LEN() { return getToken(DecafParser.LEN, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(DecafParser.MINUS, 0); }
		public TerminalNode BANG() { return getToken(DecafParser.BANG, 0); }
		public BinOpContext binOp() {
			return getRuleContext(BinOpContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(214);
				location();
				}
				break;
			case 2:
				{
				setState(215);
				methodCall();
				}
				break;
			case 3:
				{
				setState(216);
				literal();
				}
				break;
			case 4:
				{
				setState(217);
				match(INT);
				setState(218);
				match(LPAREN);
				setState(219);
				expr(0);
				setState(220);
				match(RPAREN);
				}
				break;
			case 5:
				{
				setState(222);
				match(LONG);
				setState(223);
				match(LPAREN);
				setState(224);
				expr(0);
				setState(225);
				match(RPAREN);
				}
				break;
			case 6:
				{
				setState(227);
				match(LEN);
				setState(228);
				match(LPAREN);
				setState(229);
				id();
				setState(230);
				match(RPAREN);
				}
				break;
			case 7:
				{
				setState(232);
				match(MINUS);
				setState(233);
				expr(3);
				}
				break;
			case 8:
				{
				setState(234);
				match(BANG);
				setState(235);
				expr(2);
				}
				break;
			case 9:
				{
				setState(236);
				match(LPAREN);
				setState(237);
				expr(0);
				setState(238);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(248);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(242);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(243);
					binOp();
					setState(244);
					expr(5);
					}
					} 
				}
				setState(250);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BinOpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(DecafParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(DecafParser.MINUS, 0); }
		public TerminalNode STAR() { return getToken(DecafParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(DecafParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(DecafParser.PERCENT, 0); }
		public TerminalNode LESS() { return getToken(DecafParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(DecafParser.GREATER, 0); }
		public TerminalNode LESS_EQ() { return getToken(DecafParser.LESS_EQ, 0); }
		public TerminalNode GREATER_EQ() { return getToken(DecafParser.GREATER_EQ, 0); }
		public TerminalNode EQUAL_EQ() { return getToken(DecafParser.EQUAL_EQ, 0); }
		public TerminalNode BANG_EQ() { return getToken(DecafParser.BANG_EQ, 0); }
		public TerminalNode AND_AND() { return getToken(DecafParser.AND_AND, 0); }
		public TerminalNode OR_OR() { return getToken(DecafParser.OR_OR, 0); }
		public BinOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterBinOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitBinOp(this);
		}
	}

	public final BinOpContext binOp() throws RecognitionException {
		BinOpContext _localctx = new BinOpContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_binOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 34227552256L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(DecafParser.MINUS, 0); }
		public List<TerminalNode> INTLITERAL() { return getTokens(DecafParser.INTLITERAL); }
		public TerminalNode INTLITERAL(int i) {
			return getToken(DecafParser.INTLITERAL, i);
		}
		public TerminalNode LONGLITERAL() { return getToken(DecafParser.LONGLITERAL, 0); }
		public TerminalNode CHARLITERAL() { return getToken(DecafParser.CHARLITERAL, 0); }
		public TerminalNode TRUE() { return getToken(DecafParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(DecafParser.FALSE, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_literal);
		try {
			int _alt;
			setState(264);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				match(MINUS);
				setState(255); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(254);
						match(INTLITERAL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(257); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case INTLITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				match(INTLITERAL);
				}
				break;
			case LONGLITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(260);
				match(LONGLITERAL);
				}
				break;
			case CHARLITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(261);
				match(CHARLITERAL);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 5);
				{
				setState(262);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(263);
				match(FALSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DecafParser.IDENTIFIER, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafListener ) ((DecafListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 18:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00015\u010d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0001\u0000\u0005\u0000.\b\u0000\n\u0000\f\u00001\t\u0000\u0001\u0000"+
		"\u0005\u00004\b\u0000\n\u0000\f\u00007\t\u0000\u0001\u0000\u0005\u0000"+
		":\b\u0000\n\u0000\f\u0000=\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002I\b\u0002\n\u0002\f\u0002L\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003V\b\u0003\u0001\u0004\u0001\u0004\u0003\u0004"+
		"Z\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004a\b\u0004\n\u0004\f\u0004d\t\u0004\u0003\u0004f\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0005\u0006p\b\u0006\n\u0006\f\u0006s\t\u0006\u0001"+
		"\u0006\u0005\u0006v\b\u0006\n\u0006\f\u0006y\t\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b\u008d\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00a3\b\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u00aa\b\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u00b3\b\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0003\r\u00bc\b\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u00c3\b\u000e\n\u000e\f\u000e\u00c6"+
		"\t\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u00ca\b\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u00d4\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u00f1\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0005\u0012\u00f7\b\u0012\n\u0012\f\u0012\u00fa\t\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0004\u0014\u0100\b\u0014\u000b\u0014\f"+
		"\u0014\u0101\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u0109\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0000\u0001"+
		"$\u0016\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*\u0000\u0004\u0002\u0000\u0002\u0002\n\u000b"+
		"\u0001\u0000\u0015\u001a\u0001\u0000$%\u0002\u0000\u0010\u0014\u001b\""+
		"\u011d\u0000/\u0001\u0000\u0000\u0000\u0002@\u0001\u0000\u0000\u0000\u0004"+
		"D\u0001\u0000\u0000\u0000\u0006U\u0001\u0000\u0000\u0000\bY\u0001\u0000"+
		"\u0000\u0000\nj\u0001\u0000\u0000\u0000\fm\u0001\u0000\u0000\u0000\u000e"+
		"|\u0001\u0000\u0000\u0000\u0010\u00a9\u0001\u0000\u0000\u0000\u0012\u00ab"+
		"\u0001\u0000\u0000\u0000\u0014\u00b2\u0001\u0000\u0000\u0000\u0016\u00b4"+
		"\u0001\u0000\u0000\u0000\u0018\u00b6\u0001\u0000\u0000\u0000\u001a\u00b8"+
		"\u0001\u0000\u0000\u0000\u001c\u00bf\u0001\u0000\u0000\u0000\u001e\u00c9"+
		"\u0001\u0000\u0000\u0000 \u00cb\u0001\u0000\u0000\u0000\"\u00d3\u0001"+
		"\u0000\u0000\u0000$\u00f0\u0001\u0000\u0000\u0000&\u00fb\u0001\u0000\u0000"+
		"\u0000(\u0108\u0001\u0000\u0000\u0000*\u010a\u0001\u0000\u0000\u0000,"+
		".\u0003\u0002\u0001\u0000-,\u0001\u0000\u0000\u0000.1\u0001\u0000\u0000"+
		"\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u000005\u0001\u0000"+
		"\u0000\u00001/\u0001\u0000\u0000\u000024\u0003\u0004\u0002\u000032\u0001"+
		"\u0000\u0000\u000047\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u0000"+
		"56\u0001\u0000\u0000\u00006;\u0001\u0000\u0000\u000075\u0001\u0000\u0000"+
		"\u00008:\u0003\b\u0004\u000098\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000"+
		"\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<>\u0001\u0000"+
		"\u0000\u0000=;\u0001\u0000\u0000\u0000>?\u0005\u0000\u0000\u0001?\u0001"+
		"\u0001\u0000\u0000\u0000@A\u0005\u0004\u0000\u0000AB\u0003*\u0015\u0000"+
		"BC\u0005,\u0000\u0000C\u0003\u0001\u0000\u0000\u0000DE\u0003\u000e\u0007"+
		"\u0000EJ\u0003\u0006\u0003\u0000FG\u0005-\u0000\u0000GI\u0003\u0006\u0003"+
		"\u0000HF\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001\u0000"+
		"\u0000\u0000JK\u0001\u0000\u0000\u0000KM\u0001\u0000\u0000\u0000LJ\u0001"+
		"\u0000\u0000\u0000MN\u0005,\u0000\u0000N\u0005\u0001\u0000\u0000\u0000"+
		"OV\u0003*\u0015\u0000PQ\u0003*\u0015\u0000QR\u0005*\u0000\u0000RS\u0005"+
		"/\u0000\u0000ST\u0005+\u0000\u0000TV\u0001\u0000\u0000\u0000UO\u0001\u0000"+
		"\u0000\u0000UP\u0001\u0000\u0000\u0000V\u0007\u0001\u0000\u0000\u0000"+
		"WZ\u0003\u000e\u0007\u0000XZ\u0005\u000f\u0000\u0000YW\u0001\u0000\u0000"+
		"\u0000YX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0003*\u0015"+
		"\u0000\\e\u0005&\u0000\u0000]b\u0003\n\u0005\u0000^_\u0005-\u0000\u0000"+
		"_a\u0003\n\u0005\u0000`^\u0001\u0000\u0000\u0000ad\u0001\u0000\u0000\u0000"+
		"b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000cf\u0001\u0000\u0000"+
		"\u0000db\u0001\u0000\u0000\u0000e]\u0001\u0000\u0000\u0000ef\u0001\u0000"+
		"\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0005\'\u0000\u0000hi\u0003\f"+
		"\u0006\u0000i\t\u0001\u0000\u0000\u0000jk\u0003\u000e\u0007\u0000kl\u0003"+
		"*\u0015\u0000l\u000b\u0001\u0000\u0000\u0000mq\u0005(\u0000\u0000np\u0003"+
		"\u0004\u0002\u0000on\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000"+
		"qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rw\u0001\u0000\u0000"+
		"\u0000sq\u0001\u0000\u0000\u0000tv\u0003\u0010\b\u0000ut\u0001\u0000\u0000"+
		"\u0000vy\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000"+
		"\u0000\u0000xz\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000z{\u0005"+
		")\u0000\u0000{\r\u0001\u0000\u0000\u0000|}\u0007\u0000\u0000\u0000}\u000f"+
		"\u0001\u0000\u0000\u0000~\u007f\u0003\"\u0011\u0000\u007f\u0080\u0003"+
		"\u0014\n\u0000\u0080\u0081\u0005,\u0000\u0000\u0081\u00aa\u0001\u0000"+
		"\u0000\u0000\u0082\u0083\u0003\u001a\r\u0000\u0083\u0084\u0005,\u0000"+
		"\u0000\u0084\u00aa\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u0001\u0000"+
		"\u0000\u0086\u0087\u0005&\u0000\u0000\u0087\u0088\u0003$\u0012\u0000\u0088"+
		"\u0089\u0005\'\u0000\u0000\u0089\u008c\u0003\f\u0006\u0000\u008a\u008b"+
		"\u0005\u0006\u0000\u0000\u008b\u008d\u0003\f\u0006\u0000\u008c\u008a\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u00aa\u0001"+
		"\u0000\u0000\u0000\u008e\u008f\u0005\b\u0000\u0000\u008f\u0090\u0005&"+
		"\u0000\u0000\u0090\u0091\u0003*\u0015\u0000\u0091\u0092\u0005\u0015\u0000"+
		"\u0000\u0092\u0093\u0003$\u0012\u0000\u0093\u0094\u0005,\u0000\u0000\u0094"+
		"\u0095\u0003$\u0012\u0000\u0095\u0096\u0005,\u0000\u0000\u0096\u0097\u0003"+
		"\u0012\t\u0000\u0097\u0098\u0005\'\u0000\u0000\u0098\u0099\u0003\f\u0006"+
		"\u0000\u0099\u00aa\u0001\u0000\u0000\u0000\u009a\u009b\u0005\t\u0000\u0000"+
		"\u009b\u009c\u0005&\u0000\u0000\u009c\u009d\u0003$\u0012\u0000\u009d\u009e"+
		"\u0005\'\u0000\u0000\u009e\u009f\u0003\f\u0006\u0000\u009f\u00aa\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a2\u0005\f\u0000\u0000\u00a1\u00a3\u0003$"+
		"\u0012\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00aa\u0005,\u0000"+
		"\u0000\u00a5\u00a6\u0005\u0003\u0000\u0000\u00a6\u00aa\u0005,\u0000\u0000"+
		"\u00a7\u00a8\u0005\u0005\u0000\u0000\u00a8\u00aa\u0005,\u0000\u0000\u00a9"+
		"~\u0001\u0000\u0000\u0000\u00a9\u0082\u0001\u0000\u0000\u0000\u00a9\u0085"+
		"\u0001\u0000\u0000\u0000\u00a9\u008e\u0001\u0000\u0000\u0000\u00a9\u009a"+
		"\u0001\u0000\u0000\u0000\u00a9\u00a0\u0001\u0000\u0000\u0000\u00a9\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00aa\u0011"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0003\"\u0011\u0000\u00ac\u00ad\u0003"+
		"\u0014\n\u0000\u00ad\u0013\u0001\u0000\u0000\u0000\u00ae\u00af\u0003\u0016"+
		"\u000b\u0000\u00af\u00b0\u0003$\u0012\u0000\u00b0\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b3\u0003\u0018\f\u0000\u00b2\u00ae\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u0015\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b5\u0007\u0001\u0000\u0000\u00b5\u0017\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b7\u0007\u0002\u0000\u0000\u00b7\u0019\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b9\u0003 \u0010\u0000\u00b9\u00bb\u0005&\u0000\u0000\u00ba\u00bc"+
		"\u0003\u001c\u000e\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bb\u00bc"+
		"\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00be"+
		"\u0005\'\u0000\u0000\u00be\u001b\u0001\u0000\u0000\u0000\u00bf\u00c4\u0003"+
		"\u001e\u000f\u0000\u00c0\u00c1\u0005-\u0000\u0000\u00c1\u00c3\u0003\u001e"+
		"\u000f\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000"+
		"\u0000\u0000\u00c5\u001d\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c7\u00ca\u0003$\u0012\u0000\u00c8\u00ca\u00052\u0000\u0000"+
		"\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000"+
		"\u00ca\u001f\u0001\u0000\u0000\u0000\u00cb\u00cc\u0003*\u0015\u0000\u00cc"+
		"!\u0001\u0000\u0000\u0000\u00cd\u00d4\u0003*\u0015\u0000\u00ce\u00cf\u0003"+
		"*\u0015\u0000\u00cf\u00d0\u0005*\u0000\u0000\u00d0\u00d1\u0003$\u0012"+
		"\u0000\u00d1\u00d2\u0005+\u0000\u0000\u00d2\u00d4\u0001\u0000\u0000\u0000"+
		"\u00d3\u00cd\u0001\u0000\u0000\u0000\u00d3\u00ce\u0001\u0000\u0000\u0000"+
		"\u00d4#\u0001\u0000\u0000\u0000\u00d5\u00d6\u0006\u0012\uffff\uffff\u0000"+
		"\u00d6\u00f1\u0003\"\u0011\u0000\u00d7\u00f1\u0003\u001a\r\u0000\u00d8"+
		"\u00f1\u0003(\u0014\u0000\u00d9\u00da\u0005\n\u0000\u0000\u00da\u00db"+
		"\u0005&\u0000\u0000\u00db\u00dc\u0003$\u0012\u0000\u00dc\u00dd\u0005\'"+
		"\u0000\u0000\u00dd\u00f1\u0001\u0000\u0000\u0000\u00de\u00df\u0005\u000b"+
		"\u0000\u0000\u00df\u00e0\u0005&\u0000\u0000\u00e0\u00e1\u0003$\u0012\u0000"+
		"\u00e1\u00e2\u0005\'\u0000\u0000\u00e2\u00f1\u0001\u0000\u0000\u0000\u00e3"+
		"\u00e4\u0005\r\u0000\u0000\u00e4\u00e5\u0005&\u0000\u0000\u00e5\u00e6"+
		"\u0003*\u0015\u0000\u00e6\u00e7\u0005\'\u0000\u0000\u00e7\u00f1\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e9\u0005\u0011\u0000\u0000\u00e9\u00f1\u0003"+
		"$\u0012\u0003\u00ea\u00eb\u0005#\u0000\u0000\u00eb\u00f1\u0003$\u0012"+
		"\u0002\u00ec\u00ed\u0005&\u0000\u0000\u00ed\u00ee\u0003$\u0012\u0000\u00ee"+
		"\u00ef\u0005\'\u0000\u0000\u00ef\u00f1\u0001\u0000\u0000\u0000\u00f0\u00d5"+
		"\u0001\u0000\u0000\u0000\u00f0\u00d7\u0001\u0000\u0000\u0000\u00f0\u00d8"+
		"\u0001\u0000\u0000\u0000\u00f0\u00d9\u0001\u0000\u0000\u0000\u00f0\u00de"+
		"\u0001\u0000\u0000\u0000\u00f0\u00e3\u0001\u0000\u0000\u0000\u00f0\u00e8"+
		"\u0001\u0000\u0000\u0000\u00f0\u00ea\u0001\u0000\u0000\u0000\u00f0\u00ec"+
		"\u0001\u0000\u0000\u0000\u00f1\u00f8\u0001\u0000\u0000\u0000\u00f2\u00f3"+
		"\n\u0004\u0000\u0000\u00f3\u00f4\u0003&\u0013\u0000\u00f4\u00f5\u0003"+
		"$\u0012\u0005\u00f5\u00f7\u0001\u0000\u0000\u0000\u00f6\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f7\u00fa\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9%\u0001\u0000\u0000"+
		"\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fb\u00fc\u0007\u0003\u0000"+
		"\u0000\u00fc\'\u0001\u0000\u0000\u0000\u00fd\u00ff\u0005\u0011\u0000\u0000"+
		"\u00fe\u0100\u0005/\u0000\u0000\u00ff\u00fe\u0001\u0000\u0000\u0000\u0100"+
		"\u0101\u0001\u0000\u0000\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0101"+
		"\u0102\u0001\u0000\u0000\u0000\u0102\u0109\u0001\u0000\u0000\u0000\u0103"+
		"\u0109\u0005/\u0000\u0000\u0104\u0109\u00050\u0000\u0000\u0105\u0109\u0005"+
		"1\u0000\u0000\u0106\u0109\u0005\u000e\u0000\u0000\u0107\u0109\u0005\u0007"+
		"\u0000\u0000\u0108\u00fd\u0001\u0000\u0000\u0000\u0108\u0103\u0001\u0000"+
		"\u0000\u0000\u0108\u0104\u0001\u0000\u0000\u0000\u0108\u0105\u0001\u0000"+
		"\u0000\u0000\u0108\u0106\u0001\u0000\u0000\u0000\u0108\u0107\u0001\u0000"+
		"\u0000\u0000\u0109)\u0001\u0000\u0000\u0000\u010a\u010b\u0005.\u0000\u0000"+
		"\u010b+\u0001\u0000\u0000\u0000\u0016/5;JUYbeqw\u008c\u00a2\u00a9\u00b2"+
		"\u00bb\u00c4\u00c9\u00d3\u00f0\u00f8\u0101\u0108";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}