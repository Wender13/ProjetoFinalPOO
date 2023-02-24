import java.util.Random;

public class Principal {//Toda a lógica e interface de apresentação foi transferida para a classe Jogo que possui auxílio da classe Interfaces para não ter que fazer a parte visual do terminal dentro da classe jogo3
    public static void main(String[] args){
        Jogo Jogo = new Jogo();
        Jogo.Jogar();
        // Jogo.escolhaDoTema();
        // Jogo.configurarJogadores();
        // JogadorAbstrato teste = Jogo.teste1();
        // teste.jogarTurno();
    }
}