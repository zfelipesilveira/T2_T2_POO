package sample;

import Teste.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
	Exemplo de aplicacao grafica com multiplas janelas
 */

public class MenuGerente extends Application {


    // telas necessárias
    private Application raiz;
    private TelaGerCarregarDados telaGerCarregarDados;
    private TelaGerCadastraCategoria telaGerCadastraCategoria;
    private TelaGerCadastraMarca telaGerCadastraMarca;
    private TelaGerCadastraModelo telaGerCadastraModelo;
    private TelaGerCadastraAutomovel telaGerCadastraAutomovel;
    // private TelaGerRemoveAutomovel telaGerRemoveAutomovel
    // private TelaGerConsultaLocacoes telaGerConsultaLocacoes
    // private TelaGerConsultaClientes telaGerConsultaClientes
    // private TelaGerConsultaAutomoveis telaGerConsultaAutomoveis

    //coleções necessárias
    private ListaAutomoveis listaAuto;
    private ListaCategoria listaCat;
    private ListaClientes listaCli;
    private ListaMarcas listaMar;
    private ListaModelo listaMod;
    private ListaLocacoes listaLoc;
    private PilhaPedidos pilhaPed;


    public MenuGerente(Application raiz, ListaAutomoveis la, ListaCategoria lcat, ListaClientes lcli,
                       ListaMarcas lmar, ListaModelo lmod, ListaLocacoes ll, PilhaPedidos pp) {
        super();
        this.raiz = raiz;


        //
        this.listaAuto = la;
        this.listaCat = lcat;
        this.listaCli = lcli;
        this.listaMar = lmar;
        this.listaMod = lmod;
        this.listaLoc = ll;
        this.pilhaPed = pp;


        telaGerCarregarDados = new TelaGerCarregarDados(this,la,lcat,lcli,lmar,lmod, ll, pp);
        telaGerCadastraCategoria = new TelaGerCadastraCategoria(this,listaCat);
        telaGerCadastraMarca = new TelaGerCadastraMarca(this, listaMar);
        telaGerCadastraModelo = new TelaGerCadastraModelo(this,listaMod,listaCat,listaMar);
        telaGerCadastraAutomovel = new TelaGerCadastraAutomovel(this,listaMod,listaAuto);


    }

    @Override
    public void start(Stage primaryStage) {
        // Acesso ao stage (palco) da aplicacao
        Stage thestage = primaryStage;

        GridPane painel2 = new GridPane();

        painel2.setAlignment(Pos.CENTER);
        painel2.setHgap(10);
        painel2.setVgap(10);
        painel2.setPadding(new Insets(25, 25, 25, 25));
        painel2.setGridLinesVisible(false);

        Text scenetitle = new Text("Menu de Gerente");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        painel2.add(scenetitle, 0, 0, 2, 1);

        // create labels


        Button btnCarregarDados = new Button("Carregar dados de arquivo");
        Button btnCadCat = new Button("Cadastrar nova categoria");
        Button btnCadMar = new Button("Cadastrar nova marca");
        Button btnCadMod = new Button("Cadastrar novo modelo");
        Button btnCadAuto = new Button("Cadastrar novo automóvel");
        Button btnRemoverAutomovel = new Button("Remover Automóvel");
        Button btnConsultarLocacoes = new Button("Consultar locações");
        Button btnConsultarClientes = new Button("Consultar clientes");
        Button btnConsultarAuto = new Button("Consultar automóveis");

        Button btnVoltar = new Button("Voltar para o menu principal");

        btnVoltar.setStyle("-fx-text-fill: #b22222");


        painel2.add(btnCarregarDados, 0, 3, 2, 1);
        painel2.add(btnCadCat, 0, 4);
        painel2.add(btnCadMar, 0, 5);
        painel2.add(btnCadMod, 0, 6);
        painel2.add(btnCadAuto, 0, 7);
        painel2.add(btnRemoverAutomovel, 0, 8);
        painel2.add(btnConsultarLocacoes, 0, 9);
        painel2.add(btnConsultarClientes, 0, 10);
        painel2.add(btnConsultarAuto, 0, 11);
        painel2.add(btnVoltar,0,12);





        // Tratamento de evento dos botoes
        btnVoltar.setOnAction(e -> {
            try {
                raiz.start(thestage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnCarregarDados.setOnAction(e -> {
            try {
                telaGerCarregarDados.start(thestage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnCadCat.setOnAction(e -> {
            try {
                telaGerCadastraCategoria.start(thestage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnCadMar.setOnAction(e -> {
            try {
                telaGerCadastraMarca.start(thestage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnCadMod.setOnAction(e -> {
            try {
                telaGerCadastraModelo.start(thestage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnCadAuto.setOnAction(e -> {
            try {
                telaGerCadastraAutomovel.start(thestage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

//        btnCadCli.setOnAction(e -> {
//            try {
//
//            }
//        });

//        btnFinal.setOnAction(e -> {
//            thestage.close();
//        });
        Scene scene2 = new Scene(painel2, 600, 500);

        primaryStage.setTitle("Menu de Gerente");
        primaryStage.setScene(scene2);
        primaryStage.show();
    }

}