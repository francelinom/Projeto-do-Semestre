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
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import main.Principal;

/**
 * FXML Controller class
 *
 * @author thiago
 */
public class CaixaController implements Initializable {
    
    
    
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
    
    
    @FXML
    private TableView<?> tabelaVenda;
    @FXML
    private TableColumn<?, ?> idProduto;
    @FXML
    private TableColumn<?, ?> nomeProduto;
    @FXML
    private TableColumn<?, ?> quantProduto;
    @FXML
    private TableColumn<?, ?> precoProduto;
    @FXML
    private TableColumn<?, ?> totalItem;
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
     
}