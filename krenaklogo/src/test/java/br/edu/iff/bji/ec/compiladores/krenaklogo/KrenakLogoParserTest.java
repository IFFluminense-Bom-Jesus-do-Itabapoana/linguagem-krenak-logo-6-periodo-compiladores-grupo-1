/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.edu.iff.bji.ec.compiladores.krenaklogo;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author fbarr
 */
public class KrenakLogoParserTest {

    @Test
    public void test() {

    }

    @Test
    public void testPrintExpression() {
        // Criar um fluxo de caracteres a partir da expressão "pip 8 + 4"
        CharStream cs = CharStreams.fromString("pip 8 + 4");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        KrenakLogoParser parser = new KrenakLogoParser(tokens);

        // Verificar se a análise foi bem-sucedida
        KrenakLogoParser.ProgContext tree = parser.prog();
        assertNotNull(tree);

        // Verificar se a árvore de análise contém a expressão esperada
        KrenakLogoParser.LineContext line = tree.line(0);
        assertNotNull(line);

        KrenakLogoParser.Print_Context printStat = line.print_();
        assertNotNull(printStat);

        // Verificar a expressão dentro da instrução de impressão
        KrenakLogoParser.ValueContext value = printStat.value();
        assertNotNull(value);

        KrenakLogoParser.ExpressionContext expr = value.expression();
        assertNotNull(expr);

        // Verificar a soma
        assertEquals(3, expr.getChildCount()); // expr + expr
        assertEquals("8", expr.getChild(0).getText());
        assertEquals("+", expr.getChild(1).getText());
        assertEquals("4", expr.getChild(2).getText());
    }

    @Test
    public void testPrintStatement() {
        String input = "tupü teste ak\n"
                + "  pip banana\n"
                + "ak\n";

        CharStream cs = CharStreams.fromString(input);
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        KrenakLogoParser parser = new KrenakLogoParser(tokens);

        ParseTree tree = parser.prog();
        
        System.out.println(tree.toStringTree(parser));

        // Verificar a saída do comando print
        String expectedOutput = "banana";
        String actualOutput = getPrintStatementOutput(parser, tree);
        // Remover espaços em branco extras antes de comparar
        assertEquals(expectedOutput.replaceAll("\\s+", ""), actualOutput.replaceAll("\\s+", ""));
    }

    private String getPrintStatementOutput(KrenakLogoParser parser, ParseTree tree) {
        // Percorre a árvore para encontrar o contexto do comando print
        ParseTreeWalker walker = new ParseTreeWalker();
        PrintStatementListener listener = new PrintStatementListener(parser);
        walker.walk(listener, tree);
        return listener.getPrintStatement();
    }

    private static class PrintStatementListener extends KrenakLogoBaseListener {

        private KrenakLogoParser parser;
        private String printStatement;

        public PrintStatementListener(KrenakLogoParser parser) {
            this.parser = parser;
        }

        @Override
        public void exitPrint_(KrenakLogoParser.Print_Context ctx) {
            // Obtém o texto do contexto do comando print
            printStatement = ctx.getChild(1).getText(); // Assume que o texto está no segundo filho
        }

        public String getPrintStatement() {
            return printStatement;
        }
    }

}
