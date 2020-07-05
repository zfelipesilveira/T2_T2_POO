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

        Text scenetitle = new Text("Consultar valor de locação");
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

//        String[] listaplacaAutomoveis = new String [listaAuto.getTotal()];
//        listaplacaAutomoveis = listaAuto.pesquisaListaAutoDisponiveis()



        Label selecionaCategoria = new Label("Seleciona a categoria");
        painel4.add(selecionaCategoria, 1, 1);
        cbCategorias = new ComboBox(FXCollections.observableArrayList(listaNomeCategorias));

        Label digitaPlaca = new Label("Digite a placa");
        painel4.add(digitaPlaca,0,3);
        TextField placaTextField = new TextField();
        painel4.add(placaTextField,1,3);

        Label digitaDataInicio = new Label("Digite a data de início");
        painel4.add(digitaDataInicio,0,4);
        TextField dataInicioTextField = new TextField();
        painel4.add(dataInicioTextField,1,4);

        Label digitaDataFinal = new Label("Digite a data final");
        painel4.add(digitaDataFinal,0,5);
        TextField dataFinalTextField = new TextField();
        painel4.add(dataFinalTextField,1,5);

        TextArea listaDeAutomoveis = new TextArea();
        painel4.add(listaDeAutomoveis,1,8);
        listaDeAutomoveis.setId("listaDeAutomoveis");

        rbFisicaJuridica = new ToggleGroup();
        rbFisica = new RadioButton("Pessoa Física");
        rbFisica.setToggleGroup(rbFisicaJuridica);
        rbJuridica = new RadioButton("Pessoa Jurídica");
        rbJuridica.setToggleGroup(rbFisicaJuridica);
        rbJuridica.setSelected(true);
        painel4.add(rbFisica,0,6);
        painel4.add(rbJuridica,1,6);




        painel4.add(cbCategorias, 1, 2);

        Button btnBuscarAutomoveisDisp = new Button("Buscar automóveis");

        Button btnConsultarValor = new Button("Consultar valor");

        Button btnVoltar = new Button("Voltar");





        painel4.add(btnBuscarAutomoveisDisp, 2, 2);
        painel4.add(btnConsultarValor,2,5);
        painel4.add(btnVoltar, 0, 8);

        final Text actiontarget = new Text();
        painel4.add(actiontarget, 1, 9);
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

//                listaAutoNaTela.setFill(Color.GRAY);
//                String str = "Automóveis Disponíveis:" + "\n" + automoveisDisponiveis;
//                actiontarget.setText(str);

                String str = "Automóveis Disponíveis:" + "\n" + automoveisDisponiveis;
                listaDeAutomoveis.setText(str);




            } catch(NullPointerException np){
                actiontarget.setFill(Color.RED);
                actiontarget.setText("Selecione alguma categoria");
                np.printStackTrace();
            }

        });

        btnConsultarValor.setOnAction(e -> {
            try {
                String placaAuto = placaTextField.getText();
                String dataInicio = dataInicioTextField.getText();
                String dataFinal = dataFinalTextField.getText();
                Automovel auto = listaAuto.pesquisaAutomovel(placaAuto);
                String tipoCliente = "";
                if(rbFisica.isSelected()) tipoCliente = "F";
                if(rbJuridica.isSelected()) tipoCliente = "J";
                Locacao loc = new Locacao(auto,dataInicio,dataFinal,tipoCliente);
                loc.calculaPeriodo();
                double valorLocacao = loc.getValorLocacao();
                actiontarget.setFill(Color.BLACK);
                String str = "Valor da locação: " + valorLocacao + " reais";
                actiontarget.setText(str);
                System.out.println("Valor da locação: " + valorLocacao);


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
        Scene scene4 = new Scene(painel4, 900, 750);

        primaryStage.setTitle("Consultar valor de locação");
        primaryStage.setScene(scene4);
        primaryStage.show();
    }

}
