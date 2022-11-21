package br.com.fiap.fintech.entity;

import java.util.Calendar;

import java.text.SimpleDateFormat;

public class Aplicacao {
	
	private Integer  	 cd_usuario;
	private Investimento investimento;
	private Double  	 vl_aplicacao;
	private Calendar	 dt_aplicacao;
	
	public Aplicacao() {}

	public Aplicacao(Integer cd_usuario, Investimento investimento, Double vl_aplicacao, Calendar dt_aplicacao) {
		
		this.cd_usuario   = cd_usuario;
		this.investimento = investimento;
		this.vl_aplicacao = vl_aplicacao;
		this.dt_aplicacao = dt_aplicacao;
	}

	
	public Integer getCd_usuario() {
		return cd_usuario;
	}

	public void setCd_usuario(Integer cd_usuario) {
		this.cd_usuario = cd_usuario;
	}

	public Investimento getInvestimento() {
		return investimento;
	}

	public void setInvestimento(Investimento investimento) {
		this.investimento = investimento;
	}

	public Double getVl_aplicacao() {
		return vl_aplicacao;
	}

	public void setVl_aplicacao(Double vl_aplicacao) {
		this.vl_aplicacao = vl_aplicacao;
	}

	public Calendar getDt_aplicacao() {
		return dt_aplicacao;
	}

	public void setDt_aplicacao(Calendar dt_aplicacao) {
		this.dt_aplicacao = dt_aplicacao;
	}

	@Override
	public String toString() {
		
		SimpleDateFormat dt_apli = new SimpleDateFormat("dd/mm/yyyy");
		
		return "Aplicacao:\n[cd_usuario   = "+cd_usuario    		 +",\n"
						  +" investimento = "+investimento.toString()+",\n"
						  +" vl_aplicacao = "+vl_aplicacao   		 +",\n"
						  +" dt_aplicacao = "+dt_apli.format(dt_aplicacao.getTime())+"]";
	}
	
	

	
}
