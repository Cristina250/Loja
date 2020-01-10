/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.cristina.villasboas.controller;

import br.edu.ifrs.canoas.cristina.villasboas.model.BebidaAlcoolica;
import br.edu.ifrs.canoas.cristina.villasboas.model.BebidaAlcoolicaDao;
import br.edu.ifrs.canoas.cristina.villasboas.model.BebidaNaoAlcoolica;
import br.edu.ifrs.canoas.cristina.villasboas.model.Casa;
import br.edu.ifrs.canoas.cristina.villasboas.model.HigieneCasaDao;
import br.edu.ifrs.canoas.cristina.villasboas.model.HigienePessoalDao;
import br.edu.ifrs.canoas.cristina.villasboas.model.Pessoal;
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
public class CadastroHigieneCasaController implements Initializable {
 /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Casa> tabela;
    @FXML
    private TableColumn<Casa, Integer> codigoHigieneCol;
    @FXML
    private TableColumn<Casa, String> nomeHigieneCol;
    @FXML
    private TableColumn<Casa, Integer> quantidadeHigieneCol;
    @FXML
    private TableColumn<Casa, Double> pesoHigieneCol;
    @FXML
    private TextField nome;
    @FXML
    private TextField peso;
    @FXML
    private TextField quantidade;
    @FXML
    private TextField codigo;
    
    private ObservableList<Casa> listaHigiene;  
   
      
    @FXML
    private void cadastrarHigieneCasa(ActionEvent event) {
        Casa c = new Casa();
        c.setNomeProduto(nome.getText());
        c.setCodigoProduto(Integer.parseInt(codigo.getText()));
        c.setQuantidadeProduto(Integer.parseInt(quantidade.getText()));
        c.setPeso(Double.parseDouble(peso.getText()));
        
        listaHigiene.add(c); 
        HigieneCasaDao dao = new HigieneCasaDao();
        dao.insere(c);

        nome.setText("");
        codigo.setText("");
        quantidade.setText("");
        peso.setText("");
    }
    
    @FXML
    private void editarProduto(ActionEvent event) {
        Casa pSelecionadaa = tabela.getSelectionModel().selectedItemProperty().getValue();
        nome.setText(pSelecionadaa.getNomeProduto());
        codigo.setText(String.valueOf(pSelecionadaa.getCodigoProduto()));
        codigo.setEditable(false);
        quantidade.setText("");
        peso.setText("");
    }
    @FXML
    public void editarFim(ActionEvent event){
        Casa c = new Casa();
        c.setNomeProduto(nome.getText());
        c.setCodigoProduto(Integer.parseInt(codigo.getText()));
        c.setQuantidadeProduto(Integer.parseInt(quantidade.getText()));
        c.setPeso(Double.parseDouble(peso.getText()));
        
        listaHigiene.add(c); 
        HigieneCasaDao dao = new HigieneCasaDao();
        dao.update(c);

        nome.setText("");
        codigo.setEditable(true);
        codigo.setText("");
        quantidade.setText("");
        peso.setText("");
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
        Casa pSelecionadaa = tabela.getSelectionModel().selectedItemProperty().getValue();
        HigieneCasaDao dao = new HigieneCasaDao();
        dao.delete(pSelecionadaa);
        listaHigiene.remove(pSelecionadaa);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaHigiene = tabela.getItems();
        HigieneCasaDao dao = new HigieneCasaDao();
        List<Casa> bebidaT = dao.getAll();
        for (Casa l : bebidaT) {
            listaHigiene.add(l);
        }
        codigoHigieneCol.setCellValueFactory(new PropertyValueFactory<>("codigoProduto"));
        nomeHigieneCol.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        quantidadeHigieneCol.setCellValueFactory(new PropertyValueFactory<>("quantidadeProduto"));
        pesoHigieneCol.setCellValueFactory(new PropertyValueFactory<>("peso"));
        this.tabela.setItems(listaHigiene);
    }

    
}
