package cadastrobd.model.util;
import java.sql.*;

public class ConectorBD{
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Loja;encrypt=true;trustServerCertificate=true";
    private static final String LOGIN = "loja";
    private static final String SENHA = "loja";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, LOGIN, SENHA);
    }
    
    public static PreparedStatement getPrepared(String sql) throws SQLException{
        return getConnection().prepareStatement(sql);
    }
    
    public static ResultSet getResult(String pesquisa) throws SQLException{
        return getConnection().createStatement().executeQuery(pesquisa);
    }
    
    public static void close(Connection connection) throws SQLException{
        if (connection != null){
            connection.close();
        }
    }
    
    public static void close(PreparedStatement statement) throws SQLException{
        if (statement != null){
            statement.close();
        }
    }
    
    public static void close(ResultSet resultado) throws SQLException{
        if (resultado != null){
            resultado.close();
        }
    }
}
    
