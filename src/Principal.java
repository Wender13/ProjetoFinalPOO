import java.util.LinkedList;
public class Principal {
    public static void main(String[] args){
        Baralho monte = new Baralho("astronomia");
        monte.carregar();
        monte.listarCartas(); 
    }
}