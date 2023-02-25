//@Authors: João Dinízio, Pedro, Vanderson e Wender

import java.util.List;
import java.util.Random;

public class JogadorRandomico extends JogadorAbstrato {
	
  protected int opcao;

    public JogadorRandomico(String nome, Interfaces Interface, List<String> atributosDascartas) {
		super(nome, Interface, atributosDascartas);
	}

	@Override
	public int jogarTurno() {
		Random random = new Random();
    boolean entradaValida = false;
    
    Interface.limparTela(1500);
    
    Interface.efeitoMaquinaDeEscrever("Aguarde o seu adversário escolher um atributo.", 50); 
    
    Interface.limparTela(1500);
    
    //Mostra uma pequena animação de que o jogador está escolhendo
    Interface.efeitoMaquinaDeEscrever(nome + " está escolhendo",50);
    for (int i = 0; i < 5; i++) {
          try {
                Thread.sleep(1000); //Aguarda 1 segundo
            } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.print(". ");
          }
          
          Interface.limparTela(1300);

    while (!entradaValida) {
      int numeroAleatorio = random.nextInt(4); //escolhe aleatoriamente, na sua vez, um dos 4 atributos
      try {
        if (numeroAleatorio >= 1 && numeroAleatorio <= 4) {
          entradaValida = true;
      }
      } catch (Exception e) {
        // TODO: handle exception
      }
      opcao = numeroAleatorio;
    }
        
        //aqui mostra qual o atributo que vai ser comparado na vez do jogadorRandomico
        Interface.efeitoMaquinaDeEscrever("Atributo " + atributosDascartas.get(opcao-1) + " foi escolhido por " + this.nome + ".", 35);
        
        Interface.limparTela(1500);
        
        return opcao;
	}
}
