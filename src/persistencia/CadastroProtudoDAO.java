package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.Produto;
public class CadastroProtudoDAO {
    private ConexaoBanco con = new ConexaoBanco();
	
	private final String CADASTRARPRODUTO = "INSERT INTO PRODUTOS (NOME_PRODUTO,COD_BARRAS,PRECO,QUANTIDADE,UND_MEDIDA) VALUES (?,?,?,?,?)";
//	private final String UPDATEUSUARIO = "UPDATE USUARIO SET NOME_USUARIO = ?, TEL_USUARIO = ?, EMAIL_USUARIO = ? WHERE ID_USUARIO = ?";
//	private final String DELETEUSUARIO = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";
//	private final String LISTUSUARIO = "SELECT * FROM USUARIO";
//	private final String BUSCARUSUARIO = "SELECT * FROM USUARIO WHERE UPPER(NOME_USUARIO) LIKE ?";

    
	public void cadastrarProduto(Produto u){
           
        }
    }

