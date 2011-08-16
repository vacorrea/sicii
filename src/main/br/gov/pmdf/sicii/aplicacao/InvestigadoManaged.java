package br.gov.pmdf.sicii.aplicacao;

import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;

import br.gov.pmdf.sicii.domain.entidade.Investigado;
import br.gov.pmdf.sicii.domain.repositorio.RepositorioInvestigado;


@Name("investigadoManaged")
@Scope(ScopeType.CONVERSATION)
public class InvestigadoManaged  {
	
	@In(create=true)
	private Investigado investigado;	
	
	@DataModel("investigadosConsultados")
	private List<Investigado> investigadosConsultados;
	
	private Boolean statusConsultaInvestigado = false;
	
	@In
	private RepositorioInvestigado repositorioInvestigado;	
	
	//@Restrict("#{s:hasRole('ADMINISTRADOR')}")
	public void pesquisarInvestigado() {		
		investigadosConsultados = repositorioInvestigado.recuperarTodos();
		System.out.println(investigado.getNome());
		setStatusConsultaInvestigado(true);
		//investigadosConsultados = repositorioInvestigado.recuperarPorFragmento(investigado);				
	}
	
	public void selecionarInvestigado(Investigado investigado) {
		
	}
	public void cadastrarInvestigado() {
		setStatusConsultaInvestigado(false);
		System.out.println(investigado);
		repositorioInvestigado.armazenar(investigado);
	}	
	
	public List<Investigado> getInvestigadosConsultados() {
		return investigadosConsultados;
	}
	public Investigado getInvestigado() {
		return investigado;
	}
	public void setInvestigado(Investigado investigado) {
		this.investigado = investigado;
	}
	public Boolean getStatusConsultaInvestigado() {
		return statusConsultaInvestigado;
	}
	public void setStatusConsultaInvestigado(Boolean statusConsultaInvestigado) {
		this.statusConsultaInvestigado = statusConsultaInvestigado;
	}
}
