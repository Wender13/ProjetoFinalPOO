import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogadorRandomico extends JogadorAbstrato {
	
    public JogadorRandomico(String nome, Interfaces Interface, List<String> atributosDascartas) {
		super(nome, Interface, atributosDascartas);
        this.nome = nome;
        this.pontuacao = 0;
	}

	@Override
	public int jogarTurno() {
		Random random = new Random();
        int numeroAleatorio = random.nextInt(4); //escolhe aleatoriamente, na sua vez, um dos 4 atributos

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
        
        //aqui mostra qual o atributo que vai ser comparado na vez do jogadorRandomico
        Interface.efeitoMaquinaDeEscrever("Atributo " + atributosDascartas.get(numeroAleatorio - 1) + " foi escolhido por " + this.nome + ".", 35);
        
        Interface.limparTela(1500);
        
        return numeroAleatorio;
	}
}
