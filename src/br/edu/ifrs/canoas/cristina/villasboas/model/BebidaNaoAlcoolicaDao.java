/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.cristina.villasboas.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristina
 */
public class BebidaNaoAlcoolicaDao extends AbstractDao<BebidaNaoAlcoolica>{
    @Override
    public int delete(BebidaNaoAlcoolica obj) {
        Conexao c = new Conexao();
        Connection dbConexao = c.getConexao();
        PreparedStatement preparedStatement = null;
        String insertTableSQL = "DELETE FROM BEBIDA  WHERE NOME = ?";
        try {
            preparedStatement = dbConexao.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, obj.getNomeProduto());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(BebidaNaoAlcoolica obj) {
        Conexao c = new Conexao();
        Connection dbConexao = c.getConexao();
        ArrayList<BebidaNaoAlcoolica> listaBebida = new ArrayList<BebidaNaoAlcoolica>();
        PreparedStatement preparedStatement = null;
        String insertTableSQL = "UPDATE BEBIDA SET NOME = ? WHERE CODIGO = ?";
        try {
            preparedStatement = dbConexao.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, obj.getNomeProduto());
            preparedStatement.setInt(2, obj.getCodigoProduto());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    @Override
    public int insere(BebidaNaoAlcoolica obj) {
        Conexao c = new Conexao();
        Connection dbConexao = c.getConexao();
        PreparedStatement preparedStatement = null;
        String insertTableSQL = "INSERT INTO BEBIDA"
                + "(NOME, QUANTIDADE, EMBALAGEM, CODIGO) VALUES"
                + "(?,?,?,?)";
        try {
            preparedStatement = dbConexao.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, obj.getNomeProduto());
            preparedStatement.setInt(2, obj.getQuantidadeProduto());
            preparedStatement.setString(3, obj.getTipoGarrafa());
            preparedStatement.setInt(4, obj.getCodigoProduto());
            preparedStatement.executeUpdate();
            System.out.println("");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<BebidaNaoAlcoolica> getAll() {
       Conexao c = new Conexao();
        Connection dbConexao = c.getConexao();
        ArrayList<BebidaNaoAlcoolica> listaBebida = new ArrayList<BebidaNaoAlcoolica>();
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT *FROM BEBIDA WHERE TEOR IS NULL ";
        Statement st;
        try {
            st = dbConexao.createStatement();
            ResultSet rs = st.executeQuery(selectSQL);
            while (rs.next()) {
                BebidaNaoAlcoolica l1 = new BebidaNaoAlcoolica();
                l1.setNomeProduto(rs.getString("NOME"));
                l1.setQuantidadeProduto(rs.getInt("QUANTIDADE"));
                l1.setCodigoProduto(rs.getInt("CODIGO"));
                l1.setTipoGarrafa(rs.getString("EMBALAGEM"));
                listaBebida.add(l1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaBebida;
    }
    }
  

    
    

