import java.util.*;


public class Banco
{
    private String nomeFantasia;
    private List<Agencia> agencias = new ArrayList<>();
    public Banco()
    {
  
    }
    
 
    public double total(){
        return agencias.stream().mapToDouble(s->s.total()).sum();
        
    }
     public boolean renderCP(){
        agencias.stream().forEach(ag->ag.renderCP());
        return true;
    }
    
}
