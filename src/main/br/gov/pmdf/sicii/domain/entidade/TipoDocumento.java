package br.gov.pmdf.sicii.domain.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

/**
 * Classe TipoDocumento
 * OBJETIVO: Representa os tipos de documentos existentes no Sistema
 * AUTORES: Rogerio & Vitor
 */

@Entity
public class TipoDocumento extends BaseEntity implements Serializable {
	
	private static final long serialversionUID = 1L;
	
	//atributos do sistema
	private Integer tipCodigo;
	private String sigla;
	private String descricao;
	private Date cadastradoEm;
	private Date alteradoEm;
	private Integer cadastradoPor;
	private Integer alteradoPor;

	public TipoDocumento() {

	}

	//get and set
	public Integer getTipCodigo() {
		return tipCodigo;
	}

	public void setTipCodigo(Integer tipCodigo) {
		this.tipCodigo = tipCodigo;
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
