package sample;

import Teste.*;
import TratamentoArquivos.LeituraArquivoTextoTeste;
import javafx.application.Application;
import javafx.collections.FXCollections;
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

public class TelaGerConsultaLocacoes extends Application {

    private MenuGerente menuGer;
    private ListaLocacoes listaLocacoes;
    private ToggleGroup rbFisicaJuridica;
    private RadioButton rbFisica, rbJuridica;


    public TelaGerConsultaLocacoes(MenuGerente menuGer, ListaLocacoes listaLocacoes) {
        super();
        this.menuGer = menuGer;
        this.listaLocacoes = listaLocacoes;

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

        Text scenetitle = new Text("Consulta locações");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        painel4.add(scenetitle, 0, 0, 2, 1);


        Button btnVoltar = new Button("Voltar");
        Button btnPesquisaLocacoes = new Button("Pesquisar");


        TextArea listaDeClientes = new TextArea();
        painel4.add(listaDeClientes,0,8);
        listaDeClientes.setId("ListaDeLocacoes");


        painel4.add(btnVoltar, 0, 9);
        painel4.add(btnPesquisaLocacoes, 0, 6);

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

        btnPesquisaLocacoes.setOnAction(e -> {
            try {

                String stringLista = listaLocacoes.toString();
                System.out.println(stringLista);


                String str = "Locações" + "\n" + stringLista;
                listaDeClientes.setText(str);



            } catch(NullPointerException np){
                actiontarget.setFill(Color.RED);
                actiontarget.setText("a");
                np.printStackTrace();
            }

        });

        Scene scene4 = new Scene(painel4, 500, 500);

        primaryStage.setTitle("Consulta Locações");
        primaryStage.setScene(scene4);
        primaryStage.show();
    }

}
