package modelos;

public class Funcionario {
    private String nome_funcionario;
    private int id_funcionario;
    private String data_nasc_funcionario;
    private String end_funcionario;
    private int CPF_funcionario;
    private String cargo;

    public Funcionario(String nome, String idade, String endereco, int CPF, String cargo) {
        this.nome_funcionario = nome;
        this.data_nasc_funcionario = idade;
        this.end_funcionario = endereco;
        this.CPF_funcionario = CPF;
        this.cargo = cargo;
    }

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public String getData_nasc_funcionario() {
        return data_nasc_funcionario;
    }

    public void setData_nasc_funcionario(String data_nasc_funcionario) {
        this.data_nasc_funcionario = data_nasc_funcionario;
    }

    public String getEnd_funcionario() {
        return end_funcionario;
    }

    public void setEnd_funcionario(String end_funcionario) {
        this.end_funcionario = end_funcionario;
    }

    public int getCPF_funcionario() {
        return CPF_funcionario;
    }

    public void setCPF_funcionario(int CPF_funcionario) {
        this.CPF_funcionario = CPF_funcionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
    
}
