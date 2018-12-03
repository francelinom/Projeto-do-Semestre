/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import modelos.Produto;
import persistencia.ProdutoDAO;

public class ProdutoController implements Initializable {
    //OBJETO PRODUTO
    private Produto mproduto = new Produto();
    private ObservableList<Produto> itens = FXCollections.observableArrayList();
    private ProdutoDAO produto = new ProdutoDAO();
    private ArrayList<Integer> codigo  = new ArrayList<>();
    
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
    @FXML
    private JFXTextField idProduto;
    @FXML
    private JFXButton cadprodutos;
    @FXML
    private JFXButton atualziarProduto;
    @FXML
    private JFXButton limpa;
    @FXML
    private JFXButton excluirProd;
    @FXML
    private JFXTextField buscarProduto;
    
    //TABELA
    @FXML
    private TableView<Produto> tabelasProdutos;
    @FXML
    private TableColumn<Produto, Integer> idProdCol;
    @FXML
    private TableColumn<Produto, String> nomeProdCol;
    @FXML
    private TableColumn<Produto, Double> codBarrasCol;
    @FXML
    private TableColumn<Produto, Double> precoProdCol;
    @FXML
    private TableColumn<Produto, Integer> quantProdCol;
    @FXML
    private TableColumn<Produto, String> unidProdCol;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idProdCol.setCellValueFactory(new PropertyValueFactory<Produto,Integer>("id_produto"));
        nomeProdCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome_produto"));
        codBarrasCol.setCellValueFactory(new PropertyValueFactory<Produto, Double>("cod_barra_produto"));
        precoProdCol.setCellValueFactory(new PropertyValueFactory<Produto, Double>("preco_produto")); 
        quantProdCol.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("qtd_produto"));
        unidProdCol.setCellValueFactory(new PropertyValueFactory<Produto, String>("und_medida"));
        
        codigo.addAll(produto.listarCodigo());
        atualizarTabela();
        
        tabelasProdutos.setOnMouseClicked(event -> {
            mproduto = tabelasProdutos.getSelectionModel().getSelectedItem();
            idProduto.setText(Integer.toString(mproduto.getId_produto()));
            nomeProduto.setText(mproduto.getNome_produto());
            codBarras.setText(Integer.toString(mproduto.getCod_barra_produto()));
            precoProduto.setText(Double.toString(mproduto.getPreco_produto()));
            quantProduto.setText(Integer.toString(mproduto.getQtd_produto()));
            unidadeProduto.setText(mproduto.getUnd_medida());
        });
    }    

    @FXML
    private void cadastrarProduto() {
        
        if(codigo.contains(Integer.parseInt(codBarras.getText()))){
             Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Cadastro");
                alert.setHeaderText(null);
                alert.setContentText("Código de barras já cadastrado");
                alert.showAndWait();
        }else{
           if(checkLetters(codBarras.getText(), precoProduto.getText(), quantProduto.getText())){
                Produto a = new Produto(nomeProduto.getText().toUpperCase(),Integer.parseInt(codBarras.getText()),converterVirgula(precoProduto.getText()),Integer.parseInt(quantProduto.getText()), unidadeProduto.getText().toUpperCase());
                produto.cadastrarProduto(a);
                atualizarTabela();
                limparCampos();

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Cadastro");
                alert.setHeaderText(null);
                alert.setContentText("Produto Cadastrado");
                alert.showAndWait();

            }else{
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Atenção");
                alert.setHeaderText("Campos com Valores invalidos");
                alert.setContentText("Os campos Código de Barras, Preço e Quantidade\n"
                        + "são campos numericos");

                alert.showAndWait();
            } 
        }       
    }

    @FXML
    private void atualizarProduto(ActionEvent event) {
        Produto a = new Produto(Integer.parseInt(idProduto.getText()), nomeProduto.getText(),Integer.parseInt(codBarras.getText()),converterVirgula(precoProduto.getText()),Integer.parseInt(quantProduto.getText()), unidadeProduto.getText());
        produto.atulizarProduto(a);
       //p.atulizarProduto(tabelasProdutos.getSelectionModel().getSelectedItem());
        atualizarTabela();
        limparCampos();
        
    }

    @FXML
    private void ExcluirCadastro(ActionEvent event) {
        // Produto a = new Produto(Integer.parseInt(idProduto.getText()));
        produto.deletaProduto(tabelasProdutos.getSelectionModel().getSelectedItem());
        atualizarTabela();
        limparCampos();
    }
    
    @FXML
    private void limparCampos(ActionEvent event) {
        limparCampos();
    }

    private void atualizarTabela() {
        itens.clear();
	itens.addAll(produto.listarProdutos());
        tabelasProdutos.setItems(itens);
    }
    private void limparCampos() {
        idProduto.clear();
        nomeProduto.clear();
        codBarras.clear();
        precoProduto.clear();
        quantProduto.clear();
        unidadeProduto.clear();
    }

    @FXML
    private void buscarBotao(KeyEvent event) {
        itens.clear();
	itens.addAll(produto.listarProdutosBusca(buscarProduto.getText().toUpperCase()));
        tabelasProdutos.setItems(itens);
    }  

    private boolean checkLetters(String text, String text0, String text1) {
        if(text.matches("[0-9,',']+") && text0.matches("[0-9,',']+") && text1.matches("[0-9,',']+") ){
            return true;
        }
        return false;
    }
    private double converterVirgula(String entrada){
        return Double.parseDouble(entrada.replace(',', '.'));
    }
}
