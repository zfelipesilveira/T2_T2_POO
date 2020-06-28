package sample;



import Teste.*;
import TratamentoArquivos.LeituraArquivoTextoTeste;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Scanner;

/*
	Exemplo de aplicacao grafica com multiplas janelas
 */

public class TelaGerCarregarDados extends Application {

    private MenuGerente menuGer;
    private Cliente cliente;
    private ListaClientes lista = new ListaClientes(100);
    private ToggleGroup rbFisicaJuridica;
    private RadioButton rbFisica, rbJuridica;

    private ListaAutomoveis listaAuto;
    private ListaCategoria listaCat;
    private ListaClientes listaCli;
    private ListaMarcas listaMar;
    private ListaModelo listaModelo;
    private FilaPedidos filaPedidos;
    private ListaLocacoes listaLoca;

    private LeituraArquivoTextoTeste leArquivo;




    public TelaGerCarregarDados(MenuGerente menuGer) {
        super();
        this.menuGer = menuGer;
        this.listaAuto = new ListaAutomoveis(100);
        this.listaCat = new ListaCategoria(100);
        this.listaCli = new ListaClientes(100);
        this.listaMar = new ListaMarcas(100);
        this.listaModelo = new ListaModelo(100);
        this.filaPedidos = new FilaPedidos();
        this.listaLoca = new ListaLocacoes(100);
        this.leArquivo = new LeituraArquivoTextoTeste();


    }

    public ListaAutomoveis getListaAuto() {
        return listaAuto;
    }

    public ListaCategoria getListaCat() {
        return listaCat;
    }

    public ListaModelo getListaModelo() {
        return listaModelo;
    }

    public ListaLocacoes getListaLoca() {
        return listaLoca;
    }

    public ListaClientes getListaCli() {
        return listaCli;
    }

    public FilaPedidos getFilaPedidos() {
        return filaPedidos;
    }

    public ListaMarcas getListaMar() {
        return listaMar;
    }

    @Override
    public void start(Stage primaryStage) {
        // Acesso ao stage (palco) da aplicacao
        Stage thestage = primaryStage;

        GridPane painel3 = new GridPane();

        painel3.setAlignment(Pos.CENTER);
        painel3.setHgap(10);
        painel3.setVgap(10);
        painel3.setPadding(new Insets(25, 25, 25, 25));
        painel3.setGridLinesVisible(false);

        Text scenetitle = new Text("Carregar dados");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        painel3.add(scenetitle, 0, 0, 2, 1);

        // create labels

        Label nomeArquivo = new Label("Digite o nome do arquivo");
        painel3.add(nomeArquivo, 0, 1);

        TextField nomeArquivoTextField = new TextField();
        painel3.add(nomeArquivoTextField, 1, 1);




        Button btnCarregarDados = new Button("Carregar dados");
        Button btnVoltar = new Button("Voltar");





        painel3.add(btnCarregarDados, 1, 6);
        painel3.add(btnVoltar, 0, 8);

        final Text actiontarget = new Text();
        painel3.add(actiontarget, 1, 10);
        actiontarget.setId("actiontarget");



        // Tratamento de evento dos botoes
        btnVoltar.setOnAction(e -> {
            try {
                menuGer.start(thestage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnCarregarDados.setOnAction(e -> {
            leArquivo.leRegistrosTexto2(listaCat,listaMar,listaModelo,listaAuto,listaCli,filaPedidos);
            actiontarget.setFill(Color.GREEN);
            actiontarget.setText("Dados carregados!");


        });



//        btnCadastrar.setOnAction(e -> {
//            try {
//                raiz.start(thestage);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        });

//        btnCadCli.setOnAction(e -> {
//            try {
//
//            }
//        });

//        btnFinal.setOnAction(e -> {
//            thestage.close();
//        });
        Scene scene3 = new Scene(painel3, 500, 400);

        primaryStage.setTitle("Menu de Funcionários");
        primaryStage.setScene(scene3);
        primaryStage.show();
    }

}