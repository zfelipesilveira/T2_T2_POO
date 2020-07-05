package TestesUnitarios;

import Teste.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocacaoTest {

    @Test
    public void testCreate(){
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        Automovel auto1 = new Automovel("IRG1877",2015,300, modTeste);
        PessoaFisica clienteTeste = new PessoaFisica("João", "999437892", "74774021");
        Locacao l1 = new Locacao(clienteTeste, auto1,"15/03/2020","20/02/2020");
        assertNotNull(l1);
    }

    @Test
    void getValorLocacao() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        Automovel auto1 = new Automovel("IRG1877",2015,300, modTeste);
        PessoaFisica clienteTeste = new PessoaFisica("João", "999437892", "74774021");
        Locacao l1 = new Locacao(clienteTeste, auto1,"15/03/2020","20/02/2020");
        assertEquals(l1.getValorLocacao(),6007.5);
    }

    @Test
    void getCliente() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        Automovel auto1 = new Automovel("IRG1877",2015,300, modTeste);
        PessoaFisica clienteTeste = new PessoaFisica("João", "999437892", "74774021");
        Locacao l1 = new Locacao(clienteTeste, auto1,"15/03/2020","20/02/2020");
        assertNotNull(l1.getCliente());
    }

    @Test
    void getAutomovel() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        Automovel auto1 = new Automovel("IRG1877",2015,300, modTeste);
        PessoaFisica clienteTeste = new PessoaFisica("João", "999437892", "74774021");
        Locacao l1 = new Locacao(clienteTeste, auto1,"15/03/2020","20/02/2020");
        assertNotNull(l1.getAutomovel());
    }

    @Test
    void getPeriodo() {
        CategoriaAutomovel c1 = new CategoriaAutomovel("suv");
        MarcaAutomovel m1 = new MarcaAutomovel("ford");
        ModeloNacional modTeste = new ModeloNacional("fiesta", m1, c1, 5000, 50);
        Automovel auto1 = new Automovel("IRG1877",2015,300, modTeste);
        PessoaFisica clienteTeste = new PessoaFisica("João", "999437892", "74774021");
        Locacao l1 = new Locacao(clienteTeste, auto1,"15/03/2020","20/02/2020");
        assertEquals(l1.getPeriodo(),20);

    }

}