/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.Controllers;

import Errors.AlertWindow;
import br.com.fatec.DAO.VeiculoDAO;
import br.com.fatec.Model.Cliente;
import br.com.fatec.Model.Veiculo;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
public class CadastroCarrosController implements Initializable {

    @FXML
    private AnchorPane paneCarros;
    @FXML
    private VBox vboxLabel;
    @FXML
    private Label lblPlaca;
    @FXML
    private Label lblModelo;
    @FXML
    private Label lblMarca;
    @FXML
    private Label lblAno;
    @FXML
    private VBox vboxTextos;
    @FXML
    private TextField txtPlaca;
    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtAno;
    @FXML
    private TextField txtClienteId;
    @FXML
    private Label lblClienteId;
    @FXML
    private HBox hboxBotoes;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnLimpar;
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
    
    private boolean insere, altera, remove;
    VeiculoDAO dao = new VeiculoDAO();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    @FXML
    private void btnSalvar_Click(ActionEvent event) {
        Veiculo carro = new Veiculo();
        Cliente c = new Cliente();
        c.setId(Integer.parseInt(txtClienteId.getText()));
        carro.setCliente(c);
        
        carro.setPlaca(txtPlaca.getText());
        carro.setModelo(txtModelo.getText());
        carro.setMarca(txtMarca.getText());
        carro.setCliente(c);
        carro.setAno(txtAno.getText());
        
        try{
            if(dao.buscaID(carro) != null){
                AlertWindow alert = new AlertWindow("Esse cadastro já existe!!");
                 alert.getError();
                 return;
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        
        try{
            if(dao.insere(carro)){
                AlertWindow alert = new AlertWindow("Dados inseridos com sucesso");
                alert.getInformation();
            }else {
                AlertWindow alert = new AlertWindow("Dados não alterados");
                alert.getError();
            }
        }catch(SQLException e){
           Logger.getLogger(CadastroCarrosController.class.getName());
        }
    }

    @FXML
    private void btnAlterar_Click(ActionEvent event) {
        Veiculo carro = new Veiculo();
        Cliente c = new Cliente();
        c.setId(Integer.parseInt(txtClienteId.getText()));
        carro.setCliente(c);
        
        carro.setPlaca(txtPlaca.getText());
        carro.setModelo(txtModelo.getText());
        carro.setMarca(txtMarca.getText());
        carro.setCliente(c);
        carro.setAno(txtAno.getText());
        
        try{
            if(dao.altera(carro)){
                AlertWindow alert = new AlertWindow("Dados alterados com sucesso");
                alert.getInformation();
            }else {
                AlertWindow alert = new AlertWindow("Dados não alterados");
                alert.getError();
            }
        }catch(SQLException e){
           Logger.getLogger(CadastroCarrosController.class.getName());
        }
    }

    @FXML
    private void btnExcluir_Click(ActionEvent event) throws SQLException{
        Veiculo carro = new Veiculo();
        AlertWindow alert = new AlertWindow();
        if(alert.getConfirmation()){
            return;
        }
        try{
            carro.setPlaca(txtPlaca.getText());
            carro = dao.buscaID(carro);
            if(carro == null){
                alert = new AlertWindow("Carro inválido");
                alert.getInformation();
            }
            if(dao.remove(carro)){
                alert = new AlertWindow("Dados removidos com sucesso");
                alert.getInformation();
                limparCampos();
            }else {
                alert = new AlertWindow("Dados não removidos");
                alert.getError();
            }
        }catch(SQLException e){
           Logger.getLogger(CadastroCarrosController.class.getName());
        }
    }

    @FXML
    private void btnConsultar_Click(ActionEvent event) {
        Veiculo v = new Veiculo();
        v.setPlaca(txtPlaca.getText());
        try{
            v = dao.buscaID(v);
                    System.out.println(txtPlaca.getText());

            if(v != null){
                txtAno.setText(v.getAno());
                txtMarca.setText(v.getMarca());
                txtModelo.setText(v.getModelo());
                txtPlaca.setText(v.getPlaca());
                txtClienteId.setText(""+ v.getCliente().getId());
                System.out.println(v.getAno());
            }else {
                limparCampos();
                AlertWindow alert = new AlertWindow("Veiculo não localizado");
                alert.getError();
            }
        }catch(SQLException e){
           Logger.getLogger(CadastroCarrosController.class.getName());
        }
    }
    
    public void limparCampos() {
        txtPlaca.setText("");
        txtModelo.setText("");
        txtMarca.setText("");
        txtAno.setText("");
        txtClienteId.setText("");
    }
    
}
