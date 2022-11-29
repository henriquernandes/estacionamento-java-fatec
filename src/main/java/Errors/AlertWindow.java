/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Errors;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author rebel
 */
public class AlertWindow {
    private String msg = "Dados inseridos com sucesso!";
    private String title = "Atenção";
    private String header = "Mensagem";
    

    public AlertWindow() {
    }

    public AlertWindow(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void getInformation() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(title);
        alerta.setHeaderText(header);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }
    
    public void getError() {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(title);
        alerta.setHeaderText(header);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }
    
    public boolean getConfirmation() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText("Atenção");
        alerta.setContentText("Deseja mesmo excluir?");
        Optional resultado = alerta.showAndWait();
        return resultado.get() == ButtonType.CANCEL;
           
    }
    
}
