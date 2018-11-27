/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelos.Venda;
import modelos.itensVenda;
import persistencia.VendasDAO;

/**
 * FXML Controller class
 *
 * @author Marcílio
 */
public class RelatorioVendaController implements Initializable {

    private VendasDAO v = new VendasDAO();
    private String data;
    
    @FXML
    private DatePicker campoCalendario;
    @FXML
    private TextField campoBusca;
    @FXML
    private JFXButton buscarCliente;
    
    ObservableList<Venda> itens = FXCollections.observableArrayList();
    
    @FXML
    private TableView<Venda> tabelaRelatorioVenda;
    @FXML
    private TableColumn<Venda, Integer> nVenda;
    @FXML
    private TableColumn<Venda, String> dataVenda;
    @FXML
    private TableColumn<Venda, Double> valorVenda;
    @FXML
    private TableColumn<Venda, Double> valorPago;
    @FXML
    private TableColumn<Venda, Double> troco;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nVenda.setCellValueFactory(new PropertyValueFactory<Venda,Integer>("id_venda"));
        dataVenda.setCellValueFactory(new PropertyValueFactory<Venda,String>("data_venda"));
        valorVenda.setCellValueFactory(new PropertyValueFactory<Venda,Double>("total_venda"));
        valorPago.setCellValueFactory(new PropertyValueFactory<Venda,Double>("valor_pago"));
        troco.setCellValueFactory(new PropertyValueFactory<Venda,Double>("valor_troco"));
        
        atualizarTabela();
    }    

    private void atualizarTabela() {
        itens.clear();
        itens.addAll(v.buscarVendas(data));
        tabelaRelatorioVenda.setItems(itens);
    }

    @FXML
    private void aplicarDate(ActionEvent event) {
        atualizarTabela();
    }

    @FXML
    private void gerarData(ActionEvent event) {
        
    }
    
}
