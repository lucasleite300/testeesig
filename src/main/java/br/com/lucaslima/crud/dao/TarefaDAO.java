package br.com.lucaslima.crud.dao;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.lucaslima.crud.exception.NegocioException;
import br.com.lucaslima.crud.model.Responsavel;
import br.com.lucaslima.crud.model.Situacao;
import br.com.lucaslima.crud.model.Tarefa;

public class TarefaDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Tarefa salvar(Tarefa tarefa) {
		manager.getTransaction().begin();
		manager.merge(tarefa);
		manager.getTransaction().commit();
		return tarefa;
	}
	
	public void excluir(Tarefa tarefa) {
		try {
			manager.getTransaction().begin();
			tarefa = porId(tarefa.getId());
			manager.remove(tarefa);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {			
			throw new NegocioException("Tarefa não pode ser excluída");
		}
	}

	public Tarefa porId(Long id) {		
		return manager.find(Tarefa.class, id);
	}
	
	public List<Tarefa> listAll() {
		return manager.createNativeQuery("SELECT * FROM Tarefa", Tarefa.class).getResultList();
	}
	
	public List<Tarefa> findByFilter(Long id, String titulo, Responsavel responsavel, Situacao situacao) {
		
		String hql = "SELECT t FROM Tarefa t WHERE 1 = 1 ";
		
		// Busca por id, caso tenha sido informado
		if (id != null) {
			hql += "AND t.id = :id";
		}
		
 		// Busca por titulo, caso tenha sido informado
		if (titulo != null) {
			hql += " AND t.titulo LIKE :titulo";
		}
		
		// Busca por responsavel, caso tenha sido informado
		if (responsavel != null) {
			hql += " AND t.responsavel = :responsavel";
		}	
		
		// Busca por situacao, caso tenha sido informado
		if (situacao != null) {
			hql += " AND t.situacao = :situacao";
		}
		
		// Ordem alfabética
		hql += " ORDER BY t.id ASC";
		
		TypedQuery<Tarefa> q = manager.createQuery(hql, Tarefa.class);
		
		if (id != null) {
			q.setParameter("id", id);
		}
		
		if (titulo != null) {
			q.setParameter("titulo", "%" + titulo + "%");
		}
		
		if (responsavel != null) {
			q.setParameter("responsavel", responsavel);
		}
		
		if (situacao != null) {
			q.setParameter("situacao", situacao);
		}
		
		return q.getResultList().stream().distinct().collect(Collectors.toList());
	}

}
