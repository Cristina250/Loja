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
public class BebidaAlcoolica extends Bebida{
    private int teor;

    public double getTeor() {
        return teor;
    }

    public void setTeor(int teor) {
        this.teor = teor;
    }

    @Override
    public String toString() {
        return "BebidaAlcoolica{" + "teor=" + teor + '}';
    }
    
}
