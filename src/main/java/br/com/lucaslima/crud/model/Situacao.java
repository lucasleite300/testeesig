package br.com.lucaslima.crud.model;

public enum Situacao {
	
	EMANDAMENTO("Em andamento"),
	CONCLUIDA("Concluida");
	
	private String descricao;
	
	Situacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
