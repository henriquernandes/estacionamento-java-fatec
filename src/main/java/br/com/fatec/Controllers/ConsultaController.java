/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.Controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import br.com.fatec.DAO.ClienteDAO;
import br.com.fatec.Model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class ConsultaController implements Initializable {

    @FXML
    private Button btnVoltar;
    
    @FXML
    private TableColumn<Cliente, String> colID;

    @FXML
    private TableColumn<Cliente, String> colEndereco;

    @FXML
    private TableColumn<Cliente, Boolean> colMensalista;

    @FXML
    private TableColumn<Cliente, String> colNome;

    @FXML
    private TableColumn<Cliente, String> colTelefone;

    @FXML
    private AnchorPane paneConsulta;

    @FXML
    private TableView<Cliente> tbConsulta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colMensalista.setCellValueFactory(new PropertyValueFactory<>("mensalista"));

        tbConsulta.setItems(preencheTabela());
    }

    private ObservableList<Cliente> preencheTabela() {
        ClienteDAO dao = new ClienteDAO();
        ObservableList<Cliente> clientes = FXCollections.observableArrayList();

        try {
            clientes.addAll(dao.lista(""));
        } catch (SQLException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR, "Erro Preenche Tabela: " + e.getMessage(), ButtonType.OK);
            alerta.showAndWait();
        }
        return clientes;
    }

    @FXML
    private void btnVoltar_Click(ActionEvent event) {
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        stage.close();
    }
}