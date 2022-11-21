package br.com.fiap.fintech.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Previsao {

	private Meta		 meta;
	private Integer 	 cd_previsao;
	private Investimento investimento;
	private Double		 vl_mensal;
	private Calendar	 dt_previsao;
	
	
	public Previsao() {}

	public Previsao(Meta meta, Integer cd_previsao, Investimento investimento, Double vl_mensal, Calendar dt_previsao) {
		
		this.meta	 	  = meta;
		this.cd_previsao  = cd_previsao;
		this.investimento = investimento;
		this.vl_mensal    = vl_mensal;
		this.dt_previsao  = dt_previsao;
	}
	
	
	public Meta getMeta() {
		return meta;
	}
	
	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Integer getCd_previsao() {
		return cd_previsao;
	}

	public void setCd_previsao(Integer cd_previsao) {
		this.cd_previsao = cd_previsao;
	}

	public Investimento getInvestimento() {
		return investimento;
	}

	public void setInvestimento(Investimento investimento) {
		this.investimento = investimento;
	}

	public Double getVl_mensal() {
		return vl_mensal;
	}

	public void setVl_mensal(Double vl_mensal) {
		this.vl_mensal = vl_mensal;
	}

	public Calendar getDt_previsao() {
		return dt_previsao;
	}

	public void setDt_previsao(Calendar dt_previsao) {
		this.dt_previsao = dt_previsao;
	}
	
	public String toString() {
		
		SimpleDateFormat dt_prev = new SimpleDateFormat("dd/mm/yyyy");
		
		return "Previsão:\n[meta 		 = "+meta.toString()		+",\n"
						 +" cd_previsao  = "+cd_previsao			+",\n"
					 	 +" investimento = "+investimento.toString()+",\n"
						 +" vl_mensal    = "+vl_mensal			  	+",\n"
						 +" dt_previsao  = "+dt_prev.format(dt_previsao.getTime())+"]";
	}
}
