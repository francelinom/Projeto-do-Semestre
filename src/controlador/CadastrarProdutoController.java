/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import modelos.Produto;
import persistencia.CadastroProtudoDAO;

/**
 * FXML Controller class
 *
 * @author Thiago Dantas
 */
public class CadastrarProdutoController implements Initializable {
    
    private CadastroProtudoDAO p = new CadastroProtudoDAO();
    
    @FXML
    private JFXTextField codBarras;
    @FXML
    private JFXTextField nomeProduto;
    @FXML
    private JFXTextField precoProduto;
    @FXML
    private JFXTextField unidadeProduto;
    @FXML
    private JFXTextField quantProduto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cadastrarProduto(ActionEvent event) {
        Produto a = new Produto(nomeProduto.getText(),Double.parseDouble(codBarras.getText()),Double.parseDouble(precoProduto.getText()),Integer.parseInt(quantProduto.getText()), unidadeProduto.getText());
        p.cadastrarProduto(a);
    }

    @FXML
    private void atualizarProduto(ActionEvent event) {
    }

    @FXML
    private void limparCampos(ActionEvent event) {
    }

    @FXML
    private void ExcluirCadastro(ActionEvent event) {
    }

       
}
