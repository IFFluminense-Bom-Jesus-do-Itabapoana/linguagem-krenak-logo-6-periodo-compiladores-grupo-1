package br.edu.iff.bji.ec.compiladores.krenaklogo;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KrenakLogoLexerTest {
    
    @Test
    public void testAlgoritmoToken() {
        CharStream cs = CharStreams.fromString("Hello");
        KrenakLogoLexer lexer = new KrenakLogoLexer(cs);
        Token token = lexer.nextToken();
        assertEquals(1, token.getType());
        assertEquals("Hello", token.getText());
        
        token = lexer.nextToken();
        assertEquals("<EOF>", token.getText());
    }
    
}
