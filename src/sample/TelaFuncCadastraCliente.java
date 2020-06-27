package sample;


import Teste.Cliente;
import Teste.ListaClientes;
import Teste.PessoaFisica;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
	Exemplo de aplicacao grafica com multiplas janelas
 */

public class TelaFuncCadastraCliente extends Application {

    private MenuFunc menuFunc;
    private Cliente cliente;
    private ListaClientes lista = new ListaClientes(100);
    private ToggleGroup rbFisicaJuridica;
    private RadioButton rbFisica, rbJuridica;


    public TelaFuncCadastraCliente(MenuFunc menuFunc) {
        super();
        this.menuFunc = menuFunc;

    }

    @Override
    public void start(Stage primaryStage) {
        // Acesso ao stage (palco) da aplicacao
        Stage thestage = primaryStage;

        GridPane painel3 = new GridPane();

        painel3.setAlignment(Pos.CENTER);
        painel3.setHgap(10);
        painel3.setVgap(10);
        painel3.setPadding(new Insets(25, 25, 25, 25));
        painel3.setGridLinesVisible(false);

        Text scenetitle = new Text("Cadastrar cliente");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        painel3.add(scenetitle, 0, 0, 2, 1);

        // create labels

        Label nome = new Label("Nome:");
        painel3.add(nome, 0, 1);

        TextField nomeTextField = new TextField();
        painel3.add(nomeTextField, 1, 1);

        Label tel = new Label("Telefone:");
        painel3.add(tel, 0, 2);

        TextField telBox = new TextField();
        painel3.add(telBox, 1, 2);

        Label cpfcnpj = new Label("CPF/CNPJ:");
        painel3.add(cpfcnpj, 0, 3);

        TextField cpfTextField = new TextField();
        painel3.add(cpfTextField, 1, 3);


        Button btnCadastrar = new Button("Cadastrar Cliente");
        Button btnMenuPrincipal = new Button("Voltar");

        rbFisicaJuridica = new ToggleGroup();
        rbFisica = new RadioButton("Pessoa Física");
        rbFisica.setToggleGroup(rbFisicaJuridica);
        rbJuridica = new RadioButton("Pessoa Jurídica");
        rbJuridica.setToggleGroup(rbFisicaJuridica);
        rbJuridica.setSelected(true);
        painel3.add(rbFisica,0,5);
        painel3.add(rbJuridica,1,5);



        painel3.add(btnCadastrar, 1, 6);
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btnCadastrar);
        painel3.add(hbBtn,1,6);
        painel3.add(btnMenuPrincipal, 0, 8);



        // Tratamento de evento dos botoes
        btnMenuPrincipal.setOnAction(e -> {
            try {
                menuFunc.start(thestage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnCadastrar.setOnAction(e -> {
            Cliente cpf = new PessoaFisica(nomeTextField.getText(),telBox.getText(), cpfTextField.getText());
            //if (rbFisica.equals(true))
                lista.insere(cpf);
            lista.mostra();
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
        Scene scene3 = new Scene(painel3, 500, 400);

        primaryStage.setTitle("Menu de Funcionários");
        primaryStage.setScene(scene3);
        primaryStage.show();
    }

}
