package cadastrobd.model;

public class Pessoa {
    private int id;
    private String nome;
    private String logradouro;
    private String cidade;
    private String estado;
    private String telefone;
    private String email;
    
    public Pessoa(int id, String nome, String logradouro, String cidade, String estado, String telefone, String email){
        this.id = id;
        this.nome = nome;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.email = email;
    }
    
    public int getId(){
        return this.id;
    } 
    public String getNome(){
        return this.nome;
    }   
    public String getLogradouro(){
        return this.logradouro;
    }   
    public String getCidade(){
        return this.cidade;
    }  
    public String getEstado(){
        return this.estado;
    }
    public String getTelefone(){
        return this.telefone;
    }
    public String getEmail(){
        return this.email;
    }
    
    public void exibir(){
        System.out.printf("Nome: %d\nLogradouro: %s\nCidade: %s\nEstado: %s\nTelefone %s\nE-Mail: %s", 
                getId(), getLogradouro(), getCidade(), getEstado(), getTelefone(), getEmail());
    }
}
