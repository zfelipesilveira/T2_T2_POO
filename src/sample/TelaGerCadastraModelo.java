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

public class TelaGerCadastraModelo extends Application {

    private MenuGerente menuGer;
    private ListaModelo listaMod;
    private ListaCategoria listaCat;
    private ListaMarcas listaMar;
    private ToggleGroup rbNacionalImportado;
    private RadioButton rbNacional, rbImportado;



    public TelaGerCadastraModelo(MenuGerente menuGer, ListaModelo lmod, ListaCategoria lcat, ListaMarcas lmar) {
        super();
        this.menuGer = menuGer;
        this.listaMod = lmod;
        this.listaCat = lcat;
        this.listaMar = lmar;
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

        Text scenetitle = new Text("Cadastrar modelo de carro");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        painel4.add(scenetitle, 0, 0, 2, 1);

        // create labels

        Label nomeModelo = new Label("Digite o nome do modelo");
        painel4.add(nomeModelo, 0, 1);
        TextField nomeModeloTextField = new TextField();
        painel4.add(nomeModeloTextField, 1, 1);

        Label nomeMarca = new Label("Digite o nome da marca do modelo");
        painel4.add(nomeMarca, 0, 2);
        TextField nomeMarcaTextField = new TextField();
        painel4.add(nomeMarcaTextField, 1, 2);

        Label nomeCategoria = new Label("Digite o nome da categoria do modelo");
        painel4.add(nomeCategoria, 0, 3);
        TextField nomeCategoriaTextField = new TextField();
        painel4.add(nomeCategoriaTextField, 1, 3);



        Label selecionaNacionalOuImportado = new Label("Selecione o tipo do modelo");
        painel4.add(selecionaNacionalOuImportado,0,4);
        rbNacionalImportado = new ToggleGroup();
        rbNacional = new RadioButton("Nacional");
        rbNacional.setToggleGroup(rbNacionalImportado);
        rbImportado = new RadioButton("Importado");
        rbImportado.setToggleGroup(rbNacionalImportado);
        rbImportado.setSelected(true);
        painel4.add(rbNacional,0,5);
        painel4.add(rbImportado,1,5);


        Label labelListaDeCategorias = new Label("Lista de categorias cadastradas");
        painel4.add(labelListaDeCategorias,0,8);
        TextArea listaDeCategorias = new TextArea();
        listaDeCategorias.setPrefHeight(125);
        listaDeCategorias.setPrefWidth(400);
        listaDeCategorias.setText(listaCat.toString());
        painel4.add(listaDeCategorias,1,8);
        listaDeCategorias.setId("listaDeCategorias");

        Label labelListaDeMarcas = new Label("Lista de marcas cadastradas");
        painel4.add(labelListaDeMarcas,0,9);
        TextArea listaDeMarcas = new TextArea();
        listaDeMarcas.setPrefHeight(125);
        listaDeMarcas.setPrefWidth(400);
        listaDeMarcas.setText(listaMar.toString());
        painel4.add(listaDeMarcas,1,9);
        listaDeMarcas.setId("listaDeMarcas");




        Button btnCadastrarModelo = new Button("Cadastrar");
        Button btnVoltar = new Button("Voltar");
        Button btnSalvar = new Button("Salvar modelos");





        painel4.add(btnCadastrarModelo, 1, 6);
        painel4.add(btnSalvar,1,7);
        painel4.add(btnVoltar, 0, 10);


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

        btnCadastrarModelo.setOnAction(e -> {
            MarcaAutomovel cat = new MarcaAutomovel(nomeMarcaTextField.getText());
            //listaMod.insere(cat);
            actiontarget.setFill(Color.GREEN);
            actiontarget.setText("Modelo cadastrado!");


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
        Scene scene4 = new Scene(painel4, 700, 525);

        primaryStage.setTitle("Cadastrar modelo de carro");
        primaryStage.setScene(scene4);
        primaryStage.show();
    }

}