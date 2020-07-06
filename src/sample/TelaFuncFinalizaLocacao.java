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

public class TelaFuncFinalizaLocacao extends Application {

    private MenuFunc menuFunc;
    private Automovel auto;
    private ListaAutomoveis listaAuto;
    private ListaLocacoes listaLoca;




    public TelaFuncFinalizaLocacao(MenuFunc menuFunc, ListaAutomoveis la, ListaLocacoes ll) {
        super();
        this.menuFunc = menuFunc;
        this.listaAuto = la;
        this.listaLoca = ll;


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

        Text scenetitle = new Text("Finalizar locação");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        painel4.add(scenetitle, 0, 0, 2, 1);

        // create labels

//        Label placaAuto = new Label("Digite a placa do automóvel que deseja consultar a disponibilidade");
//        painel4.add(placaAuto, 0, 1);
//
//



        Label digitaPlaca = new Label("Digite a placa");
        painel4.add(digitaPlaca,0,4);
        TextField placaTextField = new TextField();
        painel4.add(placaTextField,1,4);





        Button btnVerLocacao = new Button("Ver locação");

        Button btnFinalizarLocacao = new Button("Confirmar finalização");

        Button btnVoltar = new Button("Voltar");


        painel4.add(btnVerLocacao, 1, 5);
        painel4.add(btnFinalizarLocacao,1,9);
        painel4.add(btnVoltar, 0, 11);

        final Text actiontarget = new Text();
        painel4.add(actiontarget, 1, 10);
        actiontarget.setId("actiontarget");



        final Text dadosLocacao = new Text();
        painel4.add(dadosLocacao,1,8);
        dadosLocacao.setId("listaAutoNaTela");



        // Tratamento de evento dos botoes
        btnVoltar.setOnAction(e -> {
            try {
                menuFunc.start(thestage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnVerLocacao.setOnAction(e -> {
            try {
                if(placaTextField.getText().isEmpty()){
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Digite uma placa");
                }
                if(listaLoca.pesquisaLocacoes(placaTextField.getText()) == null){
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Nenhuma locação para esse veículo");
                }
                else {
                    String placaAuto = placaTextField.getText();
                    Locacao loc = listaLoca.pesquisaLocacoes(placaAuto);
                    dadosLocacao.setFill(Color.BLACK);
                    dadosLocacao.setText(loc.toString());

                    System.out.println(listaLoca);

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


        btnFinalizarLocacao.setOnAction(e -> {
            try {
                if(placaTextField.getText().isEmpty()){
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Digite uma placa");
                }
                else {
                    String placaAuto = placaTextField.getText();
                    Locacao loc = listaLoca.pesquisaLocacoes(placaAuto);
                    Automovel auto = listaAuto.pesquisaAutomovel(placaAuto);
                    auto.setDisponivel(1);
                    listaLoca.remove(loc);
                    actiontarget.setFill(Color.GREEN);
                    actiontarget.setText("Locação finalizada");
                }

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
        Scene scene4 = new Scene(painel4, 650, 400);

        primaryStage.setTitle("Finalizar locação");
        primaryStage.setScene(scene4);
        primaryStage.show();
    }

}
