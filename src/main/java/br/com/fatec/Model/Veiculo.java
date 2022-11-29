/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Aluno
 */
public class Veiculo {
    private final SimpleStringProperty marca, modelo, ano, placa;
    private final SimpleIntegerProperty id;
    private final SimpleObjectProperty<Cliente> cliente;



    public Veiculo() {
        this.cliente = new SimpleObjectProperty<Cliente>();
        this.marca = new SimpleStringProperty("");
        this.modelo = new SimpleStringProperty("");
        this.ano = new SimpleStringProperty("");
        this.placa = new SimpleStringProperty("");
        this.id = new SimpleIntegerProperty(0);
    }

    public Veiculo(String marca, String modelo, String ano, String placa, int id, SimpleObjectProperty<Cliente> cliente) {
        this.marca = new SimpleStringProperty(marca);
        this.modelo = new SimpleStringProperty(modelo);
        this.ano = new SimpleStringProperty(ano);
        this.placa = new SimpleStringProperty(placa);
        this.id = new SimpleIntegerProperty(id);
        this.cliente = cliente;
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
    
    public void setId(int id) {
        this.id.set(id);
    }

    public int getId() {
        return id.get();
    }

    public Cliente getCliente() {
        return cliente.get();
    }

    public void setCliente(Cliente cliente) {
        this.cliente.set(cliente);
    }
}
