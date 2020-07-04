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

public class TelaGerCadastraAutomovel extends Application {

    private MenuGerente menuGer;
    private ListaModelo listaMod;
    private ListaAutomoveis listaAuto;
    private ToggleGroup rbNacionalImportado;
    private RadioButton rbNacional, rbImportado;



    public TelaGerCadastraAutomovel(MenuGerente menuGer, ListaModelo lmod, ListaAutomoveis la) {
        super();
        this.menuGer = menuGer;
        this.listaMod = lmod;
        this.listaAuto = la;

    }

    @Override
    public void start(Stage primaryStage) {
        // Acesso ao stage (palco) da aplicacao
        Stage thestage = primaryStage;

        GridPane painel4 = new GridPane();

        painel4.setAlignment(Pos.CENTER);
        painel4.setHgap(10);
        painel4.setVgap(10);
        painel4.setPadding(new Insets(25, 25, 25, 25));
        painel4.setGridLinesVisible(false);

        Text scenetitle = new Text("Cadastrar automóvel");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        painel4.add(scenetitle, 0, 0, 2, 1);

        // create labels

        Label placaAutomovel = new Label("Digite a placa do automóvel");
        painel4.add(placaAutomovel, 0, 2);
        TextField placaAutomovelTextField = new TextField();
        painel4.add(placaAutomovelTextField, 1, 2);


        Label anoAutomovel = new Label("Digite o ano do automóvel");
        painel4.add(anoAutomovel, 0, 1);
        TextField anoAutomovelTextField = new TextField();
        painel4.add(anoAutomovelTextField, 1, 1);

        Label nomeCategoria = new Label("Digite o valor da diária do automóvel");
        painel4.add(nomeCategoria, 0, 3);
        TextField nomeCategoriaTextField = new TextField();
        painel4.add(nomeCategoriaTextField, 1, 3);

        Label nomeModelo = new Label("Digite o nome do modelo");
        painel4.add(nomeModelo, 0, 4);
        TextField nomeModeloTextField = new TextField();
        painel4.add(nomeModeloTextField, 1, 4);




        Label labelListaDeModelos = new Label("Lista de modelos cadastrados");
        painel4.add(labelListaDeModelos,0,8);
        TextArea listaDeModelos = new TextArea();
        listaDeModelos.setPrefHeight(125);
        listaDeModelos.setPrefWidth(400);
        listaDeModelos.setText(listaMod.toString());
        painel4.add(listaDeModelos,1,8);
        listaDeModelos.setId("listaDeModelos");





        Button btnCadastrarAutomovel = new Button("Cadastrar");
        Button btnVoltar = new Button("Voltar");
        Button btnSalvar = new Button("Salvar automóveis");

        btnVoltar.setStyle("-fx-text-fill: #b22222");





        painel4.add(btnCadastrarAutomovel, 1, 5);
        painel4.add(btnSalvar,1,6);
        painel4.add(btnVoltar, 0, 9);


        final Text actiontarget = new Text();
        painel4.add(actiontarget, 1, 10);
        actiontarget.setId("actiontarget");



        // Tratamento de evento dos botoes
        btnVoltar.setOnAction(e -> {
            try {
                menuGer.start(thestage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnCadastrarAutomovel.setOnAction(e -> {
            try {


            } catch (Exception ex) {
                ex.printStackTrace();
            }


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
        Scene scene4 = new Scene(painel4, 700, 500);

        primaryStage.setTitle("Cadastrar automóvel");
        primaryStage.setScene(scene4);
        primaryStage.show();
    }

}
