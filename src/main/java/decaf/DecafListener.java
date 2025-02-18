package decaf;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DecafParser}.
 */
public interface DecafListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DecafParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(DecafParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(DecafParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#importDecl}.
	 * @param ctx the parse tree
	 */
	void enterImportDecl(DecafParser.ImportDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#importDecl}.
	 * @param ctx the parse tree
	 */
	void exitImportDecl(DecafParser.ImportDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(DecafParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(DecafParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#fieldItem}.
	 * @param ctx the parse tree
	 */
	void enterFieldItem(DecafParser.FieldItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#fieldItem}.
	 * @param ctx the parse tree
	 */
	void exitFieldItem(DecafParser.FieldItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(DecafParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(DecafParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(DecafParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(DecafParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(DecafParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(DecafParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(DecafParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(DecafParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(DecafParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(DecafParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(DecafParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(DecafParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#assignExpr}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(DecafParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#assignExpr}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(DecafParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#assignOp}.
	 * @param ctx the parse tree
	 */
	void enterAssignOp(DecafParser.AssignOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#assignOp}.
	 * @param ctx the parse tree
	 */
	void exitAssignOp(DecafParser.AssignOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#increment}.
	 * @param ctx the parse tree
	 */
	void enterIncrement(DecafParser.IncrementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#increment}.
	 * @param ctx the parse tree
	 */
	void exitIncrement(DecafParser.IncrementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(DecafParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(DecafParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#callArgs}.
	 * @param ctx the parse tree
	 */
	void enterCallArgs(DecafParser.CallArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#callArgs}.
	 * @param ctx the parse tree
	 */
	void exitCallArgs(DecafParser.CallArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#callArg}.
	 * @param ctx the parse tree
	 */
	void enterCallArg(DecafParser.CallArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#callArg}.
	 * @param ctx the parse tree
	 */
	void exitCallArg(DecafParser.CallArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(DecafParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(DecafParser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(DecafParser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(DecafParser.LocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(DecafParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(DecafParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#binOp}.
	 * @param ctx the parse tree
	 */
	void enterBinOp(DecafParser.BinOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#binOp}.
	 * @param ctx the parse tree
	 */
	void exitBinOp(DecafParser.BinOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(DecafParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(DecafParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(DecafParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(DecafParser.IdContext ctx);
}