/**
 * Classe TipoEmbasamento
 * OBJETIVO: Representar os Tipos de Embasamento das Pesquisas realizadas pelos Agentes
 * AUTORES: Rog�rio & Vitor
 */

package br.gov.sicii.domain;

import java.util.Date;

public class TipoEmbasamento extends BaseEntity {
	
	private static final long serialversionUID = 1L;
	
	private Integer tipEmbasamento;
	private String sigla;
	private String descricao;
	private Date cadastradoEm;
	private Date alteradoEm;
	private Integer cadastradoPor;
	private Integer alteradoPor;
	
	public TipoEmbasamento() {

	}

	//get and set
	public Integer getTipEmbasamento() {
		return tipEmbasamento;
	}

	public void setTipEmbasamento(Integer tipEmbasamento) {
		this.tipEmbasamento = tipEmbasamento;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getCadastradoEm() {
		return cadastradoEm;
	}

	public void setCadastradoEm(Date cadastradoEm) {
		this.cadastradoEm = cadastradoEm;
	}

	public Date getAlteradoEm() {
		return alteradoEm;
	}

	public void setAlteradoEm(Date alteradoEm) {
		this.alteradoEm = alteradoEm;
	}

	public Integer getCadastradoPor() {
		return cadastradoPor;
	}

	public void setCadastradoPor(Integer cadastradoPor) {
		this.cadastradoPor = cadastradoPor;
	}

	public Integer getAlteradoPor() {
		return alteradoPor;
	}

	public void setAlteradoPor(Integer alteradoPor) {
		this.alteradoPor = alteradoPor;
	}
}
