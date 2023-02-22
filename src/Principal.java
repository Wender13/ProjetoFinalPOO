public class Principal {
    public static void main(String[] args){
        //Variáveis para iniciar o jogo 
        Interfaces Jogo = new Interfaces(); //Cria uma interface simples, mas deixará o jogo mais visível
        String Tema;
        String jogadorReal;
        String jogadorAleatório;

        Jogo.exibirCarregamento();
        Jogo.escolhaDoTema();
        Tema = Jogo.setTema();
        // Jogo.setJogadores(); 
    }
}