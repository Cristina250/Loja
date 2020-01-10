/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.cristina.villasboas.model;

import java.util.ArrayList;

/**
 *
 * @author Cristina S.VilasBoas
 */
public class Alimento extends Produto{
    private double peso;
    private int validade;

    @Override
    public String toString() {
        return "Alimento{" + "peso=" + peso + ", validade=" + validade + '}';
    }

    public int getValidade() {
        return validade;
    }

    public void setValidade(int validade) {
        this.validade = validade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }  
}
