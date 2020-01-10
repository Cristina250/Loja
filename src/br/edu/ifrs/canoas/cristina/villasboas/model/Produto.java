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
public abstract class Produto {
    private String nomeProduto;
    private int quantidadeProduto;
    private int codigoProduto;

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
    @Override
    public String toString() {
        return "Produto{" + "nomeProduto=" + nomeProduto + ", quantidadeProduto=" + quantidadeProduto + ", codigoProduto=" + codigoProduto + '}';
    }

     
}
