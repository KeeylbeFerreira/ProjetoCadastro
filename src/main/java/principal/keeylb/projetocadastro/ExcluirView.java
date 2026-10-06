package principal.keeylb.projetocadastro;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import principal.keeylb.projetocadastro.Funcionario;

public class ExcluirView {

    Funcionario[] funcionarios;

    public ExcluirView(Funcionario[] funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void abrir() {

        Stage janela = new Stage();

        // ===== TÍTULO =====

        Label titulo = new Label("EXCLUIR FUNCIONÁRIO");
        titulo.getStyleClass().add("titulo-formulario");

        Label subtitulo = new Label(
                "Remova um funcionário do sistema"
        );
        subtitulo.getStyleClass().add("subtitulo-formulario");

        // ===== CAMPO =====

        Label labelNome = new Label("Nome do funcionário");
        labelNome.getStyleClass().add("label-formulario");

        TextField campoNome = new TextField();
        campoNome.setPromptText("Digite o nome");

        // ===== BOTÃO =====

        Button excluir = new Button("🗑  Excluir funcionário");
        excluir.getStyleClass().add("botao-excluir");

        // ===== MENSAGEM =====

        Label mensagem = new Label();
        mensagem.getStyleClass().add("mensagem");

        // ===== AÇÃO DE EXCLUIR =====

        excluir.setOnAction(event -> {

            String nomeBusca = campoNome.getText();

            boolean encontrado = false;

            for (int i = 0; i < funcionarios.length; i++) {

                if (funcionarios[i] != null) {

                    if (funcionarios[i].nome.equalsIgnoreCase(nomeBusca)) {

                        encontrado = true;

                        // ===== CONFIRMAÇÃO =====

                        Alert confirmacao = new Alert(
                                Alert.AlertType.CONFIRMATION
                        );

                        confirmacao.setTitle("Confirmar exclusão");
                        confirmacao.setHeaderText(
                                "Excluir funcionário"
                        );

                        confirmacao.setContentText(
                                "Tem certeza que deseja excluir "
                                        + funcionarios[i].nome
                                        + "?"
                        );

                        ButtonType resultado =
                                confirmacao.showAndWait().orElse(ButtonType.CANCEL);

                        if (resultado == ButtonType.OK) {

                            funcionarios[i] = null;

                            mensagem.setText(
                                    "Funcionário excluído com sucesso!"
                            );

                            campoNome.clear();
                        }

                        break;
                    }
                }
            }

            if (!encontrado) {

                mensagem.setText(
                        "Funcionário não encontrado."
                );
            }
        });

        // ===== FORMULÁRIO =====

        VBox formulario = new VBox(10);

        formulario.getChildren().add(labelNome);
        formulario.getChildren().add(campoNome);
        formulario.getChildren().add(excluir);
        formulario.getChildren().add(mensagem);

        // ===== LAYOUT =====

        VBox layout = new VBox(20);

        layout.getChildren().add(titulo);
        layout.getChildren().add(subtitulo);
        layout.getChildren().add(formulario);

        layout.setAlignment(Pos.CENTER);
        layout.getStyleClass().add("formulario");

        // ===== CENA =====

        Scene scene = new Scene(layout, 500, 400);

        scene.getStylesheets().add(
                getClass().getResource("/style.css").toExternalForm()
        );

        janela.setTitle("Excluir Funcionário");
        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();
    }
}

