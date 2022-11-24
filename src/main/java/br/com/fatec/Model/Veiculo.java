/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.Model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Aluno
 */
public class Veiculo {
    private final SimpleStringProperty marca, modelo, ano, placa;

    public Veiculo() {
        this.marca = new SimpleStringProperty("");
        this.modelo = new SimpleStringProperty("");
        this.ano = new SimpleStringProperty("");
        this.placa = new SimpleStringProperty("");
    }

    public Veiculo(String marca, String modelo, String ano, String placa) {
        this.marca = new SimpleStringProperty(marca);
        this.modelo = new SimpleStringProperty(modelo);
        this.ano = new SimpleStringProperty(ano);
        this.placa = new SimpleStringProperty(placa);
    }

    public String getMarca() {
        return marca.get();
    }

    public void setMarca(String marca) {
        this.marca.set(marca);
    }

    public String getModelo() {
        return modelo.get();
    }

    public void setModelo(String modelo) {
        this.modelo.set(modelo);
    }

    public String getAno() {
        return ano.get();
    }

    public void setAno(String ano) {
        this.ano.set(ano);
    }

    public String getPlaca() {
        return placa.get();
    }

    public void setPlaca(String placa) {
        this.placa.set(placa);
    }
    
      
}
