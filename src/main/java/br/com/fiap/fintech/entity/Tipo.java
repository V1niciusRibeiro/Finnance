package br.com.fiap.fintech.entity;

public class Tipo {
	
	private Integer cd_tipo;
	private String  nm_tipo;

	
	public Tipo() {}
	
	public Tipo(Integer cd_tipo, String nm_tipo) {
		this.cd_tipo = cd_tipo;
		this.nm_tipo = nm_tipo;
	}
	
	
	public Integer getCd_tipo() {
		return cd_tipo;
	}

	public void setCd_tipo(Integer cd_tipo) {
		this.cd_tipo = cd_tipo;
	}

	public String getNm_tipo() {
		return nm_tipo;
	}

	public void setNm_tipo(String nm_tipo) {
		this.nm_tipo = nm_tipo;
	}
	
	public String toString() {
		return "Tipo:\n[cd_tipo = "+cd_tipo+",\n"
					 +" nm_tipo = "+nm_tipo+"]";
	}
	
}

