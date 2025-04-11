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

    @Test
    public void testPenupTokens() {
        // Penup -> po tu um bakui (punho acima)
        String[] inputs = {"po tu um bakui", "pb"};
        int[] expectedTokenTypes = {KrenakLogoLexer.T__28, KrenakLogoLexer.T__27};

        for (int i = 0; i < inputs.length; i++) {
            CharStream cs = CharStreams.fromString(inputs[i]);
            KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
            Token token = lexer.nextToken();

            assertEquals(expectedTokenTypes[i], token.getType());
            assertEquals(inputs[i], token.getText());

            token = lexer.nextToken();
            assertEquals(Token.EOF, token.getType());
        }
    }

    @Test
    public void testPendownTokens() {
        // Pendown -> po tu um hek hek (punho baixo)
        String[] inputs = {"po tu um hek hek", "ph"};
        int[] expectedTokenTypes = {KrenakLogoLexer.T__30, KrenakLogoLexer.T__29};

        for (int i = 0; i < inputs.length; i++) {
            CharStream cs = CharStreams.fromString(inputs[i]);
            KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
            Token token = lexer.nextToken();

            assertEquals(expectedTokenTypes[i], token.getType());
            assertEquals(inputs[i], token.getText());

            token = lexer.nextToken();
            assertEquals(Token.EOF, token.getType());
        }
    }

    @Test
    public void testHideturtleTokens() {
        // Hide Turtle -> Hion-Hinkut (Esconder tartaruga)
        String[] inputs = {"hion-hinkut", "hh"};
        int[] expectedTokenTypes = {KrenakLogoLexer.T__32, KrenakLogoLexer.T__31};

        for (int i = 0; i < inputs.length; i++) {
            CharStream cs = CharStreams.fromString(inputs[i]);
            KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
            Token token = lexer.nextToken();

            assertEquals(expectedTokenTypes[i], token.getType());
            assertEquals(inputs[i], token.getText());

            token = lexer.nextToken();
            assertEquals(Token.EOF, token.getType());
        }
    }

    @Test
    public void testLtToken() {
        // lt -> mk (esquerda)
        CharStream cs = CharStreams.fromString("mk");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__23, token.getType()); // Verifique o tipo correto para 'intschom'
        assertEquals("mk", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }

    @Test
    public void testLeftToken() {
        // Left -> mokia (esquerda)
        CharStream cs = CharStreams.fromString("mokia");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__24, token.getType()); // Verifique o tipo correto para 'nikuanin'
        assertEquals("mokia", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }

    @Test
    public void testClearscreenToken() {
        // Clearscreen -> kurim (limpar)
        CharStream cs = CharStreams.fromString("kurim");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__26, token.getType()); // Verifique o tipo correto para 'intschom'
        assertEquals("kurim", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }

    @Test
    public void testCsToken() {
        //cs= kr(limpar)
        CharStream cs = CharStreams.fromString("kr");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__25, token.getType()); // Verifique o tipo correto para 'intschom'
        assertEquals("kr", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }

    @Test
    public void testForToken() {
        //for= himpa(muitas vezes)
        CharStream cs = CharStreams.fromString("himpa");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__40, token.getType()); // Verifique o tipo correto para 'intschom'
        assertEquals("himpa", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }

    @Test
    public void testIfToken() {
        // If -> huk(qual)
        CharStream cs = CharStreams.fromString("huk");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__7, token.getType()); // Verifique o tipo correto para 'intschom'
        assertEquals("huk", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }

    @Test
    public void testFdToken() {
        // Fd -> mg(Para Frente - Abreviacao)
        CharStream cs = CharStreams.fromString("mg");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__17, token.getType()); // Verifique o tipo correto para 'intschom'
        assertEquals("mg", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }

    @Test
    public void testForwardToken() {
        // Forward -> mrong(Para Frente)
        CharStream cs = CharStreams.fromString("mrong");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__18, token.getType()); // Verifique o tipo correto para 'intschom'
        assertEquals("mrong", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }

    @Test
    public void testBkToken() {
        // Bk -> at(Para Atras - Abreviacao)
        CharStream cs = CharStreams.fromString("at");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__19, token.getType()); // Verifique o tipo correto para 'intschom'
        assertEquals("at", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }

    @Test
    public void testBackwardToken() {
        // Backward -> anthore(Para Atras)
        CharStream cs = CharStreams.fromString("anthore");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__20, token.getType()); // Verifique o tipo correto para 'intschom'
        assertEquals("anthore", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }

    @Test
    public void testLabelToken() {
        // Label -> kanhun(nome)
        CharStream cs = CharStreams.fromString("kanhun");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__37, token.getType()); // Verifique o tipo correto para 'intschom'
        assertEquals("kanhun", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }

    @Test
    public void testRandomToken() {
        // Random -> krahiimakuan(Alguém)
        CharStream cs = CharStreams.fromString("krahiimakuan");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__39, token.getType()); // Verifique o tipo correto para 'intschom'
        assertEquals("krahiimakuan", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }

    @Test
    public void testStToken() {
        // st -> kh (show turtle)
        CharStream cs = CharStreams.fromString("kh");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__33, token.getType()); // Verifique o tipo correto para 'intschom'
        assertEquals("kh", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }

    @Test
    public void testShowturtleToken() {
        // showturtle -> kanhinkut (show turtle)
        CharStream cs = CharStreams.fromString("kanhinkut");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();

        assertEquals(KrenakLogoLexer.T__34, token.getType()); // Verifique o tipo correto para 'intschom'
        assertEquals("kanhinkut", token.getText()); // Verifique o texto correto

        token = lexer.nextToken();
        assertEquals(Token.EOF, token.getType()); // Verifique o fim do arquivo
    }
}
