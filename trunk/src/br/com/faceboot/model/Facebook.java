package br.com.faceboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;




@Entity
@Table(name = "facebook")
public class Facebook {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(length = 80)
	private String email;

	@Column(length = 50)
	private String senha;
	
	@Column
	private int ativo;
	
	@Column
	private int erro;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
	
	
}
