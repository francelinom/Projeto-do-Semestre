/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXTextField;
import static controlador.CaixaController.controleVenda;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
    private FinalizarVendaDAO FinDAO = new FinalizarVendaDAO();
    
    private String datadehoje;
    private Venda v;
    private double totalN, somaPag, totalVenda, pagTotal, dinheiro = 0, credito=0, debibo = 0, alimentacao = 0, desconto = 0;
    private ObservableList<itensVenda> nitens;
    private int idVendaAtual;
    
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
        idVendaAtual = CaixaController.controleVenda.numeroVendaAtual;
        totalVenda = CaixaController.controleVenda.somaTotal;
        recalcular();
        iniciarTotal();
        datadehoje();
    }    
    //campos de leitura
    @FXML
    private void dinheiro(KeyEvent event) {
        dinheiro = converterVirgula(vDinheiro.getText());
        somarFormasPg();
    }

    @FXML
    private void credito(KeyEvent event) {
        credito = converterVirgula(vCredito.getText());
        somarFormasPg();
    }

    @FXML
    private void debito(KeyEvent event){ 
        debibo = converterVirgula(vDebito.getText());
        somarFormasPg();
    }

    @FXML
    private void alimentacao(KeyEvent event) {
        alimentacao = converterVirgula(vAlimen.getText());
        somarFormasPg();
    }

    @FXML
    private void desconto(KeyEvent event) {
        if(converterVirgula(vDesconto.getText())>=0){
            totalVenda = CaixaController.controleVenda.somaTotal;
            desconto = totalVenda * (Double.parseDouble(vDesconto.getText())/100);
            totalVenda = totalVenda - desconto;
            recalcular();
            somarFormasPg();
        }
    }
    //Botões
    @FXML
    private void cancelarPagamento(ActionEvent event) {
        limparValores();
        fecharJanela();
        
    }
    
    @FXML
    private void finalizarPagamento(ActionEvent event) {
        v = new Venda(totalVenda, somaPag, pagTotal, datadehoje);
        FinDAO.criarVenda(v);
        for(int i = 0;  i<nitens.size(); i++){
            FinDAO.alterarQuant(nitens.get(i));
            FinDAO.gravarVenda((itensVenda) nitens.get(i), idVendaAtual);
        }
        CaixaController.controleVenda.cancelarVenda(event);
        CaixaController.controleVenda.consultaUltimaVenda();
        limparValores();
        fecharJanela();
    }
    
    //metodos da classe
    
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

    private void somarFormasPg() {
        somaPag = dinheiro + credito + debibo + alimentacao;
        calculaTroco();
    }

    private void recalcular() {
        totalN = pagTotal = totalVenda;
        totalN = totalN * -1;
    }
    
    private double converterVirgula(String entrada){
        return Double.parseDouble(entrada.replace(',', '.'));
    }

    private void limparValores() {
        totalN = somaPag = totalVenda = pagTotal = dinheiro=credito=debibo=alimentacao=desconto=0;
    }

    private void datadehoje() {
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");  
        datadehoje = out.format(new Date());
    }

    private void fecharJanela() {
        Stage stage = (Stage) finalizarVenda.getScene().getWindow();
        stage.close();
    }
}
