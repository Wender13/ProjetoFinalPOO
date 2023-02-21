public abstract class JogadorAbstrato {
	protected String nome;
	private Baralho monte;
	protected int pontuacao;
	    
		
	public JogadorAbstrato(String nome) {
		super();
		this.nome = nome;
		this.pontuacao = 0;
	}
	
	public abstract void jogar();
	
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
