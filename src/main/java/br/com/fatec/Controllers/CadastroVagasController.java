/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.Controllers;

import Errors.AlertWindow;
import br.com.fatec.DAO.VagaDAO;
import br.com.fatec.DAO.VeiculoDAO;
import br.com.fatec.Model.Vaga;
import br.com.fatec.Model.Veiculo;
import java.net.URL;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    private Label lblCarroId;
    private TextField txtCodigo;
    @FXML
    private ComboBox<Veiculo> cbIdCarro;
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
    @FXML
    private Label lblCoberta;
    @FXML
    private TextField txtCodVaga;
    @FXML
    private CheckBox chbCoberta;
    
    
    private boolean insere, altera, remove;
    VagaDAO dao = new VagaDAO();
    VeiculoDAO daoVeiculo = new VeiculoDAO();
    
    private ObservableList<Veiculo> carros;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
            carros = FXCollections.observableArrayList(daoVeiculo.lista(""));
            cbIdCarro.setItems(carros);
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }    

    @FXML
    private void btnSalvar_Click(ActionEvent event) {
        Vaga vaga = new Vaga();
        Veiculo carro = new Veiculo();
        carro.setId(cbIdCarro.getSelectionModel().getSelectedItem().getId());
        vaga.setCarro(carro);
        vaga.setCod_vaga(txtCodVaga.getText());
        vaga.setCoberta(chbCoberta.isSelected());

        try{
             if(dao.insere(vaga)){
                 AlertWindow alert = new AlertWindow("Dados inseridos com sucesso");
                 alert.getInformation();
             }else {
                 AlertWindow alert = new AlertWindow("Dados não alterados");
                 alert.getError();
             }
         }catch(SQLException e){
            System.out.println(e.getMessage());
         }
    }

    @FXML
    private void btnAlterar_Click(ActionEvent event) {
        Veiculo carro = new Veiculo();
        Vaga vaga = new Vaga();
        
        if(cbIdCarro.getValue() == null){
            AlertWindow alert = new AlertWindow("Nenhum carro selecionado!!");
            alert.getError();
            return;
        }
        vaga.setCarro(carro);
        vaga.setCod_vaga(txtCodVaga.getText());
        vaga.setCoberta(chbCoberta.isSelected());

        try{
            if(dao.altera(vaga)){
                AlertWindow alert = new AlertWindow("Dados alterados com sucesso");
                alert.getInformation();
            }else {
                AlertWindow alert = new AlertWindow("Dados não alterados");
                alert.getError();
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void btnExcluir_Click(ActionEvent event) {
        Vaga v = new Vaga();
        v.setCod_vaga(txtCodVaga.getText());
        AlertWindow alert = new AlertWindow();
        try{
            v = dao.buscaID(v);
            if(v == null){
                alert.setMsg("Nenhuma vaga encontrada");
                alert.getError();
                return;
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        if(alert.getConfirmation()){
            return;
        }
        try{
            if(dao.remove(v)){
                alert = new AlertWindow("Dados excluidos com sucesso");
                alert.getInformation();
                limparCampos();
            }else {
                alert = new AlertWindow("Dados não inseridos!");
                alert.getError();
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void btnConsultar_Click(ActionEvent event) {
        Vaga v = new Vaga();
        v.setCod_vaga(txtCodVaga.getText());
        try{
            v = dao.buscaID(v);
            if(v != null){
                txtCodVaga.setText(v.getCod_vaga());
                chbCoberta.setSelected(v.isCoberta());
                cbIdCarro.setValue(daoVeiculo.buscaByID(v.getCarro()));
            }else {
                limparCampos();
                AlertWindow alert = new AlertWindow("Cliente não localizado");
                alert.getError();
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void btnVoltar_Click(ActionEvent event) {
    }

    @FXML
    private void btnLimpar_Click(ActionEvent event) {
        
    }
    
    public void limparCampos() {
        txtCarroId.setText("");
        txtCodigo.setText("");
    }
   
}
