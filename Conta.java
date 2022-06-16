import java.util.Date;
import java.text.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.*;
import javax.swing.*;


public class Conta
{
    private Cliente c; 
    private Agencia ag;
    
    private int codigo;
    private String numero;
    private String tipo;
    private double saldo;
    private double limite;
    private int doc = 1;
    private double taxaManutencao;
    private double rendimento;
    private String data;
    private int contador = 0;
  
    private ArrayList<String> historicoTransacoes = new ArrayList<>();
    
    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yy");
    
    public Conta()
    {

    }
    //getters
    public int getCodigo(){
        return codigo;
    }
    public String getTipo(){
        return tipo;
    }
    public double getSaldo(){
        return saldo;
    }
    public double getLimite(){
        return limite;
    }
    public Cliente getCliente(){
        return c;
    }
    public Agencia getAgencia(){
        return ag;
    }
     public String getNumero(){
        return numero;
    }
    public ArrayList<String> getHistoricoTransacao(){
        return historicoTransacoes;
    }
    public double getTaxaManutencao(){
        return taxaManutencao;
    }
    public double getRendimento(){
        return rendimento;
    }
   
    //setters
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    public void setLimite(double limite){
        this.limite = limite;
    }
    public void setCliente(Cliente c){
        this.c = c;
    }
    public void setAgencia(Agencia ag){
        this.ag = ag;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }
    public void setTaxaManutencao(double taxaManutencao){
        this.taxaManutencao = taxaManutencao;
    }
    public void setRendimento(double rendimento){
        this.rendimento = rendimento;
    }
  
    public boolean sacar(double valor){
        Date atualData = new Date();
        String dataFormatada = formatoData.format(atualData);
        if(valor <= (this.saldo + this.limite)){
            this.saldo-=valor;
            taxaManutencao();
            rendimento();
            historicoTransacoes.add(dataFormatada + "      SAQUE" + "           000" + doc +"            "+ valor);
            doc++;
            return true;
        }
        
        return false;
    }
   
    public boolean depositar(double valor){
        Date atualData = new Date();
        String dataDeposito = formatoData.format(atualData);
        if(valor > 0){
            this.saldo = this.saldo + valor;
            historicoTransacoes.add(dataDeposito + "   DEPOSITO" + "        000" + doc +"            "+ valor );
            doc++;
            taxaManutencao();
            rendimento();
         
            return true;
        }
        return false;
    }
    
    public boolean transferir(Conta destinatario, double valor){
         Date atualData = new Date();
        String dataFormatada = formatoData.format(atualData);
          if(valor <= (this.saldo + this.limite)){
            this.saldo-=valor;
            destinatario.saldo += valor;
            destinatario.getHistoricoTransacao().add(dataFormatada + "  TRANSF. REC" + "    000" + doc +"            "+ valor);
            historicoTransacoes.add(dataFormatada + "  TRANSF. ENV" + "    000" + doc +"            "+ valor);
            taxaManutencao();
            rendimento();
           
            
           
            doc++;
            return true;
        }
        return false;
    }
    
    public void extrato(){
        JFrame extrato = new JFrame();
        extrato.setTitle("Extrato");
        extrato.setSize(300, 500);
        extrato.setResizable(false);
        extrato.setLocationRelativeTo(null);    
        extrato.setLayout(null);
        
        JLabel titulo = new JLabel("E X T R A T O   B A N C Á R I O");
        JLabel traco = new JLabel("------------------------------------------------------------------");
        JLabel traco2 = new JLabel("------------------------------------------------------------------");
        JLabel traco3 = new JLabel("------------------------------------------------------------------");
        JLabel traco4 = new JLabel("------------------------------------------------------------------");
        
        
        JLabel data = new JLabel("DATA");
        JLabel historico = new JLabel("HISTORICO");
        JLabel doc = new JLabel("DOC");
        JLabel valor = new JLabel("VALOR");
        JLabel saldoTxt = new JLabel("SALDO ATUAL:");
      
        JLabel saldo = new JLabel(""+ getSaldo());
        JLabel cliente = new JLabel("Cliente:  " + c.getNome());
        JLabel agencia1 = new JLabel("Agencia:  " + ag.getNumero());
        JLabel conta1 = new JLabel("Conta:  " + numero);
        JLabel limiteTxt = new JLabel("LIMITE:");
        JLabel limite = new JLabel(" "+ getLimite());
               
        int k = 30;
        
        for(int i = 0; i < historicoTransacoes.size(); i++){
             JLabel transacao1 = new JLabel(historicoTransacoes.get(i));
             transacao1.setBounds(20,120+k, 290, 20);
             extrato.add(transacao1);
             k+= 20;             
        }
        int position =  130+(20* historicoTransacoes.size());
        titulo.setBounds(50, 10, 200, 30);
        traco.setBounds(10, 30, 290, 20);  
        cliente.setBounds(10,50,290, 30);
        agencia1.setBounds(10,70, 150, 30);
        conta1.setBounds(10,90, 150, 30);
        traco2.setBounds(10, 100, 290, 20);  
        data.setBounds(20, 120, 40, 20);
        historico.setBounds(80, 120, 100, 20);
        doc.setBounds(160, 120, 100, 20);
        valor.setBounds(210, 120, 50, 20);
        traco3.setBounds(10, 130, 290, 20);
        traco4.setBounds(10, position+15, 290, 20);
        saldoTxt.setBounds(20, position +30, 100, 20);
        saldo.setBounds(210, position +30, 50, 20);
        limiteTxt.setBounds(20, position +50, 100, 20);
        limite.setBounds(210, position +50, 50, 20);
        extrato.add(titulo);
        extrato.add(traco);
        extrato.add(cliente);
        extrato.add(agencia1);
        extrato.add(conta1);
        extrato.add(traco2);
        extrato.add(data);
        extrato.add(historico);
        extrato.add(doc);
        extrato.add(valor);
        extrato.add(traco3);
        extrato.add(traco4);
        extrato.add(saldoTxt);
        extrato.add(saldo);
        extrato.add(limiteTxt);
        extrato.add(limite);
        
        if(tipo == "cc"){
           
            JLabel taxaTxt = new JLabel("TAXA DE MANUTENÇÃO:");
            JLabel taxa = new JLabel("-"+ taxaManutencao);
            taxaTxt.setBounds(20, position +70, 230, 20);
            taxa.setBounds(210, position +70, 50, 20);
            extrato.add(taxaTxt);
            extrato.add(taxa);
        }
        if(tipo == "cp"){
           
            JLabel taxaTxt = new JLabel("RENDIMENTO:");
            JLabel taxa = new JLabel("+"+ rendimento);
            JLabel taxaTxt2 = new JLabel("TAXA DE MANUTENCAO:");
            JLabel taxa2 = new JLabel("-"+ taxaManutencao);
            taxaTxt.setBounds(20, position +70, 230, 20);
            taxa.setBounds(210, position +70, 50, 20);
            taxaTxt2.setBounds(20, position +90, 230, 20);
            taxa2.setBounds(210, position +90, 50, 20);
            extrato.add(taxaTxt);
            extrato.add(taxa);
        }
        
        extrato.setVisible(true);

    }
    
    public void taxaManutencao(){
       if((historicoTransacoes.size() >= 1) && contador < 1){ 
        this.saldo -= taxaManutencao;
        contador++;
       }
    }
    
    public void rendimento(){
        if(tipo == "cp"){
            this.saldo += rendimento;
            this.rendimento += rendimento;
        }
       
    }
    
    
}
