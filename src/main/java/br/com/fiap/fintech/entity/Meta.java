package br.com.fiap.fintech.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Meta {
	
	private Integer  cd_usuario;
	private Integer  cd_meta;
	private String   nm_meta;
	private Double   vl_meta;
	private Double   vl_reservado;
	private String   tx_meta;
	private Calendar dt_limite_conclusao;

	
	public Meta() {}
	
	public Meta(Integer	 cd_usuario, 
				Integer	 cd_meta, 
				String	 nm_meta, 
				Double	 vl_meta, 
				Double	 vl_reservado, 
				String 	 tx_meta, 
				Calendar dt_limite_conclusao) {

		this.cd_usuario			 = cd_usuario;
		this.cd_meta			 = cd_meta;
		this.nm_meta			 = nm_meta;
		this.vl_meta			 = vl_meta;
		this.vl_reservado		 = vl_reservado;
		this.tx_meta 			 = tx_meta;
		this.dt_limite_conclusao = dt_limite_conclusao;
	}
	
	
	public Integer getCd_usuario() {
		return cd_usuario;
	}

	public void setCd_usuario(Integer cd_usuario) {
		this.cd_usuario = cd_usuario;
	}

	public Integer getCd_meta() {
		return cd_meta;
	}

	public void setCd_meta(Integer cd_meta) {
		this.cd_meta = cd_meta;
	}

	public String getNm_meta() {
		return nm_meta;
	}

	public void setNm_meta(String nm_meta) {
		this.nm_meta = nm_meta;
	}

	public Double getVl_meta() {
		return vl_meta;
	}

	public void setVl_meta(Double vl_meta) {
		this.vl_meta = vl_meta;
	}

	public Double getVl_reservado() {
		return vl_reservado;
	}

	public void setVl_reservado(Double vl_reservado) {
		this.vl_reservado = vl_reservado;
	}

	public String getTx_meta() {
		return tx_meta;
	}

	public void setTx_meta(String tx_meta) {
		this.tx_meta = tx_meta;
	}

	public Calendar getDt_limite_conclusao() {
		return dt_limite_conclusao;
	}

	public void setDt_limite_conclusao(Calendar dt_limite_conclusao) {
		this.dt_limite_conclusao = dt_limite_conclusao;
	}
	
	@Override
	public String toString() {
		
		SimpleDateFormat dt_limite = new SimpleDateFormat("dd/mm/yyyy");
		
		return "Meta:\n[cd_usuario 			= "+cd_usuario	+",\n"
					 +" cd_meta 			= "+cd_meta		+",\n"
					 +" nm_meta 			= "+nm_meta		+",\n"
					 +" vl_meta 			= "+vl_meta		+",\n"
					 +" vl_reservado 		= "+vl_reservado+",\n"
					 +" tx_meta 			= "+tx_meta		+",\n"
					 +" dt_limite_conclusao = "+dt_limite.format(dt_limite_conclusao.getTime())+"]";
	}

}

