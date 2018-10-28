package modelos;

public class itensVenda extends Produto{
    private int idItem;
    private int quantidade;
    private double total_item;

    public itensVenda(int idItem, int quantidade, double total_iten, int id_produto, String nome_produto, double preco_produto, String und_medida) {
        super(id_produto, nome_produto, preco_produto, und_medida);
        this.idItem = idItem;
        this.quantidade = quantidade;
        this.total_item = total_iten;
    }   

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
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

}
