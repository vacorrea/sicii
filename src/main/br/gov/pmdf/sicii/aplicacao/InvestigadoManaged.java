package br.gov.pmdf.sicii.aplicacao;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.datamodel.DataModel;

import br.gov.pmdf.sicii.domain.entidade.Investigado;
import br.gov.pmdf.sicii.domain.entidade.Usuario;
import br.gov.pmdf.sicii.domain.repositorio.RepositorioInvestigado;
import br.gov.pmdf.sicii.domain.service.impl.InvestigadoServiceImpl;

@Name("investigadoManaged")
public class InvestigadoManaged  {
	
	@In(scope=ScopeType.SESSION)
	private Usuario usuarioLogado;
	
	@In(create=true) @Out(required=false)
	private Investigado investigado;	
		
	@DataModel
	private List<Investigado> investigadosConsultados;
		
	@In
	private RepositorioInvestigado repositorioInvestigado;	
	
	
	//@Restrict("#{s:hasRole('ADMINISTRADOR')}")	
	public void pesquisarInvestigado() {
		//investigadosConsultados = repositorioInvestigado.recuperarTodos();		
		investigadosConsultados = repositorioInvestigado.recuperarPorFragmento(investigado);				
	}
	@Factory("investigadosConsultados")
	public void factoryInvestigadosConsultados() {
		investigadosConsultados = repositorioInvestigado.recuperarTodos();
	}
	public String alterarInvestigado(Investigado investigado) {
		InvestigadoServiceImpl investigadoService = new InvestigadoServiceImpl();
		if( investigadoService.isCandidatoValido(investigado) ) {			
			investigado.setAlteradoPor(usuarioLogado);
			investigado.setAlteradoEm(new Date());
			repositorioInvestigado.armazenar(investigado);			
			FacesContext.getCurrentInstance().addMessage("global",new FacesMessage("Investigado Alterado com Sucesso"));
			return "sucess";					
		}
		return "fail";		
	}
	public void excluirInvestigado(Investigado investigado) {
		repositorioInvestigado.remover(investigado);
		FacesMessage facesMessage = new FacesMessage("Investigado Removido com Sucesso");
		FacesContext.getCurrentInstance().addMessage("global",facesMessage);		
	}
	public String cadastrarInvestigado() {		
		InvestigadoServiceImpl investigadoService = new InvestigadoServiceImpl();
		if( investigadoService.isCandidatoValido(investigado) ) {
			investigado.setCadastradoPor(usuarioLogado);
			investigado.setCadastradoEm(new Date());
			investigado.setAlteradoPor(usuarioLogado);
			investigado.setAlteradoEm(new Date());
			repositorioInvestigado.armazenar(investigado);
			investigado = null;
			return "sucess";					
		}		
		return "fail";
		
	}	
	
		
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
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
}
