package cadastrobd;
import cadastrobd.model.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class CadastroBDTest {
    public CadastroBDTest() throws SQLException{
        //PessoaFisica fisica = new PessoaFisica
            //(1, "João Henrique", "Avenida Luiz Almeida, 108, Gardênia", "Porto Alegre",
            //"RS", "51977018870", "fanimail88@gmail.com", "50147765613");
       //PessoaFisicaDAO.incluir(fisica);
       ArrayList<PessoaFisica> pessoas = PessoaFisicaDAO.getPessoas();
       for (PessoaFisica pessoa: pessoas){
           pessoa.exibir();
       }
    }
}
