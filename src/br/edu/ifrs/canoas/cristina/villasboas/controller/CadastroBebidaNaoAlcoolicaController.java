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
import br.edu.ifrs.canoas.cristina.villasboas.model.Casa;
import br.edu.ifrs.canoas.cristina.villasboas.model.HigieneCasaDao;
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
public class CadastroBebidaNaoAlcoolicaController implements Initializable {
    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<BebidaNaoAlcoolica> tabela;
    @FXML
    private TableColumn<BebidaNaoAlcoolica, Integer> codigoBebidaCol;
    @FXML
    private TableColumn<BebidaNaoAlcoolica, String> nomeBebidaCol;
    @FXML
    private TableColumn<BebidaNaoAlcoolica, Integer> quantidadeBebidaCol;
    @FXML
    private TableColumn<BebidaNaoAlcoolica, String> embalagemBebidaCol;
    @FXML
    private TextField nome;
    @FXML
    private TextField quantidade;
    @FXML
    private TextField codigo;
    @FXML
    private TextField tipoGarrafa;
    
    private ObservableList<BebidaNaoAlcoolica> listaBebida;   
    @FXML
    private void cadastrarNaoBebidaAlcoolica(ActionEvent event) {
        BebidaNaoAlcoolica b = new BebidaNaoAlcoolica();
        b.setNomeProduto(nome.getText());
        b.setCodigoProduto(Integer.parseInt(codigo.getText()));
        b.setQuantidadeProduto(Integer.parseInt(quantidade.getText()));
        b.setTipoGarrafa(tipoGarrafa.getText());
        
        listaBebida.add(b); 
        BebidaNaoAlcoolicaDao dao = new BebidaNaoAlcoolicaDao();
        dao.insere(b);
        
        nome.setText("");
        codigo.setText("");
        quantidade.setText("");
        tipoGarrafa.setText("");
    }
     @FXML
    private void editarProduto(ActionEvent event) {
        BebidaNaoAlcoolica bebidaSelecionadaa = tabela.getSelectionModel().selectedItemProperty().getValue();
        nome.setText(bebidaSelecionadaa.getNomeProduto());
        codigo.setText(String.valueOf(bebidaSelecionadaa.getCodigoProduto()));
        codigo.setEditable(false);
        quantidade.setText("");
        tipoGarrafa.setText(""); 
    }
    @FXML
    public void editarFim(ActionEvent event){
        BebidaNaoAlcoolica b = new BebidaNaoAlcoolica();
        b.setNomeProduto(nome.getText());
        b.setCodigoProduto(Integer.parseInt(codigo.getText()));
        b.setQuantidadeProduto(Integer.parseInt(quantidade.getText()));
        b.setTipoGarrafa(tipoGarrafa.getText());
        
        listaBebida.add(b); 
        BebidaNaoAlcoolicaDao dao = new BebidaNaoAlcoolicaDao();
        dao.update(b);

        nome.setText("");
        codigo.setEditable(true);
        quantidade.setText("");
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
    private void deletarProduto(ActionEvent event) {
       BebidaNaoAlcoolica bebidaSelecionada = tabela.getSelectionModel().selectedItemProperty().getValue();
       BebidaNaoAlcoolicaDao dao = new BebidaNaoAlcoolicaDao();
       dao.delete(bebidaSelecionada); 
       listaBebida.remove(bebidaSelecionada);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaBebida = tabela.getItems();
        BebidaNaoAlcoolicaDao dao = new BebidaNaoAlcoolicaDao();
        List<BebidaNaoAlcoolica> bebidaT = dao.getAll();
        for(BebidaNaoAlcoolica l : bebidaT){
             listaBebida.add(l);
        }
        codigoBebidaCol.setCellValueFactory(new PropertyValueFactory<>("codigoProduto"));
        nomeBebidaCol.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        quantidadeBebidaCol.setCellValueFactory(new PropertyValueFactory<>("quantidadeProduto"));
        embalagemBebidaCol.setCellValueFactory(new PropertyValueFactory<>("tipoGarrafa"));
        this.tabela.setItems(listaBebida);
    }
}
