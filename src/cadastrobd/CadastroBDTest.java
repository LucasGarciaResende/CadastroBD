package cadastrobd;
import cadastrobd.model.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class CadastroBDTest {
    public CadastroBDTest() throws SQLException{
        //Operações com Pessoa Física.
        PessoaFisica fisicaCr = new PessoaFisica
            (1, "João Henrique", "Avenida Luiz Almeida, 108, Gardênia", "Porto Alegre",
            "RS", "51977018870", "fanimail88@gmail.com", "50147765613");
        PessoaFisicaDAO.incluir(fisicaCr);
        PessoaFisica fisicaUp = new PessoaFisica
            (1, "Maria Gonzales", "Rua Dominique Silveira, 312, Emba", "São Paulo",
            "SP", "11986774030", "mariajoana0199@gmail.com", "32212366689");
        PessoaFisicaDAO.atualizar(fisicaUp);
        ArrayList<PessoaFisica> pessoas = PessoaFisicaDAO.getPessoas();
        for (PessoaFisica pessoa: pessoas){
            pessoa.exibir();
        }
        PessoaFisicaDAO.excluir(7);
        
        //Operações com Pessoa Jurídica.
        PessoaJuridica juridicaCr = new PessoaJuridica
            (1, "Feirinha do Jão", "Rua Henrique Camps, 1040, Belavista", "Fortaleza",
            "CE", "85988818040", "jaofeira7322@gmail.com", "72776454000160");
        PessoaJuridicaDAO.incluir(juridicaCr);
        PessoaJuridica juridicaUp = new PessoaJuridica
            (1, "Maria Gonzales", "Rua Dominique Silveira, 312, Emba", "São Paulo",
            "SP", "11986774030", "mariajoana0199@gmail.com", "32212366689");
        PessoaJuridicaDAO.atualizar(juridicaUp);
        ArrayList<PessoaJuridica> juridicas = PessoaJuridicaDAO.getPessoas();
        for (PessoaJuridica pessoa: juridicas){
            pessoa.exibir();
        }
        PessoaJuridicaDAO.excluir(8);
    }
}
