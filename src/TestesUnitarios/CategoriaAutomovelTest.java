package TestesUnitarios;

import Teste.CategoriaAutomovel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaAutomovelTest {

    @Test
    public void testCreate(){
        CategoriaAutomovel catTeste = new CategoriaAutomovel("suv");
        assertNotNull(catTeste);

    }

    @Test
    public void getNome() {
        CategoriaAutomovel catTeste = new CategoriaAutomovel("suv");
        assertEquals(catTeste.getNome(), "suv");
    }

}