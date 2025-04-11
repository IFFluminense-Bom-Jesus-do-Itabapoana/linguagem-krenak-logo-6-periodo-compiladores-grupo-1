/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author luanp
 */
public class TerminalPrinter {

    private JTextPane terminalArea;

    // Construtor
    public TerminalPrinter(JTextPane terminalArea) {
        this.terminalArea = terminalArea;
    }

    // Método para imprimir no terminal com valor padrão 'n'
    public void print(Object s) {
        print(s, 'n'); // Exemplo de valor padrão para classPrint
    }

    // Método para imprimir no terminal com a classe de impressão especificada
    public void print(Object s, char classPrint) {
        switch (classPrint) {
            case 'w' ->
                appendToTerminal(s, Color.YELLOW);
            case 'e' ->
                appendToTerminal(s, Color.RED);
            case 'n' ->
                appendToTerminal(s, Color.WHITE);
            case 'i' ->
                appendToTerminal(s, Color.CYAN);
            default ->
                appendToTerminal(s, Color.WHITE);
        }
    }

    // Método privado para adicionar texto ao terminal com a cor especificada
    private void appendToTerminal(Object s, Color c) {
        String message = (s instanceof String) ? (String) s : s.toString();

        StyledDocument doc = terminalArea.getStyledDocument();
        Style style = terminalArea.addStyle("Style", null);
        Style tstyle = terminalArea.addStyle("Style", null);

        StyleConstants.setForeground(style, c);
        StyleConstants.setForeground(tstyle, Color.WHITE);

        try {
            doc.insertString(doc.getLength(), "\n /Krenak/> ", tstyle);
            doc.insertString(doc.getLength(), message, style);
        } catch (BadLocationException e) {
            System.out.println("Error Terminal");
            e.printStackTrace();
            
        }
    }

}
