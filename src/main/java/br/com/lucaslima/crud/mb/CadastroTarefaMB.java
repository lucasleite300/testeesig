package br.com.lucaslima.crud.mb;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lucaslima.crud.model.Tarefa;
import br.com.lucaslima.crud.service.TarefaService;
import br.com.lucaslima.crud.util.FacesUtil;

@Named
@ViewScoped
public class CadastroTarefaMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Tarefa tarefa = new Tarefa();
	
	private Long idTarefa;
	
	@Inject
	private TarefaService tarefaService;
	
	
	public void inicializar() {
		if (idTarefa != null) {
			tarefa = tarefaService.porId(idTarefa);
		}
	}
	
	
	public String salvar() {
		Date hoje = new Date();
		if (tarefa.getDeadline().before(hoje)) {
			FacesUtil.addInfoMessage("Erro: Deadline não pode ser uma data anterior a hoje");		
		}else {
			tarefaService.salvar(tarefa);
		}
		if(tarefa.isEdicao()) {
			return "lista-tarefa.xhtml?faces-redirect=true";
		}
		return "/index.xhtml";
	}
	
	public String excluir() {
		tarefaService.excluir(tarefa);
		return "lista-tarefa.xhtml?faces-redirect=true";
	}

	public String voltar() {
		if(tarefa.isEdicao()) {
			return "lista-tarefa.xhtml?faces-redirect=true";
		}
		return "/index.xhtml";
	}

	public Tarefa getTarefa() {
		return tarefa;
	}


	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}


	public Long getIdTarefa() {
		return idTarefa;
	}


	public void setIdTarefa(Long idTarefa) {
		this.idTarefa = idTarefa;
	}

}
