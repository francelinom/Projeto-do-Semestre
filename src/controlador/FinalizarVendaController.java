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
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
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
    
    private double totalN, somaPag, totalVenda, pagTotal, dinheiro = 0, credito=0, debibo = 0, alimentacao = 0, desconto = 0;
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
        totalVenda = CaixaController.controleVenda.somaTotal;
        recalcular();
        iniciarTotal();
    }    

    @FXML
    private void cancelarPagamento(ActionEvent event) {
        limparValores();
        Stage stage = (Stage) finalizarVenda.getScene().getWindow(); //Obtendo a janela atual
        stage.close(); //Fechando o Stage
    }
    
    @FXML
    private void finalizarPagamento(ActionEvent event) {
        
    }
   
    @FXML
    private void dinheiro(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            dinheiro = converteVirgula(vDinheiro.getText());
            somaP();
        }
    }

    @FXML
    private void credito(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            credito = converteVirgula(vCredito.getText());
            somaP();
        }
    }

    @FXML
    private void debito(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            debibo = converteVirgula(vDebito.getText());
            somaP();
        }
    }

    @FXML
    private void alimentacao(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            alimentacao = converteVirgula(vAlimen.getText());
            somaP();
        }
    }

    @FXML
    private void desconto(KeyEvent event) {
        
        if (event.getCode() == KeyCode.ENTER) {
            if(converteVirgula(vDesconto.getText())>0){
                totalVenda = CaixaController.controleVenda.somaTotal;
                desconto = totalVenda * (Double.parseDouble(vDesconto.getText())/100);
                totalVenda = totalVenda - desconto;
                recalcular();
                somaP();
               
            }
        }
    }
    
    private void iniciarTotal() {
        total.setText(String.format("%.2f",totalVenda));
        troco.setText(String.format("%.2f",pagTotal));
        troco.setTextFill(Color.web("#FF0000"));
    }

    private void calculaTroco() {
        
        pagTotal = totalN + somaPag ;
        troco.setText(String.format("%.2f",pagTotal));
        if(pagTotal<0){
            troco.setTextFill(Color.web("#FF0000"));
        }else{
            troco.setTextFill(Color.web("#0000FF"));
        }
    }

    private void somaP() {
        somaPag = dinheiro + credito + debibo + alimentacao;
        calculaTroco();
    }

    private void recalcular() {
        totalN = pagTotal = totalVenda;
        totalN = totalN * -1;
        
    }
    private double converteVirgula(String entrada){
        double valor = Double.parseDouble(entrada.replace(',', '.'));
        return valor;
    }

    private void limparValores() {
        totalN = somaPag = totalVenda = pagTotal = dinheiro=credito=debibo=alimentacao=desconto=0;
    }
}
