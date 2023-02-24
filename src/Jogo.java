import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogo {

    private Interfaces Interface = new Interfaces(); //Essa classe será resposável pela parte visual do jogo
    private String Tema; //Tema que será usado para escolher as cartas
    private int opcaoTema; //Inteiro usado no método escolhaDoTema() para o jogador escolher
    private String nomeJogadorReal;
    private String nomeJogadorAleatório;
    private JogadorRandomico jogadorRandomico;
    private JogadorReal jogadorReal;
    private Baralho Monte;
    private List<String> atributosDascartas;




    public void Jogar(){//Método responsável por chamar os métodos de criação dos jogadores, seleção do tema e lógica do jogo
        int Continuar = 1;

        Interface.Apresentacao(); //Mostra a tela de inicialização do jogo

        do {
            Interface.limparTela(1500);

            //Configuração dos elementos
            escolhaDoTema();
            configurarJogadores();

            //Variáveis para que o jogo funcione
            ArrayList listaDeJogadores = new ArrayList<JogadorAbstrato>(); //Jogadores
            Random random = new Random(); //Aleatoriedade para o primeiro que for jogar
            int jogadorDaVez = random.nextInt(2); //Quem irá jogar na próxima vez
            Carta cartaJogador1;
            Carta cartaJogador2;
            String vencedorRodada;
            String vencedorJogo;
            String atributoEscolhido;
            
            //Distribuição das cartas
            listaDeJogadores.add(jogadorReal);
            listaDeJogadores.add(jogadorRandomico);
            Monte.distribuir(listaDeJogadores);

            //Mostra quem vai começar o jogo
            if (jogadorDaVez == 0) {Interface.efeitoMaquinaDeEscrever(jogadorReal.getNome() + " comecará o jogo!", 50);} else {Interface.efeitoMaquinaDeEscrever(jogadorRandomico.getNome() + " comecará o jogo!", 50);}

            Interface.limparTela(1500);

            // Interface.efeitoMaquinaDeEscrever(, 50);
            while (jogadorReal.getMonte().isEmpty() == false || jogadorRandomico.getMonte().isEmpty() == false) {
                if (jogadorDaVez == 0) {
                    atributoEscolhido = jogadorReal.jogarTurno();
                    jogadorDaVez = 1;
                } else {
                    atributoEscolhido = jogadorRandomico.jogarTurno();
                    jogadorDaVez = 0;
                }

                cartaJogador1 = jogadorReal.getMonte().peekFirst(); //Pega primeira carta do monte
                jogadorReal.getMonte().removeFirst(); //Remove primeira carta do monte

                cartaJogador2 = jogadorRandomico.getMonte().getFirst(); //Pega primeira carta do monte
                jogadorRandomico.getMonte().removeFirst(); //Remove primeira carta do monte

                // if (cartaJogador1) {
                    
                // }

                //finalizar a lógica do jogo
            }

        } while (Continuar == 1);
        
    }

    public void escolhaDoTema() {
        //Variáveis do método
        String[] temas = {"Animais", "Astronomia", "Carros", "Deuses"};
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

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

        } while (opcao < 0 || opcao > 4); //Isso corrigirá aquela questão do 0 ser considerado o primeiro

        switch (opcaoTema) { //Converte a escolha de int para um String, assim evita problemas com Sensitive Cases
            case 1:
                Tema = "animais";
                break;
            case 2:
                Tema = "astronomia";
                break;
            case 3:
                Tema = "carros";
                break;
            case 4:
                Tema = "deuses";
        }

        //Criação do monte de acordo com o tema selecionado
        Monte = new Baralho(Tema);
        Monte.carregar();
        atributosDascartas = Monte.getAtributos();
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
    public void configurarJogadores(){
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
            
            //Aqui será decidido se o nome do adversário vai ser selecionado pelo jogador ou pelo algoritmo, isso vai depender da reposta do jogador
            if (escolhaDoJogador == 0) {//Caso jogador não queira decidir o nome do adversário

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
            } else if (escolhaDoJogador == 1){ //Caso jogador queira decidir o nome do adversário

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
                Interface.efeitoMaquinaDeEscrever("Tenha um ótimo jogo!", 50); //Se a opção for válida
            } else { //Se a não opção for válida
                Interface.limparTela(1500);
                Interface.efeitoMaquinaDeEscrever("Digite uma opção válida!", 50);
            }
            
        } while (escolhaDoJogador < 0 || escolhaDoJogador > 1);

        System.out.println();

        //Criação dos Jogadores
        jogadorRandomico = new JogadorRandomico(nomeJogadorAleatório, Interface, atributosDascartas);
        jogadorReal = new JogadorReal(nomeJogadorReal, Interface, atributosDascartas);
    }

    public void teste(){
        String x;
        System.out.println(x = jogadorReal.jogarTurno());
    }
}