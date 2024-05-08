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
    //TODO: Outros testes
}
