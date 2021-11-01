package br.com.lucaslima.crud.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lucaslima.crud.model.Responsavel;
import br.com.lucaslima.crud.model.Situacao;
import br.com.lucaslima.crud.model.Tarefa;
import br.com.lucaslima.crud.service.TarefaService;
import br.com.lucaslima.crud.util.FacesUtil;

@Named
@ViewScoped
public class ListaTarefaMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TarefaService tarefaService;
	
	private List<Tarefa> tarefas = new ArrayList<>();
	
	private List<Tarefa> tarefaSelecionadas = new ArrayList<>();
	
	//filtros para busca
	private Long filtroId;
	private String filtroTitulo;
	private Responsavel filtroResponsavel;
	private Situacao filtroSituacao;
	
	public void excluirSelecionados() {
		for (Tarefa tarefa : tarefaSelecionadas) {
			tarefaService.excluir(tarefa);
			tarefas.remove(tarefa);
		}
		
		FacesUtil.addInfoMessage("Tarefa(s) excluída(s) com sucesso!");
	}
	
	public void concluirSelecionados() {
		for (Tarefa tarefa : tarefaSelecionadas) {
			if(tarefa.getSituacao() == Situacao.CONCLUIDA) {
				FacesUtil.addInfoMessage("Tarefa "+ tarefa.getId() +" já foi concluida!");
			}else {
				tarefa.setSituacao(Situacao.CONCLUIDA);
				tarefaService.salvar(tarefa);
				FacesUtil.addInfoMessage("Tarefa(s) selecionada(s) concluida(s) com sucesso!");
			}
		}
	}
	
	public String busca(){
		tarefas = tarefaService.findByFilter(getFiltroId(), getFiltroTitulo(), getFiltroResponsavel(), getFiltroSituacao());
		return null;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public List<Tarefa> getTarefaSelecionadas() {
		return tarefaSelecionadas;
	}

	public void setTarefaSelecionadas(List<Tarefa> tarefaSelecionadas) {
		this.tarefaSelecionadas = tarefaSelecionadas;
	}

	public Long getFiltroId() {
		return filtroId;
	}

	public void setFiltroId(Long filtroId) {
		this.filtroId = filtroId;
	}

	public String getFiltroTitulo() {
		return filtroTitulo;
	}

	public void setFiltroTitulo(String filtroTitulo) {
		this.filtroTitulo = filtroTitulo;
	}

	public Responsavel getFiltroResponsavel() {
		return filtroResponsavel;
	}

	public void setFiltroResponsavel(Responsavel filtroResponsavel) {
		this.filtroResponsavel = filtroResponsavel;
	}

	public Situacao getFiltroSituacao() {
		return filtroSituacao;
	}

	public void setFiltroSituacao(Situacao filtroSituacao) {
		this.filtroSituacao = filtroSituacao;
	}	

}
