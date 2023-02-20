public class JogadorAbstrato {
  private String nome;
	private Baralho monte;
	private int pontuacao;
	    
		
	public JogadorAbstrato(String nome) {
		super();
		this.nome = nome;
	}
	
	public void incrementarPontuacao() {
	        this.pontuacao++;
	}
  
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Baralho getMonte() {
		return monte;
	}

	public void setMonte(Baralho monte) {
		this.monte = monte;
	}


	public int getPontuacao() {
		return pontuacao;
	}


	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

}
