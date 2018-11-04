/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Produto;

/**
 *
 * @author Thiago
 */
public class ConsultarPrecoDAO {
    private ConexaoBanco con = new ConexaoBanco();
    private Produto p ;
    private final String CONSULTARPRECO = "SELECT NOME_PRODUTO, PRECO FROM PRODUTOS WHERE COD_BARRAS = (?)";
    public Produto consultaPreco (int cod) {
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(CONSULTARPRECO);
            
            prepararInstrucao.setInt(1, cod);
            
            ResultSet rs = prepararInstrucao.executeQuery();
            
            if (rs.next()) {                
                p = new Produto(rs.getString("NOME_PRODUTO"), rs.getDouble("PRECO"));
                //item = new itensVenda(rs.getInt("QUANTPRODUTO"),rs.getDouble("TOTALDOITEN"), rs.getInt("IDDOPRODUTO"),rs.getString("NOME_PRODUTO"), rs.getDouble("PRECOPRODUTO"), rs.getString("UND_MEDIDA"));
                //itensVenda n = new itensVenda(cod, cod, cod, CONSULTARPRODUTO, cod, CONSULTARPRODUTO);
               
                //Produto p = new Produto(0, LISTPRODUTOS, 0, 0, 0, LISTPRODUTOS);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroProtudoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
}
