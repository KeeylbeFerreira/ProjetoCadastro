package principal.keeylb.projetocadastro;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscaView {

    Funcionario[] funcionarios;

    public BuscaView(Funcionario[] funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void abrir() {

        Stage janela = new Stage();

        // ===== TÍTULO =====

        Label titulo = new Label("BUSCAR FUNCIONÁRIO");
        titulo.getStyleClass().add("titulo-formulario");

        Label subtitulo = new Label(
                "Encontre um funcionário cadastrado"
        );
        subtitulo.getStyleClass().add("subtitulo-formulario");

        // ===== CAMPO =====

        Label labelNome = new Label("Nome do funcionário");
        labelNome.getStyleClass().add("label-formulario");

        TextField campoNome = new TextField();
        campoNome.setPromptText("Digite o nome");

        // ===== BOTÃO =====

        Button buscar = new Button("🔍  Buscar");
        buscar.getStyleClass().add("botao-cadastrar");

        // ===== RESULTADO =====

        Label resultadoTitulo = new Label();
        resultadoTitulo.getStyleClass().add("resultado-titulo");

        Label resultado = new Label();
        resultado.getStyleClass().add("resultado");

        VBox resultadoBox = new VBox(8);

        resultadoBox.getChildren().add(resultadoTitulo);
        resultadoBox.getChildren().add(resultado);

        resultadoBox.getStyleClass().add("resultado-box");

        resultadoBox.setVisible(false);

        // ===== BUSCA =====

        buscar.setOnAction(event -> {

            String nomeBusca = campoNome.getText();

            boolean encontrado = false;

            for (int i = 0; i < funcionarios.length; i++) {

                if (funcionarios[i] != null) {

                    if (funcionarios[i].nome.equalsIgnoreCase(nomeBusca)) {

                        resultadoTitulo.setText(
                                "FUNCIONÁRIO ENCONTRADO"
                        );

                        resultado.setText(
                                "Nome: " + funcionarios[i].nome
                                        + "\nIdade: " + funcionarios[i].idade + " anos"
                                        + "\nCargo: " + funcionarios[i].cargo
                                        + "\nSalário: R$ "
                                        + String.format(
                                        "%.2f",
                                        funcionarios[i].salario
                                )
                        );

                        resultadoBox.getStyleClass().remove("resultado-erro");
                        resultadoBox.getStyleClass().add("resultado-sucesso");

                        resultadoBox.setVisible(true);

                        encontrado = true;

                        break;
                    }
                }
            }

            if (!encontrado) {

                resultadoTitulo.setText(
                        "FUNCIONÁRIO NÃO ENCONTRADO"
                );

                resultado.setText(
                        "Nenhum funcionário foi encontrado com esse nome."
                );

                resultadoBox.getStyleClass().remove("resultado-sucesso");
                resultadoBox.getStyleClass().add("resultado-erro");

                resultadoBox.setVisible(true);
            }
        });

        // ===== FORMULÁRIO =====

        VBox formulario = new VBox(8);

        formulario.getChildren().add(labelNome);
        formulario.getChildren().add(campoNome);
        formulario.getChildren().add(buscar);

        // ===== LAYOUT =====

        VBox layout = new VBox(20);

        layout.getChildren().add(titulo);
        layout.getChildren().add(subtitulo);
        layout.getChildren().add(formulario);
        layout.getChildren().add(resultadoBox);

        layout.setAlignment(Pos.TOP_CENTER);
        layout.getStyleClass().add("formulario");

        // ===== CENA =====

        Scene scene = new Scene(layout, 500, 500);

        scene.getStylesheets().add(
                getClass().getResource("/style.css").toExternalForm()
        );

        janela.setTitle("Buscar Funcionário");
        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();
    }
}