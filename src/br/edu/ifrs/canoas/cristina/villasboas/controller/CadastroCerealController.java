/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.cristina.villasboas.controller;

import br.edu.ifrs.canoas.cristina.villasboas.model.AlimentoCerealDao;
import br.edu.ifrs.canoas.cristina.villasboas.model.BebidaNaoAlcoolica;
import br.edu.ifrs.canoas.cristina.villasboas.model.BebidaNaoAlcoolicaDao;
import br.edu.ifrs.canoas.cristina.villasboas.model.Cereal;
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
public class CadastroCerealController implements Initializable {
    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Cereal> tabela;
    
    @FXML
    private TableColumn<Cereal, Integer> codigoAlimentoCol;
    
    @FXML
    private TableColumn<Cereal, String> nomeAlimentoCol;
    
    @FXML
    private TableColumn<Cereal, Double> pesoAlimentoCol;
    
    @FXML
    private TableColumn<Cereal, Integer> validadeAlimentoCol;
    
    @FXML
    private TableColumn<Cereal, Double> valorAlimentoCol;
    
    @FXML
    private TextField nome;
    
    @FXML
    private TextField peso;
    
    @FXML
    private TextField codigo;
    
    @FXML
    private TextField validade;
    
     @FXML
    private TextField valor;
    
    private ObservableList<Cereal> listaAlimento; 
    
    @FXML
    private void cadastrarCereal(ActionEvent event) {
        Cereal c = new Cereal();
        c.setNomeProduto(nome.getText());
        c.setCodigoProduto(Integer.parseInt(codigo.getText()));
        c.setValidade(Integer.parseInt(validade.getText()));
        c.setPeso(Integer.parseInt(peso.getText()));
        
        listaAlimento.add(c); 
        AlimentoCerealDao dao = new AlimentoCerealDao();
        dao.update(c);
        
        nome.setText("");
        codigo.setText("");
        validade.setText("");
        peso.setText("");
       
    }
    
    @FXML
    private void editarProduto(ActionEvent event) {
        Cereal alimentoSelecionado = tabela.getSelectionModel().selectedItemProperty().getValue();
        nome.setText(alimentoSelecionado.getNomeProduto());
        codigo.setText(String.valueOf(alimentoSelecionado.getCodigoProduto()));
        codigo.setEditable(false);
        validade.setText("");
        peso.setText(""); 
    }
    @FXML
    public void editarFim(ActionEvent event){
        Cereal c = new Cereal();
        c.setNomeProduto(nome.getText());
        c.setCodigoProduto(Integer.parseInt(codigo.getText()));
        c.setValidade(Integer.parseInt(validade.getText()));
        c.setPeso(Integer.parseInt(peso.getText()));
        
        listaAlimento.add(c); 
        AlimentoCerealDao dao = new AlimentoCerealDao();
        dao.update(c);
        
        nome.setText("");
        codigo.setEditable(true);
        codigo.setText("");
        validade.setText("");
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
       Cereal alimentoSelecionado = tabela.getSelectionModel().selectedItemProperty().getValue();
       AlimentoCerealDao  dao = new AlimentoCerealDao ();
       dao.delete(alimentoSelecionado); 
       listaAlimento.remove(alimentoSelecionado);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaAlimento = tabela.getItems();//Ponteiro
        AlimentoCerealDao  dao = new AlimentoCerealDao();
        List<Cereal> cerealT = dao.getAll();
        for(Cereal l : cerealT){
            listaAlimento.add(l);
        }
        codigoAlimentoCol.setCellValueFactory(new PropertyValueFactory<>("codigoProduto"));
        nomeAlimentoCol.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        pesoAlimentoCol.setCellValueFactory(new PropertyValueFactory<>("peso"));
        validadeAlimentoCol.setCellValueFactory(new PropertyValueFactory<>("validade"));
        this.tabela.setItems(listaAlimento);
    }
}
