package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Produto;

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
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroProtudoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
   
}
