/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.Model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Aluno
 */
public class Vaga {
    private final SimpleStringProperty cod_vaga;
    private final SimpleBooleanProperty coberta;

   
    public Vaga() {
        this.cod_vaga = new SimpleStringProperty("");
        this.coberta = new SimpleBooleanProperty(false);
    }
    
    public Vaga(String cod_vaga, boolean coberta){
        this.cod_vaga = new SimpleStringProperty(cod_vaga);
        this.coberta = new SimpleBooleanProperty(coberta);
    }
    
    public String getCod_vaga() {
        return cod_vaga.get();
    }

    public void setCod_vaga(String cod_vaga) {
        this.cod_vaga.set(cod_vaga);
    }

    public boolean isCoberta() {
        return coberta.get();
    }

    public void setCoberta(boolean coberta) {
        this.coberta.set(coberta);
    }
    
}
