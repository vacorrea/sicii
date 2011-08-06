/**
 * Interface de Servi�o.<br>
 * Cont�m os m�todos de chamadas das Classes DAO.
 * 
 * @author Rog�rio Pinto & Vitor
 */

package br.gov.sicii.service.interfaces;

import java.util.List;

import br.gov.sicii.domain.BaseEntity;

public interface IBaseEntityService<B extends BaseEntity> {
    void inserir(B baseEntity);

    void alterar(B entidade);

    void remover(B entidade);

    List<B> consultar(B baseEntity);

    List<B> consultarTodos();

    B consultarPorId(Integer id);

}
