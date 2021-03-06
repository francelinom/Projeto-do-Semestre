/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBanco {
    private static final String USUARIO = "admin";	
	private static final String SENHA = "admin";
	private static final String CAMINHO = "jdbc:h2:~/PDVfacil/banco"; //INIT = runscript from '~/ProjetoDoSemestre/persistencia/ModeloBancoPDV.sql'";
	private static final String DRIVER = "org.h2.Driver";
        private Connection conexao;
        private static final String CRIAR_TABELAS =
"-- -----------------------------------------------------\n" +
"-- Table produtos\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS produtos (\n" +
"  	id SERIAL NOT NULL,\n" +
"  	nome_produto VARCHAR(45) NULL,\n" +
"  	cod_barras CHAR(14) NULL,\n" +
"  	preco DECIMAL NULL,\n" +
"       quantidade INT NULL,\n" +
"  und_medida VARCHAR(10) NULL,\n" +
"  PRIMARY KEY (id));\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table vendas\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS vendas (\n" +
"  idvendas SERIAL NOT NULL ,\n" +
"  total_venda DECIMAL NULL,\n"+
"  valor_Pago DECIMAL NULL,\n"+
"  valor_troco DECIMAL NULL,\n"+
"  data_venda VARCHAR(10) NULL,\n" +
"  PRIMARY KEY (idvendas));\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table itens\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS itens (\n" +
"  iditens SERIAL NOT NULL ,\n"+
"  num_item INT NULL,\n" +
"  vendas_idvendas INT NOT NULL,\n" +
"  iddoproduto INT NULL,\n" +
"  nomeproduto VARCHAR(45) NULL,\n" +
"  undproduto VARCHAR(45) NULL,\n" +
"  precoproduto VARCHAR(45) NULL,\n" +
"  quantproduto INT NULL,\n" +
"  totaldoitem VARCHAR(45) NULL,\n" +
"  PRIMARY KEY (iditens),\n" +
"  CONSTRAINT fk_itens_vendas\n" +
"    FOREIGN KEY (vendas_idvendas)\n" +
"    REFERENCES vendas (idvendas)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);";

    //METODO QUE EFETUA A CONEXAO COM O BANCO DE DADOS
    public void conecta() {
        try {
            Class.forName(DRIVER); //Carrega o driver (inicializa um objeto da classe org.postgresql.Driver) 
            conexao = DriverManager.getConnection(CAMINHO, USUARIO, SENHA); //Cria a conexao
            System.out.println("Banco conectado");
            Statement stmt = conexao.createStatement();
            stmt.execute(CRIAR_TABELAS);
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    //METODO QUE DESCONECTA O BANCO DE DADOS
    public void desconecta() {
        try {
            conexao.close();//fecha a conexao
        } catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }
    }

    public Connection getConexao() {
        return conexao;
    }
}
