import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Baralho extends LinkedList<Carta> {
    private String tema;

    public Baralho(String tema){this.setTema(tema);}

    public void carregar(){
        
        //Arquivo que será selecionado de acordo com o tema
        String arquivoTema = null;
        
        switch (tema) {
            case "animais":
                    arquivoTema = "animais.json";

                    try {

                        //Criação do parser
                        JSONParser parser = new JSONParser();
            
                        //Cria uma Array com base no arquivo do Tema
                        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(arquivoTema));
            
                        for (Object o : jsonArray) {
                            JSONObject jsonObject = (JSONObject) o;
                            
                            //Variáveis que serão lidas do arquivo json
                            String nome = (String) jsonObject.get("Nome");
                            String codigo = (String) jsonObject.get("Código");
                            int atributo1 = (int) jsonObject.get("Peso");
                            int atributo2 = (int) jsonObject.get("Longevidade");
                            int atributo3 = (int) jsonObject.get("Velocidade");
                            double atributo4 = (double) jsonObject.get("Comprimento");
                            String curiosidade1 = (String) jsonObject.get("Curiosidade1"); 
                            String curiosidade2 = (String) jsonObject.get("Curiosidade2");
                            String curiosidade3 = (String) jsonObject.get("Curiosidade3");
                            boolean superTrunfo = (Boolean) jsonObject.get("SuoerTrunfo");
            
                            this.add(new Carta(nome, codigo, atributo1, atributo2, atributo3, atributo4, curiosidade1, curiosidade2, curiosidade3, superTrunfo));
            
                        }
                    } catch (IOException | ParseException e) {
                        e.printStackTrace();
                    }
                break;

            case "astronomia":
                arquivoTema = "astronomia.json";
                break;

            case "carros":
                arquivoTema = "carros.json";
                break;

            case "deuses":
                    arquivoTema = "deuses.json";
                break;
            default:
                System.out.println("Desculpe, o tema escolido não foi encontrado, selecione um tema valido...");
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
