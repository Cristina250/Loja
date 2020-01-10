/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.cristina.villasboas.controller;

import br.edu.ifrs.canoas.cristina.villasboas.model.AlimentoCerealDao;
import br.edu.ifrs.canoas.cristina.villasboas.model.AlimentoFrutaDao;
import br.edu.ifrs.canoas.cristina.villasboas.model.AlimentoHortalicaDao;
import br.edu.ifrs.canoas.cristina.villasboas.model.Casa;
import br.edu.ifrs.canoas.cristina.villasboas.model.Cereal;
import br.edu.ifrs.canoas.cristina.villasboas.model.Fruta;
import br.edu.ifrs.canoas.cristina.villasboas.model.HigieneCasaDao;
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
public class CadastroHortalicaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Hortalica> tabela;
    
    @FXML
    private TableColumn<Hortalica, Integer> codigoAlimentoCol;
    
    @FXML
    private TableColumn<Hortalica, String> nomeAlimentoCol;
    
    @FXML
    private TableColumn<Hortalica, Integer> pesoAlimentoCol;
    
    @FXML
    private TableColumn<Hortalica, String> validadeAlimentoCol;
    
    
    @FXML
    private TextField nome;
    
    @FXML
    private TextField prazo;
    
    @FXML
    private TextField quantidade;
    
    @FXML
    private TextField codigo;
    
    
    private ObservableList<Hortalica> listaAlimento; 
   
    @FXML
    private void cadastrarHoralica(ActionEvent event) {
        Hortalica h = new Hortalica();

        h.setNomeProduto(nome.getText());
        h.setCodigoProduto(Integer.parseInt(codigo.getText()));
        h.setQuantidadeProduto(Integer.parseInt(quantidade.getText()));
        h.setPrazoPromocao(Integer.parseInt(prazo.getText()));
      
        listaAlimento.add(h); 
        AlimentoHortalicaDao dao = new AlimentoHortalicaDao();
        dao.update(h);
        
        nome.setText("");
        codigo.setText("");
        quantidade.setText("");
        prazo.setText("");
    }
      @FXML
    private void editarProduto(ActionEvent event) {
        Hortalica alimentoSelecionado = tabela.getSelectionModel().selectedItemProperty().getValue();
        nome.setText( alimentoSelecionado.getNomeProduto());
        codigo.setText(String.valueOf( alimentoSelecionado.getCodigoProduto()));
        codigo.setEditable(false);
        quantidade.setText("");
        prazo.setText("");
       
    }
     @FXML
    public void editarFim(ActionEvent event){
        Hortalica b = new Hortalica();
        b.setNomeProduto(nome.getText());
        b.setCodigoProduto(Integer.parseInt(codigo.getText()));
        b.setQuantidadeProduto(Integer.parseInt(quantidade.getText()));
        b.setPrazoPromocao(Integer.parseInt(prazo.getText()));
        
        listaAlimento.add(b); 
        AlimentoHortalicaDao dao = new AlimentoHortalicaDao();
        dao.update(b);

        nome.setText("");
        codigo.setEditable(true);
        codigo.setText("");
        quantidade.setText("");
        prazo.setText("");
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
       Hortalica alimentoSelecionado = tabela.getSelectionModel().selectedItemProperty().getValue();
       AlimentoHortalicaDao  dao = new AlimentoHortalicaDao  ();
       dao.delete( alimentoSelecionado); 
       listaAlimento.remove( alimentoSelecionado);
    }
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        listaAlimento = tabela.getItems();
        AlimentoHortalicaDao dao = new  AlimentoHortalicaDao();
        List<Hortalica> FrutaT = dao.getAll();
        for (Hortalica l : FrutaT) {
            listaAlimento.add(l);
        }
        codigoAlimentoCol.setCellValueFactory(new PropertyValueFactory<>("codigoProduto"));
        nomeAlimentoCol.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        pesoAlimentoCol.setCellValueFactory(new PropertyValueFactory<>("peso"));
        validadeAlimentoCol.setCellValueFactory(new PropertyValueFactory<>("prazoPromocao"));
        this.tabela.setItems(listaAlimento);
    }
}
