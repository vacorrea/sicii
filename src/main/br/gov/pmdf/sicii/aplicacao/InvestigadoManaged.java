package br.gov.pmdf.sicii.aplicacao;

import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import br.gov.pmdf.sicii.domain.entidade.Investigado;
import br.gov.pmdf.sicii.domain.repositorio.RepositorioInvestigado;


@Name("investigadoManaged")
@Scope(ScopeType.CONVERSATION)
public class InvestigadoManaged  {
		
	private Investigado investigado;	
	
	private Boolean statusConsulta = false; 
	
	private List<Investigado> investigadosConsultados;
	
	@In
	private RepositorioInvestigado repositorioInvestigado;	
	
	//@Restrict("#{s:hasRole('ADMINISTRADOR')}")
	public void pesquisarInvestigado() {
		investigadosConsultados = repositorioInvestigado.recuperarPorFragmento(investigado);
		setStatusConsulta(true);		
	}
	
	public void selecionarInvestigado(Investigado investigado) {
		
	}
	
	
	public void setStatusConsulta(Boolean statusConsulta) {
		this.statusConsulta = statusConsulta;
	}
	public Boolean getStatusConsulta() {
		return statusConsulta;
	}
	public List<Investigado> getInvestigadosConsultados() {
		return investigadosConsultados;
	}
}
