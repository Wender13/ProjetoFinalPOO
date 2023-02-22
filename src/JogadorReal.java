import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JogadorReal extends JogadorAbstrato {
    public JogadorReal(String nome) {
        super(nome);
    }
    
	@Override
	public void jogarTurno() {
		
		Scanner sc = new Scanner(System.in);
        String atributoEscolhido = null;
        String[] atributos = {"Atributo 1", "Atributo 2", "Atributo 3", "Atributo 4"};
        int opcao = 0;
        boolean entradaValida = false;
        
        //aqui o jogador pode escolher o tema e já está inserido o tratamento de erro
        while (!entradaValida) {
            try {
                System.out.println("Escolha o atributo a ser comparado:");
                System.out.println("1 - Atributo 1");
                System.out.println("2 - Atrinuto 2");
                System.out.println("3 - Atributo 3");
                System.out.println("4 - Atributo 4");
                opcao = sc.nextInt();
                
                if (opcao >= 1 && opcao <= 4) {
                    atributoEscolhido = atributos[opcao-1];
                    entradaValida = true;
                } else {
                    System.out.println("Opção inválida! Digite um número entre 1 e 4.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite um número inteiro.");
                sc.next();
            }
        }
        
        System.out.println(atributoEscolhido + " escolhido.");
    }   
}
