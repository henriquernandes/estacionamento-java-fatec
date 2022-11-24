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
public class Cliente {
    private final SimpleStringProperty nome, endereco, telefone;
    private final SimpleBooleanProperty mensalista, selecionado;
    private final SimpleIntegerProperty id;

    public Cliente() {
        this.nome = new SimpleStringProperty("");
        this.endereco = new SimpleStringProperty("");
        this.telefone = new SimpleStringProperty("");
        this.mensalista = new SimpleBooleanProperty(false);
        this.selecionado = new SimpleBooleanProperty(false);
        this.id = new SimpleIntegerProperty(0);
    }

    public Cliente(String nome, String endereco, String telefone, boolean mensalista, boolean selecionado, int id) {
        this.nome = new SimpleStringProperty(nome);
        this.endereco = new SimpleStringProperty(endereco);
        this.telefone = new SimpleStringProperty(telefone);
        this.mensalista = new SimpleBooleanProperty(mensalista);
        this.selecionado = new SimpleBooleanProperty(false);
        this.id = new SimpleIntegerProperty(id);
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public SimpleStringProperty enderecoProperty() {
        return endereco;
    }

    public SimpleStringProperty telefoneProperty() {
        return telefone;
    }

    public SimpleBooleanProperty mensalistaProperty() {
        return mensalista;
    }

    public SimpleBooleanProperty selecionadoProperty() {
        return selecionado;
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getEndereco() {
        return endereco.get();
    }

    public void setEndereco(String endereco) {
        this.endereco.set(endereco);
    }

    public String getTelefone() {
        return telefone.get();
    }

    public void setTelefone(String telefone) {
        this.telefone.set(telefone);
    }

    public boolean isMensalista() {
        return mensalista.get();
    }

    public void setMensalista(boolean mensalista) {
        this.mensalista.set(mensalista);
    }

    public boolean isSelecionado() {
        return selecionado.get();
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado.set(selecionado);
    }
      
    public void setId(int id) {
        this.id.set(id);
    }
    public int getId() {
        return this.id.get();
    }
}
