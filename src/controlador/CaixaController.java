/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void finalizarVenda(ActionEvent event) {
        try {
            Parent finalizar = FXMLLoader.load(getClass().getResource("/visao/FinalizarVenda.fxml"));
            caixa.setCenter(finalizar);
        } catch (Exception e) {
        }
    }
}
