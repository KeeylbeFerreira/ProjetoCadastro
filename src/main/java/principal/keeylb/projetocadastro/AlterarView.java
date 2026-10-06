package principal.keeylb.projetocadastro;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlterarView {

    Funcionario[] funcionarios;

    public AlterarView(Funcionario[] funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void abrir() {

        Stage janela = new Stage();

        // ===== TÍTULO =====

        Label titulo = new Label("ALTERAR FUNCIONÁRIO");
        titulo.getStyleClass().add("titulo-formulario");

        Label subtitulo = new Label(
                "Busque um funcionário e atualize seus dados"
        );
        subtitulo.getStyleClass().add("subtitulo-formulario");

        // ===== BUSCA =====

        Label labelBusca = new Label("Nome do funcionário");
        labelBusca.getStyleClass().add("label-formulario");

        TextField campoBusca = new TextField();
        campoBusca.setPromptText("Digite o nome do funcionário");

        Button buscar = new Button("🔍  Buscar funcionário");
        buscar.getStyleClass().add("botao-cadastrar");

        // ===== MENSAGEM =====

        Label mensagem = new Label();
        mensagem.getStyleClass().add("mensagem");

        // ===== CAMPOS DE ALTERAÇÃO =====

        Label labelDados = new Label("Dados do funcionário");
        labelDados.getStyleClass().add("label-formulario");

        TextField campoNome = new TextField();
        campoNome.setPromptText("Nome");

        TextField campoIdade = new TextField();
        campoIdade.setPromptText("Idade");

        TextField campoCargo = new TextField();
        campoCargo.setPromptText("Cargo");

        TextField campoSalario = new TextField();
        campoSalario.setPromptText("Salário");

        Button salvar = new Button("✓  Salvar alterações");
        salvar.getStyleClass().add("botao-cadastrar");

        // ===== CAMPOS ESCONDIDOS INICIALMENTE =====

        labelDados.setVisible(false);
        campoNome.setVisible(false);
        campoIdade.setVisible(false);
        campoCargo.setVisible(false);
        campoSalario.setVisible(false);
        salvar.setVisible(false);

        // ===== BUSCAR FUNCIONÁRIO =====

        buscar.setOnAction(event -> {

            String nomeBusca = campoBusca.getText();

            boolean encontrado = false;

            for (int i = 0; i < funcionarios.length; i++) {

                if (funcionarios[i] != null) {

                    if (funcionarios[i].nome.equalsIgnoreCase(nomeBusca)) {

                        campoNome.setText(funcionarios[i].nome);
                        campoIdade.setText(funcionarios[i].idade);
                        campoCargo.setText(funcionarios[i].cargo);

                        campoSalario.setText(
                                String.valueOf(funcionarios[i].salario)
                        );

                        labelDados.setVisible(true);
                        campoNome.setVisible(true);
                        campoIdade.setVisible(true);
                        campoCargo.setVisible(true);
                        campoSalario.setVisible(true);
                        salvar.setVisible(true);

                        mensagem.setText(
                                "✓ Funcionário encontrado. Você pode alterar os dados."
                        );

                        mensagem.getStyleClass().remove("mensagem-erro");
                        mensagem.getStyleClass().add("mensagem-sucesso");

                        encontrado = true;

                        break;
                    }
                }
            }

            if (!encontrado) {

                mensagem.setText(
                        "Funcionário não encontrado."
                );

                mensagem.getStyleClass().remove("mensagem-sucesso");
                mensagem.getStyleClass().add("mensagem-erro");
            }
        });

        // ===== SALVAR ALTERAÇÕES =====

        salvar.setOnAction(event -> {

            String nomeBusca = campoBusca.getText();

            for (int i = 0; i < funcionarios.length; i++) {

                if (funcionarios[i] != null) {

                    if (funcionarios[i].nome.equalsIgnoreCase(nomeBusca)) {

                        funcionarios[i].nome =
                                campoNome.getText();

                        funcionarios[i].idade =
                                campoIdade.getText();

                        funcionarios[i].cargo =
                                campoCargo.getText();

                        funcionarios[i].salario =
                                Double.parseDouble(
                                        campoSalario.getText()
                                );

                        mensagem.setText(
                                "✓ Funcionário alterado com sucesso!"
                        );

                        mensagem.getStyleClass().remove("mensagem-erro");
                        mensagem.getStyleClass().add("mensagem-sucesso");

                        break;
                    }
                }
            }
        });

        // ===== FORMULÁRIO DE BUSCA =====

        VBox buscaBox = new VBox(8);

        buscaBox.getChildren().add(labelBusca);
        buscaBox.getChildren().add(campoBusca);
        buscaBox.getChildren().add(buscar);

        buscaBox.getStyleClass().add("secao-formulario");

        // ===== FORMULÁRIO DE ALTERAÇÃO =====

        VBox alteracaoBox = new VBox(8);

        alteracaoBox.getChildren().add(labelDados);
        alteracaoBox.getChildren().add(campoNome);
        alteracaoBox.getChildren().add(campoIdade);
        alteracaoBox.getChildren().add(campoCargo);
        alteracaoBox.getChildren().add(campoSalario);
        alteracaoBox.getChildren().add(salvar);

        alteracaoBox.getStyleClass().add("secao-formulario");

        // ===== LAYOUT =====

        VBox layout = new VBox(18);

        layout.getChildren().add(titulo);
        layout.getChildren().add(subtitulo);
        layout.getChildren().add(buscaBox);
        layout.getChildren().add(alteracaoBox);
        layout.getChildren().add(mensagem);

        layout.setAlignment(Pos.TOP_CENTER);
        layout.getStyleClass().add("formulario");

        // ===== CENA =====

        Scene scene = new Scene(layout, 500, 650);

        scene.getStylesheets().add(
                getClass().getResource("/style.css").toExternalForm()
        );

        janela.setTitle("Alterar Funcionário");
        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();
    }
}