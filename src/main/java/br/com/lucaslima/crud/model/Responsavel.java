package br.com.lucaslima.crud.model;

public enum Responsavel {
	
	CHEFE("Lucas"),
	GERENTE("Maria"),
	FUNCIONARIO1("Marcos"),
	FUNCIONARIO2("Joana"),
	ESTAGIARIO("João");
	
	private String descricao;
	
	Responsavel(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
