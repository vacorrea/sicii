package br.gov.sicii.service.impl;

import java.util.List;

import br.gov.sicii.dao.interfaces.IBaseEntityDAO;
import br.gov.sicii.domain.BaseEntity;
import br.gov.sicii.service.interfaces.IBaseEntityService;

/**
 * Classe de servi�o abstrata.<br>
 * Todas as classes de servi�o devem derivar desta.
 * 
 * @author Nairon Nunes da Silva
 */
public abstract class AbstractBaseEntityService<B extends BaseEntity> implements IBaseEntityService<B>{

	private IBaseEntityDAO<B> dao;

	@Override
	public List<B> consultar(B baseEntity) {
		return getDao().consultar(baseEntity);
	}

	@Override
	public List<B> consultarTodos() {
		return getDao().consultarTodos();
	}

	@Override
	public B consultarPorId(Integer id) {
		return getDao().consultarPorId(id);
	}

	@Override
	public void inserir(B baseEntity){
		aplicarRegrasNegocioAntes(baseEntity);
		getDao().inserir(baseEntity);
		aplicarRegrasNegocioDepois(baseEntity);
	}

	@Override
	public void alterar(B baseEntity) {
		aplicarRegrasNegocioAntes(baseEntity);
		getDao().alterar(baseEntity);
	}

	@Override
	public void remover(B baseEntity){
		getDao().remover(baseEntity);
	}

	/**
	 * M�todo <u>opcional</u> respons�vel por aplicar regras de neg�cio antes de inserir ou alterar alguma entidade
	 * @param entidade
	 */
	protected void aplicarRegrasNegocioAntes(B baseEntity){

	}
	
	/**
	 * M�todo <u>opcional</u> respons�vel por aplicar regras de neg�cio ap�s inserir alguma entidade
	 * @param entidade
	 */
	protected void aplicarRegrasNegocioDepois(B baseEntity){

	}
	
	public IBaseEntityDAO<B> getDao() {
		return dao;
	}

	public void setDao(IBaseEntityDAO<B> dao) {
		this.dao = dao;
	}
}
