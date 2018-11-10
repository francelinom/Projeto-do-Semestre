/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXTextField;
import static controlador.CaixaController.controleVenda;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import modelos.Venda;
import modelos.itensVenda;
import persistencia.FinalizarVendaDAO;

/**
 * FXML Controller class
 *
 * @author Thiago
 */
public class FinalizarVendaController implements Initializable {
    
    private FinalizarVendaDAO gravarVenda = new FinalizarVendaDAO();
    
    private double sTotal,dTotal, dinheiro = 0, credito=0, somaPag;
    private ObservableList<itensVenda> nitens;
    
    @FXML
    private Label troco;
    @FXML
    private Label total;
    @FXML
    private BorderPane finalizarVenda;
    @FXML
    private JFXTextField vDinheiro;
    @FXML
    private JFXTextField vCredito;
    @FXML
    private JFXTextField vDebito;
    @FXML
    private JFXTextField vAlimen;
    @FXML
    private JFXTextField vDesconto;
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nitens = CaixaController.controleVenda.itens;
        dTotal = sTotal = CaixaController.controleVenda.somaTotal;
        iniciarTotal();
    }    

    @FXML
    private void cancelarPagamento(ActionEvent event) {
        
    }
    
    @FXML
    private void finalizarPagamento(ActionEvent event) {
        
    }
   
    @FXML
    private void dinheiro(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            dinheiro = Double.parseDouble(vDinheiro.getText());
            somaP();
        }
    }

    @FXML
    private void credito(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            credito = Double.parseDouble(vDinheiro.getText());
        }
    }

    @FXML
    private void debito(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            
        }
    }

    @FXML
    private void alimentacao(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            
        }
    }

    @FXML
    private void desconto(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            
        }
    }
    
    private void iniciarTotal() {
        total.setText(String.valueOf(sTotal));
        troco.setText(String.valueOf(dTotal));
    }

    private void calculaTroco() {
        
       dTotal = sTotal - somaPag;
       troco.setText(String.valueOf(dTotal));
               
    }

    private void somaP() {
        somaPag = dinheiro + credito;
        calculaTroco();
    }
}
