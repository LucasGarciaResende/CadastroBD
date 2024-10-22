package cadastrobd.model;
import java.sql.*;
import cadastrobd.model.util.*;
import java.util.ArrayList;

public abstract class PessoaFisicaDAO<E, K> {
    
    public static PessoaFisica getPessoa(int idpessoa) throws SQLException{
        String pesquisa = 
            "SELECT pessoa.*, pessoa_fisica.cpf FROM dbo.pessoa_fisica INNER JOIN dbo.pessoa ON pessoa_fisica.idpessoa = pessoa.idpessoa WHERE pessoa.idpessoa = ?";  
        PreparedStatement statement = ConectorBD.getPrepared(pesquisa);
        statement.setInt(1, idpessoa);
        ResultSet resultado = statement.executeQuery();
        PessoaFisica pessoa = null;
        if(resultado.next()){
            int id = resultado.getInt("idpessoa");
            String nome = resultado.getString("nome");
            String logradouro = resultado.getString("logradouro");
            String cidade = resultado.getString("cidade");
            String estado = resultado.getString("estado");
            String telefone = resultado.getString("telefone");
            String email = resultado.getString("email");
            String cpf = resultado.getString("cpf");
            pessoa = new PessoaFisica(id, nome, logradouro, cidade, estado, telefone, email, cpf);
        }
        ConectorBD.close(resultado);
        ConectorBD.close(statement);
        return pessoa;
    }
    
    public static ArrayList<PessoaFisica> getPessoas() throws SQLException{
        ArrayList<PessoaFisica> pessoas = new ArrayList<>();
        String pesquisa = 
            "SELECT pessoa.*, pessoa_fisica.cpf FROM dbo.pessoa_fisica INNER JOIN dbo.pessoa ON pessoa_fisica.idpessoa = pessoa.idpessoa";
        ResultSet resultado = ConectorBD.getResult(pesquisa);
        while(resultado.next()){
            int id = resultado.getInt("idpessoa");
                String nome = resultado.getString("nome");
                String logradouro = resultado.getString("logradouro");
                String cidade = resultado.getString("cidade");
                String estado = resultado.getString("estado");
                String telefone = resultado.getString("telefone");
                String email = resultado.getString("email");
                String cpf = resultado.getString("cpf");
                PessoaFisica pessoa = new PessoaFisica(id, nome, logradouro, cidade, estado, telefone, email, cpf);
                pessoas.add(pessoa);
        }
        ConectorBD.close(resultado);
        return pessoas;
    }
    
    public static void incluir(PessoaFisica pessoa) throws SQLException{
        SequenceManager sequenceManager = new SequenceManager();
        long idSeq = sequenceManager.getValue("seq_pessoa_id");
        String insertPessoa = 
            "INSERT INTO dbo.pessoa (idpessoa, nome, logradouro, cidade, estado, telefone, email) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";
        String insertPessoaFisica = 
            "INSERT INTO dbo.pessoa_fisica (idpessoa, cpf) VALUES (?, ?)";
        PreparedStatement stmtPessoa = ConectorBD.getPrepared(insertPessoa);
        stmtPessoa.setLong(1, idSeq);
        stmtPessoa.setString(2, pessoa.getNome());
        stmtPessoa.setString(3, pessoa.getLogradouro());
        stmtPessoa.setString(4, pessoa.getCidade());
        stmtPessoa.setString(5, pessoa.getEstado());
        stmtPessoa.setString(6, pessoa.getTelefone());
        stmtPessoa.setString(7, pessoa.getEmail());
        stmtPessoa.executeUpdate();
        PreparedStatement stmtFisica = ConectorBD.getPrepared(insertPessoaFisica);
        stmtFisica.setLong(1, idSeq);
        stmtFisica.setString(2, pessoa.getCpf());
        stmtFisica.executeUpdate();
        ConectorBD.close(stmtPessoa);
        ConectorBD.close(stmtFisica);
    }
    
    public static void atualizar(PessoaFisica pessoa) throws SQLException{
        String updatePessoa = "UPDATE dbo.pessoa" +
            "SET nome = ?, logradouro = ?, cidade = ?, estado = ?, telefone = ?, email = ? " +
            "WHERE idpessoa = ?";
        String updateFisica =
            "UPDATE dbo.pessoa_fisica SET cpf = ? WHERE idpessoa = ?";
        PreparedStatement stmtPessoa = ConectorBD.getPrepared(updatePessoa);
        stmtPessoa.setString(1, pessoa.getNome());
        stmtPessoa.setString(2, pessoa.getLogradouro());
        stmtPessoa.setString(3, pessoa.getCidade());
        stmtPessoa.setString(4, pessoa.getEstado());
        stmtPessoa.setString(5, pessoa.getTelefone());
        stmtPessoa.setString(6, pessoa.getEmail());
        stmtPessoa.setInt(7, pessoa.getId());
        stmtPessoa.executeUpdate();
        PreparedStatement stmtFisica = ConectorBD.getPrepared(updateFisica);
        stmtFisica.setString(1, pessoa.getCpf());
        stmtFisica.setInt(2, pessoa.getId());
        stmtFisica.executeUpdate();
        ConectorBD.close(stmtPessoa);
        ConectorBD.close(stmtFisica);
    }
    
    public static void excluir(int idpessoa) throws SQLException{
        String deletePessoa = "DELETE FROM dbo.pessoa WHERE idpessoa = ?";
        String deleteFisica = "DELETE FROM dbo.pessoa_fisica WHERE idpessoa = ?";
        PreparedStatement stmtPessoa = ConectorBD.getPrepared(deletePessoa);
        stmtPessoa.setInt(1, idpessoa);
        stmtPessoa.executeUpdate();
        PreparedStatement stmtFisica = ConectorBD.getPrepared(deleteFisica);
        stmtFisica.setInt(1, idpessoa);
        stmtFisica.executeUpdate();
        ConectorBD.close(stmtPessoa);
        ConectorBD.close(stmtFisica);
    }
}
