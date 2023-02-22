import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JogadorReal extends JogadorAbstrato {
    public JogadorReal(String nome) {
        super(nome);
    }
    
	@Override
   public void escolherBaralho() {
		List<Baralho> baralhos = new ArrayList<>();
        baralhos.add(new Baralho("Baralho 1"));
        baralhos.add(new Baralho("Baralho 2"));
        baralhos.add(new Baralho("Baralho 3"));
        baralhos.add(new Baralho("Baralho 4"));

        Scanner scanner = new Scanner(System.in);
        int escolha = 0;

        while (escolha < 1 || escolha > baralhos.size()) {
<<<<<<< HEAD
    		System.out.println("Baralhos disponíveis:\n\nBaralho 1: Animais\nBaralho 2: Astronomia\nBaralho 3: Carros\nBaralho 4: Deuses\n\n" + nome + ", escolha o número de um baralho disponível:");
=======
    		System.out.println("Baralhos disponÃ­veis:\n\nBaralho 1: Animais\nBaralho 2: Astronomia\nBaralho 3: Carros\nBaralho 4: Deuses\n\n" + nome + ", escolha o nÃºmero de um baralho disponÃ­vel:");
>>>>>>> 667a8496268393d68254edb74c3c92593d0fc6f4
            escolha = scanner.nextInt();
        }

        this.monte = baralhos.get(escolha - 1);
        
        System.out.println("Distribuindo baralho " + escolha + ".");
        
        // return tema - implementar logica para que retorne o tema escolhido
	}

	@Override
	public void jogarTurno() {
		// implementar logica do jogador da vez: escolher atributo a ser comparado
		
	}
 }
<<<<<<< HEAD

=======
>>>>>>> 667a8496268393d68254edb74c3c92593d0fc6f4
