/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.Model;

/**
 *
 * @author rebel
 */
public class Mensalidade {
    
    private double valor;
    private int id;

    public Mensalidade() {
    }

    public Mensalidade(double valor, int id) {
        this.valor = valor;
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ""+valor;
    }
    
    
    
}
