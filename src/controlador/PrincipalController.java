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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author thiago
 */
public class PrincipalController implements Initializable {

    @FXML
    private JFXButton iniciobtn;
    @FXML
    private JFXButton cadasbtn;
    @FXML
    private AnchorPane panielPrinc;
    @FXML
    private BorderPane tela;
    @FXML
    private ImageView logo;
    @FXML
    private Label titulo;
    @FXML
    private JFXButton caixabtn;
    @FXML
    private JFXButton btnrelatorio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void telaPrincipal(ActionEvent event) {
        tela.setCenter(panielPrinc);
        titulo.setText("INICIO");
    }

    @FXML
    private void cadastrarProdutos(ActionEvent event) {
        try {
            Parent cadastrarProdutos = FXMLLoader.load(getClass().getResource("/visao/CadastrarProduto.fxml"));
            tela.setCenter(cadastrarProdutos);
            titulo.setText("CADASTRAR");
            
        } catch (Exception e) {
        }
    }

    @FXML
    private void caixa(ActionEvent event) {
        try {
            Parent caixa = FXMLLoader.load(getClass().getResource("/visao/Caixa.fxml"));
            tela.setCenter(caixa);
            titulo.setText("CAIXA");
        } catch (Exception e) {
        }
    }

    @FXML
    private void gerarRelatorio(ActionEvent event) {
        Parent relatorio;
        try {
            relatorio = FXMLLoader.load(getClass().getResource("/visao/Relatorio.fxml"));
            tela.setCenter(relatorio);
            titulo.setText("RELATÓRIOS");
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
