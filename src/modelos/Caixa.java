package modelos;

import java.sql.Date;

public class Caixa {
    private int id_caixa;
    private double valor_venda;
    private String  forma_pagamento;
    private Date data_compra;
    //cadastro
    public Caixa(double valor_venda, String forma_pagamento, Date data_compra) {
        this.valor_venda = valor_venda;
        this.forma_pagamento = forma_pagamento;
        this.data_compra = data_compra;
    }
    //consulta
    public Caixa(int id_caixa, double valor_venda, String forma_pagamento, Date data_compra) {
        this.id_caixa = id_caixa;
        this.valor_venda = valor_venda;
        this.forma_pagamento = forma_pagamento;
        this.data_compra = data_compra;
    }

    public int getId_caixa() {
        return id_caixa;
    }

    public double getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(double valor_venda) {
        this.valor_venda = valor_venda;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }
    
    
}
