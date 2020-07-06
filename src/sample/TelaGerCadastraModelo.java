package sample;



import ClassesBasicas.*;
import TratamentoArquivos.EscritaArquivos;
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

public class TelaGerCadastraModelo extends Application {

    private MenuGerente menuGer;
    private ListaModelo listaMod;
    private ListaCategoria listaCat;
    private ListaMarcas listaMar;
    private ToggleGroup rbNacionalImportado;
    private RadioButton rbNacional, rbImportado;
    EscritaArquivos escritaArquivos = new EscritaArquivos();



    public TelaGerCadastraModelo(MenuGerente menuGer, ListaModelo lmod, ListaCategoria lcat, ListaMarcas lmar) {
        super();
        this.menuGer = menuGer;
        this.listaMod = lmod;
        this.listaCat = lcat;
        this.listaMar = lmar;
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

        Text scenetitle = new Text("Cadastrar modelo de carro");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        painel4.add(scenetitle, 0, 0, 2, 1);

        // create labels

        Label nomeModelo = new Label("Digite o nome do modelo");
        painel4.add(nomeModelo, 0, 1);
        TextField nomeModeloTextField = new TextField();
        painel4.add(nomeModeloTextField, 1, 1);

        Label nomeMarca = new Label("Digite o nome da marca do modelo");
        painel4.add(nomeMarca, 0, 2);
        TextField nomeMarcaTextField = new TextField();
        painel4.add(nomeMarcaTextField, 1, 2);

        Label nomeCategoria = new Label("Digite o nome da categoria do modelo");
        painel4.add(nomeCategoria, 0, 3);
        TextField nomeCategoriaTextField = new TextField();
        painel4.add(nomeCategoriaTextField, 1, 3);

        Label valorModelo = new Label("Valor do modelo");
        painel4.add(valorModelo, 0, 4);
        TextField valorModeloTextField = new TextField();
        painel4.add(valorModeloTextField, 1, 4);

        Label taxaModelo = new Label("Taxa/IPI do modelo");
        painel4.add(taxaModelo, 0, 5);
        TextField taxaModeloTextField = new TextField();
        painel4.add(taxaModeloTextField, 1, 5);







        Label selecionaNacionalOuImportado = new Label("Selecione o tipo do modelo");
        painel4.add(selecionaNacionalOuImportado,0,6);
        rbNacionalImportado = new ToggleGroup();
        rbNacional = new RadioButton("Nacional");
        rbNacional.setToggleGroup(rbNacionalImportado);
        rbImportado = new RadioButton("Importado");
        rbImportado.setToggleGroup(rbNacionalImportado);
        rbImportado.setSelected(true);
        painel4.add(rbNacional,0,7);
        painel4.add(rbImportado,1,7);


        Label labelListaDeCategorias = new Label("Lista de categorias cadastradas");
        painel4.add(labelListaDeCategorias,0,10);
        TextArea listaDeCategorias = new TextArea();
        listaDeCategorias.setPrefHeight(125);
        listaDeCategorias.setPrefWidth(400);
        listaDeCategorias.setText(listaCat.toString());
        painel4.add(listaDeCategorias,1,10);
        listaDeCategorias.setId("listaDeCategorias");

        Label labelListaDeMarcas = new Label("Lista de marcas cadastradas");
        painel4.add(labelListaDeMarcas,0,11);
        TextArea listaDeMarcas = new TextArea();
        listaDeMarcas.setPrefHeight(125);
        listaDeMarcas.setPrefWidth(400);
        listaDeMarcas.setText(listaMar.toString());
        painel4.add(listaDeMarcas,1,11);
        listaDeMarcas.setId("listaDeMarcas");





        Button btnCadastrarModelo = new Button("Cadastrar");
        Button btnVoltar = new Button("Voltar");
        Button btnSalvar = new Button("Salvar modelos");

        btnVoltar.setStyle("-fx-text-fill: #b22222");





        painel4.add(btnCadastrarModelo, 1, 8);
        painel4.add(btnSalvar,2,8);
        painel4.add(btnVoltar, 0, 12);


        final Text actiontarget = new Text();
        painel4.add(actiontarget, 1, 13);
        actiontarget.setId("actiontarget");



        // Tratamento de evento dos botoes
        btnVoltar.setOnAction(e -> {
            try {
                menuGer.start(thestage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnCadastrarModelo.setOnAction(e -> {
            try {
                CategoriaAutomovel cat = listaCat.pesquisaCategoria(nomeCategoriaTextField.getText());
                MarcaAutomovel mar = listaMar.pesquisaMarca(nomeMarcaTextField.getText());
                if (cat == null && mar != null) {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Categoria não encontrada");
                }
                if (mar == null && cat != null) {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Marca não encontrada");
                }
                if (mar == null && cat == null) {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Categoria e marca não encontradas");
                }
                if (mar != null && cat != null && valorModeloTextField.getText().matches("[0-9]+") && taxaModeloTextField.getText().matches("[0-9]+")) {
                    if (rbNacional.isSelected()) {
                        String nomeMod = nomeModeloTextField.getText();
                        double valor = Double.parseDouble(valorModeloTextField.getText());
                        double taxaipi = Double.parseDouble(taxaModeloTextField.getText());

                        ModeloAutomovel mod = new ModeloNacional(nomeMod, mar, cat, valor, taxaipi);
                        listaMod.insere(mod);

                        actiontarget.setFill(Color.GREEN);
                        actiontarget.setText("Modelo cadastrado");
                    }
                    if (rbImportado.isSelected()) {
                        String nomeMod = nomeModeloTextField.getText();
                        double valor = Double.parseDouble(valorModeloTextField.getText());
                        double taxaipi = Double.parseDouble(taxaModeloTextField.getText());

                        ModeloAutomovel mod = new ModeloImportado(nomeMod, mar, cat, valor, taxaipi);
                        listaMod.insere(mod);

                        actiontarget.setFill(Color.GREEN);
                        actiontarget.setText("Modelo cadastrado");

                    }

                } else {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Erro no preenchimento dos campos");

                }
            }catch (NullPointerException en) {
                en.printStackTrace();
            }
        });

        btnSalvar.setOnAction(e -> {
            try {
                ModeloAutomovel[] listaSalvar = new ModeloAutomovel[100];
                listaSalvar = listaMod.getModelos().toArray(listaSalvar);
                System.out.println(listaSalvar);
                escritaArquivos.gravaRegistrosModelos(listaSalvar);
                actiontarget.setFill(Color.GREEN);
                actiontarget.setText("Modelos salvos em txt");
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
        Scene scene4 = new Scene(painel4, 850, 675);

        primaryStage.setTitle("Cadastrar modelo de carro");
        primaryStage.setScene(scene4);
        primaryStage.show();
    }

}