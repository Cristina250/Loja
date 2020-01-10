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
 * @author Aluno
 */
public class HigienePessoalDao extends AbstractDao<Pessoal>{

    @Override
    public int delete(Pessoal obj) {
    Conexao c = new Conexao();
        Connection dbConexao = c.getConexao();
        PreparedStatement preparedStatement = null;
        String insertTableSQL = "DELETE FROM HIEGIENE  WHERE NOME = ?";
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
    public int update(Pessoal obj) {
        Conexao c = new Conexao();
        Connection dbConexao = c.getConexao();
        ArrayList<Pessoal> listaHigiene = new ArrayList<Pessoal>();

        PreparedStatement preparedStatement = null;
        String insertTableSQL = "UPDATE HIEGIENE SET NOME = ? WHERE CODIGOH = ?";
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
    public int insere(Pessoal obj) {
        Conexao c = new Conexao();
        Connection dbConexao = c.getConexao();
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO BEBIDA"
                + "(NOME, PESO, QUANTIDADE, CODIGOH) VALUES"
                + "(?,?,?,?)";
        try {
            preparedStatement = dbConexao.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, obj.getNomeProduto());
            preparedStatement.setDouble(2, obj.getPeso());
            preparedStatement.setInt(3, obj.getQuantidadeProduto());
            preparedStatement.setInt(3, obj.getCodigoProduto());
            preparedStatement.executeUpdate();
            System.out.println("");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Pessoal> getAll() {
    Conexao c = new Conexao();
        Connection dbConexao = c.getConexao();
        ArrayList<Pessoal> listaHigiene = new ArrayList<Pessoal>();
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT *FROM HIEGIENE";
        Statement st;
        try {
            st = dbConexao.createStatement();
            ResultSet rs = st.executeQuery(selectSQL);
            while (rs.next()) {
                Pessoal l1 = new Pessoal();
                l1.setNomeProduto(rs.getString("NOME"));
                l1.setQuantidadeProduto(rs.getInt("QUANTIDADE"));
                l1.setCodigoProduto(rs.getInt("CODIGO"));
                l1.setPeso(rs.getInt("PESO"));
                listaHigiene.add(l1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaHigiene;
    }
  }
    

