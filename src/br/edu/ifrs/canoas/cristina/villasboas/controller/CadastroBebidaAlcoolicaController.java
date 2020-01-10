/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.cristina.villasboas.controller;

import br.edu.ifrs.canoas.cristina.villasboas.model.BebidaAlcoolica;
import br.edu.ifrs.canoas.cristina.villasboas.model.BebidaAlcoolicaDao;
import br.edu.ifrs.canoas.cristina.villasboas.model.BebidaNaoAlcoolica;
import br.edu.ifrs.canoas.cristina.villasboas.model.BebidaNaoAlcoolicaDao;
import br.edu.ifrs.canoas.cristina.villasboas.model.Hortalica;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cristina S.VilasBoas
 */
public class CadastroBebidaAlcoolicaController implements Initializable {
    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<BebidaAlcoolica> tabela;
    
    @FXML
    private TableColumn<BebidaAlcoolica, Integer> codigoBebidaCol;
    
    @FXML
    private TableColumn<BebidaAlcoolica, String> nomeBebidaCol;
    
    @FXML
    private TableColumn<BebidaAlcoolica, Integer> teorBebidaCol;
    
    @FXML
    private TableColumn<BebidaAlcoolica, Integer> quantidadeBebidaCol;
    
    @FXML
    private TableColumn<BebidaAlcoolica, String> embalagemBebidaCol;
    
    @FXML
    private TextField nome;
    
    @FXML
    private TextField teor;
    
    @FXML
    private TextField quantidade;
    
    @FXML
    private TextField codigo;
    
    @FXML
    private TextField tipoGarrafa;
    
    private ObservableList<BebidaAlcoolica> listaBebida;
   
    @FXML
    private void cadastrarBebidaAlcoolica(ActionEvent event) {
        BebidaAlcoolica b = new BebidaAlcoolica();
        b.setNomeProduto(nome.getText());
        b.setCodigoProduto(Integer.parseInt(codigo.getText()));
        b.setQuantidadeProduto(Integer.parseInt(quantidade.getText()));
        b.setTeor(Integer.parseInt(teor.getText()));
        b.setTipoGarrafa(tipoGarrafa.getText());
        
        listaBebida.add(b); 
        BebidaAlcoolicaDao dao = new BebidaAlcoolicaDao();
        dao.insere(b);

        nome.setText("");
        codigo.setText("");
        quantidade.setText("");
        teor.setText("");
        tipoGarrafa.setText("");
    }
    
    @FXML
    private void btVoltar(ActionEvent event) {
        Parent root;
        try {
            Stage stage = Final.stage;
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void editarProduto(ActionEvent event) {
        BebidaAlcoolica bebidaSelecionadaa = tabela.getSelectionModel().selectedItemProperty().getValue();
        nome.setText(bebidaSelecionadaa.getNomeProduto());
        codigo.setText(String.valueOf(bebidaSelecionadaa.getCodigoProduto()));
        codigo.setEditable(false);
        quantidade.setText("");
        teor.setText("");
        tipoGarrafa.setText("");
       
    }
    
    public void editarFim(ActionEvent event){
        BebidaAlcoolica b = new BebidaAlcoolica();
        b.setNomeProduto(nome.getText());
        b.setCodigoProduto(Integer.parseInt(codigo.getText()));
        b.setQuantidadeProduto(Integer.parseInt(quantidade.getText()));
        b.setTeor(Integer.parseInt(teor.getText()));
        b.setTipoGarrafa(tipoGarrafa.getText());
        
        listaBebida.add(b); 
        BebidaAlcoolicaDao dao = new BebidaAlcoolicaDao();
        dao.update(b);
        nome.setText("");
        codigo.setEditable(true);
        codigo.setText("");
        quantidade.setText("");
        teor.setText("");
        tipoGarrafa.setText("");
    }
    @FXML
    private void deletarProduto(ActionEvent event) {
       BebidaAlcoolica bebidaSelecionadaa= tabela.getSelectionModel().selectedItemProperty().getValue();
       BebidaAlcoolicaDao dao = new BebidaAlcoolicaDao();
       dao.delete(bebidaSelecionadaa); 
       listaBebida.remove(bebidaSelecionadaa);
    }
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaBebida = tabela.getItems();//Ponteiro
        BebidaAlcoolicaDao dao = new BebidaAlcoolicaDao();
        List<BebidaAlcoolica> bebidaT = dao.getAll();
        
        for(BebidaAlcoolica l : bebidaT){
             listaBebida.add(l);
        }
        codigoBebidaCol.setCellValueFactory(new PropertyValueFactory<>("codigoProduto"));
        nomeBebidaCol.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        quantidadeBebidaCol.setCellValueFactory(new PropertyValueFactory<>("quantidadeProduto"));
        embalagemBebidaCol.setCellValueFactory(new PropertyValueFactory<>("tipoGarrafa"));
        teorBebidaCol.setCellValueFactory(new PropertyValueFactory<>("teor"));          
        this.tabela.setItems(listaBebida);
    }
}    

