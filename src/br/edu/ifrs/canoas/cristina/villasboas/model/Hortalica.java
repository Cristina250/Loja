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
public class Hortalica extends Alimento{
    private int prazoPromocao;

    public int getPrazoPromocao() {
        return prazoPromocao;
    }

    public void setPrazoPromocao(int prazoPromocao) {
        this.prazoPromocao = prazoPromocao;
    }
     @Override
    public String toString() {
        return "Hortaliça{" + "prazo de promoção =" + prazoPromocao + super.toString();
    }

}
