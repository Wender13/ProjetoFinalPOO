public class JogadorRandomico {
  private static final String[] nomes = {"Fulano", "Ciclano"};
	
    public JogadorRandomico(String nome) {
		super(nome);
		Random random = new Random();
        int index = random.nextInt(nomes.length);
        this.nome = nomes[index];
        this.pontuacao = 0;
	}
	
	@Override
	public void jogar() {
		//Implementar logica jogador randomico
	}
}
