package TestesUnitarios;

import Teste.PessoaJuridica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaJuridicaTest {

    @Test
    public void testCreate(){
        PessoaJuridica clienteTeste = new PessoaJuridica("Ambev", "999437892", "74774021");
        assertNotNull(clienteTeste);
    }

    @Test
    void getNome() {
        PessoaJuridica clienteTeste = new PessoaJuridica("Ambev", "999437892", "74774021");
        assertEquals(clienteTeste.getNome(), "Ambev");
    }

    @Test
    void getTelefone() {
        PessoaJuridica clienteTeste = new PessoaJuridica("Ambev", "999437892", "74774021");
        assertEquals(clienteTeste.getTelefone(), "999437892");
    }

    @Test
    void getCpf() {
        PessoaJuridica clienteTeste = new PessoaJuridica("João", "999437892", "74774021");
        assertEquals(clienteTeste.getCnpj(), "74774021");
    }

}