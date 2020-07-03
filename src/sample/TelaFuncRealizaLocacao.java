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

public class TelaFuncRealizaLocacao extends Application {

    private MenuFunc menuFunc;
    private Automovel auto;
    private ListaCategoria listaCat;
    private ListaAutomoveis listaAuto;
    private ListaClientes listaCli;
    private ListaLocacoes listaLoca;
    private ToggleGroup rbFisicaJuridica;
    private RadioButton rbFisica, rbJuridica;
    private ComboBox cbCategorias;





    public TelaFuncRealizaLocacao(MenuFunc menuFunc, ListaCategoria lcat, ListaAutomoveis la, ListaClientes lcli, ListaLocacoes ll) {
        super();
        this.menuFunc = menuFunc;
        this.listaCat = lcat;
        this.listaAuto = la;
        this.listaCli = lcli;
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

        Text scenetitle = new Text("Realizar locação");
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


        Label digitaCPFCNPJ = new Label("Digite o CPF/CNPJ do cliente");
        painel4.add(digitaCPFCNPJ,0,3);
        TextField cpfcnpjTextField = new TextField();
        painel4.add(cpfcnpjTextField,1,3);


        Label digitaPlaca = new Label("Digite a placa");
        painel4.add(digitaPlaca,0,4);
        TextField placaTextField = new TextField();
        painel4.add(placaTextField,1,4);

        Label digitaDataInicio = new Label("Digite a data de início");
        painel4.add(digitaDataInicio,0,5);
        TextField dataInicioTextField = new TextField();
        painel4.add(dataInicioTextField,1,5);

        Label digitaDataFinal = new Label("Digite a data final");
        painel4.add(digitaDataFinal,0,6);
        TextField dataFinalTextField = new TextField();
        painel4.add(dataFinalTextField,1,6);


        Label labelListaDeAutomoveis = new Label("Lista de automóveis disponíveis");
        painel4.add(labelListaDeAutomoveis,0,9);
        TextArea listaDeAutomoveis = new TextArea();
        listaDeAutomoveis.setPrefHeight(125);
        listaDeAutomoveis.setPrefWidth(400);
//        textArea.setPrefHeight(height);  //sets height of the TextArea to 400 pixels
//        textArea.setPrefWidth(width);
        painel4.add(listaDeAutomoveis,1,9);
        listaDeAutomoveis.setId("listaDeAutomoveis");

        Label labelListaDeClientes = new Label("Lista de clientes cadastrados");
        painel4.add(labelListaDeClientes,0,10);
        TextArea listaDeClientes = new TextArea();
        listaDeClientes.setPrefHeight(125);
        listaDeClientes.setPrefWidth(400);
        listaDeClientes.setText(listaCli.toString());
        painel4.add(listaDeClientes,1,10);
        listaDeAutomoveis.setId("listaDeClientes");




        painel4.add(cbCategorias, 1, 2);

        Button btnBuscarAutomoveisDisp = new Button("Buscar automóveis");

        Button btnRealizarLocacao = new Button("Realizar Locação");

        Button btnVoltar = new Button("Voltar");





        painel4.add(btnBuscarAutomoveisDisp, 2, 2);
        painel4.add(btnRealizarLocacao,2,6);
        painel4.add(btnVoltar, 0, 11);

        final Text actiontarget = new Text();
        painel4.add(actiontarget, 1, 12);
        actiontarget.setId("actiontarget");



        final Text dadosLocacao = new Text();
        painel4.add(dadosLocacao,2,12);
        dadosLocacao.setId("listaAutoNaTela");



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

        btnRealizarLocacao.setOnAction(e -> {
            try {
                if(cpfcnpjTextField.getText().isEmpty() || placaTextField.getText().isEmpty() ||
                        dataInicioTextField.getText().isEmpty() || dataFinalTextField.getText().isEmpty()){
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Preencha todos os campos");
                }
                else {
                    String cpfcnpj = cpfcnpjTextField.getText();
                    String placaAuto = placaTextField.getText();
                    String dataInicio = dataInicioTextField.getText();
                    String dataFinal = dataFinalTextField.getText();
                    Automovel auto = listaAuto.pesquisaAutomovel(placaAuto);
                    Cliente cliente = listaCli.pesquisaClientePorCpf(cpfcnpj);
                    Locacao loc = new Locacao(cliente, auto, dataInicio, dataFinal);
                    loc.calculaPeriodo();
                    listaLoca.insere(loc);
                    actiontarget.setFill(Color.GREEN);
                    actiontarget.setText("Locação realizada");

                    loc.setValorLocacao();
                    dadosLocacao.setFill(Color.BLACK);
                    dadosLocacao.setText(loc.toString());

                    System.out.println(listaLoca);

                    double valorLocacao = loc.getValorLocacao();
                    System.out.println("Valor da locação: " + valorLocacao);
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
        Scene scene4 = new Scene(painel4, 900, 750);

        primaryStage.setTitle("Realizar locação");
        primaryStage.setScene(scene4);
        primaryStage.show();
    }

}
