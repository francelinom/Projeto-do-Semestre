/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import modelos.Produto;
import persistencia.ConsultarPrecoDAO;

/**
 * FXML Controller class
 *
 * @author Thiago
 */
public class ConsultaPrecoController implements Initializable {
    private ConsultarPrecoDAO c = new ConsultarPrecoDAO();
    private Produto p;
    
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
    }    

    @FXML
    private void consPreco(KeyEvent event) {
       if (event.getCode() == KeyCode.ENTER) {
            p = c.consultaPreco(Integer.parseInt(consultaPreco.getText()));
            mostrarNome.setText(p.getNome_produto());
            mostraPreco.setText(String.format("R$ "+"%.2f", p.getPreco_produto()));
            limparCampos();
       }
    }

    private void limparCampos() {
        consultaPreco.clear();
    }
}
