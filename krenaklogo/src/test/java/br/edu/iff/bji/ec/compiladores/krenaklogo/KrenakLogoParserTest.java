/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.edu.iff.bji.ec.compiladores.krenaklogo;

import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;
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
        String input = "tupü teste\n"
                + "  intschom \"variavel\" 10 + 20 \n"
                + "  pip :variavel \n"
                 + "  pip [puts] \n"
                + "ak \n";

        CharStream cs = CharStreams.fromString(input);
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        KrenakLogoParser parser = new KrenakLogoParser(tokens);
        

        // Adiciona um listener de erro personalizado para mostrar informações sobre os erros
        parser.removeErrorListeners(); // Remove os listeners padrão
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                    int line, int charPositionInLine, String msg,
                    RecognitionException e) {
                System.err.printf("Erro de sintaxe na linha %d, posição %d: %s%n",
                        line, charPositionInLine, msg);
            }
        });

        // Processa o código de entrada
        try {
            ParseTree tree = parser.prog(); // Aqui o parser será executado
            System.out.println(tree.toStringTree(parser));
            // Verificar a saída do comando print
            String expectedOutput = "puts";
            String actualOutput = getPrintStatementOutput(parser, tree);
            // Remover espaços em branco extras antes de comparar
            assertEquals(expectedOutput.replaceAll("\\s+", ""), actualOutput.replaceAll("\\s+", ""));
        } catch (RecognitionException | ParseCancellationException ex) {
            // Captura exceções de reconhecimento (não deveria ocorrer se o parser terminar sem erros)
            System.err.println("Erro durante a análise: " + ex.getMessage());
        }
        // Captura exceções de cancelamento de análise (parse)

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
        private Map<String, String> variables = new HashMap<>();

        public PrintStatementListener(KrenakLogoParser parser) {
            this.parser = parser;
        }

        @Override
        public void exitMake(KrenakLogoParser.MakeContext ctx) {
           String varName = ctx.STRINGLITERAL().getText();
            varName = varName.substring(1, varName.length() - 1); // Remove as aspas
            String varValue = ctx.value().getText();
             if (varValue.startsWith("\"")) {
                 varValue = varValue.substring(1, varValue.length() - 1);
             }
            variables.put(varName, varValue);
            System.out.println("Definindo variável: " + varName + " com valor: " + varValue);
        }

        @Override
        public void exitPrint_(KrenakLogoParser.Print_Context ctx
        ) {
            if (ctx.quotedstring() != null) {
                String quotedString = ctx.quotedstring().getText(); // Obtém o texto do quotedstring
                String cleanedText = quotedString.substring(1, quotedString.length() - 1); // Remove os colchetes
                printStatement = cleanedText; // Define a declaração de impressão como o texto limpo
                System.out.println("É um quotedstring: " + cleanedText);
            } else if (ctx.value() != null) {
               String value = ctx.value().getText();
                if (value.startsWith(":")) {
                    String varName = value.substring(1);
                    var text = variables.getOrDefault(varName, "undefined");
                    printStatement = text;
                } else {
                    printStatement = value;
                }
                System.out.println("É um value: " + printStatement); // Assume que o texto está no segundo filho

            } else {
                // Outro tipo de statement
                System.out.println("É um algo: " + ctx.getText());
                printStatement = ctx.getChild(1).getText(); // Assume que o texto está no segundo filho

            }
        }

        public String getPrintStatement() {
            return printStatement;
        }
    }

}
