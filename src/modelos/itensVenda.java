package modelos;

public class itensVenda extends Produto{
    private int quantidade;
    private double total_iten;

    public itensVenda(int quantidade, double total_iten, int id_produto, String nome_produto, double preco_produto, String und_medida) {
        super(id_produto, nome_produto, preco_produto, und_medida);
        this.quantidade = quantidade;
        this.total_iten = total_iten;
    }   

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal_iten() {
        return total_iten;
    }

    public void setTotal_iten(double total_iten) {
        this.total_iten = total_iten;
    }

}
