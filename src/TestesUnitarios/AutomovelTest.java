package TestesUnitarios;

import Teste.Automovel;
import Teste.CategoriaAutomovel;
import Teste.MarcaAutomovel;
import Teste.ModeloNacional;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutomovelTest {

    @Test
    public void testCreate(){
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        Automovel auto1 = new Automovel("IRG1877",2015,300, modTeste);
        assertNotNull(auto1);
    }

    @Test
    void setDisponivel() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        Automovel auto1 = new Automovel("IRG1877",2015,300, modTeste);
        auto1.setDisponivel(1);
        assertEquals(auto1.getDisponivel(), true);
    }


    @Test
    void getValorDiaria() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        Automovel auto1 = new Automovel("IRG1877",2015,300, modTeste);
        assertEquals(auto1.getValorDiaria(),300);
    }

    @Test
    void getNomeModelo() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        Automovel auto1 = new Automovel("IRG1877",2015,300, modTeste);
        assertEquals(auto1.getNomeModelo(),"fiesta");
    }

    @Test
    void getCategoria() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        Automovel auto1 = new Automovel("IRG1877",2015,300, modTeste);
        assertNotNull(auto1.getCategoria());
    }

    @Test
    void getPlaca() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        Automovel auto1 = new Automovel("IRG1877",2015,300, modTeste);
        assertEquals(auto1.getPlaca(),"IRG1877");
    }

    @Test
    void getAno() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        Automovel auto1 = new Automovel("IRG1877",2015,300, modTeste);
        assertEquals(auto1.getAno(), 2015);
    }

    @Test
    void getModelo() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        Automovel auto1 = new Automovel("IRG1877",2015,300, modTeste);
        assertNotNull(auto1.getModelo());
    }

}