package cadastrobd.model;

public class PessoaJuridica extends Pessoa{
    private String cnpj;
    
    public PessoaJuridica(int id, String nome, String logradouro, String cidade, String estado, String telefone, String email, String cnpj){
        super(id, nome, logradouro, cidade, estado, telefone, email);
        this.cnpj = cnpj;
    }
    
    public String getCnpj(){
        return this.cnpj;
    }
    
    @Override
    public void exibir(){
        System.out.printf("Id: %d\nNome: %s\nLogradouro: %s\nCidade: %s\nEstado: %s\nTelefone %s\nE-Mail: %s\nCnpj: %s\n", 
                getId(), getNome(),getLogradouro(), getCidade(), getEstado(), getTelefone(), getEmail(), getCnpj());
    }   
}
