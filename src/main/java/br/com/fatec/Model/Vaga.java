/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.Model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Aluno
 */
public class Vaga {
    private final SimpleStringProperty cod_vaga;
    private final SimpleBooleanProperty coberta;
    private Veiculo carro;
    private final SimpleIntegerProperty id;

   
    public Vaga() {
        this.id = new SimpleIntegerProperty(0);
        this.cod_vaga = new SimpleStringProperty("");
        this.coberta = new SimpleBooleanProperty(false);
    }
    
    public Vaga(String cod_vaga, boolean coberta, SimpleIntegerProperty id){
        this.cod_vaga = new SimpleStringProperty(cod_vaga);
        this.coberta = new SimpleBooleanProperty(coberta);
        this.id = new SimpleIntegerProperty(id.get());
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

    public Veiculo getCarro() {
        return carro;
    }

    public void setCarro(Veiculo carro) {
        this.carro = carro;
    }

    public int getId() {
        return id.get();
    }
}
