
public class Cliente
{
    private String nome;  
    private String cpf;
   
    public Cliente()
    {

    }
    //getters
    public String getNome(){
        return nome;
    }
    public String getCPF(){
        return cpf;
    }
    //setters
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCPF(String cpf){
        this.cpf = cpf;
    }
    
}
