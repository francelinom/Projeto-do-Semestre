package modelos;

import java.util.ArrayList;

public class Venda {
    private int id_venda;
    private ArrayList<itensVenda> lista_venda;//mudar para lista
    private double total_venda;
    private int total_iten;//rever já que tá lista
    private String data_venda;
    
    
    //CONSTRUTOR PARA INSERIR
    public Venda(int itens, double totVenda, int totItens, String nome_cliente, String dataVenda, String formaPgto) {
        this.total_venda = totVenda;
        this.total_iten = totItens;  
        this.data_venda = dataVenda;     
    }

    //CONSTRUTOR PARA CONSULTAR
    public Venda(int id_venda, itensVenda lista_venda, double total_venda, int total_iten, String data_venda) {
        this.id_venda = id_venda;
       // this.lista_venda = lista_venda;
        this.total_venda = total_venda;
        this.total_iten = total_iten;
        this.data_venda = data_venda;
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

    public int getTotal_iten() {
        return total_iten;
    }

    public void setTotal_iten(int total_iten) {
        this.total_iten = total_iten;
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
    
}
