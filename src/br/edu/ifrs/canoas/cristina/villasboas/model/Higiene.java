/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.cristina.villasboas.model;

/**
 *
 * @author Cristina S.VilasBoas
 */
public class Higiene extends Produto{
private double peso;

    @Override
    public String toString() {
        return "Higiene{" + "Peso =" + peso + super.toString();
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    
}
