package cadastrobd.model;
import java.sql.*;
import cadastrobd.model.util.*;
import java.util.ArrayList;

public abstract class PessoaJuridicaDAO<E, K> {
    
    public static PessoaJuridica getPessoa(int idpessoa) throws SQLException{
        String pesquisa = 
            "SELECT pessoa.*, pessoa_juridica.cnpj FROM dbo.pessoa_juridica INNER JOIN dbo.pessoa ON pessoa_jurdica.idpessoa = pessoa.idpessoa WHERE pessoa.idpessoa = ?";  
        PreparedStatement statement = ConectorBD.getPrepared(pesquisa);
        statement.setInt(1, idpessoa);
        ResultSet resultado = statement.executeQuery();
        PessoaJuridica pessoa = null;
        if(resultado.next()){
            int id = resultado.getInt("idpessoa");
            String nome = resultado.getString("nome");
            String logradouro = resultado.getString("logradouro");
            String cidade = resultado.getString("cidade");
            String estado = resultado.getString("estado");
            String telefone = resultado.getString("telefone");
            String email = resultado.getString("email");
            String cnpj = resultado.getString("cnpj");
            pessoa = new PessoaJuridica(id, nome, logradouro, cidade, estado, telefone, email, cnpj);
        }
        ConectorBD.close(resultado);
        ConectorBD.close(statement);
        return pessoa;
    }
    
    public static ArrayList<PessoaJuridica> getPessoas() throws SQLException{
        ArrayList<PessoaJuridica> pessoas = new ArrayList<>();
        String pesquisa = 
            "SELECT pessoa.*, pessoa_juridica.cnpj FROM dbo.pessoa_juridica INNER JOIN dbo.pessoa ON pessoa_juridica.idpessoa = pessoa.idpessoa";
        ResultSet resultado = ConectorBD.getResult(pesquisa);
        while(resultado.next()){
            int id = resultado.getInt("idpessoa");
                String nome = resultado.getString("nome");
                String logradouro = resultado.getString("logradouro");
                String cidade = resultado.getString("cidade");
                String estado = resultado.getString("estado");
                String telefone = resultado.getString("telefone");
                String email = resultado.getString("email");
                String cnpj = resultado.getString("cnpj");
                PessoaJuridica pessoa = new PessoaJuridica(id, nome, logradouro, cidade, estado, telefone, email, cnpj);
                pessoas.add(pessoa);
        }
        ConectorBD.close(resultado);
        return pessoas;
    }
    
    public static void incluir(PessoaJuridica pessoa) throws SQLException{
        SequenceManager sequenceManager = new SequenceManager();
        long idSeq = sequenceManager.getValue("seq_pessoa_id");
        String insertPessoa = 
            "INSERT INTO dbo.pessoa (idpessoa, nome, logradouro, cidade, estado, telefone, email) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";
        String insertJuridica = 
            "INSERT INTO dbo.pessoa_juridica (idpessoa, cnpj) VALUES (?, ?)";
        PreparedStatement stmtPessoa = ConectorBD.getPrepared(insertPessoa);
        stmtPessoa.setLong(1, idSeq);
        stmtPessoa.setString(2, pessoa.getNome());
        stmtPessoa.setString(3, pessoa.getLogradouro());
        stmtPessoa.setString(4, pessoa.getCidade());
        stmtPessoa.setString(5, pessoa.getEstado());
        stmtPessoa.setString(6, pessoa.getTelefone());
        stmtPessoa.setString(7, pessoa.getEmail());
        stmtPessoa.executeUpdate();
        PreparedStatement stmtJuridica = ConectorBD.getPrepared(insertJuridica);
        stmtJuridica.setLong(1, idSeq);
        stmtJuridica.setString(2, pessoa.getCnpj());
        stmtJuridica.executeUpdate();
        ConectorBD.close(stmtPessoa);
        ConectorBD.close(stmtJuridica);
    }
    
    public static void atualizar(PessoaJuridica pessoa) throws SQLException{
        String updatePessoa = "UPDATE dbo.pessoa" +
            "SET nome = ?, logradouro = ?, cidade = ?, estado = ?, telefone = ?, email = ? " +
            "WHERE idpessoa = ?";
        String updateJuridica =
            "UPDATE dbo.pessoa_juridica SET cnpj = ? WHERE idpessoa = ?";
        PreparedStatement stmtPessoa = ConectorBD.getPrepared(updatePessoa);
        stmtPessoa.setString(1, pessoa.getNome());
        stmtPessoa.setString(2, pessoa.getLogradouro());
        stmtPessoa.setString(3, pessoa.getCidade());
        stmtPessoa.setString(4, pessoa.getEstado());
        stmtPessoa.setString(5, pessoa.getTelefone());
        stmtPessoa.setString(6, pessoa.getEmail());
        stmtPessoa.setInt(7, pessoa.getId());
        stmtPessoa.executeUpdate();
        PreparedStatement stmtJuridica = ConectorBD.getPrepared(updateJuridica);
        stmtJuridica.setString(1, pessoa.getCnpj());
        stmtJuridica.setInt(2, pessoa.getId());
        stmtJuridica.executeUpdate();
        ConectorBD.close(stmtPessoa);
        ConectorBD.close(stmtJuridica);
    }
    
    public static void excluir(int idpessoa) throws SQLException{
        String deletePessoa = "DELETE FROM dbo.pessoa WHERE idpessoa = ?";
        String deleteJuridica = "DELETE FROM dbo.pessoa_juridica WHERE idpessoa = ?";
        PreparedStatement stmtPessoa = ConectorBD.getPrepared(deletePessoa);
        stmtPessoa.setInt(1, idpessoa);
        stmtPessoa.executeUpdate();
        PreparedStatement stmtJuridica = ConectorBD.getPrepared(deleteJuridica);
        stmtJuridica.setInt(1, idpessoa);
        stmtJuridica.executeUpdate();
        ConectorBD.close(stmtPessoa);
        ConectorBD.close(stmtJuridica);
    }
}
