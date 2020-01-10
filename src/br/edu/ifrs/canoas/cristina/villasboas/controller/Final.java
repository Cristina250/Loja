/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.cristina.villasboas.controller;

import br.edu.ifrs.canoas.cristina.villasboas.model.BebidaAlcoolica;
import br.edu.ifrs.canoas.cristina.villasboas.model.Produto;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Aluno
 */
public class Final extends Application {
    public static ArrayList<Produto> cadastrarProduto = new ArrayList <Produto>(); 
    static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        Final.stage = stage;
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    

}
