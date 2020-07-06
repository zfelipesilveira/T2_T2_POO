package sample;



import ClassesBasicas.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
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

public class TelaFuncConsultaDisponibilidade extends Application {

    private MenuFunc menuFunc;
    private Automovel auto;
    private ListaCategoria listaCat;
    private ListaAutomoveis listaAuto;
    private ToggleGroup rbFisicaJuridica;
    private RadioButton rbFisica, rbJuridica;
    private ComboBox<String> cbCategorias;





    public TelaFuncConsultaDisponibilidade(MenuFunc menuFunc, ListaCategoria lcat, ListaAutomoveis la) {
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


        Label selecionaCategoria = new Label("Selecione a categoria");
        painel4.add(selecionaCategoria, 1, 1);
        cbCategorias = new ComboBox<String>(FXCollections.observableArrayList(listaNomeCategorias));

//        Cliente[] listaSalvar = new Cliente[100];
//        listaSalvar = listaCli.getClientes().toArray(listaSalvar);

        //cbCategorias = new ComboBox(listaCat.getCategoriasComboBox());
                //FlightData.getInstance().getCidadesAtendidas());
        painel4.add(cbCategorias, 1, 2);


        Button btnVerificarDisponibilidade= new Button("Verificar");
        Button btnVoltar = new Button("Voltar");


        TextArea listaDeAutomoveis = new TextArea();
        painel4.add(listaDeAutomoveis,1,8);
        listaDeAutomoveis.setId("listaDeAutomoveis");


        painel4.add(btnVerificarDisponibilidade, 1, 4);
        painel4.add(btnVoltar, 0, 8);

        final Text actiontarget = new Text();
        painel4.add(actiontarget, 1, 10);
        actiontarget.setId("actiontarget");

//        final Text listaAutoNaTela = new Text();
//        painel4.add(listaAutoNaTela,1,12);
//        listaAutoNaTela.setId("listaAutoNaTela");



        // Tratamento de evento dos botoes
        btnVoltar.setOnAction(e -> {
            try {

                menuFunc.start(thestage);


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnVerificarDisponibilidade.setOnAction(e -> {
            try {

                String nomeCategoria = cbCategorias.getSelectionModel().getSelectedItem().toString();
                CategoriaAutomovel categoria = listaCat.pesquisaCategoria(nomeCategoria);
                String automoveisDisponiveis = listaAuto.pesquisaAutoDispPorCategoria(categoria);
                System.out.println(automoveisDisponiveis);


                String str = "Automóveis Disponíveis:" + "\n" + automoveisDisponiveis;
                listaDeAutomoveis.setText(str);






            } catch(NullPointerException np){
                actiontarget.setFill(Color.RED);
                actiontarget.setText("Seleciona alguma categoria");
                np.printStackTrace();
            }

        });


        Scene scene4 = new Scene(painel4, 700, 600);

        primaryStage.setTitle("Verificar disponibilidade");
        primaryStage.setScene(scene4);
        primaryStage.show();
    }

}
