import javax.swing.*;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.*;

public class Teste_Interface_Instavel{
      
      JFrame tela = new JFrame();
      JPanel sistema = new JPanel();
      JPanel telaSistema = new JPanel();
      
      JButton btnCC = new JButton("CC");
      JButton btnCP = new JButton("CP");
      
      JButton btnSaque = new JButton("SAQUE");
      JButton btnDeposito = new JButton("DEPOSITO");
      JButton btnSaldoExtrato = new JButton("SALDO/EXTRATO");
      JButton btnTransferir = new JButton("TRANSFERIR");
      
       
      JButton btnSaque2 = new JButton("SAQUE");
      JButton btnDeposito2 = new JButton("DEPOSITO");
      JButton btnSaldoExtrato2 = new JButton("SALDO/EXTRATO");
      JButton btnTransferir2 = new JButton("TRANSFERIR");
      
      JButton btnBack = new JButton("Voltar");
      JButton btnBack2 = new JButton("Voltar");
      JButton btnBack3 = new JButton("Voltar");
      Color azul = new Color(37, 150, 190);
      Color azulEscuro = new Color(6,57,112);
      Color cinza = new Color(204,231,232);
        
      Conta conta1 = new Conta();
      Conta conta2 = new Conta();
      Cliente cliente1 = new Cliente();
      Cliente cliente2 = new Cliente();
      Agencia ag =  new Agencia();
      
      JButton btnAgencia = new JButton("AGENCIA");
      JButton btnConta = new JButton("CONTA");
      JButton btnTot = new JButton("TOTAL");
      JButton btnRender = new JButton("RENDER CP");
      
      private ArrayList<Conta> conts = new ArrayList<>();
      private ArrayList<Double> totals = new ArrayList<>();
      private int conta = 0;
      private int contaD = 0;
    public Teste_Interface_Instavel()
    {
        
        telaInicial();
         
        tela.add(sistema);
        tela.add(telaSistema); 
        tela.setVisible(true);
        
        
        conta1.setCodigo(1);
        conta1.setTipo("cc");
        conta1.setLimite(50);
        conta1.setTaxaManutencao(35);
        cliente1.setCPF("002.402.341-00");
        cliente1.setNome("Roberto Domundo");
        conta1.setCliente(cliente1);
        conta1.setNumero("49308-1");
        conta1.setAgencia(ag);
        
        conta2.setCodigo(1);
        conta2.setTipo("cp");
        conta2.setLimite(50);
        conta2.setNumero("25740-6");
        conta2.setAgencia(ag);
        conta2.setRendimento(0.9);
        cliente2.setCPF("538.962.602-00");
        cliente2.setNome("Alane Martins");
        conta2.setCliente(cliente2);
        conta1.taxaManutencao();
        ag.setNumero("1002-y");
        conts.add(conta1);
        conts.add(conta2);
        ag.setContas(conts);
        
    }
     ActionListener al = new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
              if(e.getSource() == btnCC) {

                   btnCC.setVisible(false);
                   btnCP.setVisible(false);
                   btnBack3.setVisible(false);
                   acessoContaCorrente();
                   
               } 
               if(e.getSource() == btnCP) {
                
                   btnCC.setVisible(false);
                   btnCP.setVisible(false);
                   btnBack3.setVisible(false);
                   acessoContaPoupanca();
                   
               } 
               if(e.getSource() == btnBack3) {
                
                   btnCC.setVisible(false);
                   btnCP.setVisible(false);
                   btnBack3.setVisible(false);
                   btnTot.setVisible(false);
                   btnRender.setVisible(false);
                   op();
                   
               } 
              
        } 
    };
    
    public void telaInicial(){
        tela.setTitle("Sistema Bancário");
        tela.setSize(700,800);
        tela.setResizable(false);
        tela.setLocationRelativeTo(null);    
        tela.setLayout(null);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        desenharAtm();
    }
    public void desenharAtm(){
        telaSistema.setLayout(null);
        telaSistema.setBounds(50, 50, 600, 550);
        telaSistema.setBackground(azul);
       
        sistema.setLayout(null);
        sistema.setBounds(90, 70, 350, 280);
        sistema.setBackground(azulEscuro);
        
        op();
    }
    
    public void op(){
        btnAgencia.setLayout(null);
        btnAgencia.setBounds (130, 100, 100, 20);
        btnAgencia.setBackground(cinza);
        btnAgencia.setVisible(true);
        
        btnConta.setLayout(null);
        btnConta.setBounds (130, 130, 100, 20);
        btnConta.setBackground(cinza);
        btnConta.setVisible(true);
        
        sistema.add(btnAgencia);
        sistema.add(btnConta);
        
        btnAgencia.addActionListener(ai);
        btnConta.addActionListener(ai);
    }
    public void telaConta(){
            btnSaque.setLayout(null);
            btnSaque.setBounds (10, 60, 140, 20);
            btnSaque.setBackground(cinza);
            btnSaque.setVisible(true);
            
            btnSaldoExtrato.setLayout(null);
            btnSaldoExtrato.setBounds (10, 90, 140, 20);
            btnSaldoExtrato.setBackground(cinza);
            btnSaldoExtrato.setVisible(true);
            
            btnDeposito.setLayout(null);
            btnDeposito.setBounds (10, 120, 140, 20);
            btnDeposito.setBackground(cinza);
            btnDeposito.setVisible(true);
            
            btnTransferir.setLayout(null);
            btnTransferir.setBounds (200, 60, 140, 20);
            btnTransferir.setBackground(cinza);
            btnTransferir.setVisible(true);
            
            btnBack.setLayout(null);
            btnBack.setBounds (10, 200, 140, 20);
            btnBack.setBackground(cinza);
            btnBack.setVisible(true);
            
            sistema.add(btnSaque);
            sistema.add(btnSaldoExtrato);
            sistema.add(btnDeposito);
            sistema.add(btnTransferir);
            sistema.add(btnBack);
            
            btnSaque.addActionListener(ac);
            btnSaldoExtrato.addActionListener(ac);
            btnDeposito.addActionListener(ac);
            btnTransferir.addActionListener(ac);
            btnBack.addActionListener(voltar);
           
    }
    
    public void telaConta2(){
            btnSaque2.setLayout(null);
            btnSaque2.setBounds (10, 60, 140, 20);
            btnSaque2.setBackground(cinza);
            btnSaque2.setVisible(true);
            
            btnSaldoExtrato2.setLayout(null);
            btnSaldoExtrato2.setBounds (10, 90, 140, 20);
            btnSaldoExtrato2.setBackground(cinza);
            btnSaldoExtrato2.setVisible(true);
            
            btnDeposito2.setLayout(null);
            btnDeposito2.setBounds (10, 120, 140, 20);
            btnDeposito2.setBackground(cinza);
            btnDeposito2.setVisible(true);
            
            btnTransferir2.setLayout(null);
            btnTransferir2.setBounds (200, 60, 140, 20);
            btnTransferir2.setBackground(cinza);
            btnTransferir2.setVisible(true);
            
            btnBack2.setLayout(null);
            btnBack2.setBounds (10, 200, 140, 20);
            btnBack2.setBackground(cinza);
            btnBack2.setVisible(true);
            
            sistema.add(btnSaque2);
            sistema.add(btnSaldoExtrato2);
            sistema.add(btnDeposito2);
            sistema.add(btnTransferir2);
            sistema.add(btnBack2);
            
            btnSaque2.addActionListener(ap);
            btnSaldoExtrato2.addActionListener(ap);
            btnDeposito2.addActionListener(ap);
            btnTransferir2.addActionListener(ap);
            btnBack2.addActionListener(voltar);
           
    }
    public void opTipoAgencia(){
   
        //botoes dessa tela
        btnBack3.setLayout(null);
        btnBack3.setBounds (20, 200, 100, 20);
        btnBack3.setBackground(cinza);
        btnBack3.setVisible(true);
        
        btnTot.setLayout(null);
        btnTot.setBounds (40, 100, 100, 20);
        btnTot.setBackground(cinza);
        btnTot.setVisible(true);
        
        btnRender.setLayout(null);
        btnRender.setBounds (40, 130, 100, 20);
        btnRender.setBackground(cinza);
        btnRender.setVisible(true);
        
        
        sistema.add(btnTot);
        sistema.add(btnBack3);
        sistema.add(btnRender);
        
        btnTot.addActionListener(actionAg);
        btnRender.addActionListener(actionAg);
        btnBack3.addActionListener(al);
    }
    public void opTipoConta(){
   
        //botoes dessa tela
        btnBack3.setLayout(null);
        btnBack3.setBounds (20, 200, 100, 20);
        btnBack3.setBackground(cinza);
        btnBack3.setVisible(true);
        
        btnCC.setLayout(null);
        btnCC.setBounds (100, 100, 70, 70);
        btnCC.setBackground(cinza);
        btnCC.setVisible(true);
        
        btnCP.setLayout(null);
        btnCP.setBounds (180, 100, 70, 70);
        btnCP.setBackground(cinza);
        btnCP.setVisible(true);
        
        sistema.add(btnCP);
        sistema.add(btnCC);
        sistema.add(btnBack3);
        
        btnCC.addActionListener(al);
        btnCP.addActionListener(al);
        btnBack3.addActionListener(al);
    }
    
    
    
     ActionListener ai = new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
             if(e.getSource() == btnAgencia){
                 btnAgencia.setVisible(false);
                 btnConta.setVisible(false);
                 opTipoAgencia();
             }
             if(e.getSource() == btnConta){
                 btnAgencia.setVisible(false);
                 btnConta.setVisible(false);
                 opTipoConta();
             }
      
        }
    };
    ActionListener actionAg = new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
             if(e.getSource() == btnTot){
                    double t =   ag.total();
                    totals.add(t);
                    conta += 1;
                    if(conta == 1){
                        JFrame resultado = new JFrame();
                        resultado.setSize(200,100);
                        resultado.setResizable(false);
                        resultado.setLocationRelativeTo(null);    
                        resultado.setLayout(null);
                        resultado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        JLabel r = new JLabel("" + totals.get(0));
                        r.setBounds(40, 10, 100, 20);
                        resultado.add(r);
                        resultado.setVisible(true);
                    
                    }
             }
             if(e.getSource() == btnRender){
                 
                 if(ag.renderCP() == true){
                        contaD++;
                        if(contaD == 1){
                        
                            JFrame resultado = new JFrame();
                            resultado.setSize(250,100);
                            resultado.setResizable(false);
                            resultado.setLocationRelativeTo(null);    
                            resultado.setLayout(null);
                            resultado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            JLabel r = new JLabel("RENDIMENTO ATUALIZADO");
                            r.setBounds(40, 10, 200, 20);
                            resultado.add(r);
                            resultado.setVisible(true);
                            
                        }
                }
                    
             }
            
        }
    };
    ActionListener ap = new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
             if(e.getSource() == btnSaque2){
                      
                      JOptionPane r = new JOptionPane();
                      double v= Integer.parseInt( r.showInputDialog("Digite o valor que deseja sacar")
                      );
                      conta2.sacar(v);
             }
              if(e.getSource() == btnSaldoExtrato2){
                      conta2.extrato();
             }
             if(e.getSource() == btnDeposito2){
                      JOptionPane r = new JOptionPane();
                      double v= Integer.parseInt( r.showInputDialog("Digite o valor que deseja depositar")
                      );
                      conta2.depositar(v);
             }
             if(e.getSource() == btnTransferir2){
                      JOptionPane r = new JOptionPane();
                      double v= Integer.parseInt( r.showInputDialog("Digite o valor a ser transferido para conta poupança"));
                      conta2.transferir(conta1, v);
             }
        }
    };
    ActionListener ac = new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
             if(e.getSource() == btnSaque){
                      
                      JOptionPane r = new JOptionPane();
                      double v= Integer.parseInt( r.showInputDialog("Digite o valor que deseja sacar")
                      );
                      conta1.sacar(v);
             }
              if(e.getSource() == btnSaldoExtrato){
                      conta1.extrato();
             }
             if(e.getSource() == btnDeposito){
                      JOptionPane r = new JOptionPane();
                      double v= Integer.parseInt( r.showInputDialog("Digite o valor que deseja depositar")
                      );
                      conta1.depositar(v);
             }
             if(e.getSource() == btnTransferir){
                      JOptionPane r = new JOptionPane();
                      double v= Integer.parseInt( r.showInputDialog("Digite o valor a ser transferido para conta poupança"));
                      conta1.transferir(conta2, v);
             }
        }
    };
    
    ActionListener voltar = new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
             if(e.getSource() == btnBack){
                      btnSaque.setVisible(false);
                      btnSaldoExtrato.setVisible(false);
                      btnDeposito.setVisible(false);
                      btnTransferir.setVisible(false);
                      btnBack.setVisible(false);
                      opTipoConta();
                    
             }
             if(e.getSource() == btnBack2){
                      btnSaque2.setVisible(false);
                      btnSaldoExtrato2.setVisible(false);
                      btnDeposito2.setVisible(false);
                      btnTransferir2.setVisible(false);
                      btnBack2.setVisible(false);
                      opTipoConta();
                    
             }
                      
        }
    };
    public void acessoContaCorrente(){
           telaConta();
    }
     public void acessoContaPoupanca(){
           telaConta2();
    }


}
