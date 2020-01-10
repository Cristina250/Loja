/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.cristina.villasboas.controller;

import br.edu.ifrs.canoas.cristina.villasboas.model.AlimentoCerealDao;
import br.edu.ifrs.canoas.cristina.villasboas.model.AlimentoFrutaDao;
import br.edu.ifrs.canoas.cristina.villasboas.model.Casa;
import br.edu.ifrs.canoas.cristina.villasboas.model.Cereal;
import br.edu.ifrs.canoas.cristina.villasboas.model.Fruta;
import br.edu.ifrs.canoas.cristina.villasboas.model.HigieneCasaDao;
import br.edu.ifrs.canoas.cristina.villasboas.model.HigienePessoalDao;
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
public class CadastroFrutaController implements Initializable {

    /**
     * Initializes the controller class.
     */
  
     @FXML
    private TableView<Fruta> tabelaZ;
    @FXML
    private TableColumn<Fruta, Integer> codigoAlimentoCol;
    
    @FXML
    private TableColumn<Fruta, String> nomeAlimentoCol;
    
    @FXML
    private TableColumn<Fruta, Integer> pesoAlimentoCol;
    
    @FXML
    private TableColumn<Fruta, String> validadeAlimentoCol;
    
    @FXML
    private TextField nome;
    
    @FXML
    private TextField quantidade;
    
    @FXML
    private TextField codigo;
    
    @FXML
    private TextField peso;
    @FXML
    private TextField validade;
    private ObservableList<Fruta> listaAlimento; 
    
    @FXML
    private void cadastrarFruta(ActionEvent event) {
        Fruta f = new Fruta();
        f.setNomeProduto(nome.getText());
        f.setCodigoProduto(Integer.parseInt(codigo.getText()));
        f.setPeso(Integer.parseInt(peso.getText()));
        f.setValidade(Integer.parseInt(validade.getText()));
        
        listaAlimento.add(f); 
        AlimentoFrutaDao dao = new AlimentoFrutaDao();
        dao.update(f);
        
        nome.setText("");
        codigo.setText("");
        validade.setText("");
        peso.setText("");
    }
      @FXML
    private void editarProduto(ActionEvent event) {
        Fruta alimentoSelecionado = tabelaZ.getSelectionModel().selectedItemProperty().getValue();
        nome.setText(alimentoSelecionado.getNomeProduto());
        codigo.setText(String.valueOf(alimentoSelecionado.getCodigoProduto()));
        codigo.setEditable(false);
        validade.setText("");
        peso.setText(""); 
    }
     @FXML
    public void editarFim(ActionEvent event){
        Fruta b = new Fruta();
        b.setNomeProduto(nome.getText());
        b.setCodigoProduto(Integer.parseInt(codigo.getText()));
        b.setQuantidadeProduto(Integer.parseInt(quantidade.getText()));
        b.setPeso(Integer.parseInt(peso.getText()));
        
        listaAlimento.add(b); 
        AlimentoFrutaDao dao = new AlimentoFrutaDao();
        dao.update(b);

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
        Fruta alimentoSelecionado = tabelaZ.getSelectionModel().selectedItemProperty().getValue();
        AlimentoFrutaDao dao = new AlimentoFrutaDao();
        dao.delete(alimentoSelecionado);
        listaAlimento.remove(alimentoSelecionado);
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        listaAlimento = tabelaZ.getItems();
        AlimentoFrutaDao dao = new AlimentoFrutaDao();
        List<Fruta> FrutaT = dao.getAll();
        for (Fruta l : FrutaT) {
            listaAlimento.add(l);
        }
        codigoAlimentoCol.setCellValueFactory(new PropertyValueFactory<>("codigoProduto"));
        nomeAlimentoCol.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        pesoAlimentoCol.setCellValueFactory(new PropertyValueFactory<>("peso"));
        validadeAlimentoCol.setCellValueFactory(new PropertyValueFactory<>("validade"));
        this.tabelaZ.setItems(listaAlimento);
    }
}
