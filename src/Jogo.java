import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogo {

    public Jogo(){
    }

    private Interfaces Interface = new Interfaces(); //Essa classe será resposável pela parte visual do jogo
    private String Tema; //Tema que será usado para escolher as cartas
    private int opcaoTema; //Inteiro usado no método escolhaDoTema() para o jogador escolher
    private String nomeJogadorReal;
    private String nomeJogadorAleatório;


    public void Jogar(String Tema, Object JogadorReal, Object JogadorAleatório){
    }

    public void escolhaDoTema() {
        //Variáveis do método
        String[] temas = {"Animais", "Astronomia", "Carros", "Deuses"};
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        Interface.Apresentacao(); //Mostra a tela de inicialização do jogo


        do { //Resposável por mostrar as opções e coletar somente as opções válidas
            System.out.println("\033[H\033[2J");
            Interface.efeitoMaquinaDeEscrever("Escolha um tema:", 50);
            System.out.println();
            Interface.efeitoMaquinaDeEscrever("1 - Animais", 50);
            System.out.println();
            Interface.efeitoMaquinaDeEscrever("2 - Astronomia", 50);
            System.out.println();
            Interface.efeitoMaquinaDeEscrever("3 - Carros", 50);
            System.out.println();
            Interface.efeitoMaquinaDeEscrever("4 - Deuses", 50);
            System.out.println();
            Interface.efeitoMaquinaDeEscrever("0 - Sair", 50);
            System.out.println();
            System.out.println();
            Interface.efeitoMaquinaDeEscrever("Opção: ", 50);

            //Lê a próxima linha
            opcao = Integer.parseInt(scanner.nextLine());
        

        if (opcao <0 || opcao > 4) {
            System.out.println("\033[H\033[2J");

            try {
                Thread.sleep(1000); //Aguarda 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(opcao + " não é uma opção válida, selecione uma opção válida.");

            
            Interface.limparTela(1000);

        } else {
            if (opcao == 0) {
                System.out.println("O jogo foi encerrado.");

                Interface.limparTela(1500);

                return  ;
            } else {
                System.out.println("O tema foi escolido foi: " + temas[opcao - 1] + ".");
                opcaoTema = opcao;

                Interface.limparTela(1500);
                
            }
        }

        } while (opcao < 0 || opcao > 4);

        switch (opcaoTema) { //Converte a escolha de int para um String, assim evita problemas com Sensitive Cases
            case 1:
                Tema = "animais";
            
            case 2:
                Tema = "astronomia";

            case 3:
                Tema = "carros";

            case 4:
                Tema = "deuses";
        }
    }

    private String nomeAleatório() throws IOException{ //Seleciona um nome aleatório
        //Abre o arquivo CSV
        BufferedReader leitor = new BufferedReader(new FileReader("temas/nomes.csv"));

        //Lê todos os nomes do arquivo e armazená-los em uma lista
        List<String> nomes = new ArrayList<>();
        String linha;
        while ((linha = leitor.readLine()) != null) {
            String[] valores = linha.split(",");
            nomes.add(valores[0] + " " + valores[1]);
        }

        //Escolhe um nome aleatório da lista
        Random random = new Random();
        String nomeAleatorio = nomes.get(random.nextInt(nomes.size()));

        //Fecha o leitor
        leitor.close();
        return nomeAleatorio;
    }

    //Esse método pegará o nome dos jogadores que o usuário escolher
    public void setJogadores(){
        Scanner sc = new Scanner(System.in);
        int escolhaDoJogador;

        Interface.efeitoMaquinaDeEscrever("Digite seu nome: ", 50);

        nomeJogadorReal = sc.nextLine(); //Lê o nome do jogador
        
        Interface.limparTela(1500);

        Interface.efeitoMaquinaDeEscrever("\nBem-vindo, " + nomeJogadorReal + "!", 50);

        Interface.limparTela(2000);

        do {

        Interface.efeitoMaquinaDeEscrever("Deseja escolher o nome de seu adversário?", 30);

        System.out.println();
        System.out.println();

        Interface.efeitoMaquinaDeEscrever("(0)Não      (1)Sim", 30);

        System.out.println();
        System.out.println();
        
            escolhaDoJogador = Integer.parseInt(sc.nextLine());

            if (escolhaDoJogador == 0) {//Aqui será decidido se o nome do adversário vai ser selecionado pelo jogador ou pelo algoritmo, isso vai depender da reposta do jogador

                Interface.limparTela(1500);

                Interface.efeitoMaquinaDeEscrever("Sem problemas, deixe isso com a gente.", 50);

                try {
                    nomeJogadorAleatório = nomeAleatório();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                do {//O looping serve para impedir que o jogo continue se os nomes dos jogadores forem iguais
                    Interface.limparTela(1500);

                    try {
                        nomeJogadorAleatório = nomeAleatório();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } while (nomeJogadorAleatório.equals(nomeJogadorReal));

                Interface.efeitoMaquinaDeEscrever("Você jogará contra " + nomeJogadorAleatório + "!", 50);
                System.out.println();
                Interface.efeitoMaquinaDeEscrever("Tenha um ótimo jogo!", 50);
            } else if (escolhaDoJogador == 1){
                do {//O looping serve para impedir que o jogo continue se os nomes dos jogadores forem iguais
                    Interface.limparTela(1000);

                    Interface.efeitoMaquinaDeEscrever("Certo, como seu adversário se chama?", 50);

                    System.out.println();
                    System.out.println();

                    nomeJogadorAleatório = sc.nextLine();

                    if (nomeJogadorAleatório.equals(nomeJogadorReal)) {
                        Interface.limparTela(1000);
                        Interface.efeitoMaquinaDeEscrever("O nome dos jogadores não podem ser iguais, digite um diferente!", 50);
                    }

                } while (nomeJogadorAleatório.equals(nomeJogadorReal));

                Interface.limparTela(1500);

                Interface.efeitoMaquinaDeEscrever("Você jogará contra " + nomeJogadorAleatório + "!", 50);
                System.out.println();
                Interface.efeitoMaquinaDeEscrever("Tenha um ótimo jogo!", 50);
            } else {
                Interface.limparTela(1500);
                Interface.efeitoMaquinaDeEscrever("Digite uma opção válida!", 50);
            }
            
        } while (escolhaDoJogador < 0 || escolhaDoJogador > 1);

        System.out.println();

        //Falta criar os objetos jogadores
    }
}