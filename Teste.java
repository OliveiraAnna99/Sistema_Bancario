import java.util.*;

public class Teste
{
    
    public Teste()
    {
        
      ArrayList<Conta> contasAgencia1 = new ArrayList<>();
      ArrayList<Conta> contasAgencia2 = new ArrayList<>();
      Banco bancoBrasil = new Banco();
      Agencia agen1 = new Agencia();
      Agencia agen2 = new Agencia();
      Conta c1 = new Conta();
      Conta c2 = new Conta();
      Conta c3 = new Conta();
      Conta c4 = new Conta();
      
      Cliente cli1 = new Cliente();
      Cliente cli2 = new Cliente();
      Cliente cli3 = new Cliente();
      Cliente cli4 = new Cliente();
      
      cli1.setNome("Angelo Medeiros");
      cli2.setNome("Zuleide da Cunha");
      cli3.setNome("Ariane Lime");
      cli4.setNome("Pedro Barroso");
      
      cli1.setCPF("000.000.000-00");
      cli2.setNome("111.111.111-11");
      cli3.setNome("222.222.222-22");
      cli4.setNome("333.333.333-33");
      
      c1.setCliente(cli1);
      c2.setCliente(cli2);
      c3.setCliente(cli3);
      c4.setCliente(cli4);
      
      c1.setTipo("cc");
      c2.setTipo("cc");
      c3.setTipo("cp");
      c4.setTipo("cp");
      
      
      c1.setTaxaManutencao(36);
      c2.setTaxaManutencao(36);
      c3.setTaxaManutencao(24);
      c4.setTaxaManutencao(24);
      
        
      c1.setRendimento(0.9);
      c2.setRendimento(0.9);
      c3.setRendimento(0.9);
      c4.setRendimento(0.9);
      
      c1.setLimite(50);
      c2.setLimite(50);
      c3.setLimite(50);
      c4.setLimite(50);
      
       c1.setNumero("3041-t");
       c2.setNumero("3621-y");
       c3.setNumero("3031-t");
       c4.setNumero("3631-y"); 
       agen1.setNumero("001");
       agen2.setNumero("002");
       contasAgencia1.add(c1);
        contasAgencia1.add(c2);
         contasAgencia2.add(c3);
          contasAgencia2.add(c4);
      agen1.setContas(contasAgencia1);
      agen1.setContas(contasAgencia2);
      
      c1.depositar(20);
      c2.depositar(23);
      c3.depositar(450);
      c4.depositar(5);
      
      
    }
     

   
}
