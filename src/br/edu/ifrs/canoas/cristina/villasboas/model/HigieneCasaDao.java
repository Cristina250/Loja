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
public class HigieneCasaDao extends AbstractDao<Casa>{

    @Override
    public int delete(Casa obj) {
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
    public int update(Casa obj) {
        Conexao c = new Conexao();
        Connection dbConexao = c.getConexao();
        ArrayList<Casa> listaHigiene = new ArrayList<Casa>();

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
    public int insere(Casa obj) {
        Conexao c = new Conexao();
        Connection dbConexao = c.getConexao();
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO HIEGIENE"
                + "(NOME, PESO, QUANTIDADE, CODIGOH) VALUES"
                + "(?,?,?,?)";
        try {
            preparedStatement = dbConexao.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, obj.getNomeProduto());
            preparedStatement.setInt(2, obj.getQuantidadeProduto());
            preparedStatement.setInt(3, obj.getCodigoProduto());
            preparedStatement.executeUpdate();
            System.out.println("");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Casa> getAll() {
        Conexao c = new Conexao();
        Connection dbConexao = c.getConexao();
        ArrayList<Casa> listaHigiene = new ArrayList<Casa>();
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT *FROM HIEGIENE";
        Statement st;
        try {
            st = dbConexao.createStatement();
            ResultSet rs = st.executeQuery(selectSQL);
            while (rs.next()) {
                Casa l1 = new Casa();
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
    


