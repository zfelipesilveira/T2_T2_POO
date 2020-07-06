package sample;



import ClassesBasicas.*;
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

public class TelaGerRemoveAutomovel extends Application {

    private MenuGerente menuGer;
    private ListaAutomoveis listaAuto;



    public TelaGerRemoveAutomovel(MenuGerente menuGer, ListaAutomoveis la) {
        super();
        this.menuGer = menuGer;
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

        Text scenetitle = new Text("Remover automóvel");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        painel4.add(scenetitle, 0, 0, 2, 1);

        // create labels

        Label placaAutomovel = new Label("Digite a placa do automóvel que deseja remover");
        painel4.add(placaAutomovel, 0, 1);

        TextField placaTextField = new TextField();
        painel4.add(placaTextField, 0, 2);




        Button btnRemoverAutomovel = new Button("Remover");
        Button btnVoltar = new Button("Voltar");
        Button btnSalvar = new Button("Salvar automóveis");

        btnVoltar.setStyle("-fx-text-fill: #b22222");



        painel4.add(btnRemoverAutomovel, 0, 3);
        painel4.add(btnSalvar,1,5);
        painel4.add(btnVoltar, 0, 6);


        final Text actiontarget = new Text();
        painel4.add(actiontarget, 1, 3);
        actiontarget.setId("actiontarget");



        // Tratamento de evento dos botoes
        btnVoltar.setOnAction(e -> {
            try {
                menuGer.start(thestage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnRemoverAutomovel.setOnAction(e -> {
            try {
                Automovel auto = listaAuto.pesquisaAutomovel(placaTextField.getText());
                if(auto == null){
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Automóvel não encontrado");

                }
                else{
                    listaAuto.remove(placaTextField.getText());
                    actiontarget.setFill(Color.GREEN);
                    actiontarget.setText("Automóvel removido");

                }
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
        Scene scene4 = new Scene(painel4, 500, 400);

        primaryStage.setTitle("Remover automóvel");
        primaryStage.setScene(scene4);
        primaryStage.show();
    }

}
