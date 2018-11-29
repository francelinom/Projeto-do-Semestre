/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelos.itensVenda;
import persistencia.VendasDAO;
import controlador.RelatorioVendaController;
import modelos.Venda;

/**
 * FXML Controller class
 *
 * @author Thiago
 */
public class ItensRelatorioController implements Initializable {
    
    private VendasDAO v = new VendasDAO();
    private ObservableList<itensVenda> itens = FXCollections.observableArrayList();
    private int idv ;
    private RelatorioVendaController i = new RelatorioVendaController();
    
    
    @FXML
    private TableView<itensVenda> tabelaItens;
    @FXML
    private TableColumn<itensVenda, Integer> itemNum;
    @FXML
    private TableColumn<itensVenda, Integer> idProduto;
    @FXML
    private TableColumn<itensVenda, String> nomeProduto;
    @FXML
    private TableColumn<itensVenda, Integer> quantProduto;
    @FXML
    private TableColumn<itensVenda, Double> precoProduto;
    @FXML
    private TableColumn<itensVenda, String> und;
    @FXML
    private TableColumn<itensVenda, Double> totalItem;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        itemNum.setCellValueFactory(new PropertyValueFactory<itensVenda,Integer>("itenN"));
        idProduto.setCellValueFactory(new PropertyValueFactory<itensVenda,Integer>("id_produto"));
        nomeProduto.setCellValueFactory(new PropertyValueFactory<itensVenda,String>("nome_produto"));
        precoProduto.setCellValueFactory(new PropertyValueFactory<itensVenda,Double>("preco_produto"));
        und.setCellValueFactory(new PropertyValueFactory<itensVenda,String>("und_medida"));
        quantProduto.setCellValueFactory(new PropertyValueFactory<itensVenda,Integer>("quantidade"));
        totalItem.setCellValueFactory(new PropertyValueFactory<itensVenda,Double>("total_item"));
        
        idv = i.id;
        System.out.println(idv);
        atualizarTabela();
    }    

    private void atualizarTabela() {
        itens.clear();
        itens.addAll(v.listarItensVenda(idv));
        tabelaItens.setItems(itens);
    }
    
}
