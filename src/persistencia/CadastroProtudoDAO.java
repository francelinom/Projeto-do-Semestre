package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Produto;

public class CadastroProtudoDAO {
    private ConexaoBanco con = new ConexaoBanco();
    
	
	private final String CADASTRARPRODUTO = "INSERT INTO PRODUTOS (NOME_PRODUTO,COD_BARRAS,PRECO,QUANTIDADE,UND_MEDIDA) VALUES (?,?,?,?,?)";
//	private final String UPDATEUSUARIO = "UPDATE USUARIO SET NOME_USUARIO = ?, TEL_USUARIO = ?, EMAIL_USUARIO = ? WHERE ID_USUARIO = ?";
//	private final String DELETEUSUARIO = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";
//	private final String LISTUSUARIO = "SELECT * FROM USUARIO";
//	private final String BUSCARUSUARIO = "SELECT * FROM USUARIO WHERE UPPER(NOME_USUARIO) LIKE ?";

    
	public void cadastrarProduto(Produto p){
                  
        try {
            con.conecta();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = con.getConexao().prepareStatement(CADASTRARPRODUTO);
            
            prepararInstrucao.setString(1, p.getNome_produto());
            prepararInstrucao.setDouble(2, p.getCod_barra_produto());
            prepararInstrucao.setDouble(3, p.getPreco_produto());
            prepararInstrucao.setInt(4, p.getQtd_produto());
            prepararInstrucao.setString(5, p.getUnd_medida());
            prepararInstrucao.execute();
            
            con.desconecta();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroProtudoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    public void atulizarProduto(Produto a) {
        
    }
    }

