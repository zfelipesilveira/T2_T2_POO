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
	Exemplo de aplicacao grafica com multiplas cenas
 */

public class MenuPrincipal extends Application {


    private MenuFunc menuFunc;
    private MenuGerente menuGerente;
    private Cliente cliente;
    private ListaAutomoveis listaAuto;
    private ListaCategoria listaCat;
    private ListaClientes listaCli;
    private ListaMarcas listaMar;
    private ListaModelo listaMod;
    private ListaLocacoes listaLoc;
    private PilhaPedidos pilhaPed;


    public MenuPrincipal() {
        super();
        menuFunc = new MenuFunc(this);
        menuGerente = new MenuGerente(this);
        listaAuto = new ListaAutomoveis(100);
        listaCat = new ListaCategoria(100);
        listaCli = new ListaClientes(100);
        listaMar = new ListaMarcas(100);
        listaMod = new ListaModelo(100);
        listaLoc = new ListaLocacoes(100);
        pilhaPed = new PilhaPedidos();

    }

    public ListaAutomoveis getListaAuto() {
        return listaAuto;
    }

    public ListaCategoria getListaCat() {
        return listaCat;
    }

    public ListaModelo getListaModelo() {
        return listaMod;
    }

    public ListaLocacoes getListaLoca() {
        return listaLoc;
    }

    public ListaClientes getListaCli() {
        return listaCli;
    }

    public PilhaPedidos getFilaPedidos() {
        return pilhaPed;
    }

    public ListaMarcas getListaMar() {
        return listaMar;
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

        Scene scene1 = new Scene(painel1, 400, 300);
        primaryStage.setTitle("Multiplas cenas");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}