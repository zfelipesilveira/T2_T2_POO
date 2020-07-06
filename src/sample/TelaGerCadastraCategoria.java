package sample;



import ClassesBasicas.*;
import TratamentoArquivos.EscritaArquivos;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
	Exemplo de aplicacao grafica com multiplas janelas
 */

public class TelaGerCadastraCategoria extends Application {

    private MenuGerente menuGer;
    private ListaCategoria listaCat;
    EscritaArquivos escritaArquivos = new EscritaArquivos();


    public TelaGerCadastraCategoria(MenuGerente menuGer, ListaCategoria lcat) {
        super();
        this.menuGer = menuGer;
        this.listaCat = lcat;
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

        Text scenetitle = new Text("Cadastrar categoria de carro");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        painel4.add(scenetitle, 0, 0, 2, 1);

        // create labels

        Label nomeCategoria = new Label("Digite o nome da categoria");
        painel4.add(nomeCategoria, 0, 1);

        TextField nomeCategoriaTextField = new TextField();
        painel4.add(nomeCategoriaTextField, 1, 1);




        Button btnCadastrarCategoria = new Button("Cadastrar");
        Button btnVoltar = new Button("Voltar");
        Button btnSalvar = new Button("Salvar categorias");





        painel4.add(btnCadastrarCategoria, 1, 3);
        painel4.add(btnSalvar,1,6);
        painel4.add(btnVoltar, 0, 8);


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

        btnCadastrarCategoria.setOnAction(e -> {
            CategoriaAutomovel cat = new CategoriaAutomovel(nomeCategoriaTextField.getText());
            System.out.println(cat);
            listaCat.insere(cat);
            System.out.println(listaCat);
            actiontarget.setFill(Color.GREEN);
            actiontarget.setText("Categoria cadastrada!");


        });

        btnSalvar.setOnAction(e -> {
            CategoriaAutomovel[] listaSalvar = new CategoriaAutomovel[100];
            listaSalvar = listaCat.getCategorias().toArray(listaSalvar);
            System.out.println(listaSalvar);
            escritaArquivos.gravaRegistrosCategorias(listaSalvar);
            actiontarget.setFill(Color.GREEN);
            actiontarget.setText("Categorias salvas em txt");
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
        Scene scene4 = new Scene(painel4, 500, 400);

        primaryStage.setTitle("Cadastrar categoria");
        primaryStage.setScene(scene4);
        primaryStage.show();
    }

}