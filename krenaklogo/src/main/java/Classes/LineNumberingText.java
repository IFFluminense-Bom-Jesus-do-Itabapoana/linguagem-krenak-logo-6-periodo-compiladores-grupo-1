/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JComponent;
import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Utilities;

/**
 *
 * @author luanp
 */
public class LineNumberingText extends JComponent implements CaretListener, DocumentListener, PropertyChangeListener {

    private static final long serialVersionUID = 1L;
    private final JTextPane textPane;
    private int lastDigits;
    private int lastHeight;
    private int lastLineCount;

    public LineNumberingText(JTextPane textPane) {
        this.textPane = textPane;
        textPane.getDocument().addDocumentListener(this);
        textPane.addCaretListener(this);
        textPane.addPropertyChangeListener(this);
        lastDigits = 0;
        lastHeight = 0;
        lastLineCount = 0;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        FontMetrics fontMetrics = textPane.getFontMetrics(textPane.getFont());
        Insets insets = textPane.getInsets();
        int availableWidth = getWidth() - insets.left - insets.right;
        int lineHeight = fontMetrics.getHeight();
        int y = insets.top + fontMetrics.getAscent();

        int startOffset = textPane.viewToModel(new Point(0, insets.top));
        int endOffset = textPane.viewToModel(new Point(0, getHeight()));

        while (startOffset <= endOffset) {
            try {
                int lineNumber = getLineNumber(startOffset);
                String lineNumberText = String.valueOf(lineNumber);
                int stringWidth = fontMetrics.stringWidth(lineNumberText);
                int x = availableWidth - stringWidth;
                g.drawString(lineNumberText, x, y);
                startOffset = Utilities.getRowEnd(textPane, startOffset) + 1;
                y += lineHeight;
            } catch (Exception e) {
                break;
            }
        }
    }

    private int getLineNumber(int offset) {
        Document doc = textPane.getDocument();
        Element root = doc.getDefaultRootElement();
        return root.getElementIndex(offset) + 1;
    }

    @Override
    public Dimension getPreferredSize() {
        int lineCount = getLineCount();
        int digits = Math.max(3, String.valueOf(lineCount).length());
        FontMetrics fontMetrics = textPane.getFontMetrics(textPane.getFont());
        int width = digits * fontMetrics.charWidth('0') + 6;
        int height = textPane.getHeight();

        if (lastDigits != digits) {
            lastDigits = digits;
            firePropertyChange("preferredWidth", 0, width);
        }

        if (lastHeight != height) {
            lastHeight = height;
            firePropertyChange("preferredHeight", 0, height);
        }

        return new Dimension(width, height);
    }

    private int getLineCount() {
        Element root = textPane.getDocument().getDefaultRootElement();
        return root.getElementCount();
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        repaint();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        documentChanged();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        documentChanged();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        documentChanged();
    }

    protected void documentChanged() {
        int lineCount = getLineCount();
        if (lineCount != lastLineCount) {
            repaint();
            lastLineCount = lineCount;
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("font".equals(evt.getPropertyName())) {
            repaint();
        }
    }
}
