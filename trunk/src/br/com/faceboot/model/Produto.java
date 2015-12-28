package br.com.faceboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(length = 1000)
	private String descricao;

	@Column(length = 1000)
	private String link;
	
	@Column
	private int ativo;
	
	@Column
	private int erro;
	
	@Column(length = 1000)
	private String texto;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	public int getErro() {
		return erro;
	}

	public void setErro(int erro) {
		this.erro = erro;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
}
