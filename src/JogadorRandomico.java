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
	public void escolherBaralho() {
		List<Baralho> baralhos = new ArrayList<>();
        baralhos.add(new Baralho("Baralho 1: Animais"));
        baralhos.add(new Baralho("Baralho 2: Astronomia"));
        baralhos.add(new Baralho("Baralho 3: Carros"));
        baralhos.add(new Baralho("Baralho 4: Deuses"));

        Random random = new Random();
        int escolha = random.nextInt(baralhos.size());

        this.monte = baralhos.get(escolha);
        
        System.out.println("Distribuindo baralho " + escolha + ".");
        
        //return tema - aqui tem que implementar a logica dle retornar o tema que foi escolhido aleatoriamente
	}

	@Override
	public void jogarTurno() {
		//implementar logica do jogador da vez: escolhe aleatoriamente atributo a ser comparado
	}
		
}
