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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class ConsultaController implements Initializable {

    @FXML
    private AnchorPane paneConsulta;
    @FXML
    private Label lblConsulta;
    @FXML
    private ComboBox<?> cbConsulta;
    @FXML
    private Label lblCodigo;
    @FXML
    private TextField txtCodigo;
    @FXML
    private TableView<?> tbConsulta;
    @FXML
    private TableColumn<?, ?> colVaga;
    @FXML
    private TableColumn<?, ?> colCliente;
    @FXML
    private TableColumn<?, ?> colCarro;
    @FXML
    private Button btnBusca;
    @FXML
    private Button btnVoltar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnBusca_Click(ActionEvent event) {
    }

    @FXML
    private void btnVoltar_Click(ActionEvent event) {
    }
    
}
