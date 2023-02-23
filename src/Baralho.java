import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Baralho extends LinkedList<Carta> {

	private Carta Carta;
	private String Tema;
	private String nomeArquivo = null;
	private InputStream Fluxo = null;
	private InputStreamReader Leitor = null;
	BufferedReader leitorComBuffered = null;



    public Baralho(String Tema) {
        this.Tema = Tema;
    }
	
    public void carregar(){ //Mpetodo que criará as cartas
        switch (Tema) {
            case "animais":
            nomeArquivo = "temas/animais.csv";
                break;

            case "astronomia":
                nomeArquivo = "temas/astronomia.csv";
                break;
            case "carros":
            nomeArquivo = "temas/carros.csv";
                break;

            case "deuses":
                nomeArquivo = "temas/deuses.csv";
                break;
            default: System.out.println("Este tema não existe, selecione um válido!");
                break;
        }

        if(nomeArquivo != null) {
			try{
				Fluxo = new FileInputStream(nomeArquivo);
				Leitor = new InputStreamReader(Fluxo);
				leitorComBuffered = new BufferedReader(Leitor);

				String Linha = leitorComBuffered.readLine();
				Linha = leitorComBuffered.readLine();

				while(Linha != null) {
					String[] Atributo = Linha.split(",");
                    int Atributo2 = Integer.valueOf(Atributo[2]);
                    int Atributo3 = Integer.valueOf(Atributo[3]);
                    double Atributo4 = Double.valueOf(Atributo[4]);
                    int Atributo5 = Integer.valueOf(Atributo[5]);
                    Boolean Atributo9 = Boolean.valueOf(Atributo[9]);

					//Criação das cartas
					this.add(new Carta(Atributo[0], Atributo[1], Tema, Atributo2, Atributo3, Atributo4, Atributo5, Atributo[6], Atributo[7], Atributo[8], Atributo9));
					Linha = leitorComBuffered.readLine();
				}

			}
			catch(FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}
			finally {
				try {
					leitorComBuffered.close();
				}
				catch(IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}else {
			System.out.println("Esse tema não é válido. Próximo!");
		}
    }

    public void embaralhar(){Collections.shuffle(this);}

    // public void distribuir(Jogador[] jogadores) {
	// 	int jogador = 0;
	// 	Iterator<Carta> iterador = this.iterator();
		
	// 	while ( iterador.hasNext() ) {
	// 		if (jogadores[jogador].getMonte() == null){jogadores[jogador].setMonte(new Baralho(this.tema));}
			
	// 		jogadores[jogador].getMonte().add(iterador.next());
	// 		iterador.remove();

	// 		jogador = (jogador + 1) % jogadores.length;  
	// 	}
	// }

    protected void listarCartas(){
		for (Carta carta : this) {
			System.out.println(carta);
			System.out.println("\n");
		}
	}

    protected Carta pegarDoTopo(){
        if (this.peekLast() != null){return this.pollLast();}
        else {
            System.out.println("O monte não tem mais cartas!");
		    return null;
        }   
    }

    //Métodos Get
    public String getTema(){return Tema;}
    protected List<String> getAtributos(){return this.get(0).getListaDeAtributos();} //Retorna o nome dos atributos e das unidades de medida que variam de acordo com cada tema

    //Métodos Set
    private void setTema(String Tema){this.Tema = Tema;}
}