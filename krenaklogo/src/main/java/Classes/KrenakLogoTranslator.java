/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 *
 * @author luanp
 */
public class KrenakLogoTranslator {

    private Map<Integer, String> tokenMap;
    private TerminalPrinter terminal;
    private boolean hasSyntaxErrors;

    // Construtor
    public KrenakLogoTranslator(TerminalPrinter terminal) {
        this.terminal = terminal;
        this.hasSyntaxErrors = false;
        tokenMap = new HashMap<>();

        // Adicionando os mapeamentos
        tokenMap.put(1, "to");
        tokenMap.put(2, "end");
        tokenMap.put(3, ":");
        tokenMap.put(4, ",");
        tokenMap.put(5, "repeat");
        tokenMap.put(6, "[");
        tokenMap.put(7, "]");
        tokenMap.put(8, "if");
        tokenMap.put(9, "<");
        tokenMap.put(10, ">");
        tokenMap.put(11, "=");
        tokenMap.put(12, "make");
        tokenMap.put(13, "print");
        tokenMap.put(14, "+");
        tokenMap.put(15, "-");
        tokenMap.put(16, "*");
        tokenMap.put(17, "/");
        tokenMap.put(18, "fd");
        tokenMap.put(19, "forward");
        tokenMap.put(20, "bk");
        tokenMap.put(21, "back");
        tokenMap.put(22, "rt");
        tokenMap.put(23, "right");
        tokenMap.put(24, "lt");
        tokenMap.put(25, "left");
        tokenMap.put(26, "cs");
        tokenMap.put(27, "clearscreen");
        tokenMap.put(28, "pu");
        tokenMap.put(29, "penup");
        tokenMap.put(30, "pd");
        tokenMap.put(31, "pendown");
        tokenMap.put(32, "ht");
        tokenMap.put(33, "hideturtle");
        tokenMap.put(34, "st");
        tokenMap.put(35, "showturtle");
        tokenMap.put(36, "home");
        tokenMap.put(37, "stop");
        tokenMap.put(38, "label");
        tokenMap.put(39, "setxy");
        tokenMap.put(40, "random");
        tokenMap.put(41, "for");
    }

    public void addErrorListener(Parser parser) {
        parser.removeErrorListeners(); // Remove os listeners padrão
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                    int line, int charPositionInLine, String msg,
                    RecognitionException e) {
                String errorMsg = String.format("Erro de sintaxe na linha %d, posição %d: %s",
                        line, charPositionInLine, msg);
                terminal.print(errorMsg, 'e');
                hasSyntaxErrors = true;
            }
        });
    }

    public String translateTokens(CommonTokenStream tokens) {
        StringBuilder logoCode = new StringBuilder();

        tokens.getTokens().forEach(token -> {
            String translatedText = tradutor(token.getType());
            if (translatedText != null) {
                logoCode.append(translatedText);
                if (token.getType() != 3) { // 3 representa o token ":"
                    logoCode.append(" ");
                }
            } else if (!token.getText().equals("<EOF>")) {
                logoCode.append(token.getText()).append(" ");
            }
        });

        return logoCode.toString();
    }

    public File createLogoFile(String logoCode, String logoFileName) throws IOException {
        File logoFile = new File(logoFileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logoFile))) {
            writer.write(logoCode);
        }
        return logoFile;
    }

    public boolean hasSyntaxErrors() {
        return hasSyntaxErrors;
    }

    public String tradutor(int i) {
        return tokenMap.get(i);
    }
}
