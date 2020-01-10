/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.cristina.villasboas.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Aluno
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Label label;
   
    @FXML
    private void btAlimento(ActionEvent event) {
        Parent root;
        try {
            Stage stage = Final.stage;
            root = FXMLLoader.load(getClass().getResource("CategoriaAlimento.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void btHigiene(ActionEvent event) {
        Parent root;
        try {
            Stage stage = Final.stage;
            root = FXMLLoader.load(getClass().getResource("CategoriaHigiene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        @FXML
    private void btBebida(ActionEvent event) {
        Parent root;
        try {
            Stage stage = Final.stage;
            root = FXMLLoader.load(getClass().getResource("CategoriaBebida.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb){}    
}
