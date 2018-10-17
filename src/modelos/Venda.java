package modelos;

public class Venda {
    private int id_venda;
    private int itens;//mudar para lista
    private double totVenda;
    private int totItens;
    private String dataVenda;
    
    
    //CONSTRUTOR PARA INSERIR
    public Venda(int itens, double totVenda, int totItens, String nome_cliente, String dataVenda, String formaPgto) {
        this.itens = itens;
        this.totVenda = totVenda;
        this.totItens = totItens;  
        this.dataVenda = dataVenda;     
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
    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }
}
