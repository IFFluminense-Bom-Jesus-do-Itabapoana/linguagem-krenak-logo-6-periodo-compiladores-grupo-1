/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.iff.bji.ec.compiladores.krenaklogo;

import Classes.KrenakLogoTranslator;
import Classes.LineNumberingText;
import Classes.SyntaxHighlighter;
import Classes.TerminalPrinter;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author luanp
 */
public class IDE extends javax.swing.JFrame {

    private boolean hasSyntaxErrors = false;
    private static boolean isDarkMode = true;
    TerminalPrinter terminal;

    /**
     * Creates new form IDE
     */
    public IDE() {
        try {
            Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Logo_bg.png"));
            setIconImage(iconeTitulo);
        } catch (Exception e) {
            System.out.println(e);
        }
        initComponents();  // Seu método de inicialização existente


        // Criar a JTextArea
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        // Criar o JScrollPane e adicionar a JTextArea a ele
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Criar e configurar a barra de números de linha
        LineNumberingText lineNumberingText = new LineNumberingText(textArea);
        scrollPane.setRowHeaderView(lineNumberingText);

        // Configurar o layout do painel para BorderLayout
        panel.setLayout(new BorderLayout());

        // Adicionar o JScrollPane ao painel (no centro, por exemplo)
        panel.add(scrollPane, BorderLayout.CENTER);

        terminal = new TerminalPrinter(terminalArea);
        SyntaxHighlighter syntaxHighlighter = new SyntaxHighlighter(lineNumberingText, textArea);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        terminalArea = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        menu = new javax.swing.JLabel();
        themebtn = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KRENAK LOGO");

        terminalArea.setEditable(false);
        terminalArea.setBackground(new java.awt.Color(51, 51, 51));
        terminalArea.setForeground(new java.awt.Color(255, 255, 255));
        terminalArea.setMaximumSize(new java.awt.Dimension(2147483647, 400));
        terminalArea.setSelectionColor(new java.awt.Color(204, 204, 204));
        jScrollPane2.setViewportView(terminalArea);

        jButton1.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        jButton1.setText("▶ RUN");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setHideActionText(true);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        panel.setPreferredSize(new java.awt.Dimension(375, 500));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/krenak branco1.png"))); // NOI18N

        menu.setText("...");
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMouseClicked(evt);
            }
        });

        themebtn.setText("Dark Mode");
        themebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themebtn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menu, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(themebtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        terminalArea.setText(" ");

        var code = textArea.getText();
        CharStream cs = CharStreams.fromString(code + "\n");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        KrenakLogoParser parser = new KrenakLogoParser(tokens);

        // Instancia o tradutor
        KrenakLogoTranslator krenakLogoTranslator = new KrenakLogoTranslator(terminal);

        // Adiciona o listener de erro através do método da classe
        krenakLogoTranslator.addErrorListener(parser);

        // Processa o código de entrada
        try {
            ParseTree tree = parser.prog(); // Aqui o parser será executado

            // Tradução dos tokens para código Logo
            String logoCode = krenakLogoTranslator.translateTokens(tokens);

            // Criação do arquivo Logo temporário
            String logoFileName = "temp.logo";
            File logoFile = krenakLogoTranslator.createLogoFile(logoCode, logoFileName);

            terminal.print("O cod foi criado com sucesso!", 'i');

            // Caminho para o intérprete Logo 
            String logoInterpreter = "C:\\Program Files (x86)\\UCBLogo\\ucblogo.exe";

            // Criação do comando para executar o arquivo Logo
            ProcessBuilder pb = new ProcessBuilder(logoInterpreter, logoFileName);
            pb.redirectErrorStream(true);

            // Inicia o processo se não houver erros
            if (!krenakLogoTranslator.hasSyntaxErrors()) {
                Process process = pb.start();

                new Thread(() -> {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            terminal.print(line, 'w');
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }

        } catch (RecognitionException | ParseCancellationException ex) {
            // Captura exceções de reconhecimento (não deveria ocorrer se o parser terminar sem erros)
            terminal.print("Erro durante a análise: " + ex.getMessage(), 'e');
        } catch (IOException ex) {
            System.out.println("Error IDE");
            Logger.getLogger(IDE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseClicked
        JDialog dialog = new JDialog();
        dialog.setTitle("Configurações");
        dialog.setModal(true); // Para bloquear outras interações até o fechamento
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Criar um JPanel para organizar os componentes
        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));

        // Criar o campo de entrada de texto
        panel.add(new JLabel("Selecione o caminho do UCBLogo:"));
        panel.add(textField);

        // Adicionar ação para o botão Submit
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode manipular a entrada de texto
                String inputText = textField.getText();
                System.out.println("Submitted: " + inputText);
                dialog.dispose(); // Fechar o pop-up
            }
        });

        // Adicionar ação para o botão Cancel
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Fechar o pop-up sem fazer nada
            }
        });

        // Criar um JPanel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        // Adicionar os painéis ao dialog
        dialog.getContentPane().add(panel, BorderLayout.CENTER);
        dialog.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Ajustar o tamanho e centralizar na tela
        dialog.pack();
        dialog.setLocationRelativeTo(null);

        // Tornar o dialog visível
        dialog.setVisible(true);

    }//GEN-LAST:event_menuMouseClicked

    private void themebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themebtnActionPerformed
        if (isDarkMode) {
            // Troca para o tema claro
            themebtn.setText("Light Mode");
            FlatLightLaf.setup();
        } else {
            // Troca para o tema escuro,
            themebtn.setText("Dark Mode");
            FlatDarkLaf.setup();
        }
        // Atualiza o tema na interface
        isDarkMode = !isDarkMode;

        FlatLightLaf.updateUI();
    }//GEN-LAST:event_themebtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel menu;
    private javax.swing.JPanel panel;
    private javax.swing.JTextPane terminalArea;
    private javax.swing.JToggleButton themebtn;
    // End of variables declaration//GEN-END:variables
   JTextPane textArea = new JTextPane();
    JButton submitButton = new JButton("Submit");
    JButton cancelButton = new JButton("Cancel");
    JTextField textField = new JTextField();
}
