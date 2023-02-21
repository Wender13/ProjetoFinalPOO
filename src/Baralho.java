import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

//Biblioteca Jackson que será resposável por ler os arquivos Json
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class Baralho extends LinkedList<Carta> {

	private String Tema;

    public Baralho(String Tema) {this.Tema = Tema;}

    private File arquivoJson;
	
    public void carregar(){
        
        ObjectMapper Mapper = new ObjectMapper(); //JSON para Object

        switch (Tema) {
            case "animais": 
                arquivoJson = new File("animais.json");
                break;

            case "astronomia":
                arquivoJson = new File("astronomia.json");
                break;

            case "carros":
                arquivoJson = new File("carros.json");
                break;

            case "deuses":
                arquivoJson = new File("deuses.json");
                break;

            default: 
                System.out.println("Desculpe, o tema escolido não foi encontrado, selecione um tema válido...");
                arquivoJson = null;
                break;
        }
        
        try {
            
            if(arquivoJson != null){
                //Lê o arquivo JSON e cria um mapa de objetos
                Map<String, Object>[] objetos = Mapper.readValue(arquivoJson, Map[].class);
    
                //Atribui valor às variáveis cujo atributo tem o mesmo nome
                for (Map<String, Object> obj : objetos) {
                    String Nome = (String) obj.get("Nome");
                    String Código = (String) obj.get("Código");
                    String Curiosidade1 = (String) obj.get("Curiosidade1");
                    String Curiosidade2 = (String) obj.get("Curiosidade2");
                    String Curiosidade3 = (String) obj.get("Curiosidade3");
                    Boolean SuperTrunfo = (boolean) obj.get("SuperTrunfo");
    
                    Carta carta;
                    switch (Tema) {
                        case "animais":
                            int Atributo1 = (int) obj.get("Peso");
                            int Atributo2 = (int) obj.get("Velocidade");
                            int Atributo3 = (int) obj.get("Longevidade");
                            double Atributo4 = (double) obj.get("Comprimento");
    
                            carta = new Carta(Nome, Código, Atributo1, Atributo2, Atributo3, Atributo4, Curiosidade1, Curiosidade2, Curiosidade3, SuperTrunfo);
                            if (carta != null) {
                                this.add(carta);
                            }
                            break;
                    
                        case "astronomia":
                            int Atributo11 = (int) obj.get("Massa");
                            int Atributo21 = (int) obj.get("Densidade");
                            int Atributo31 = (int) obj.get("Diâmetro");
                            double Atributo41 = (double) obj.get("Temperatura");
    
                            carta = new Carta(Nome, Código, Atributo11, Atributo21, Atributo31, Atributo41, Curiosidade1, Curiosidade2, Curiosidade3, SuperTrunfo);
                            if (carta != null) {
                                this.add(carta);
                            }
                            break;
    
                        case "carros":
                            int Atributo12 = (int) obj.get("Potência");
                            int Atributo22 = (int) obj.get("Torque");
                            int Atributo32 = (int) obj.get("Cilindrada");
                            double Atributo42 = (double) obj.get("0-100");
    
                            carta = new Carta(Nome, Código, Atributo12, Atributo22, Atributo32, Atributo42, Curiosidade1, Curiosidade2, Curiosidade3, SuperTrunfo);
                            if (carta != null) {
                                this.add(carta);
                            }
                            break;
                    
                        case "deuses":
                            int Atributo13 = (int) obj.get("Força");
                            int Atributo23 = (int) obj.get("Velocidade");
                            int Atributo33 = (int) obj.get("Inteligência");
                            double Atributo43 = (double) obj.get("Poderes");
    
                            carta = new Carta(Nome, Código, Atributo13, Atributo23, Atributo33, Atributo43, Curiosidade1, Curiosidade2, Curiosidade3, SuperTrunfo);
                            if (carta != null) {
                                this.add(carta);
                            }
                            break;
    
                        default: System.out.println("Desculpe, o tema selecionado não existe, selecione um válido");
                            break;
                    }
                }
    
                
            } else {System.out.println("Erro fatal!!!");}

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo JSON");
            e.printStackTrace();
        }

    }

    // public void embaralhar(){Collections.shuffle(this);}

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

    // public void listarCartas(){System.out.println(this);}

    // public Carta pegarDoTopo(){
    //     if (this.peekLast() != null){return this.pollLast();}
    //     else {
    //         System.out.println("O monte não tem mais cartas!");
	// 	    return null;
    //     }   
    // }

    //Métodos Get
    public String getTema(){return Tema;}

    //Métodos Set
    private void setTema(String Tema){this.Tema = Tema;}
}