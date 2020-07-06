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

public class TelaGerCadastraMarca extends Application {

    private MenuGerente menuGer;
    private ListaMarcas listaMar;
    EscritaArquivos escritaArquivos = new EscritaArquivos();



    public TelaGerCadastraMarca(MenuGerente menuGer, ListaMarcas lmar) {
        super();
        this.menuGer = menuGer;
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

        Text scenetitle = new Text("Cadastrar categoria de carro");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        painel4.add(scenetitle, 0, 0, 2, 1);

        // create labels

        Label nomeMarca = new Label("Digite o nome da marca");
        painel4.add(nomeMarca, 0, 1);

        TextField nomeMarcaTextField = new TextField();
        painel4.add(nomeMarcaTextField, 1, 1);




        Button btnCadastrarCategoria = new Button("Cadastrar");
        Button btnVoltar = new Button("Voltar");
        Button btnSalvar = new Button("Salvar marcas");

        btnVoltar.setStyle("-fx-text-fill: #b22222");





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
            MarcaAutomovel cat = new MarcaAutomovel(nomeMarcaTextField.getText());
            listaMar.insere(cat);
            actiontarget.setFill(Color.GREEN);
            actiontarget.setText("Categoria cadastrada!");


        });

        btnSalvar.setOnAction(e -> {
            MarcaAutomovel[] listaSalvar = new MarcaAutomovel[100];
            listaSalvar = listaMar.getMarcas().toArray(listaSalvar);
            escritaArquivos.gravaRegistrosMarcas(listaSalvar);
            actiontarget.setFill(Color.GREEN);
            actiontarget.setText("Clientes salvos em txt");
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