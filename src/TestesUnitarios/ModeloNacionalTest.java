package TestesUnitarios;

import ClassesBasicas.CategoriaAutomovel;
import ClassesBasicas.MarcaAutomovel;
import ClassesBasicas.ModeloNacional;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModeloNacionalTest {

    @Test
    public void testCreate() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        assertNotNull(modTeste);
    }

    @Test
    void getNome() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        assertEquals(m1.getNome(),"fiesta");
    }

    @Test
    void getCategoria() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        assertNotNull(modTeste.getCategoria());
    }

    @Test
    void getMarca() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        assertNotNull(modTeste.getMarca());
    }

    @Test
    void getTaxa() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        assertEquals(modTeste.getIpi(), 50);
    }

    @Test
    void getValor() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        assertEquals(modTeste.getValor(), 5000);
    }

    @Test
    void getValorFixo() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        assertEquals(modTeste.getValorFixo(), 5250);
    }

}