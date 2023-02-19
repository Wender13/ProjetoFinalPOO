import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Baralho extends LinkedList<Carta> {
    private String tema;

    public Baralho(String tema){this.setTema(tema);}

    public void carregar(){
        JSONObject jsonObject; 
        
        //Parse de tratamento
        JSONParser parser = new JSONParser();
        
        //Variáveis que serão lidas do arquivo json
        String nome;
        String codigo;
        int atributo1;
        int atributo2;
        int atributo3;
        double atributo4;
        String unidadeAtributo1;
        String unidadeAtributo2;
        String unidadeAtributo3;
        String unidadeAtributo4;
        String curiosidade1;
        String curiosidade2;
        String curiosidade3;
        boolean superTrunfo;
        
        
        switch (tema) {
            case "animais":
                try {
                    //Salva no objeto JSONObject o que o parse tratou do arquivo
                    jsonObject = (JSONObject) parser.parse(new FileReader(
                            "animais.json"));
        
                    //Salva nas variaveis os dados retirados do arquivo
                    nome = (String) jsonObject.get("Nome");
                    codigo = (String) jsonObject.get("Código");
                    atributo1 = (int) jsonObject.get("Peso");
                    atributo2 = (int) jsonObject.get("Longevidade");
                    atributo3 = (int) jsonObject.get("Comprimento");
                    atributo4 = (int) jsonObject.get("Velocidade");
                    
                }
                //Trata as exceptions que podem ser lançadas no decorrer do processo
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            
                break;
            case "astronomia":
            FileReader reader = new FileReader("/src/Temas/astronomia.json");
            
            break;
            case "carros":
            FileReader reader = new FileReader("/src/Temas/carros.json");
            
            break;
            case "deuses":
            FileReader reader = new FileReader("/src/Temas/deuses.json");
                
                break;
            default:
                break;
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

    public String getTema(){return tema;}

    //Métodos Set

    private void setTema(String tema){this.tema = tema;}
}
