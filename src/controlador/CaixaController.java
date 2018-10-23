/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import main.Principal;
import modelos.Produto;
import modelos.itensVenda;
import persistencia.CaixaDAO;
/**
 * FXML Controller class
 *
 * @author thiago
 */
public class CaixaController implements Initializable {
    
    CaixaDAO p = new CaixaDAO();
    
    itensVenda item;
    
        
    @FXML
    private JFXButton finalizarVenda;
    @FXML
    private BorderPane caixa;
    @FXML
    private JFXButton canVenda;
    @FXML
    private TextField campoLeitura;
    @FXML
    private JFXTextField totalVenda;
    
    //tabela
    
    ObservableList<itensVenda> itens = FXCollections.observableArrayList();
    
    @FXML
    private TableView<itensVenda> tabelaVenda;
    @FXML
    private TableColumn<itensVenda, Integer> idProduto;
    @FXML
    private TableColumn<itensVenda, String> nomeProduto;
    @FXML
    private TableColumn<itensVenda, Integer> quantProduto;
    @FXML
    private TableColumn<itensVenda, Double> precoProduto;
    @FXML
    private TableColumn<itensVenda, Double> totalItem;
    @FXML
    private JFXButton excluirItem;
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idProduto.setCellValueFactory(new PropertyValueFactory<itensVenda,Integer>("id_produto"));
        nomeProduto.setCellValueFactory(new PropertyValueFactory<itensVenda,String>("nome_produto"));
        precoProduto.setCellValueFactory(new PropertyValueFactory<itensVenda,Double>("preco_produto"));
        quantProduto.setCellValueFactory(new PropertyValueFactory<itensVenda,Integer>("quantidade"));
        totalItem.setCellValueFactory(new PropertyValueFactory<itensVenda,Double>("total_item"));
        
        atualizarTabela();
        
    }    
    
    @FXML
    private void finalizarVenda(ActionEvent event) throws IOException {
       
        Parent root =FXMLLoader.load(getClass().getResource("/visao/FinalizarVenda.fxml"));
        Scene janela = new Scene(root);
        
        Stage stage = new Stage();
        stage.setScene(janela);
        stage.show();
        stage.setTitle("Finalizar Venda");
        
//        try {                
//            //Parent finalizar = FXMLLoader.load(getClass().getResource("/visao/FinalizarVenda.fxml"));
//            //caixa.setCenter(finalizar);
//                       
//        } catch (Exception e) {
//        }
    }

    @FXML
    private void canelarVenda(ActionEvent event) {
    }

    @FXML
    private void excluirItem(ActionEvent event) {
    }

    @FXML
    private void listar(KeyEvent event) {
        System.out.println("teste");
        itensVenda item = p.consultaProduto(Integer.parseInt(campoLeitura.getText()));
        atualizarTabela();
        
        //p.cadastradarProduto();
    }
    
     private void atualizarTabela() {
	itens.add(item);
        tabelaVenda.setItems(itens);
    }
}