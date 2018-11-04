/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.CaixaController.controleVenda;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import modelos.Venda;
import persistencia.FinalizarVendaDAO;

/**
 * FXML Controller class
 *
 * @author Thiago
 */
public class FinalizarVendaController implements Initializable {
    FinalizarVendaDAO gravarVenda = new FinalizarVendaDAO();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
    }    


    @FXML
    private void cancelarPagamento(ActionEvent event) {
    }

    @FXML
    private void finalizarPagamento(ActionEvent event) {
        
    }
    
}
