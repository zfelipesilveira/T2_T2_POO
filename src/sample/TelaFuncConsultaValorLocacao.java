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

import java.util.Scanner;

/*
	Exemplo de aplicacao grafica com multiplas janelas
 */

public class TelaFuncConsultaValorLocacao extends Application {

    private MenuFunc menuFunc;
    private Automovel auto;
    private ListaCategoria listaCat;
    private ListaAutomoveis listaAuto;
    private ToggleGroup rbFisicaJuridica;
    private RadioButton rbFisica, rbJuridica;
    private ComboBox cbCategorias;





    public TelaFuncConsultaValorLocacao(MenuFunc menuFunc, ListaCategoria lcat, ListaAutomoveis la) {
        super();
        this.menuFunc = menuFunc;
        this.listaCat = lcat;
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

//        Label placaAuto = new Label("Digite a placa do automóvel que deseja consultar a disponibilidade");
//        painel4.add(placaAuto, 0, 1);
//
//        TextField placaAutoTextField = new TextField();
//        painel4.add(placaAutoTextField, 1, 1);


        String[] listaNomeCategorias = new String[listaCat.getTotal()];
        listaNomeCategorias = listaCat.getCategoriasNomes().toArray(listaNomeCategorias);

        String[] placaAutomoveis = new String [listaAuto.ge]


        Label selecionaCategoria = new Label("Seleciona a categoria");
        painel4.add(selecionaCategoria, 1, 1);
        cbCategorias = new ComboBox(FXCollections.observableArrayList(listaNomeCategorias));

//        Cliente[] listaSalvar = new Cliente[100];
//        listaSalvar = listaCli.getClientes().toArray(listaSalvar);

        //cbCategorias = new ComboBox(listaCat.getCategoriasComboBox());
        //FlightData.getInstance().getCidadesAtendidas());
        painel4.add(cbCategorias, 1, 2);

        Button btnBuscarAutomoveisDisp = new Button("Buscar automóveis");
        Button btnVoltar = new Button("Voltar");





        painel4.add(btnBuscarAutomoveisDisp, 1, 4);
        painel4.add(btnVoltar, 0, 8);

        final Text actiontarget = new Text();
        painel4.add(actiontarget, 1, 10);
        actiontarget.setId("actiontarget");

        final Text listaAutoNaTela = new Text();
        painel4.add(listaAutoNaTela,1,12);
        listaAutoNaTela.setId("listaAutoNaTela");



        // Tratamento de evento dos botoes
        btnVoltar.setOnAction(e -> {
            try {
                menuFunc.start(thestage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnBuscarAutomoveisDisp.setOnAction(e -> {
            try {//CategoriaAutomovel cat = new CategoriaAutomovel(nomeCategoriaTextField.getText());
                //String nomeCategoria = cbCategorias.getSelectionModel().getSelectedItem().toString();

                String nomeCategoria = cbCategorias.getSelectionModel().getSelectedItem().toString();
                CategoriaAutomovel categoria = listaCat.pesquisaCategoria(nomeCategoria);
                String automoveisDisponiveis = listaAuto.pesquisaAutoDispPorCategoria(categoria);
                System.out.println(automoveisDisponiveis);



                //System.out.println(teste);
                //CategoriaAutomovel umaCategoria =

//                actiontarget.setFill(Color.GREEN);
//                actiontarget.setText("Verificando disponibilidade");

                listaAutoNaTela.setFill(Color.GRAY);
                String str = "Automóveis Disponíveis:" + "\n" + automoveisDisponiveis;
                actiontarget.setText(str);




            } catch(NullPointerException np){
                actiontarget.setFill(Color.RED);
                actiontarget.setText("Seleciona alguma categoria");
                np.printStackTrace();
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
        Scene scene4 = new Scene(painel4, 700, 600);

        primaryStage.setTitle("Verificar disponibilidade");
        primaryStage.setScene(scene4);
        primaryStage.show();
    }

}
