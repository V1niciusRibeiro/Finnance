package br.com.fiap.fintech.entity;

public class Categoria {

	private Integer cd_categoria;
	private Integer cd_usuario;
	private String  nm_categoria;

	public Categoria() {}
	
	public Categoria(Integer cd_categoria, String nm_categoria, Integer cd_usuario) {
		this.cd_categoria = cd_categoria;
		this.nm_categoria = nm_categoria;
		this.cd_usuario   = cd_usuario;
	}
	
	
	public Integer getCd_categoria() {
		return cd_categoria;
	}

	public void setCd_categoria(Integer cd_categoria) {
		this.cd_categoria = cd_categoria;
	}

	public Integer getCd_usuario() {
		return cd_usuario;
	}

	public void setCd_usuario(Integer cd_usuario) {
		this.cd_usuario = cd_usuario;
	}
	
	public String getNm_categoria() {
		return nm_categoria;
	}

	public void setNm_categoria(String nm_categoria) {
		this.nm_categoria = nm_categoria;
	}
	
	public String toString() {
		return "Categoria:\n[cd_categoria = "+cd_categoria+",\n"
						  +" cd_usuario   = "+cd_usuario  +",\n"
					      +" nm_categoria = "+nm_categoria+"]";
	}
	
}
