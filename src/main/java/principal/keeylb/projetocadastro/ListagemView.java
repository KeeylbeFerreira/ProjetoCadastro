package principal.keeylb.projetocadastro;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListagemView {

    Funcionario[] funcionarios;

    public ListagemView(Funcionario[] funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void abrir() {

        Stage janela = new Stage();

        // ===== TÍTULO =====

        Label titulo = new Label("FUNCIONÁRIOS CADASTRADOS");
        titulo.getStyleClass().add("titulo-formulario");

        // ===== TABELA =====

        TableView<Funcionario> tabela = new TableView<>();

        TableColumn<Funcionario, String> colunaNome =
                new TableColumn<>("Nome");

        TableColumn<Funcionario, String> colunaIdade =
                new TableColumn<>("Idade");

        TableColumn<Funcionario, String> colunaCargo =
                new TableColumn<>("Cargo");

        TableColumn<Funcionario, Double> colunaSalario =
                new TableColumn<>("Salário");

        // ===== CONECTANDO AS COLUNAS =====

        colunaNome.setCellValueFactory(
                new PropertyValueFactory<>("nome")
        );

        colunaIdade.setCellValueFactory(
                new PropertyValueFactory<>("idade")
        );

        colunaCargo.setCellValueFactory(
                new PropertyValueFactory<>("cargo")
        );

        colunaSalario.setCellValueFactory(
                new PropertyValueFactory<>("salario")
        );

        // ===== ADICIONANDO COLUNAS NA TABELA =====

        tabela.getColumns().add(colunaNome);
        tabela.getColumns().add(colunaIdade);
        tabela.getColumns().add(colunaCargo);
        tabela.getColumns().add(colunaSalario);

        // ===== ADICIONANDO FUNCIONÁRIOS =====

        for (int i = 0; i < funcionarios.length; i++) {

            if (funcionarios[i] != null) {

                tabela.getItems().add(funcionarios[i]);
            }
        }

        // ===== TAMANHO DAS COLUNAS =====

        colunaNome.setPrefWidth(150);
        colunaIdade.setPrefWidth(100);
        colunaCargo.setPrefWidth(150);
        colunaSalario.setPrefWidth(120);

        // ===== LAYOUT =====

        VBox layout = new VBox(20);

        layout.getChildren().add(titulo);
        layout.getChildren().add(tabela);

        layout.setAlignment(Pos.CENTER);
        layout.getStyleClass().add("formulario");

        // ===== CENA =====

        Scene scene = new Scene(layout, 700, 500);

        scene.getStylesheets().add(
                getClass().getResource("/style.css").toExternalForm()
        );

        janela.setTitle("Funcionários");
        janela.setScene(scene);
        janela.setResizable(false);
        janela.show();
    }
}