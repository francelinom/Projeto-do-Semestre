package modelos;

public class Produto {
    private int id_produto;
    private String nome_produto;
    private double cod_barra_produto;
    private double preco_produto;
    private int qtd_produto;
    private String und_medida;

    public Produto(String nome_produto, double cod_barra_produto, double preco_produto, int qtd_produto, String und_medida) {
        this.nome_produto = nome_produto;
        this.cod_barra_produto = cod_barra_produto;
        this.preco_produto = preco_produto;
        this.qtd_produto = qtd_produto;
        this.und_medida = und_medida;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public int getId_produto() {
        return id_produto;
    }

    public double getCod_barra_produto() {
        return cod_barra_produto;
    }

    public void setCod_barra_produto(double cod_barra_produto) {
        this.cod_barra_produto = cod_barra_produto;
    }

    public double getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(double preco_produto) {
        this.preco_produto = preco_produto;
    }

    public int getQtd_produto() {
        return qtd_produto;
    }

    public void setQtd_produto(int qtd_produto) {
        this.qtd_produto = qtd_produto;
    }

    public String getUnd_medida() {
        return und_medida;
    }

    public void setUnd_medida(String und_medida) {
        this.und_medida = und_medida;
    }
    
    
    
}
