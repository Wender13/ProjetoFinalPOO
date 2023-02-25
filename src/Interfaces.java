//@Authors: João Dinízio, Pedro, Vanderson e Wender
//Essa classe será resposável por deixar o jogo ter uma interface mais visível e organizada, além de separar a parte mais visual da classe jogo, onde ela atuará em conjunto à classe jogo

public class Interfaces {
    //Acho que o nome é bem sugestivo, algo estético
    public void efeitoMaquinaDeEscrever(String Frase, int Tempo){
        String frase = Frase;
        int tempo = Tempo;

        for (int i = 0; i < frase.length(); i++) {
            System.out.print(frase.charAt(i));
            try {
                Thread.sleep(tempo); //Espera um tempo determinado em milissegundos entre cada caractere.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void limparTela(int tempo){ //Aguarda um tempo específico em milissegundos e limpa a tela
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\033[H\033[2J");
    }

    //Essa classe só irá mostrar uma pequena apresentação no terminal, não é tão essencial
    public void Apresentacao(){
        //Início da parte estética, nesse início mostra uma tela simples de carregamento
        System.out.println("\033[H\033[2J");//Limpa o terminal
        efeitoMaquinaDeEscrever("Carregando ",70);
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000); //Aguarda 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(". ");
        }
        efeitoMaquinaDeEscrever("Concluído.", 70);

        limparTela(2000);

        try {
            Thread.sleep(2000); //Aguarda 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Fim da tela de carregamento

        //Esse for dá o efeito de frase piscando, não é necessário, é algo estético
        for (int i = 0; i < 3; i++) {
            System.out.println("Bem-vindo ao Super Trunfo!\n");

            limparTela(1000);

            try {
                Thread.sleep(1000); //Aguarda 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(1000); //Aguarda 1 segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Fim da parte estética

        //Apresentação dos alunos

        System.out.println();
        //Exibe o nome dos criadores
        efeitoMaquinaDeEscrever("Escrito por João Dionísio, Pedro, Vanderson e Wender.", 50);

        try {
            Thread.sleep(1000); //Aguarda 1 segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}