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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
        if(checaCampos()){
            AlertWindow alert = new AlertWindow("Preencha todos os campos!!");
            alert.getError();
            return;
        }

        Vaga vaga = new Vaga();
        Veiculo carro = new Veiculo();
        carro.setId(cbIdCarro.getSelectionModel().getSelectedItem().getId());
        vaga.setCarro(carro);
        vaga.setCod_vaga(txtCodVaga.getText());
        vaga.setCoberta(chbCoberta.isSelected());

        try{
            if(dao.buscaID(vaga) != null){
                AlertWindow alert = new AlertWindow("Esse cadastro já existe!!");
                 alert.getError();
                 return;
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

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
        vaga.setCod_vaga(txtCodVaga.getText());
        
        if(checaCampos()){
            AlertWindow alert = new AlertWindow("Preencha todos os campos!!");
            alert.getError();
            return;
        }else {
            carro.setId(cbIdCarro.getSelectionModel().getSelectedItem().getId());
        }

        
        
        try{
            vaga = dao.buscaID(vaga);
            System.out.println(vaga);
            if(vaga == null){
                AlertWindow alert = new AlertWindow("Nenhum vaga encontrada!!");
                alert.getError();
                return;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
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
        if(txtCodVaga.getText().isEmpty()){
            AlertWindow alert = new AlertWindow("Preencha o cod da vaga");
            alert.getError();
            return;
        }

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
                alert = new AlertWindow("Dados não excluidos!");
                alert.getError();
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void btnConsultar_Click(ActionEvent event) {
        if(txtCodVaga.getText().isEmpty()){
            AlertWindow alert = new AlertWindow("Preencha o codigo da vaga");
            alert.getError();
            return;
        }

        Vaga v = new Vaga();
        v.setCod_vaga(txtCodVaga.getText());

        try{
            v = dao.buscaID(v);
            if(v != null){
                txtCodVaga.setText(v.getCod_vaga());
                chbCoberta.setSelected(v.isCoberta());
                Veiculo c = daoVeiculo.buscaByID(v.getCarro());
                cbIdCarro.setValue(c);
            }else {
                limparCampos();
                AlertWindow alert = new AlertWindow("Vaga não localizado");
                alert.getError();
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
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

    public void limparCampos() {
        txtCodVaga.setText("");
        chbCoberta.setSelected(false);
        cbIdCarro.getSelectionModel().clearSelection();
        cbIdCarro.setValue(null);
    }

    //faça uma função para checar se o campo está vazio
    public boolean checaCampos(){
        return txtCodVaga.getText().isEmpty() || cbIdCarro.getValue() == null || cbIdCarro.getSelectionModel().isEmpty();
    }
}
