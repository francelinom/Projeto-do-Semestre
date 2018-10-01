package modelos;

public class Cliente {
    private String nome_cliente;
    private int CPF_cliente;
    private int id_cliente;
    private int tel_cliente;
    private String data_nasc_cliente;
    private String end_cliente;

    public Cliente(String nome_cliente, int CPF_cliente, int tel_cliente, String data_nasc_cliente, String end_cliente) {
        this.nome_cliente = nome_cliente;
        this.CPF_cliente = CPF_cliente;
        this.tel_cliente = tel_cliente;
        this.data_nasc_cliente = data_nasc_cliente;
        this.end_cliente = end_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public int getCPF_cliente() {
        return CPF_cliente;
    }

    public void setCPF_cliente(int CPF_cliente) {
        this.CPF_cliente = CPF_cliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public int getTel_cliente() {
        return tel_cliente;
    }

    public void setTel_cliente(int tel_cliente) {
        this.tel_cliente = tel_cliente;
    }

    public String getData_nasc_cliente() {
        return data_nasc_cliente;
    }

    public void setData_nasc_cliente(String data_nasc_cliente) {
        this.data_nasc_cliente = data_nasc_cliente;
    }

    public String getEnd_cliente() {
        return end_cliente;
    }

    public void setEnd_cliente(String end_cliente) {
        this.end_cliente = end_cliente;
    }
    
    
    
}
