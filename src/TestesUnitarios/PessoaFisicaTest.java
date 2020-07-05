package TestesUnitarios;

import Teste.PessoaFisica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaFisicaTest {

    @Test
    public void testCreate(){
        PessoaFisica clienteTeste = new PessoaFisica("João", "999437892", "74774021");
        assertNotNull(clienteTeste);
    }

    @Test
    void getNome() {
        PessoaFisica clienteTeste = new PessoaFisica("João", "999437892", "74774021");
        assertEquals(clienteTeste.getNome(), "João");
    }

    @Test
    void getTelefone() {
        PessoaFisica clienteTeste = new PessoaFisica("João", "999437892", "74774021");
        assertEquals(clienteTeste.getTelefone(), "999437892");
    }

    @Test
    void getCpf() {
        PessoaFisica clienteTeste = new PessoaFisica("João", "999437892", "74774021");
        assertEquals(clienteTeste.getCpf(), "74774021");
    }

}