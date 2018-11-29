package modelos;

public class itensVenda extends Produto{ 
    private int itenN;
    private int quantidade;
    private double total_item;
    private int iditem;

    public itensVenda(int itenN, int quantidade, double total_iten, int id_produto, String nome_produto, double preco_produto, String und_medida) {
        super(id_produto, nome_produto, preco_produto, und_medida);
        this.itenN = itenN;
        this.quantidade = quantidade;
        this.total_item = total_iten;
    }   

    public itensVenda(int itenN, int quantidade, double total_item, int iditem, int id_produto, String nome_produto, double preco_produto, String und_medida) {
        super(id_produto, nome_produto, preco_produto, und_medida);
        this.itenN = itenN;
        this.quantidade = quantidade;
        this.total_item = total_item;
        this.iditem = iditem;
    }

    public itensVenda(Venda selectedItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getItenN() {
        return itenN;
    }

    public void setItenN(int itenN) {
        this.itenN = itenN;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal_item() {
        return total_item;
    }

    public void setTotal_item(double total_item) {
        this.total_item = total_item;
    }

    public int getIditem() {
        return iditem;
    }

    public void setIditem(int iditem) {
        this.iditem = iditem;
    }
    
}
