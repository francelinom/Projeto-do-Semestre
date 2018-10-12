package modelos;

public class Venda {
    private int id_venda;
    private int itens;
    private double totVenda;
    private int totItens;
    //private String nome_cliente;
    private String dataVenda;
    //private String formaPgto;
    
    
    //CONSTRUTOR PARA INSERIR
    public Venda(int itens, double totVenda, int totItens, String nome_cliente, String dataVenda, String formaPgto) {
        this.itens = itens;
        this.totVenda = totVenda;
        this.totItens = totItens;
  //      this.nome_cliente = nome_cliente;
        this.dataVenda = dataVenda;
       // this.formaPgto = formaPgto;
    }

    //CONSTRUTOR PARA CONSULTAR
    public Venda(int id_venda, int itens, double totVenda, int totItens, String dataVenda) {
        this.id_venda = id_venda;
        this.itens = itens;
        this.totVenda = totVenda;
        this.totItens = totItens;
        this.dataVenda = dataVenda;
    }
    

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public int getItens() {
        return itens;
    }

    public void setItens(int itens) {
        this.itens = itens;
    }

    public double getTotVenda() {
        return totVenda;
    }

    public void setTotVenda(double totVenda) {
        this.totVenda = totVenda;
    }

    public int getTotItens() {
        return totItens;
    }

    public void setTotItens(int totItens) {
        this.totItens = totItens;
    }

//    public String getNome_cliente() {
//        return nome_cliente;
//    }
//
//    public void setNome_cliente(String nome_cliente) {
//        this.nome_cliente = nome_cliente;
//    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

//    public String getFormaPgto() {
//        return formaPgto;
//    }
//
//    public void setFormaPgto(String formaPgto) {
//        this.formaPgto = formaPgto;
//    }
}
