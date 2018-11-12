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
import persistencia.CaixaDAO;
/**
 * FXML Controller class
 *
 * @author thiago
 */
public class CaixaController implements Initializable {
    static  CaixaController controleVenda;
    
    private Venda venda;
    
    CaixaDAO cxDAO = new CaixaDAO();
   
    private ArrayList<Integer> codigo  = new ArrayList<>();
   
    private itensVenda item;
    private int numeroItem = 1;
    int numeroVendaAtual;
    private int numeroVendaAnterior;
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
        codigo.addAll(cxDAO.listarProdutos());
        consultaUltimaVenda();
        
        
        for(Integer codigo : codigo){
            System.out.println(codigo);
        }
    }    
    
    @FXML
    private void finalizarVenda(ActionEvent event) throws IOException {
              
        Parent root = FXMLLoader.load(getClass().getResource("/visao/FinalizarVenda.fxml"));
        Scene janela = new Scene(root);
        
        Stage stage = new Stage();
        stage.setScene(janela);
        stage.show();
        stage.setTitle("Finalizar Venda");
        
    }
     @FXML
    private void listarProdutos(KeyEvent event) {
        
        if (event.getCode() == KeyCode.ENTER) {
            
            int c = Integer.parseInt(campoLeitura.getText());
            if(codigo. contains(c)){
                Produto po = cxDAO.consultaProduto(Integer.parseInt(campoLeitura.getText()));
                item = new itensVenda(numeroItem, Integer.parseInt(quantP.getText()),calcTotalItens(Integer.parseInt(quantP.getText()), po.getPreco_produto()), po.getId_produto(), po.getNome_produto(), po.getPreco_produto(), po.getUnd_medida());
                atualizarTabela();
                limparCampos();
                somarTotalvenda(item);
                numeroItem++;
            }else {
                System.out.println("codigo não cadastrado");
                limparCampos();
            }
        }
    }
    
    @FXML
    void canelarVenda(ActionEvent event) {
        itens.clear();
        numeroItem = 0;
        somaTotal = 0;
        totalVenda.setText("0");
        
    }

    @FXML
    private void excluirItem(ActionEvent event) {
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

    void consultaUltimaVenda() {
        numeroVendaAnterior = cxDAO.consultarUltimaVenda();
        if(numeroVendaAnterior > 0){
            numeroVendaAtual = numeroVendaAnterior+1;
            numVenda.setText(Integer.toString(numeroVendaAtual));
        }else{
            numVenda.setText(Integer.toString(numeroVendaAtual));
        }
    }
}