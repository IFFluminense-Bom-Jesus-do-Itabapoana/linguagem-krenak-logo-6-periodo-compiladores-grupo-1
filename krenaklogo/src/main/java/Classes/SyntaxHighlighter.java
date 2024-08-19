/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import br.edu.iff.bji.ec.compiladores.krenaklogo.KrenakLogoLexer;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author luanp
 */
public class SyntaxHighlighter {

    private final LineNumberingText lineNumberingTextArea;
    private final JTextPane textArea;

    public SyntaxHighlighter(LineNumberingText lineNumberingTextArea, JTextPane textArea) {
        this.lineNumberingTextArea = lineNumberingTextArea;
        this.textArea = textArea;

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                highlightText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                highlightText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //highlightText();
            }
        });
    }

    private void highlightText() {
        // Inicia uma nova tarefa de colorização com SwingWorker
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                try {
                    String text = textArea.getText(0, textArea.getDocument().getLength());
                    applyHighlighting(text);
                } catch (BadLocationException e) {
                    System.out.println("Error Lighter");
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void done() {
                // Atualiza a interface gráfica após a conclusão da colorização
                textArea.repaint();
            }
        }.execute();
    }

    private void applyHighlighting(String text) {
        StyledDocument doc = textArea.getStyledDocument();

        // Cria estilos padrão e específicos para diferentes tipos de tokens
        Style defaultStyle = textArea.addStyle("Default", null);
        StyleConstants.setForeground(defaultStyle, Color.GREEN);
        doc.setCharacterAttributes(0, text.length(), defaultStyle, true);

        Style keywordStyle = textArea.addStyle("Keyword", null);
        StyleConstants.setForeground(keywordStyle, Color.CYAN);

        Style numberStyle = textArea.addStyle("Number", null);
        StyleConstants.setForeground(numberStyle, Color.ORANGE);

        Style stringStyle = textArea.addStyle("String", null);
        StyleConstants.setForeground(stringStyle, Color.WHITE);

        Style commentStyle = textArea.addStyle("Comment", null);
        StyleConstants.setForeground(commentStyle, Color.GRAY);
        
        Style startStyle = textArea.addStyle("StartEnd", null);
        StyleConstants.setForeground(startStyle, Color.MAGENTA);

        // Utiliza o lexer para identificar tokens e aplicar estilos
        CharStream cs = CharStreams.fromString(text);
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();

        // Aplica os estilos aos tokens
        for (Token token : tokens.getTokens()) {
            int tokenStart = token.getStartIndex();
            int tokenEnd = token.getStopIndex() + 1;

            Style style = null;
            switch (token.getType()) {
                case KrenakLogoLexer.STRINGLITERAL, KrenakLogoLexer.STRING -> style = stringStyle;
                case KrenakLogoLexer.NUMBER -> style = numberStyle;
                case KrenakLogoLexer.COMMENT -> style = commentStyle;
                case KrenakLogoLexer.T__0, KrenakLogoLexer.T__1 -> style = startStyle;
                default -> {
                    if (isKeyword(token.getText())) {
                        style = keywordStyle;
                    }
                }
            }

            if (style != null) {
                doc.setCharacterAttributes(tokenStart, tokenEnd - tokenStart, style, true);
            }
        }
    }

    private boolean isKeyword(String text) {
        // Define as palavras-chave para destaques
        String[] keywords = {"tupü", "ak", "intai", "huk", "kr", "kurim", "pb", "po tu um bakui", "ph", "po tu um hek hek",
            "hh", "hion-hinkut", "kh", "kanhinkut", "kischem", "jan", "kanhun", "iopu", "krahiimakuan", "himpa",
            "intschom", "pip", "mg", "mrong", "at", "anthore", "nk", "nikuanin", "mk", "mokia"};
        for (String keyword : keywords) {
            if (keyword.equals(text)) {
                return true;
            }
        }
        return false;
    }
}
