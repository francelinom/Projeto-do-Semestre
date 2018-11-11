package modelos;

import java.util.ArrayList;

public class Venda {
    private int id_venda;
    private double total_venda;
    private ArrayList<itensVenda> lista_venda;
    private String data_venda;
    
    //consulta
    public Venda(int id_venda, double total_venda, ArrayList<itensVenda> lista_venda, String data_venda) {
        this.id_venda = id_venda;
        this.total_venda = total_venda;
        this.lista_venda = lista_venda;
        this.data_venda = data_venda;
    }
    //cadastro no banco
    public Venda(double total_venda, ArrayList<itensVenda> lista_venda, String data_venda) {
        this.total_venda = total_venda;
        this.lista_venda = lista_venda;
        this.data_venda = data_venda;
    }

    public Venda(double somaTotal) {
        somaTotal = this.total_venda;
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
    
}
