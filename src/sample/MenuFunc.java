package sample;

import Teste.Cliente;
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

public class MenuFunc extends Application {

    private Application raiz;
    private TelaFuncCadastraCliente telaFCC;

    public MenuFunc(Application raiz) {
        super();
        this.raiz = raiz;
        telaFCC = new TelaFuncCadastraCliente(this);

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

        Text scenetitle = new Text("Menu de Funcionários");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        painel2.add(scenetitle, 0, 0, 2, 1);

        // create labels


        Button btnCadCli = new Button("Cadastrar Cliente");
        Button btnConsultarDispAuto = new Button("Consultar disponibilidade");
        Button btnConsultarVLoc = new Button("Consultar valor de locação");
        Button btnRealizarLoc = new Button("Realizar locação");
        Button btnFinalizarLoc = new Button("Finalizar locação");
        Button btnMenuPrincipal = new Button("Voltar para o menu principal");


        painel2.add(btnCadCli, 0, 3, 2, 1);
        painel2.add(btnConsultarDispAuto, 0, 4);
        painel2.add(btnConsultarVLoc, 0, 5);
        painel2.add(btnRealizarLoc, 0, 6);
        painel2.add(btnFinalizarLoc, 0, 7);
        painel2.add(btnMenuPrincipal, 0, 8);



        // Tratamento de evento dos botoes
        btnMenuPrincipal.setOnAction(e -> {
            try {
                raiz.start(thestage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnCadCli.setOnAction(e -> {
            try {
                telaFCC.start(thestage);
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
        Scene scene2 = new Scene(painel2, 500, 400);

        primaryStage.setTitle("Menu de Funcionários");
        primaryStage.setScene(scene2);
        primaryStage.show();
    }

}