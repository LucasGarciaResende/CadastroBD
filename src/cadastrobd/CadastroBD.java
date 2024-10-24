package cadastrobd;
import cadastrobd.model.*;
import cadastrobd.model.util.*;
import java.sql.SQLException;
import java.util.Scanner;

public class CadastroBD{
    public static void main(String[] args) throws SQLException{
        boolean flag = true;
        int menu;
        String escolha;
        PessoaFisica fisica;
        PessoaJuridica juridica;
        int id;
        String nome;
        String logradouro;
        String cidade;
        String estado;
        String telefone;
        String email;
        String cpf;
        String cnpj;
        while(flag){         
            System.out.println("========================\n"
                             + "|1 - Incluir Pessoa    |\n"
                             + "|2 - Alterar Pessoa    |\n"
                             + "|3 - Excluir Pessoa    |\n"
                             + "|4 - Exibir Pessoa    |\n"
                             + "|5 - Exibir Todos      |\n"
                             + "|0 - Finalizar Programa|\n"
                             + "========================");
            Scanner input = new Scanner(System.in);
            menu = input.nextInt();
            input.nextLine();
            switch(menu){
                case 0:
                    flag = false;
                    break;
                case 1:
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                    escolha = input.nextLine();
                    switch(escolha){
                        case "F":
                            System.out.println("Insira o nome:");
                            nome = input.nextLine();
                            System.out.println("Insira o Logradouro -Endereço, Número, Bairro-:");
                            logradouro = input.nextLine();
                            System.out.println("Insira a Cidade:");
                            cidade = input.nextLine();
                            System.out.println("Insira o Estado");
                            estado= input.nextLine();
                            if (estado.length() != 2){
                                System.out.println("Input Inválido");
                                break;
                            }
                            System.out.println("Insira o Número de Telefone c/DDD:");
                            telefone = input.nextLine();
                            if ((telefone.length() != 11)){
                                System.out.println("Input Inválido");
                                break;
                            }
                            System.out.println("Insira o E-Mail");
                            email = input.nextLine();
                            System.out.println("Insira o CPF sem símbolos");
                            cpf = input.nextLine();
                            if (cpf.length() != 11){
                                System.out.println("Input Inválido");
                                break;
                            }
                            fisica = new PessoaFisica(1, nome, logradouro, cidade, estado, telefone, email, cpf);
                            PessoaFisicaDAO.incluir(fisica);
                            System.out.println("Pessoa Adicionada com Sucesso!");
                            break;
                        case "J":
                            System.out.println("Insira o nome:");
                            nome = input.nextLine();
                            System.out.println("Insira o Logradouro -Endereço, Número, Bairro-:");
                            logradouro = input.nextLine();
                            System.out.println("Insira a Cidade:");
                            cidade = input.nextLine();
                            System.out.println("Insira o Estado");
                            estado= input.nextLine();
                            if (estado.length() != 2){
                                System.out.println("Input Inválido");
                                break;
                            }
                            System.out.println("Insira o Número de Telefone c/DDD:");
                            telefone = input.nextLine();
                            if ((telefone.length() != 11)){
                                System.out.println("Input Inválido");
                                break;
                            }
                            System.out.println("Insira o E-Mail");
                            email = input.nextLine();
                            System.out.println("Insira o CPF sem símbolos");
                            cnpj = input.nextLine();
                            if (cnpj.length() != 11){
                                System.out.println("Input Inválido");
                                break;
                            }
                            juridica = new PessoaJuridica(1, nome, logradouro, cidade, estado, telefone, email, cnpj);
                            PessoaJuridicaDAO.incluir(juridica);
                            System.out.println("Pessoa Adicionada com Sucesso!");
                            break;
                        default:
                            System.out.println("Input Inválido");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                    escolha = input.nextLine();
                    switch(escolha){
                        case "F":
                            System.out.println("Insira o ID da pessoa a ser alterada");
                            id = input.nextInt();
                            input.nextLine();
                            System.out.println("Insira o nome:");
                            nome = input.nextLine();
                            System.out.println("Insira o Logradouro -Endereço, Número, Bairro-:");
                            logradouro = input.nextLine();
                            System.out.println("Insira a Cidade:");
                            cidade = input.nextLine();
                            System.out.println("Insira o Estado");
                            estado= input.nextLine();
                            if (estado.length() != 2){
                                System.out.println("Input Inválido");
                                break;
                            }
                            System.out.println("Insira o Número de Telefone c/DDD:");
                            telefone = input.nextLine();
                            if ((telefone.length() != 11)){
                                System.out.println("Input Inválido");
                                break;
                            }
                            System.out.println("Insira o E-Mail");
                            email = input.nextLine();
                            System.out.println("Insira o CPF sem símbolos");
                            cpf = input.nextLine();
                            if (cpf.length() != 11){
                                System.out.println("Input Inválido");
                                break;
                            }
                            fisica = new PessoaFisica(id, nome, logradouro, cidade, estado, telefone, email, cpf);
                            PessoaFisicaDAO.atualizar(fisica);
                            System.out.println("Pessoa Alterada com Sucesso!");
                            break;
                        case "J":
                            System.out.println("Insira o ID da pessoa a ser alterada");
                            id = input.nextInt();
                            input.nextLine();
                            System.out.println("Insira o nome:");
                            nome = input.nextLine();
                            System.out.println("Insira o Logradouro -Endereço, Número, Bairro-:");
                            logradouro = input.nextLine();
                            System.out.println("Insira a Cidade:");
                            cidade = input.nextLine();
                            System.out.println("Insira o Estado");
                            estado= input.nextLine();
                            if (estado.length() != 2){
                                System.out.println("Input Inválido");
                                break;
                            }
                            System.out.println("Insira o Número de Telefone c/DDD:");
                            telefone = input.nextLine();
                            if ((telefone.length() != 11)){
                                System.out.println("Input Inválido");
                                break;
                            }
                            System.out.println("Insira o E-Mail");
                            email = input.nextLine();
                            System.out.println("Insira o CPF sem símbolos");
                            cnpj = input.nextLine();
                            if (cnpj.length() != 11){
                                System.out.println("Input Inválido");
                                break;
                            }
                            juridica = new PessoaJuridica(id, nome, logradouro, cidade, estado, telefone, email, cnpj);
                            PessoaJuridicaDAO.incluir(juridica);
                            System.out.println("Pessoa Alterada com Sucesso!");
                            break;
                        default:
                            System.out.println("Input Inválido");
                    }
                    break;
                case 3:
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                    escolha = input.nextLine();
                    switch(escolha){
                        case "F":
                            System.out.println("Insira o ID da pessoa a ser excluida");
                            id = input.nextInt();
                            input.nextLine();
                            PessoaFisicaDAO.excluir(id);
                            System.out.println("Pessoa Excluida com Sucesso!");
                            break;
                        case "J":
                            System.out.println("Insira o ID da pessoa a ser excluida");
                            id = input.nextInt();
                            input.nextLine();
                            PessoaJuridicaDAO.excluir(id);
                            System.out.println("Pessoa Excluida com Sucesso!");
                            break;
                        default:
                            System.out.println("Input Inválido");
                    }
                    break;
                case 4:
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                    escolha = input.nextLine();
                    switch(escolha){
                        case "F":
                            System.out.println("Insira o ID da pessoa");
                            id = input.nextInt();
                            input.nextLine();
                            PessoaFisicaDAO.getPessoa(id).exibir();
                            break;
                        case "J":
                            System.out.println("Insira o ID da pessoa");
                            id = input.nextInt();
                            input.nextLine();
                            PessoaJuridicaDAO.getPessoa(id).exibir();
                            break;
                        default:
                            System.out.println("Input Inválido");
                    }
                    break;
                case 5:
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                    escolha = input.nextLine();
                    switch(escolha){
                        case "F":
                            for(PessoaFisica pessoa: PessoaFisicaDAO.getPessoas()){
                                pessoa.exibir();
                            }
                            break;
                        case "J":
                            for(PessoaJuridica pessoa: PessoaJuridicaDAO.getPessoas()){
                                pessoa.exibir();
                            }
                            break;
                        default:
                            System.out.println("Input Inválido");
                    }
                    break;
                default:
                    System.out.println("Input Inválido");
                    break;
            }
        }
    }
}
