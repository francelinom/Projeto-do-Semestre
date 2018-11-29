/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelos.Venda;
import modelos.itensVenda;
import persistencia.VendasDAO;

/**
 * FXML Controller class
 *
 * @author Marcílio
 */
public class RelatorioVendaController implements Initializable {
    static  RelatorioVendaController controleRelatorio;
    ArrayList<itensVenda> itensVenda = new ArrayList();
    private VendasDAO v = new VendasDAO();
    private Venda iVenda;
    private String data;
    private double soma;
    
    @FXML
    private DatePicker campoCalendario;
    @FXML
    private TextField campoBusca;
    @FXML
    private JFXButton buscarCliente;
    @FXML
    private Label totalDia;
     
    private ObservableList<Venda> itens = FXCollections.observableArrayList();
    
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
        somarTotal();
    }

    @FXML
    private void gerarData(ActionEvent event) {
        Date d = Date.valueOf(campoCalendario.getValue());
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");  
        data = out.format(d);
        System.out.println(data);
    }

    private void somarTotal() {
        soma = 0;
        for (int i = 0; i < itens.size(); i++) {
            soma  = soma + itens.get(i).getTotal_venda();
            System.out.println(soma);
        }
        totalDia.setText(String.format("%.2f", soma));
    }

    @FXML
    private void visualizarItens(ActionEvent event) {
       iVenda = (tabelaRelatorioVenda.getSelectionModel().getSelectedItem());
       itensVenda = v.listarItensVenda(iVenda.getId_venda());
       
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/visao/ItensRelatorio.fxml"));
            Scene janela = new Scene(root);

            Stage stage = new Stage();
            stage.setScene(janela);
            stage.show();
            stage.setTitle("Itens da Venda");
        } catch (IOException ex) {
            Logger.getLogger(RelatorioVendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
}
