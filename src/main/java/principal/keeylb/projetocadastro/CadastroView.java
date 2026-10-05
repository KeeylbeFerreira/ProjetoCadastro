package principal.keeylb.projetocadastro;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CadastroView {

    Funcionario[] funcionarios;

    public CadastroView(Funcionario[] funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void abrir() {

        Stage janela = new Stage();

        // ===== TÍTULO =====

        Label titulo = new Label("CADASTRAR FUNCIONÁRIO");
        titulo.getStyleClass().add("titulo-formulario");

        Label subtitulo = new Label("Preencha os dados abaixo");
        subtitulo.getStyleClass().add("subtitulo-formulario");


        // ===== NOME =====

        Label labelNome = new Label("Nome");

        TextField campoNome = new TextField();
        campoNome.setPromptText("Digite o nome");


        // ===== IDADE =====

        Label labelIdade = new Label("Idade");

        TextField campoIdade = new TextField();
        campoIdade.setPromptText("Digite a idade");


        // ===== CARGO =====

        Label labelCargo = new Label("Cargo");

        TextField campoCargo = new TextField();
        campoCargo.setPromptText("Digite o cargo");


        // ===== SALÁRIO =====

        Label labelSalario = new Label("Salário");

        TextField campoSalario = new TextField();
        campoSalario.setPromptText("Digite o salário");


        // ===== BOTÃO =====

        Button cadastrar = new Button("Cadastrar");
        cadastrar.getStyleClass().add("botao-cadastrar");


        // ===== AÇÃO DO BOTÃO =====

        cadastrar.setOnAction(event -> {

            Funcionario funcionario = new Funcionario();

            funcionario.nome = campoNome.getText();
            funcionario.idade = campoIdade.getText();
            funcionario.cargo = campoCargo.getText();

            funcionario.salario =
                    Double.parseDouble(campoSalario.getText());


            // Procurar uma posição vazia

            for (int i = 0; i < funcionarios.length; i++) {

                if (funcionarios[i] == null) {

                    funcionarios[i] = funcionario;

                    System.out.println("Funcionário cadastrado!");

                    janela.close();

                    break;
                }
            }
        });


        // ===== FORMULÁRIO =====

        VBox formulario = new VBox(8);

        formulario.getChildren().add(labelNome);
        formulario.getChildren().add(campoNome);

        formulario.getChildren().add(labelIdade);
        formulario.getChildren().add(campoIdade);

        formulario.getChildren().add(labelCargo);
        formulario.getChildren().add(campoCargo);

        formulario.getChildren().add(labelSalario);
        formulario.getChildren().add(campoSalario);

        formulario.getChildren().add(cadastrar);


        // ===== LAYOUT =====

        VBox layout = new VBox(15);

        layout.getChildren().add(titulo);
        layout.getChildren().add(subtitulo);
        layout.getChildren().add(formulario);

        layout.setAlignment(Pos.CENTER);

        layout.getStyleClass().add("formulario");


        // ===== CENA =====

        Scene scene = new Scene(layout, 500, 600);

        scene.getStylesheets().add(
                getClass().getResource("/style.css").toExternalForm()
        );

        janela.setTitle("Cadastrar Funcionário");
        janela.setScene(scene);
        janela.setResizable(false);

        janela.show();
    }
}