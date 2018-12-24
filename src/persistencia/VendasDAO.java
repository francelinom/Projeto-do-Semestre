/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class VendasDAO {
    private ConexaoBanco con =  new ConexaoBanco();
    
    private final String CRIARVENDA = "INSERT INTO VENDAS(TOTAL_VENDA,VALOR_PAGO, VALOR_TROCO, DATA_VENDA) VALUES (?,?,?,?)";
    private final String GRAVARVENDA = "INSERT INTO ITENS(NUM_ITEM, VENDAS_IDVENDAS, IDDOPRODUTO, NOMEPRODUTO, UNDPRODUTO, PRECOPRODUTO, QUANTPRODUTO, TOTALDOITEM) VALUES (?,?,?,?,?,?,?,?);";
    private final String CONSULTARULTIMAVENDA = "SELECT MAX(IDVENDAS)FROM VENDAS;";
    private final String BUSCARVENDAS = "SELECT * FROM VENDAS WHERE DATA_VENDA = ? ";
    private final String LISTARVENDAS = "SELECT * FROM VENDAS";
    private final String BUSCARITENS = "SELECT * FROM ITENS WHERE VENDAS_IDVENDAS = ?";
    
        
    public void criarVenda(Venda v) {
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(CRIARVENDA);
            
            prepararInstrucao.setDouble(1, v.getTotal_venda());
            prepararInstrucao.setDouble(2, v.getValor_pago());
            prepararInstrucao.setDouble(3, v.getValor_troco());
            prepararInstrucao.setString(4, v.getData_venda());
            prepararInstrucao.execute();
            
            con.desconecta();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void gravarVenda(itensVenda itensDaVenda, int idVendaAtual) {
        //System.out.println(itensDaVenda.getItenN());
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(GRAVARVENDA);

            prepararInstrucao.setInt(1, itensDaVenda.getItenN());
            prepararInstrucao.setInt(2, idVendaAtual);
            prepararInstrucao.setInt(3, itensDaVenda.getId_produto());
            prepararInstrucao.setString(4, itensDaVenda.getNome_produto());
            prepararInstrucao.setString(5, itensDaVenda.getUnd_medida());
            prepararInstrucao.setDouble(6, itensDaVenda.getPreco_produto());
            prepararInstrucao.setInt(7, itensDaVenda.getQuantidade());
            prepararInstrucao.setDouble(8, itensDaVenda.getTotal_item() );

            prepararInstrucao.execute();
  
            con.desconecta();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cod;
    }

    public ArrayList<Venda> buscarVendas(String data) {
         ArrayList<Venda> lista = new ArrayList<>();
        
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(BUSCARVENDAS);
            System.out.println(data);
            
            prepararInstrucao.setString(1, data);
            ResultSet rs = prepararInstrucao.executeQuery();
            
            while (rs.next()) {                
                Venda v = new Venda(rs.getInt("idvendas"),rs.getDouble("total_venda"), rs.getDouble("valor_Pago"),rs.getDouble("valor_troco"), rs.getString("data_venda"));
                lista.add(v);
                //Venda v = new Venda(0, 0, 0, 0, CRIARVENDA);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  lista;
    }

    public ArrayList<itensVenda> listarItensVenda(int id_venda) {
        ArrayList<itensVenda> lista = new ArrayList<>();
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(BUSCARITENS);
            System.out.println("buscando itens");
            
            prepararInstrucao.setInt(1, id_venda);
            ResultSet rs = prepararInstrucao.executeQuery();
            
            while (rs.next()) {                
                itensVenda v = new itensVenda(rs.getInt("num_item"),rs.getInt("quantproduto"), rs.getDouble("totaldoitem"),rs.getInt("iditens"), rs.getInt("iddoproduto"), rs.getString("nomeproduto"),rs.getDouble("precoproduto"), rs.getString("undproduto"));
                lista.add(v);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  lista;
        
    }
    public ArrayList<Venda> listarTodasVendas() {
         ArrayList<Venda> lista = new ArrayList<>();
        
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(LISTARVENDAS);
            
            ResultSet rs = prepararInstrucao.executeQuery();
            
            while (rs.next()) {                
                Venda v = new Venda(rs.getInt("idvendas"),rs.getDouble("total_venda"), rs.getDouble("valor_Pago"),rs.getDouble("valor_troco"), rs.getString("data_venda"));
                lista.add(v);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  lista;
    }
}