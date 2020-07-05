package TestesUnitarios;

import Teste.CategoriaAutomovel;
import Teste.MarcaAutomovel;
import Teste.ModeloImportado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModeloImportadoTest {

    @Test
    public void testCreate() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloImportado modTeste = new ModeloImportado("fiesta", m1, c1, 5000, 50);
        assertNotNull(modTeste);
    }

    @Test
    void getNome() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloImportado modTeste = new ModeloImportado("fiesta", m1, c1, 5000, 50);
        assertEquals(m1.getNome(),"fiesta");
    }

    @Test
    void getCategoria() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloImportado modTeste = new ModeloImportado("fiesta", m1, c1, 5000, 50);
        assertNotNull(modTeste.getCategoria());
    }

    @Test
    void getMarca() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloImportado modTeste = new ModeloImportado("fiesta", m1, c1, 5000, 50);
        assertNotNull(modTeste.getMarca());
    }

    @Test
    void getTaxa() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloImportado modTeste = new ModeloImportado("fiesta", m1, c1, 5000, 50);
        assertEquals(modTeste.getTaxa(), 50);
    }

    @Test
    void getValor() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloImportado modTeste = new ModeloImportado("fiesta", m1, c1, 5000, 50);
        assertEquals(modTeste.getValor(), 5000);
    }

    @Test
    void getValorFixo() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloImportado modTeste = new ModeloImportado("fiesta", m1, c1, 5000, 50);
        assertEquals(modTeste.getValorFixo(), 5625);
    }

}