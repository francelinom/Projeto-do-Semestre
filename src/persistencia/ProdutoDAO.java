package persistencia;

import com.jfoenix.controls.JFXTextField;
import com.sun.corba.se.spi.orbutil.fsm.Guard;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;
import modelos.Produto;
import modelos.itensVenda;

public class ProdutoDAO {
    private ConexaoBanco con = new ConexaoBanco();
    private Produto produto;
   
    private final String CADASTRARPRODUTO = "INSERT INTO PRODUTOS (NOME_PRODUTO,COD_BARRAS,PRECO,QUANTIDADE,UND_MEDIDA) VALUES (?,?,?,?,?)";
    private final String ATUALIZARPRODUTO = "UPDATE PRODUTOS SET NOME_PRODUTO = ?, COD_BARRAS = ?, PRECO = ?, QUANTIDADE = ?, UND_MEDIDA = ? WHERE ID = ?";
    private final String DELETARPRODUTO = "DELETE FROM PRODUTOS WHERE ID = ?";
    private final String LISTARPRODUTOS = "SELECT * FROM PRODUTOS";
//    private final String BUSCARPRODUTOS = "SELECT * FROM PRODUTOS WHERE NOME_PRODUTO = ?";
    private final String BUSCARPRODUTOS = "SELECT * FROM PRODUTOS WHERE UPPER(NOME_PRODUTO) LIKE "
            + "'%' || '"+"?"+"' || '%'";
    private final String CONSULTARPRECO = "SELECT NOME_PRODUTO, PRECO FROM PRODUTOS WHERE COD_BARRAS = (?)";
    private final String CONSULTARPRODUTO = "SELECT ID, NOME_PRODUTO, PRECO, UND_MEDIDA FROM PRODUTOS WHERE COD_BARRAS = (?)";
    private final String CONSULTARCODIGO = "SELECT COD_BARRAS FROM PRODUTOS";
    private final String ALTERAQUANTIDADE = "UPDATE PRODUTOS SET QUANTIDADE = QUANTIDADE - (?) WHERE ID = (?);";    
    
    public void cadastrarProduto(Produto p){
                  
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(CADASTRARPRODUTO);
            
            prepararInstrucao.setString(1, p.getNome_produto());
            prepararInstrucao.setInt(2, p.getCod_barra_produto());
            prepararInstrucao.setDouble(3, p.getPreco_produto());
            prepararInstrucao.setInt(4, p.getQtd_produto());
            prepararInstrucao.setString(5, p.getUnd_medida());
            
            prepararInstrucao.execute();
            
            con.desconecta();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    public void atulizarProduto(Produto p) {
        
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(ATUALIZARPRODUTO);
            
            prepararInstrucao.setString(1, p.getNome_produto());
            prepararInstrucao.setInt(2, p.getCod_barra_produto());
            prepararInstrucao.setDouble(3, p.getPreco_produto());
            prepararInstrucao.setInt(4, p.getQtd_produto());
            prepararInstrucao.setString(5, p.getUnd_medida());
            prepararInstrucao.setInt(6, p.getId_produto());
            prepararInstrucao.executeUpdate();
            
        con.desconecta();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deletaProduto(Produto p){
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(DELETARPRODUTO);
            
            prepararInstrucao.setInt(1, p.getId_produto());
            prepararInstrucao.execute();
            
            
        con.desconecta();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Produto> listarProdutos() {
        ArrayList<Produto> lista = new ArrayList<>();
        
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(LISTARPRODUTOS);
            
            ResultSet rs = prepararInstrucao.executeQuery();
            
            while (rs.next()) {                
                Produto produto = new Produto(rs.getInt("ID"),rs.getString("NOME_PRODUTO"), rs.getInt("COD_BARRAS"),rs.getDouble("PRECO"), rs.getInt("QUANTIDADE"), rs.getString("UND_MEDIDA"));
                lista.add(produto);
                //Produto p = new Produto(0, LISTPRODUTOS, 0, 0, 0, LISTPRODUTOS);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  lista;
    }

    public ArrayList<Produto> listarProdutosBusca(String buscarProduto) {
        ArrayList<Produto> lista = new ArrayList<>();
        
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            
            String BUSCARPRODUTOS_NOVO = "SELECT * FROM PRODUTOS WHERE UPPER(NOME_PRODUTO) LIKE "
            + "'%' || '"+buscarProduto+"' || '%'";
            prepararInstrucao = con.getConexao().prepareStatement(BUSCARPRODUTOS_NOVO);
            
            ResultSet rs = prepararInstrucao.executeQuery();
            while (rs.next()) {                
                Produto p = new Produto(rs.getInt("ID"),rs.getString("NOME_PRODUTO"), rs.getInt("COD_BARRAS"),rs.getDouble("PRECO"), rs.getInt("QUANTIDADE"), rs.getString("UND_MEDIDA"));
                lista.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  lista;
    }
    
    public Produto consultaPreco (int cod) {
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(CONSULTARPRECO);
            
            prepararInstrucao.setInt(1, cod);
            ResultSet rs = prepararInstrucao.executeQuery();
            
            if (rs.next()) {                
                produto = new Produto(rs.getString("NOME_PRODUTO"), rs.getDouble("PRECO"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }
     public Produto consultaProduto (int cod) {
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(CONSULTARPRODUTO);
            
            prepararInstrucao.setInt(1, cod);
            
            ResultSet rs = prepararInstrucao.executeQuery();
            
            if (rs.next()) {                
                produto = new Produto(rs.getInt("ID"),rs.getString("NOME_PRODUTO"), rs.getDouble("PRECO"), rs.getString("UND_MEDIDA"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }
     public ArrayList<Integer> listarCodigo() {
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
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
       public void alterarQuant(itensVenda itensDaVenda) {
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(ALTERAQUANTIDADE);
            prepararInstrucao.setInt(1, itensDaVenda.getQuantidade());
            prepararInstrucao.setInt(2, itensDaVenda.getId_produto());

            prepararInstrucao.execute();
  
            con.desconecta();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

