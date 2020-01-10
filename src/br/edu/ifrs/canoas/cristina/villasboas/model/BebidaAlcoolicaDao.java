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
 * @author Cristina S.VilasBoas
 */
public class BebidaAlcoolicaDao extends AbstractDao<BebidaAlcoolica> {

    @Override
    public int delete(BebidaAlcoolica obj) {
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
    public int update(BebidaAlcoolica obj) {
        Conexao c = new Conexao();
        Connection dbConexao = c.getConexao();
        ArrayList<BebidaAlcoolica> listaBebida = new ArrayList<BebidaAlcoolica>();

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
    public int insere(BebidaAlcoolica obj) {
        Conexao c = new Conexao();
        Connection dbConexao = c.getConexao();
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO BEBIDA"
                + "(NOME, QUANTIDADE, TEOR, EMBALAGEM, CODIGO) VALUES"
                + "(?,?,?,?,?)";
        try {
            preparedStatement = dbConexao.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, obj.getNomeProduto());
            preparedStatement.setInt(2, obj.getQuantidadeProduto());
            preparedStatement.setInt(3, (int) obj.getTeor());
            preparedStatement.setString(4, obj.getTipoGarrafa());
            preparedStatement.setInt(5, obj.getCodigoProduto());
            preparedStatement.executeUpdate();
            System.out.println("");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<BebidaAlcoolica> getAll() {
        Conexao c = new Conexao();
        Connection dbConexao = c.getConexao();
        ArrayList<BebidaAlcoolica> listaBebida = new ArrayList<BebidaAlcoolica>();

        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT *FROM BEBIDA";
        Statement st;
        try {
            st = dbConexao.createStatement();
            ResultSet rs = st.executeQuery(selectSQL);
            while (rs.next()) {
                BebidaAlcoolica l1 = new BebidaAlcoolica();
                l1.setNomeProduto(rs.getString("NOME"));
                l1.setQuantidadeProduto(rs.getInt("QUANTIDADE"));
                l1.setTeor(rs.getInt("TEOR"));
                l1.setCodigoProduto(rs.getInt("CODIGO"));
                listaBebida.add(l1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaBebida;
    }

}
