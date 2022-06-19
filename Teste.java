import java.util.*;
import javax.swing.*;

public class Teste
{
    private List<Conta> contas = new ArrayList<>();
    private List<Agencia> agencias = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private Banco banco = new Banco();
    private Agencia agencia = new Agencia();    
    private Conta conta = new Conta();
    private Random random = new Random();
      
    public Banco Teste()
    {
          Banco bank = createBank();
          bank.setAgencias(createAgency(3));
          for(Agencia ag: bank.getAgencias()){
            ag.setContas(createConta(4));
            ag.setTotal(ag.total());
            ag.renderCP();
            ag.manutencaoCP();
          }
         return bank;
    }
     
    public Banco createBank(){
        banco.setNomeFantasia("Banco do Brasil");
        return banco;
    }
    public String gNumeroAgencia(){
        String numero = "";
        for(int i = 0; i < 4; i++){
            numero += "" + random.nextInt(9);
        }
        return numero;
    }
    public String gNumeroTipo(String  type){
        if(gTipoConta().equals("Conta Corrente PF")){
            return "001";
        }else if(gTipoConta().equals("Conta Poupanca PF")){
            return "013";
        }
        return "";
    }
    
    public double gQuantia_Alta_Dinheiro(){
        return Math.ceil(20+ (Math.random()*125));
    }
    public double gQuantia_Baixa_Dinheiro(){
        return Math.ceil(20+ (Math.random()*24));
    }

    public String gerarNumeroConta(){
        String numero = "";
        for(int i = 0; i<10; i++){
            if(i == 8){
             numero += "-";
            }else{
                 numero += random.nextInt(9);
            }
        }
        return numero;
    }
     public String gerarData(){
        int dia = (1 + random.nextInt(28));
        int mes = (1 + random.nextInt(11));
        String sDia = "";
        String sMes = "";
        if(dia < 10){
            sDia = "0" + dia;
        }else{
            sDia = "" + dia;
        }
        if(mes < 10){
            sMes = "0"+ mes;
        }else{
             sMes = ""+ mes;
        }
        
        String data = sDia + "/" + sMes + "/" + (2022);
       
        return data;
    }
    public List<Conta> createConta(int qtdConta){
        String tipo = gTipoConta();
        for(int i = 0; i < qtdConta; i++){
          Conta c = new Conta();

          c.setCodigo(i);
          c.setTipo(tipo);
          c.setNumeroTipo(gNumeroTipo(tipo));
          c.depositar(gQuantia_Alta_Dinheiro());
          c.sacar(gQuantia_Baixa_Dinheiro());
          c.setLimite(35);
          c.setTaxaManutencao(50);
          c.setRendimento(0.8);
          c.setSaldo(c.getSaldo());
          //c.setAgencia(agencias.get(i));
          clientes = createUsers(1);
          c.setCliente(clientes.get(i));
          c.setNumero(gerarNumeroConta());
          c.setData(gerarData());
          contas.add(c);
          if(i > 0){
              c.transferir(contas.get(i-1), gQuantia_Baixa_Dinheiro());
          }
       }
      
       return contas;
    }
    
    public String gTipoConta(){
        String tipo[] = {"Conta Corrente PF", "Conta Poupanca PF","Conta Simples PF ", "Conta Corrente PJ", "Conta Poupanca PJ"};
        return tipo[random.nextInt(1)];
    }
    
    public List<Agencia> createAgency(int qtdAgency){
        for(int i = 0; i < qtdAgency; i++){
          Agencia a = new Agencia();
          a.setCodigo(i);
          a.setNumero(gNumeroAgencia());
          a.setContas(contas);
          agencias.add(a);
       }
       return agencias;
    }
    public String gerarCPF(){
        String cpf= "";
        for(int i =0; i < 14; i++){
            if((i == 3) || (i == 7)){
             cpf += ".";
            }
            else if(i == 11){
             cpf += "-";
            }
            else{
             cpf += (""+random.nextInt(9));
            }
        }
        return cpf;
    }
    public String gerarNome(){
        String nome[] = {"Amanda", "Anna", "Sophia","Beatriz", "Bruno", "Felipe", "Mateus", "Gabriel", "Breno", "Vinicius", "Livia", "Marcela", "Marcelo", "Douglas", "Mariana", "Ingrid", "Emanoel" };
        String sobrenome[] = {"Costa", "Medeiros", "Oliveira", "Araújo", "Lima", "Souza", "Dantas", "Silva", "Barros", "Cunha"};
        String nomeCompleto = nome[random.nextInt(nome.length-1)] + " " + sobrenome[random.nextInt(sobrenome.length-1)];
        return nomeCompleto;
    }
    public List<Cliente> createUsers(int qtdUsers){
        for(int i = 0; i < qtdUsers; i++){
          Cliente cli = new Cliente();
          cli.setNome(gerarNome());
          cli.setCPF(gerarCPF());
          clientes.add(cli);
       }
       return clientes;
    }
        
   
}
