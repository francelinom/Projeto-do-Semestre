/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import modelos.Produto;
import modelos.Venda;
import modelos.itensVenda;

/**
 *
 * @author Thiago Dantas
 */
public class CaixaDAO {
    ConexaoBanco con = new ConexaoBanco();
    Produto p, listaDeCodigo;
    
    private final String CONSULTARPRODUTO = "SELECT ID, NOME_PRODUTO, PRECO, UND_MEDIDA FROM PRODUTOS WHERE COD_BARRAS = (?)";
    private final String CONSULTARCODIGO = "SELECT COD_BARRAS FROM PRODUTOS";
    private final String CONSULTARULTIMAVENDA = "SELECT MAX(IDVENDAS)FROM VENDAS;";
    
    public Produto consultaProduto (int cod) {
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(CONSULTARPRODUTO);
            
            prepararInstrucao.setInt(1, cod);
            
            ResultSet rs = prepararInstrucao.executeQuery();
            
            if (rs.next()) {                
                p = new Produto(rs.getInt("ID"),rs.getString("NOME_PRODUTO"), rs.getDouble("PRECO"), rs.getString("UND_MEDIDA"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroProtudoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public ArrayList<Integer> listarProdutos() {
        ArrayList<Integer> lista = new ArrayList<>();
        int cod;
         try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(CONSULTARCODIGO);
                    
            ResultSet rs = prepararInstrucao.executeQuery();
            
            while (rs.next()) {                
                cod  = (rs.getInt("COD_BARRAS"));
                lista.add(cod);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroProtudoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public int consultarUltimaVenda() {
        int cod = 0;
         try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(CONSULTARULTIMAVENDA);
                    
            ResultSet rs = prepararInstrucao.executeQuery();
            
            while (rs.next()) {                
                cod  = (rs.getInt("MAX(IDVENDAS)"));          
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroProtudoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cod;
        
    }
}
