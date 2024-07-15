package br.edu.iff.bji.ec.compiladores.krenaklogo;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KrenakLogoLexerTest {

    @Test
    public void testNumberToken() {
        CharStream cs = CharStreams.fromString("123");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();
        assertEquals(44, token.getType());
        assertEquals("123", token.getText());

        token = lexer.nextToken();
        assertEquals("<EOF>", token.getText());
    }

    @Test
    public void testStringLiteralToken() {
        CharStream cs = CharStreams.fromString("\"Olá\"");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();
        assertEquals(KrenakLogoLexer.STRINGLITERAL, token.getType());
        assertEquals("\"Olá\"", token.getText());

        token = lexer.nextToken();
        assertEquals(KrenakLogoLexer.EOF, token.getType());
    }

    @Test
    public void testIdentifierToken() {
        CharStream cs = CharStreams.fromString("foo bar baz");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);

        assertEquals(KrenakLogoLexer.STRING, lexer.nextToken().getType());
        assertEquals(KrenakLogoLexer.STRING, lexer.nextToken().getType());
        assertEquals(KrenakLogoLexer.STRING, lexer.nextToken().getType());

        assertEquals(KrenakLogoLexer.EOF, lexer.nextToken().getType());
    }

    @Test
    public void testProcedureToken() {
        // to -> tupü (Fazer)
        CharStream cs = CharStreams.fromString("tupü");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__0, token.getType()); // Verifique o tipo correto para 'tupu'
        assertEquals("tupü", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }
    @Test
    public void testEndToken() {
        // end -> ak (fechar, encerrar)
        CharStream cs = CharStreams.fromString("ak");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__1, token.getType()); // Verifique o tipo correto para 'ak'
        assertEquals("ak", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }
    
    @Test
    public void testPrintToken() {
        // print -> pip (ver)
        CharStream cs = CharStreams.fromString("pip");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__12, token.getType()); // Verifique o tipo correto para 'pip'
        assertEquals("pip", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }
    @Test
    public void testMakeToken() {
        // make -> intschom (fazer)
        CharStream cs = CharStreams.fromString("intschom");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__11, token.getType()); // Verifique o tipo correto para 'intschom'
        assertEquals("intschom", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }

    @Test
    public void testltToken() {
        CharStream cs = CharStreams.fromString("mk");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__23, token.getType()); // Verifique o tipo correto para 'intschom'
        assertEquals("mk", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }

    @Test
    public void testHomeToken() {
        // home -> kischem (Casa)
        CharStream cs = CharStreams.fromString("kischem");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__35, token.getType()); // Verifique o tipo correto para 'kischem'
        assertEquals("kischem", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
}
     @Test
    public void testStopToken() {
        // stop -> jan (Sair)
        CharStream cs = CharStreams.fromString("jan");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__36, token.getType()); // Verifique o tipo correto para 'jan'
        assertEquals("jan", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    
}
    
    
    @Test
    public void testRepeatToken() {
        // repeat -> intai (repetir)
        CharStream cs = CharStreams.fromString("intai");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__4, token.getType()); // Verifique o tipo correto para 'intschom'
        assertEquals("intai", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }

     @Test
    public void testSetxyToken() {
        // stexy -> iopu (pó-iopu/ dedo indicador)
        CharStream cs = CharStreams.fromString("iopu");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__38, token.getType()); // Verifique o tipo correto para 'iopu'
        assertEquals("iopu", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }
    
    @Test
    public void testRightToken() {
        // Right -> nikuanin (direita)
        CharStream cs = CharStreams.fromString("nikuanin");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__22, token.getType()); // Verifique o tipo correto para 'nikuanin'
        assertEquals("nikuanin", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }
@Test
    public void testRtToken() {
        // rt -> nk (direita)
        CharStream cs = CharStreams.fromString("nk");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__21, token.getType()); // Verifique o tipo correto para 'nk'
        assertEquals("nk", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }

}