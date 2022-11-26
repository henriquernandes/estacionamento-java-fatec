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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class CadastroVagasController implements Initializable {

    @FXML
    private AnchorPane paneVagas;
    @FXML
    private Label lblCodigo;
    @FXML
    private Label lblTipo;
    @FXML
    private Label lblCarroId;
    @FXML
    private TextField txtCodigo;
    @FXML
    private ComboBox<?> cbTipo;
    @FXML
    private TextField txtCarroId;
    @FXML
    private Label lblTitulo;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnConsultar;
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
