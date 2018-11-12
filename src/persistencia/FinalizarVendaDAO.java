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
import modelos.itensVenda;

/**
 *
 * @author Thiago Dantas
 */
public class FinalizarVendaDAO {
    private ConexaoBanco con =  new ConexaoBanco();
    
    private final String CRIARVENDA = "INSERT INTO VENDAS(TOTAL_VENDA, DATA_VENDA) VALUES (?,?)";
    private final String GRAVARVENDA = "INSERT INTO ITENS(NUM_ITEM, VENDAS_IDVENDAS, IDDOPRODUTO, NOMEPRODUTO, UNDPRODUTO, PRECOPRODUTO, QUANTPRODUTO, TOTALDOITEM) VALUES (?,?,?,?,?,?,?,?)";
    private final String CONSULTARULTIMOITEM = "SELECT MAX(IDVENDAS)FROM ITENS;";
    
    public void criarVenda(double totalVenda, String datadehoje) {
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(CRIARVENDA);
            
            prepararInstrucao.setDouble(1, totalVenda);
            prepararInstrucao.setString(2, datadehoje);
            
            prepararInstrucao.execute();
            
            con.desconecta();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroProtudoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void gravarVenda(itensVenda itensDaVenda, int idVendaAtual) {
        //System.out.println(itensDaVenda.getItenN());
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(GRAVARVENDA);
            System.out.println("Tá indo");
                
                prepararInstrucao.setInt(1, itensDaVenda.getItenN());
                prepararInstrucao.setInt(2, idVendaAtual);
                prepararInstrucao.setInt(3, itensDaVenda.getId_produto());
                prepararInstrucao.setString(4, itensDaVenda.getNome_produto());
                prepararInstrucao.setString(5, itensDaVenda.getUnd_medida());
                prepararInstrucao.setDouble(6, itensDaVenda.getPreco_produto());
                prepararInstrucao.setInt(7, itensDaVenda.getQtd_produto());
                prepararInstrucao.setDouble(8, itensDaVenda.getTotal_item() );

                prepararInstrucao.execute();
                System.out.println(itensDaVenda.toString());
                
            
            con.desconecta();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroProtudoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}