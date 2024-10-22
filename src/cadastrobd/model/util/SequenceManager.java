package cadastrobd.model.util;
import java.sql.*;

public class SequenceManager {
    public long getValue(String sequencia) throws SQLException{
        String pesquisa = "SELECT NEXT VALUE FOR " + sequencia;
        PreparedStatement statement = ConectorBD.getPrepared(pesquisa);
        ResultSet resultado = statement.executeQuery();
        if(resultado.next()){
            return resultado.getLong(1);
        }
        else{
            return -1;
        }
    }
}
