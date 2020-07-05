package sample;

import Teste.*;
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
	Menu principal da aplicação
 */

public class MenuPrincipal extends Application {


    private MenuFunc menuFunc;
    private MenuGerente menuGerente;
    private Cliente cliente;
    private ListaAutomoveis listaAuto = new ListaAutomoveis(100);
    private ListaCategoria listaCat = new ListaCategoria(100);
    private ListaClientes listaCli = new ListaClientes(100);
    private ListaMarcas listaMar = new ListaMarcas(100);
    private ListaModelo listaMod = new ListaModelo(100);
    private ListaLocacoes listaLoc = new ListaLocacoes(100);
    private PilhaPedidos pilhaPed = new PilhaPedidos();
    private PilhaPedidosLocacoes pilaPedLoc = new PilhaPedidosLocacoes();


    public MenuPrincipal() {
        super();
        menuFunc = new MenuFunc(this, listaAuto, listaCat, listaCli, listaMar, listaMod, listaLoc, pilhaPed, pilaPedLoc);
        menuGerente = new MenuGerente(this, listaAuto, listaCat, listaCli, listaMar, listaMod, listaLoc, pilhaPed, pilaPedLoc);

    }

    @Override
    public void start(Stage primaryStage) {
        // Acesso ao stage (palco) da aplicacao
        Stage thestage = primaryStage;

        // Cria 2 paineis
        GridPane painel1;
        painel1 = new GridPane();
        painel1.setAlignment(Pos.CENTER);
        painel1.setHgap(10);
        painel1.setVgap(10);
        painel1.setPadding(new Insets(25, 25, 25, 25));
        painel1.setGridLinesVisible(false);

        Text scenetitle = new Text("Menu Principal");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        painel1.add(scenetitle, 0, 0, 2, 1);


        Button btnFunc = new Button("Menu de funcionários");
        Button btnGerente = new Button("Menu de gerente");
        Button btncarregarDados = new Button("Carregar dados");
        Button btnFinal = new Button("Terminar");


        btnFinal.setStyle("-fx-text-fill: #b22222");

        painel1.add(btnFunc, 0, 3, 2, 1);
        painel1.add(btnGerente, 0, 4);
        painel1.add(btncarregarDados, 0, 5);
        painel1.add(btnFinal, 0, 6);

        // Tratamento de evento dos botoes
        btnFunc.setOnAction(e -> {
            menuFunc.start(thestage);
        });

        btnGerente.setOnAction(e -> {
            menuGerente.start(thestage);
        });


        btnFinal.setOnAction(e -> {
            thestage.close();
        });

        Scene scene1 = new Scene(painel1, 600, 500);
        primaryStage.setTitle("Multiplas cenas");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}