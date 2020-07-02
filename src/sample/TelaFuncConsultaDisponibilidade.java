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

public class TelaFuncConsultaDisponibilidade extends Application {

    private MenuFunc menuFunc;
    private Automovel auto;
    private ListaAutomoveis listaAuto;
    private ToggleGroup rbFisicaJuridica;
    private RadioButton rbFisica, rbJuridica;





    public TelaFuncConsultaDisponibilidade(MenuFunc menuFunc, ListaAutomoveis la) {
        super();
        this.menuFunc = menuFunc;
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

        Text scenetitle = new Text("Consulta de disponibilidade");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        painel4.add(scenetitle, 0, 0, 2, 1);

        // create labels

        Label placaAuto = new Label("Digite a placa do automóvel que deseja consultar a disponibilidade");
        painel4.add(placaAuto, 0, 1);

        TextField placaAutoTextField = new TextField();
        painel4.add(placaAutoTextField, 1, 1);




        Button btnCadastrarCategoria = new Button("Cadastrar");
        Button btnVoltar = new Button("Voltar");





        painel4.add(btnCadastrarCategoria, 1, 6);
        painel4.add(btnVoltar, 0, 8);

        final Text actiontarget = new Text();
        painel4.add(actiontarget, 1, 10);
        actiontarget.setId("actiontarget");



        // Tratamento de evento dos botoes
        btnVoltar.setOnAction(e -> {
            try {
                menuFunc.start(thestage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnCadastrarCategoria.setOnAction(e -> {
            //CategoriaAutomovel cat = new CategoriaAutomovel(nomeCategoriaTextField.getText());

            actiontarget.setFill(Color.GREEN);
            actiontarget.setText("Categoria cadastrada carregados!");


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
