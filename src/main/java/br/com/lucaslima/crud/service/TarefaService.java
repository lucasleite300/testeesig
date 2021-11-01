package br.com.lucaslima.crud.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.lucaslima.crud.dao.TarefaDAO;
import br.com.lucaslima.crud.model.Responsavel;
import br.com.lucaslima.crud.model.Situacao;
import br.com.lucaslima.crud.model.Tarefa;

public class TarefaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TarefaDAO tarefaDAO;	
	
	public void salvar(Tarefa tarefa) {
		if (tarefa.isInclusao()) {
			tarefa.setCriacao(new Date());
			//Todo cadastro gera uma situação em andamento
			tarefa.setSituacao(Situacao.EMANDAMENTO);
		}
		
		if (tarefa.isEdicao()) {
			tarefa.setEdicao(new Date());
		}
		
		tarefaDAO.salvar(tarefa);
	}
	
	public void excluir(Tarefa tarefa) {
		tarefaDAO.excluir(tarefa);
	}
	
	
	public List<Tarefa> listAll() {
		return tarefaDAO.listAll();
	}
	
	public Tarefa porId(Long id) {
		return tarefaDAO.porId(id);
	}
	
	public List<Tarefa> findByFilter(Long id, String titulo, Responsavel responsavel, Situacao situacao) {
		return tarefaDAO.findByFilter(id, titulo, responsavel, situacao);
	}

}
