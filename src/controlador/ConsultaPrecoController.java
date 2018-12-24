/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import modelos.Produto;
import persistencia.ProdutoDAO;

public class ConsultaPrecoController implements Initializable {
    private ProdutoDAO c = new ProdutoDAO();
    private Produto produto;
    private ArrayList<String> codigo  = new ArrayList<>();
    private ProdutoDAO listaCodigos = new ProdutoDAO();
    @FXML
    private BorderPane tela;
    @FXML
    private JFXTextField consultaPreco;
    @FXML
    private Label mostrarNome;
    @FXML
    private Label mostraPreco;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        codigo.addAll(listaCodigos.listarCodigo());
    }    

    @FXML
    private void consPreco(KeyEvent event) {
        
       if (event.getCode() == KeyCode.ENTER) {
           String i = consultaPreco.getText();
           if(codigo.contains(i)){
               produto = c.consultaPreco(consultaPreco.getText());
                mostrarNome.setText(produto.getNome_produto());
                mostraPreco.setText(String.format("R$ "+"%.2f", produto.getPreco_produto()));
                consultaPreco.clear();
           }else{
               mostrarNome.setText("Não encontrado");
               consultaPreco.clear();
               mostraPreco.setText("");
           }
       }
    }
   
}
