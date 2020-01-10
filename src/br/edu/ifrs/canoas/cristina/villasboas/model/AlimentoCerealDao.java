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
public class AlimentoCerealDao extends AbstractDao<Cereal> {

    @Override
    public int delete(Cereal obj) {
        Conexao c = new Conexao();
        Connection dbConexao = c.getConexao();
        PreparedStatement preparedStatement = null;
        String insertTableSQL = "DELETE FROM ALIMENTO WHERE NOME = ?";
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
    public int update(Cereal obj) {
        Conexao c = new Conexao();
        Connection dbConexao = c.getConexao();
        ArrayList<Cereal> listaAlimento = new ArrayList<Cereal>();

        PreparedStatement preparedStatement = null;
        String insertTableSQL = "UPDATE ALIMENTO SET NOME = ? WHERE CODIGOA = ?";
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
    public int insere(Cereal obj) {
        Conexao c = new Conexao();
        Connection dbConexao = c.getConexao();
        PreparedStatement preparedStatement = null;
        String insertTableSQL = "INSERT INTO ALIMENTO"
                + "(NOME, PESO,VALIDADE, CODIGOA) VALUES"
                + "(?,?,?,?)";
        try {
            preparedStatement = dbConexao.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, obj.getNomeProduto());
            preparedStatement.setDouble(2, obj.getPeso());
           // preparedStatement.setDouble(3, obj.getValor());
            preparedStatement.setInt(3, obj.getValidade());
            preparedStatement.setInt(4, obj.getCodigoProduto());
            
            preparedStatement.executeUpdate();
            System.out.println("");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Cereal> getAll() {
        Conexao c = new Conexao();
        Connection dbConexao = c.getConexao();
        ArrayList<Cereal> listaAlimento = new ArrayList<Cereal>();

        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT *FROM ALIMENTO WHERE ";
        Statement st;
        try {
            st = dbConexao.createStatement();
            ResultSet rs = st.executeQuery(selectSQL);
            while (rs.next()) {
                Cereal l1 = new Cereal();
                l1.setNomeProduto(rs.getString("NOME"));
                l1.setQuantidadeProduto(rs.getInt("VALIDADE"));
                l1.setCodigoProduto(rs.getInt("CODIGOA"));
                l1.setPeso(rs.getInt("PESO"));
               
               // l1.setValor(rs.getDouble("VALOR"));
                listaAlimento.add(l1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaAlimento;
    }

}
