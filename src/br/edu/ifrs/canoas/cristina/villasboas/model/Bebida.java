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
public class Bebida extends Produto{
    private  String tipoGarrafa;

    public String getTipoGarrafa() {
        return tipoGarrafa;
    }

    public void setTipoGarrafa(String tipoGarrafa) {
        this.tipoGarrafa = tipoGarrafa;
    }

    @Override
    public String toString() {
        return "Bebida{" + "tipoGarrafa=" + tipoGarrafa + '}';
    }
}
