package principal.keeylb.projetocadastro;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Funcionario[] funcionarios = new Funcionario[3];

    @Override
    public void start(Stage stage) {

        // ===== CABEÇALHO =====

        Label icone = new Label("👥");
        icone.getStyleClass().add("icone-cabecalho");

        Label titulo = new Label("SISTEMA DE FUNCIONÁRIOS");
        titulo.getStyleClass().add("titulo");

        Label subtitulo = new Label(
                "Gerenciamento de funcionários"
        );
        subtitulo.getStyleClass().add("subtitulo");

        VBox textosCabecalho = new VBox(3);

        textosCabecalho.getChildren().add(titulo);
        textosCabecalho.getChildren().add(subtitulo);

        HBox identidade = new HBox(12);

        identidade.setAlignment(Pos.CENTER_LEFT);

        identidade.getChildren().add(icone);
        identidade.getChildren().add(textosCabecalho);

        Label status = new Label("● Online");
        status.getStyleClass().add("status");

        HBox cabecalho = new HBox();

        cabecalho.setAlignment(Pos.CENTER_LEFT);

        cabecalho.getChildren().add(identidade);
        cabecalho.getChildren().add(status);

        cabecalho.getStyleClass().add("cabecalho");


        // ===== BOAS-VINDAS =====

        Label ola = new Label("Olá! 👋");
        ola.getStyleClass().add("ola");

        Label mensagem = new Label("O que você deseja fazer?");
        mensagem.getStyleClass().add("mensagem");

        VBox boasVindas = new VBox(5);
        boasVindas.getChildren().add(ola);
        boasVindas.getChildren().add(mensagem);


        // ===== BOTÕES =====

        Button cadastrar = new Button();
        cadastrar.setText("👤\nCadastrar\nnovo funcionário");
        cadastrar.getStyleClass().add("card");

        Button listar = new Button();
        listar.setText("📋\nListar\nfuncionários");
        listar.getStyleClass().add("card");
        listar.setOnAction(event -> {

            ListagemView listagemView = new ListagemView(funcionarios);

            listagemView.abrir();

        });

        Button buscar = new Button();
        buscar.setText("🔍\nBuscar\nfuncionário");
        buscar.getStyleClass().add("card");
        buscar.setOnAction(event -> {
            BuscaView buscaView = new BuscaView(funcionarios);
            buscaView.abrir();
        });

        Button alterar = new Button();
        alterar.setText("✏\nAlterar\ncadastro");
        alterar.getStyleClass().add("card");
        alterar.setOnAction(event -> {
            AlterarView alterarView = new AlterarView(funcionarios);
            alterarView.abrir();
        });

        Button excluir = new Button();
        excluir.setText("🗑\nExcluir\nfuncionário");
        excluir.getStyleClass().add("card-excluir");
        excluir.setOnAction(event -> {

            ExcluirView excluirView =
                    new ExcluirView(funcionarios);

            excluirView.abrir();
        });

        // ===== BOTÃO CADASTRAR =====

        cadastrar.setOnAction(event -> {

            CadastroView cadastroView = new CadastroView(funcionarios);

            cadastroView.abrir();

        });


        // ===== GRID DOS BOTÕES =====

        GridPane cards = new GridPane();

        cards.setHgap(25);
        cards.setVgap(20);
        cards.setAlignment(Pos.CENTER);

        cards.add(cadastrar, 0, 0);
        cards.add(listar, 1, 0);

        cards.add(buscar, 0, 1);
        cards.add(alterar, 1, 1);

        cards.add(excluir, 0, 2);

        GridPane.setColumnSpan(excluir, 2);
        GridPane.setHalignment(excluir, javafx.geometry.HPos.CENTER);


        // ===== CONTEÚDO PRINCIPAL =====

        VBox conteudo = new VBox(30);

        conteudo.getChildren().add(boasVindas);
        conteudo.getChildren().add(cards);

        conteudo.setAlignment(Pos.TOP_CENTER);
        conteudo.getStyleClass().add("conteudo");


        // ===== LAYOUT PRINCIPAL =====

        BorderPane layout = new BorderPane();

        layout.setTop(cabecalho);
        layout.setCenter(conteudo);

        layout.getStyleClass().add("principal");


        // ===== CENA =====

        Scene scene = new Scene(layout, 950, 650);

        scene.getStylesheets().add(
                getClass().getResource("/style.css").toExternalForm()
        );

        stage.setTitle("Sistema de Funcionários");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}