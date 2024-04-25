// Generated from br/edu/iff/bji/ec/compiladores/krenaklogo/KrenakLogo.g4 by ANTLR 4.13.1
package br.edu.iff.bji.ec.compiladores.krenaklogo;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KrenakLogoParser}.
 */
public interface KrenakLogoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KrenakLogoParser#hello}.
	 * @param ctx the parse tree
	 */
	void enterHello(KrenakLogoParser.HelloContext ctx);
	/**
	 * Exit a parse tree produced by {@link KrenakLogoParser#hello}.
	 * @param ctx the parse tree
	 */
	void exitHello(KrenakLogoParser.HelloContext ctx);
}