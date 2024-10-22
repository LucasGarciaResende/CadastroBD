package cadastrobd.model;

public class PessoaFisica extends Pessoa{
    private String cpf;
    
    public PessoaFisica(int id, String nome, String logradouro, String cidade, String estado, String telefone, String email, String cpf){
        super(id, nome, logradouro, cidade, estado, telefone, email);
        this.cpf = cpf;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    @Override
    public void exibir(){
        System.out.printf("Id: %d\nNome: %s\nLogradouro: %s\nCidade: %s\nEstado: %s\nTelefone %s\nE-Mail: %s\nCpf: %s\n", 
                getId(), getNome(), getLogradouro(), getCidade(), getEstado(), getTelefone(), getEmail(), getCpf());
    }   
}
