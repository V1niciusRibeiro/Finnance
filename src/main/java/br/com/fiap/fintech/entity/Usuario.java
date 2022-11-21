package br.com.fiap.fintech.entity;

import br.com.fiap.fintech.util.CriptografiaUtils;

public class Usuario {
	
	private Integer cd_usuario;
	private String  email;
	private String  senha;
	private String  nm_usuario;
	
	
	public Usuario(Integer cd_usuario, String email, String senha, String nm_usuario) {
		super();
		this.cd_usuario = cd_usuario;
		this.email = email;
		setSenha(senha);
		this.nm_usuario = nm_usuario;
	}

	public Usuario() {
		super();
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
		try {
			this.senha = CriptografiaUtils.criptografar(senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Integer getCd_usuario() {
		return cd_usuario;
	}

	public void setCd_usuario(Integer cd_usuario) {
		this.cd_usuario = cd_usuario;
	}

	public String getNm_usuario() {
		return nm_usuario;
	}

	public void setNm_usuario(String nm_usuario) {
		this.nm_usuario = nm_usuario;
	}

}