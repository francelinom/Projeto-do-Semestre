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
    
    private double somaTotal;
    private ObservableList<itensVenda> nitens;
    
    @FXML
    private JFXTextField dinheiro;
    @FXML
    private JFXTextField credito;
    @FXML
    private JFXTextField debito;
    @FXML
    private JFXTextField alimentacao;
    @FXML
    private JFXTextField desconto;
    @FXML
    private Label troco;
    @FXML
    private Label total;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        total.setText("nome");
    }    


    @FXML
    private void cancelarPagamento(ActionEvent event) {
    }

    @FXML
    private void finalizarPagamento(ActionEvent event) {
        
    }

    public void finalizar(ObservableList<itensVenda> itens, double totalVenda) {
        ObservableList<itensVenda> nitens = itens;
        somaTotal = totalVenda;
        System.out.println(somaTotal);

    }
}
