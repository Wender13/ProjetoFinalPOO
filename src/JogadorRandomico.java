import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogadorRandomico extends JogadorAbstrato {
  private static final String[] nomes = {"Fulano", "Ciclano"};
	
    public JogadorRandomico(String nome) {
		super(nome);
		Random random = new Random(); 
        int index = random.nextInt(nomes.length);
        this.nome = nomes[index];
        this.pontuacao = 0;
	}

	@Override
	public void jogarTurno() {
		Random random = new Random();
        int numeroAleatorio = random.nextInt(4); //escolhe aleatoriamente, na sua vez, um dos 4 atributos
        
        //aqui mostra qual o atributo que vai ser comparado na vez do jogadorRandomico
        if(numeroAleatorio == 0) {
        	System.out.println("Atributo 1 foi escolhido pelo jogador Adversário.");
        } else if(numeroAleatorio == 1) {
        	System.out.println("Atributo 2 foi escolhido pelo jogador Adversário.");
        } else if(numeroAleatorio == 2) {
        	System.out.println("Atributo 3 foi escolhido pelo jogador Adversário.");
        } else if(numeroAleatorio == 3) {
        	System.out.println("Atributo 4 foi escolhido pelo jogador Adversário.");
        } else {
        	System.out.println("Atributo 1 foi escolhido pelo jogador Adversário.");
        }
	}
}
	
