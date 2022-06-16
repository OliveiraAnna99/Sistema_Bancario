import java.util.*;
import javax.swing.*;

public class Agencia
{
    private int codigo;
    private String numero;
    private List<Conta> contas = new ArrayList<>();
    private double total = 0;
    public Agencia()
    {
  
    }
    //getters
    public int getCodigo(){
        return codigo;
    }
    public String getNumero(){
        return numero;
    }
    public List<Conta> getContas(){
        return contas;
    }
    public double getTotal(){
        return total;
    }
    
    
    //setters
    public void setCodigo(){
        this.codigo = codigo;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }
    public void setContas(ArrayList<Conta> contas){
        this.contas = contas;
    }
    public double total(){
         return contas.stream().mapToDouble(s->s.getSaldo()).sum();
        
    }
    public boolean renderCP(){
        contas.stream().filter(c->c.getTipo().equals("cp")).forEach(c->c.rendimento());
        return true;
    }
    
     public boolean manutencaoCP(){
        contas.stream().filter(c->c.getTipo().equals("cp")).forEach(c->c.taxaManutencao());
        return true;
    }
    
   
    
  
}
