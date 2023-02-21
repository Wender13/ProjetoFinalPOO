import java.util.LinkedList;
public class Principal {
    public static void main(String[] args){
        Baralho monte = new Baralho("deuses");
        monte.carregar();
        monte.listarCartas(); 
    }
}