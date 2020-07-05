package TestesUnitarios;

import Teste.MarcaAutomovel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarcaAutomovelTest {

    @Test
    public void testCreate(){
        MarcaAutomovel marcaTeste = new MarcaAutomovel("ford");
        assertNotNull(marcaTeste);

    }

    @Test
    public void getNome() {
        MarcaAutomovel marcaTeste = new MarcaAutomovel("ford");
        assertEquals(marcaTeste.getNome(), "ford");
    }

}