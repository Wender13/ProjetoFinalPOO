//@Authors: João Dinízio, Pedro, Vanderson e Wender

import java.util.List;
import java.util.Scanner;

public class JogadorReal extends JogadorAbstrato {
    public JogadorReal(String nome, Interfaces Interface, List<String> atributosDascartas) {
        super(nome, Interface,atributosDascartas);
    }
    
	@Override
	public int jogarTurno() {
		
		Scanner sc = new Scanner(System.in);
        String[] atributos = {atributosDascartas.get(0), atributosDascartas.get(1), atributosDascartas.get(2),atributosDascartas.get(3)};
        int opcao = 0;
        boolean entradaValida = false;
        
        //aqui o jogador pode escolher o tema e já está inserido o tratamento de erro
        while (!entradaValida) {
            try {
                Interface.limparTela(1500);

                Interface.efeitoMaquinaDeEscrever("Escolha o atributo a ser comparado:",50);
                System.out.println();
                System.out.println();
                Interface.efeitoMaquinaDeEscrever("1 - " + atributosDascartas.get(0),50);
                System.out.println();
                Interface.efeitoMaquinaDeEscrever("2 - " + atributosDascartas.get(1),50);
                System.out.println();
                Interface.efeitoMaquinaDeEscrever("3 - " + atributosDascartas.get(2),50);
                System.out.println();
                Interface.efeitoMaquinaDeEscrever("4 - " + atributosDascartas.get(3),50);
                System.out.println();
                System.out.println();
                Interface.efeitoMaquinaDeEscrever("Opção: ", 50);
                opcao = sc.nextInt();
                
                if (opcao >= 1 && opcao <= 4) {//Permite escolher apenas números de 1 a 4
                    entradaValida = true;
                } else {
                    Interface.limparTela(1000);
                    Interface.efeitoMaquinaDeEscrever("Opção inválida! Digite um número entre 1 e 4.",50);
                }
            } catch (Exception e) {
                Interface.limparTela(1000);
                Interface.efeitoMaquinaDeEscrever("Entrada inválida! Digite um número inteiro.",50);
                sc.next();
            }
        }
        
        //Mostra o atributo escolhido
        Interface.efeitoMaquinaDeEscrever(atributosDascartas.get(opcao - 1) + " escolhido.", 50);
        System.out.println("\n");

        return opcao;
    }   
}
