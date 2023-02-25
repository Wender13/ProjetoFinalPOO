//@Authors: João Dinízio, Pedro, Vanderson e Wender

import java.util.List;

public abstract class JogadorAbstrato {
	protected String nome;
	protected Baralho monte;
	protected int pontuacao;
	protected Interfaces Interface;
	protected List<String> atributosDascartas;
	
	    
		
	public JogadorAbstrato(String nome, Interfaces Interface, List<String> atributosDascartas) {
		super();
		this.nome = nome;
		this.pontuacao = 0;
		this.Interface = Interface;
		this.atributosDascartas = atributosDascartas;
	}
	
	public abstract int jogarTurno();
	
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

	protected void setPontuacao(int pontuacao){//Apenas para debug, não pense em trapacear!!!
		this.pontuacao = pontuacao;
	}


	public void incrementarPontuacao() {
		this.pontuacao++;
	}
}
