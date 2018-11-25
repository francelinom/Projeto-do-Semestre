package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;
import main.Principal;
import modelos.Produto;
import modelos.Venda;
import modelos.itensVenda;
import persistencia.ProdutoDAO;
import persistencia.VendasDAO;
/**
 * FXML Controller class
 *
 * @author thiago
 */
public class CaixaController implements Initializable {
    static  CaixaController controleVenda;
    private ProdutoDAO produtos = new ProdutoDAO();
    private VendasDAO vendaConsulta = new VendasDAO();
    
    private Venda venda;
    private ArrayList<Integer> codigo  = new ArrayList<>();
    private itensVenda item;
    private int numeroItem = 1;
    private int numeroVendaAnterior;
    int numeroVendaAtual = 1;
    double somaTotal;
        
    @FXML
    private JFXButton finalizarVenda;
    @FXML
    private BorderPane caixa;
    @FXML
    private JFXButton canVenda;
    @FXML
    private TextField campoLeitura;
    @FXML
    private JFXButton excluirItem;
    @FXML
    private TextField quantP;
    @FXML
    private Label numVenda;
    @FXML
    private Label totalVenda;
    @FXML
    private Label status;
    //tabela
    
    ObservableList<itensVenda> itens = FXCollections.observableArrayList();
    
    @FXML
    private TableView<itensVenda> tabelaVenda;
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
    @FXML
    private Label situacaoP;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controleVenda = this;
        // TODO
        itemNum.setCellValueFactory(new PropertyValueFactory<itensVenda,Integer>("itenN"));
        idProduto.setCellValueFactory(new PropertyValueFactory<itensVenda,Integer>("id_produto"));
        nomeProduto.setCellValueFactory(new PropertyValueFactory<itensVenda,String>("nome_produto"));
        precoProduto.setCellValueFactory(new PropertyValueFactory<itensVenda,Double>("preco_produto"));
        und.setCellValueFactory(new PropertyValueFactory<itensVenda,String>("und_medida"));
        quantProduto.setCellValueFactory(new PropertyValueFactory<itensVenda,Integer>("quantidade"));
        totalItem.setCellValueFactory(new PropertyValueFactory<itensVenda,Double>("total_item"));
        
        atualizarTabela();
        itens.clear();
        codigo.addAll(produtos.listarCodigo());
        consultaUltimaVenda();
        situacaoCaixa();
    }    
    
    @FXML
    private void finalizarVenda(ActionEvent event) throws IOException {
        reorganizarLista();
        if(itens.size()>0)      {
            Parent root = FXMLLoader.load(getClass().getResource("/visao/FinalizarVenda.fxml"));
            Scene janela = new Scene(root);

            Stage stage = new Stage();
            stage.setScene(janela);
            stage.show();
            stage.setTitle("Finalizar Venda");
        }        
    }
    
     @FXML
    private void listarProdutos(KeyEvent event) {
        
        if (event.getCode() == KeyCode.ENTER && checkLetters(campoLeitura.getText())) {
            
            int c = Integer.parseInt(campoLeitura.getText());
            if(codigo. contains(c)){
                Produto po = produtos.consultaProduto(Integer.parseInt(campoLeitura.getText()));
                item = new itensVenda(numeroItem, Integer.parseInt(quantP.getText()),calcTotalItens(Integer.parseInt(quantP.getText()), po.getPreco_produto()), po.getId_produto(), po.getNome_produto(), po.getPreco_produto(), po.getUnd_medida());
                atualizarTabela();
                limparCampos();
                somarTotalvenda(item);
                situacaoCaixa();
                situacaoP.setText("...");
                numeroItem++;
            }else {
                situacaoP.setText("Codigo não cadastrado");
                limparCampos();
            }
        }
    }
    
   @FXML
    void cancelarVenda(ActionEvent event) {
        itens.clear();
        numeroItem = 1;
        somaTotal = 0;
        totalVenda.setText("0,00");
        situacaoCaixa();
    }

    @FXML
    private void excluirItem(ActionEvent event) {
        somarTotalExcluir(tabelaVenda.getSelectionModel().getSelectedItem());
        itens.remove(tabelaVenda.getSelectionModel().getSelectedItem());
       
        
    }
    
    //metodos
      private void atualizarTabela() {
	itens.add(item);
        tabelaVenda.setItems(itens);
    }

    private double calcTotalItens(int quantP, double precoP) {
        double r = quantP * precoP;
        return r;
    }
    private void limparCampos() {
	campoLeitura.clear();
        quantP.setText("1");
    }

    private void somarTotalvenda(itensVenda item) {
        somaTotal = somaTotal + item.getTotal_item();
        totalVenda.setText(String.format("%.2f", somaTotal));
    }
    private void somarTotalExcluir(itensVenda item) {
        somaTotal = somaTotal - item.getTotal_item();
        totalVenda.setText(String.format("%.2f", somaTotal));
    }

    void consultaUltimaVenda() {
        numeroVendaAnterior = vendaConsulta.consultarUltimaVenda();
        if(numeroVendaAnterior > 0){
            numeroVendaAtual = numeroVendaAnterior+1;
            numVenda.setText(Integer.toString(numeroVendaAtual));
        }else{
            numVenda.setText(Integer.toString(numeroVendaAtual));
        }
        itens.clear();
        situacaoCaixa();
    }

    private void situacaoCaixa() {
        if(itens.size()>=1){
            status.setText("Em Venda");
        }else{
            status.setText("Livre");
        }
    }

    private void reorganizarLista() {
        for (int i = 0; i < itens.size(); i++) {
            itens.get(i).setItenN(i+1);
        }
    }
    private boolean checkLetters(String str){
        return str.matches("[0-9]+");
    }
}