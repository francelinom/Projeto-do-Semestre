/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
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
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
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
     
}