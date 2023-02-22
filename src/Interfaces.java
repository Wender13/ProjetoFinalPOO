//Essa classe será resposável por deixar o jogo ter uma interface mais visível e organizada, além de separar a parte mais visual separa da classe jogo 

//Edit.:

import java.util.Scanner;

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

    public void exibirCarregamento() {
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
        efeitoMaquinaDeEscrever("Concluído.", 70);;
    }

    //Essa classe só irá mostrar uma pequena apresentação no terminal, não é tão essencial
    public void Apresentacao(){
        //Início da parte estética
        try {
            Thread.sleep(2000); //Aguarda 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\033[H\033[2J"); //Limpa a saída do terminal, é só uma questão estética

        try {
            Thread.sleep(2000); //Aguarda 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Esse for dá o efeito de frase piscando, não é necessário, é algo estético
        for (int i = 0; i < 3; i++) {
            System.out.println("Bem-vindo ao Super Trunfo!\n");

            try {
                Thread.sleep(1000); //Aguarda 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("\033[H\033[2J");

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

        efeitoMaquinaDeEscrever("Escrito por João Dionísio, Pedro, Vanderson e Wender.", 50);
    }

    private int opcaoTema;

    public void escolhaDoTema() {
        String[] temas = {"Animais", "Astronomia", "Carros", "Deuses"};

        Apresentacao();

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        do { //Resposável por mostrar as opções e coletar somente as opções válidas
            System.out.println("\033[H\033[2J");
            efeitoMaquinaDeEscrever("Escolha um tema:", 50);
            System.out.println();
            efeitoMaquinaDeEscrever("1 - Animais", 50);
            System.out.println();
            efeitoMaquinaDeEscrever("2 - Astronomia", 50);
            System.out.println();
            efeitoMaquinaDeEscrever("3 - Carros", 50);
            System.out.println();
            efeitoMaquinaDeEscrever("4 - Deuses", 50);
            System.out.println();
            efeitoMaquinaDeEscrever("0 - Sair", 50);
            System.out.println();
            System.out.println();
            efeitoMaquinaDeEscrever("Opção: ", 50);

        try {
            opcao = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            //Não é um número válido
        }

        if (opcao <0 || opcao > 4) {
            System.out.println("\033[H\033[2J");

            try {
                Thread.sleep(1000); //Aguarda 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(opcao + " não é uma opção válida, selecione uma opção válida.");

            
            try {
                Thread.sleep(1000); //Aguarda 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.println("\033[H\033[2J");
        } else {
            if (opcao == 0) {
                System.out.println("O jogo foi encerrado.");

                try {
                    Thread.sleep(1500); //Aguarda 5 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("\033[H\033[2J");

                return  ;
            } else {
                System.out.println("O tema foi escolido foi: " + temas[opcao - 1] + ".");
                opcaoTema = opcao;

                try {
                    Thread.sleep(1500); //Aguarda 5 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("\033[H\033[2J");
                
            }
        }

        } while (opcao <0 || opcao > 4);
    }

    //Esse método será resposável por colocar o tema correto para a seleção do tema, assim evitará problemas com a classe baralho, já que a mesma escolhe o tema de acordo com a forma que as palavras estão escritas, no caso ela escolhe com as palavras escritas exatamente assim: "animais", "astronomia", "carros" e "deuses", um número, espaço ou letra maiúscula muda tudo
    public String setTema() {
        switch (opcaoTema) {
            case 1:
                return "animais";
            
            case 2:
                return "astronomia";

            case 3:
                return "carros";

            case 4:
                return "deuses";
        }
        return null;
    }

    //Esse método pegará o nome dos jogadores que o usuário escolher
    public String setJogadores(){
        return null;
    }
}
