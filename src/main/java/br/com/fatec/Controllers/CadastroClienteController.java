/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class CadastroClienteController implements Initializable {

    @FXML
    private AnchorPane paneClientes;
    @FXML
    private HBox hboxBotoes;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnConsultar;
    @FXML
    private Label lblTitulo;
    @FXML
    private VBox vboxLabels;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblEndereco;
    @FXML
    private Label lblTelefone;
    @FXML
    private CheckBox chbMensalista;
    @FXML
    private VBox vboxTexto;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtEndereco;
    @FXML
    private TextField txtTelefone;
    @FXML
    private VBox vboxBotoes;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnLimpar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnSalvar_Click(ActionEvent event) {
    }

    @FXML
    private void btnAlterar_Click(ActionEvent event) {
    }

    @FXML
    private void btnExcluir_Click(ActionEvent event) {
    }

    @FXML
    private void btnConsultar_Click(ActionEvent event) {
    }

    @FXML
    private void btnVoltar_Click(ActionEvent event) {
    }

    @FXML
    private void btnLimpar_Click(ActionEvent event) {
    }
    
}
