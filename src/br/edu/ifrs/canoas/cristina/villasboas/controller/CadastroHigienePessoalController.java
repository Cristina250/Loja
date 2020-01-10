/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.cristina.villasboas.controller;

import br.edu.ifrs.canoas.cristina.villasboas.model.BebidaNaoAlcoolica;
import br.edu.ifrs.canoas.cristina.villasboas.model.BebidaNaoAlcoolicaDao;
import br.edu.ifrs.canoas.cristina.villasboas.model.Casa;
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
public class CadastroHigienePessoalController implements Initializable {

    /**
     * FXML Controller class
     *
     * @author Cristina S.VilasBoas
     */
    
    @FXML
    private TableView<Pessoal> tabelaZ;
    @FXML
    private TableColumn<Pessoal, Integer> codigoHigieneCol;
    @FXML
    private TableColumn<Pessoal, String> nomeHigieneCol;
    @FXML
    private TableColumn<Pessoal, Integer> quantidadeHigieneCol;
    @FXML
    private TableColumn<Pessoal, Double> pesoHigieneCol;

    @FXML
    private TextField nome;

    @FXML
    private TextField peso;

    @FXML
    private TextField quantidade;

    @FXML
    private TextField codigo;

    private ObservableList<Pessoal> listaHigiene;

    @FXML
    private void cadastrarHigienePessoal(ActionEvent event) {
        Pessoal p = new Pessoal();
        p.setNomeProduto(nome.getText());
        p.setCodigoProduto(Integer.parseInt(codigo.getText()));
        p.setQuantidadeProduto(Integer.parseInt(quantidade.getText()));
        p.setPeso(Double.parseDouble(peso.getText()));

        listaHigiene.add(p); 
        HigienePessoalDao dao = new HigienePessoalDao();
        dao.insere(p);

        nome.setText("");
        codigo.setText("");
        quantidade.setText("");
        peso.setText("");
    }
    
     @FXML
    private void editarProduto(ActionEvent event) {
        Pessoal pSelecionadaa = tabelaZ.getSelectionModel().selectedItemProperty().getValue();
        nome.setText(pSelecionadaa.getNomeProduto());
        codigo.setText(String.valueOf(pSelecionadaa.getCodigoProduto()));
        codigo.setEditable(false);
        codigo.setText("");
        quantidade.setText("");
        peso.setText("");
    }
    @FXML
    public void editarFim(ActionEvent event){
        Pessoal b = new Pessoal();
        b.setNomeProduto(nome.getText());
        b.setCodigoProduto(Integer.parseInt(codigo.getText()));
        b.setQuantidadeProduto(Integer.parseInt(quantidade.getText()));
        b.setPeso(Double.parseDouble(peso.getText()));

        listaHigiene.add(b); 
        HigienePessoalDao dao = new HigienePessoalDao();
        dao.update(b);

        nome.setText("");
        codigo.setEditable(true);
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
        Pessoal pSelecionadaa = tabelaZ.getSelectionModel().selectedItemProperty().getValue();
        HigienePessoalDao dao = new HigienePessoalDao();
        dao.delete(pSelecionadaa);
        listaHigiene.remove(pSelecionadaa);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaHigiene = tabelaZ.getItems();
        HigienePessoalDao dao = new HigienePessoalDao();
        List<Pessoal> bebidaT = dao.getAll();
        for (Pessoal l : bebidaT) {
            listaHigiene.add(l);
        }
        codigoHigieneCol.setCellValueFactory(new PropertyValueFactory<>("codigoProduto"));
        nomeHigieneCol.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        quantidadeHigieneCol.setCellValueFactory(new PropertyValueFactory<>("quantidadeProduto"));
        pesoHigieneCol.setCellValueFactory(new PropertyValueFactory<>("peso"));
        this.tabelaZ.setItems(listaHigiene);
    }

}
