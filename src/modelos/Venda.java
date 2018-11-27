package modelos;

import java.util.ArrayList;

public class Venda {
    private int id_venda;
    private double total_venda;
    private double valor_pago;
    private double valor_troco;
    private String data_venda;
    
    //consulta
    public Venda(int id_venda, double total_venda, double valor_pago, double valor_troco, String data_venda) {
        this.id_venda = id_venda;
        this.total_venda = total_venda;
        this.valor_pago = valor_pago;
        this.valor_troco = valor_troco;
        this.data_venda = data_venda;
    }
    //cadastro
    public Venda(double total_venda, double valor_pago, double valor_troco, String data_venda) {
        this.total_venda = total_venda;
        this.valor_pago = valor_pago;
        this.valor_troco = valor_troco;
        this.data_venda = data_venda;
    }
    
//    //consulta
//    public Venda(int id_venda, double total_venda, ArrayList<itensVenda> lista_venda, String data_venda) {
//        this.id_venda = id_venda;
//        this.total_venda = total_venda;
//        this.lista_venda = lista_venda;
//        this.data_venda = data_venda;
//    }
//    //cadastro no banco
//    public Venda(double total_venda, ArrayList<itensVenda> lista_venda, String data_venda) {
//        this.total_venda = total_venda;
//        this.lista_venda = lista_venda;
//        this.data_venda = data_venda;
//    }

    public Venda(double somaTotal) {
        somaTotal = this.total_venda;
    }

    public int getId_venda() {
        return id_venda;
    }
  
    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }
    

    public double getTotal_venda() {
        return total_venda;
    }

    public void setTotal_venda(double total_venda) {
        this.total_venda = total_venda;
    }
    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }
    
//    public itensVenda getLista_venda() {
//        return lista_venda;
//    }
//
//    public void setLista_venda(itensVenda lista_venda) {
//        this.lista_venda = lista_venda;
//    }

    public double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(double valor_pago) {
        this.valor_pago = valor_pago;
    }

    public double getValor_troco() {
        return valor_troco;
    }

    public void setValor_troco(double valor_troco) {
        this.valor_troco = valor_troco;
    }
    
}
