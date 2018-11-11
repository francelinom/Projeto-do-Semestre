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
    private final String CRIARVENDA = "INSERT INTO VENDAS(TOTAL_VENDA, DATA_VENDA) VALUES (?,?)";
    private final String GRAVARVENDA = "INSERT INTO VENDAS(NUN_ITEM_VENDA, VENDAS_IDVENDAS, IDODOPRODUTO, NOMEPRODUTO, UNDPRODUTO, PRECOPRODUTO, QUANTPRODUTO, TOTADOITEM) VALUES (?,?,?,?,?,?,?,?)";
    private final String CONSULTARULTIMAVENDA = "SELECT MAX(IDVENDAS)FROM VENDAS;";
                                       // INSERT INTO CAIXA (TOTAL_VEND) VALUES(?);) ";

    public Produto consultaProduto (int cod) {
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(CONSULTARPRODUTO);
            
            prepararInstrucao.setInt(1, cod);
            
            ResultSet rs = prepararInstrucao.executeQuery();
            
            if (rs.next()) {                
                p = new Produto(rs.getInt("ID"),rs.getString("NOME_PRODUTO"), rs.getDouble("PRECO"), rs.getString("UND_MEDIDA"));
                //item = new itensVenda(rs.getInt("QUANTPRODUTO"),rs.getDouble("TOTALDOITEN"), rs.getInt("IDDOPRODUTO"),rs.getString("NOME_PRODUTO"), rs.getDouble("PRECOPRODUTO"), rs.getString("UND_MEDIDA"));
                //itensVenda n = new itensVenda(cod, cod, cod, CONSULTARPRODUTO, cod, CONSULTARPRODUTO);
               
                //Produto p = new Produto(0, LISTPRODUTOS, 0, 0, 0, LISTPRODUTOS);
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

    public void criarVenda(double totalVenda, String datadehoje) {
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(CRIARVENDA);
            
            //prepararInstrucao.setInt(1, idVendaAtual);
            prepararInstrucao.setDouble(1, totalVenda);
            prepararInstrucao.setString(2, datadehoje);
            
            prepararInstrucao.execute();
            
            con.desconecta();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroProtudoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public int consultarUltimaVenda() {
        System.out.println("entrou na primeira parte");
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
    public void gravarVenda(ArrayList<itensVenda> itensDaVenda, int idVendaAtual, int tamanho) {
        int n = 0;
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            
            
            while (n<tamanho) {        
                prepararInstrucao = con.getConexao().prepareStatement(GRAVARVENDA);
                prepararInstrucao.setInt(1, itensDaVenda.get(n).getItenN());
                prepararInstrucao.setInt(2, idVendaAtual);
                prepararInstrucao.setInt(3, itensDaVenda.get(n).getId_produto());
                prepararInstrucao.setString(4, itensDaVenda.get(n).getNome_produto());
                prepararInstrucao.setString(5, itensDaVenda.get(n).getUnd_medida());
                prepararInstrucao.setDouble(6, itensDaVenda.get(n).getPreco_produto());
                prepararInstrucao.setInt(7, itensDaVenda.get(n).getQtd_produto());
                prepararInstrucao.setDouble(8, itensDaVenda.get(n).getTotal_item() );

                prepararInstrucao.execute();
                System.out.println(itensDaVenda.toString());
                n++;
            }
            
            
           
            
            con.desconecta();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroProtudoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
