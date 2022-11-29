/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.Controllers;

import Errors.AlertWindow;
import br.com.fatec.DAO.ClienteDAO;
import br.com.fatec.Model.Cliente;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;
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
import javafx.stage.Stage;

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
    @FXML
    private Label lblId;
    @FXML
    private TextField txtId;
    
    private boolean insere, altera, remove;
    ClienteDAO dao = new ClienteDAO();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnSalvar_Click(ActionEvent event) {
        Cliente c = new Cliente();
        c.setNome(txtNome.getText());
        c.setTelefone(txtTelefone.getText());
        c.setEndereco(txtEndereco.getText());
        c.setMensalista(chbMensalista.isSelected());
        try{
            if(dao.insere(c)){
                AlertWindow alert = new AlertWindow("Dados inseridos com sucesso");
                alert.getInformation();
            }else {
                AlertWindow alert = new AlertWindow("Dados não inseridos!");
                alert.getError();
                limparCampos();
            }
        }catch(SQLException e){
           Logger.getLogger(CadastroCarrosController.class.getName());
        }
    }

    @FXML
    private void btnAlterar_Click(ActionEvent event) {
        Cliente c = new Cliente();
        c.setNome(txtNome.getText());
        c.setTelefone(txtTelefone.getText());
        c.setEndereco(txtEndereco.getText());
        c.setMensalista(chbMensalista.isSelected());
        try{
            if(dao.altera(c)){
                AlertWindow alert = new AlertWindow("Dados alterados com sucesso");
                alert.getInformation();
            }else {
                AlertWindow alert = new AlertWindow("Dados não inseridos!");
                alert.getError();
            }
        }catch(SQLException e){
           Logger.getLogger(CadastroCarrosController.class.getName());
        }
    }

    @FXML
    private void btnExcluir_Click(ActionEvent event) {
        Cliente c = new Cliente();
        c.setId(Integer.parseInt(txtId.getText()));
        AlertWindow alert = new AlertWindow();
        if(alert.getConfirmation()){
            return;
        }
        try{
            if(dao.remove(c)){
                alert = new AlertWindow("Dados excluidos com sucesso");
                alert.getInformation();
                limparCampos();
            }else {
                alert = new AlertWindow("Dados não inseridos!");
                alert.getError();
            }
        }catch(SQLException e){
           Logger.getLogger(CadastroCarrosController.class.getName());
        }
    }

    @FXML
    private void btnConsultar_Click(ActionEvent event) {
        Cliente c = new Cliente();
        c.setId(Integer.parseInt(txtId.getText()));
        try{
            c = dao.buscaID(c);
            if(c != null){
                txtNome.setText(c.getNome());
                txtTelefone.setText(c.getTelefone());
                txtEndereco.setText(c.getEndereco());
                chbMensalista.setSelected(c.isMensalista());;
            }else {
                limparCampos();
                AlertWindow alert = new AlertWindow("Cliente não localizado");
                alert.getError();
            }
        }catch(SQLException e){
           Logger.getLogger(CadastroCarrosController.class.getName());
        }
    }

    @FXML
    private void btnVoltar_Click(ActionEvent event) {
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnLimpar_Click(ActionEvent event) {
        limparCampos();
    }
    
    private void limparCampos() {
        txtNome.setText("");
        txtTelefone.setText("");
        txtEndereco.setText("");
        chbMensalista.setSelected(false);
    }
    
}
