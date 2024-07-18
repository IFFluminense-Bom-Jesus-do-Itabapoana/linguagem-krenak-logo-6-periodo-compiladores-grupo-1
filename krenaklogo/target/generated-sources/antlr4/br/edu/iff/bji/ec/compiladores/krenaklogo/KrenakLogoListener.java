// Generated from br/edu/iff/bji/ec/compiladores/krenaklogo/KrenakLogo.g4 by ANTLR 4.13.1
package br.edu.iff.bji.ec.compiladores.krenaklogo;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KrenakLogoParser}.
 */
public interface KrenakLogoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(KrenakLogoParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(KrenakLogoParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(KrenakLogoParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(KrenakLogoParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(KrenakLogoParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(KrenakLogoParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#procedureInvocation}.
	 * @param ctx the parse tree
	 */
	void enterProcedureInvocation(KrenakLogoParser.ProcedureInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#procedureInvocation}.
	 * @param ctx the parse tree
	 */
	void exitProcedureInvocation(KrenakLogoParser.ProcedureInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterProcedureDeclaration(KrenakLogoParser.ProcedureDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitProcedureDeclaration(KrenakLogoParser.ProcedureDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#parameterDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclarations(KrenakLogoParser.ParameterDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#parameterDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclarations(KrenakLogoParser.ParameterDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#func_}.
	 * @param ctx the parse tree
	 */
	void enterFunc_(KrenakLogoParser.Func_Context ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#func_}.
	 * @param ctx the parse tree
	 */
	void exitFunc_(KrenakLogoParser.Func_Context ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#repeat_}.
	 * @param ctx the parse tree
	 */
	void enterRepeat_(KrenakLogoParser.Repeat_Context ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#repeat_}.
	 * @param ctx the parse tree
	 */
	void exitRepeat_(KrenakLogoParser.Repeat_Context ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(KrenakLogoParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(KrenakLogoParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#ife}.
	 * @param ctx the parse tree
	 */
	void enterIfe(KrenakLogoParser.IfeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#ife}.
	 * @param ctx the parse tree
	 */
	void exitIfe(KrenakLogoParser.IfeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(KrenakLogoParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(KrenakLogoParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(KrenakLogoParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(KrenakLogoParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#make}.
	 * @param ctx the parse tree
	 */
	void enterMake(KrenakLogoParser.MakeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#make}.
	 * @param ctx the parse tree
	 */
	void exitMake(KrenakLogoParser.MakeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#print_}.
	 * @param ctx the parse tree
	 */
	void enterPrint_(KrenakLogoParser.Print_Context ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#print_}.
	 * @param ctx the parse tree
	 */
	void exitPrint_(KrenakLogoParser.Print_Context ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#quotedstring}.
	 * @param ctx the parse tree
	 */
	void enterQuotedstring(KrenakLogoParser.QuotedstringContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#quotedstring}.
	 * @param ctx the parse tree
	 */
	void exitQuotedstring(KrenakLogoParser.QuotedstringContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(KrenakLogoParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(KrenakLogoParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(KrenakLogoParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(KrenakLogoParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#signExpression}.
	 * @param ctx the parse tree
	 */
	void enterSignExpression(KrenakLogoParser.SignExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#signExpression}.
	 * @param ctx the parse tree
	 */
	void exitSignExpression(KrenakLogoParser.SignExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyingExpression(KrenakLogoParser.MultiplyingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyingExpression(KrenakLogoParser.MultiplyingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(KrenakLogoParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(KrenakLogoParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#deref}.
	 * @param ctx the parse tree
	 */
	void enterDeref(KrenakLogoParser.DerefContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#deref}.
	 * @param ctx the parse tree
	 */
	void exitDeref(KrenakLogoParser.DerefContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#fd}.
	 * @param ctx the parse tree
	 */
	void enterFd(KrenakLogoParser.FdContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#fd}.
	 * @param ctx the parse tree
	 */
	void exitFd(KrenakLogoParser.FdContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#bk}.
	 * @param ctx the parse tree
	 */
	void enterBk(KrenakLogoParser.BkContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#bk}.
	 * @param ctx the parse tree
	 */
	void exitBk(KrenakLogoParser.BkContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#rt}.
	 * @param ctx the parse tree
	 */
	void enterRt(KrenakLogoParser.RtContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#rt}.
	 * @param ctx the parse tree
	 */
	void exitRt(KrenakLogoParser.RtContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#lt}.
	 * @param ctx the parse tree
	 */
	void enterLt(KrenakLogoParser.LtContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#lt}.
	 * @param ctx the parse tree
	 */
	void exitLt(KrenakLogoParser.LtContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#cs}.
	 * @param ctx the parse tree
	 */
	void enterCs(KrenakLogoParser.CsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#cs}.
	 * @param ctx the parse tree
	 */
	void exitCs(KrenakLogoParser.CsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#pu}.
	 * @param ctx the parse tree
	 */
	void enterPu(KrenakLogoParser.PuContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#pu}.
	 * @param ctx the parse tree
	 */
	void exitPu(KrenakLogoParser.PuContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#pd}.
	 * @param ctx the parse tree
	 */
	void enterPd(KrenakLogoParser.PdContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#pd}.
	 * @param ctx the parse tree
	 */
	void exitPd(KrenakLogoParser.PdContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#ht}.
	 * @param ctx the parse tree
	 */
	void enterHt(KrenakLogoParser.HtContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#ht}.
	 * @param ctx the parse tree
	 */
	void exitHt(KrenakLogoParser.HtContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#st}.
	 * @param ctx the parse tree
	 */
	void enterSt(KrenakLogoParser.StContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#st}.
	 * @param ctx the parse tree
	 */
	void exitSt(KrenakLogoParser.StContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#home}.
	 * @param ctx the parse tree
	 */
	void enterHome(KrenakLogoParser.HomeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#home}.
	 * @param ctx the parse tree
	 */
	void exitHome(KrenakLogoParser.HomeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#stop}.
	 * @param ctx the parse tree
	 */
	void enterStop(KrenakLogoParser.StopContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#stop}.
	 * @param ctx the parse tree
	 */
	void exitStop(KrenakLogoParser.StopContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(KrenakLogoParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(KrenakLogoParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#setxy}.
	 * @param ctx the parse tree
	 */
	void enterSetxy(KrenakLogoParser.SetxyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#setxy}.
	 * @param ctx the parse tree
	 */
	void exitSetxy(KrenakLogoParser.SetxyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#random}.
	 * @param ctx the parse tree
	 */
	void enterRandom(KrenakLogoParser.RandomContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#random}.
	 * @param ctx the parse tree
	 */
	void exitRandom(KrenakLogoParser.RandomContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#fore}.
	 * @param ctx the parse tree
	 */
	void enterFore(KrenakLogoParser.ForeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#fore}.
	 * @param ctx the parse tree
	 */
	void exitFore(KrenakLogoParser.ForeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(KrenakLogoParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(KrenakLogoParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(KrenakLogoParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(KrenakLogoParser.CommentContext ctx);
}