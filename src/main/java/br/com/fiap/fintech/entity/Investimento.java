package br.com.fiap.fintech.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Investimento {

	private Integer  cd_investimento;
	private Tipo	 tipo;
	private String	 ds_investimento;
	private Double   pr_rendimento_a_a;
	private Calendar dt_vencimento;
	private Double 	 pr_iof;
	private Double	 pr_ir;
	
	public Investimento() {}
	
	public Investimento(Integer	 cd_investimento,
						Tipo	 tipo,
						String	 ds_investimento, 
						Double	 pr_rendimento_a_a, 
						Calendar dt_vencimento, 
						Double 	 pr_iof,
						Double	 pr_ir) 
	{	
		this.cd_investimento   = cd_investimento;
		this.tipo 			   = tipo;
		this.ds_investimento   = ds_investimento;
		this.pr_rendimento_a_a = pr_rendimento_a_a;
		this.dt_vencimento 	   = dt_vencimento;
		this.pr_iof 		   = pr_iof;
		this.pr_ir 			   = pr_ir;	
	}

	
	public Integer getCd_investimento() {
		return cd_investimento;
	}

	public void setCd_investimento(Integer cd_investimento) {
		this.cd_investimento = cd_investimento;
	}

	public Tipo getTipo() {
		return tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public String getDs_investimento() {
		return ds_investimento;
	}

	public void setDs_investimento(String ds_investimento) {
		this.ds_investimento = ds_investimento;
	}

	public Double getPr_rendimento_a_a() {
		return pr_rendimento_a_a;
	}

	public void setPr_rendimento_a_a(Double pr_rendimento_a_a) {
		this.pr_rendimento_a_a = pr_rendimento_a_a;
	}

	public Calendar getDt_vencimento() {
		return dt_vencimento;
	}

	public void setDt_vencimento(Calendar dt_vencimento) {
		this.dt_vencimento = dt_vencimento;
	}

	public Double getPr_iof() {
		return pr_iof;
	}

	public void setPr_iof(Double pr_iof) {
		this.pr_iof = pr_iof;
	}

	public Double getPr_ir() {
		return pr_ir;
	}

	public void setPr_ir(Double pr_ir) {
		this.pr_ir = pr_ir;
	}
	
	public String toString() {
		
		SimpleDateFormat dt_vencto = new SimpleDateFormat("dd/mm/yyyy");
		
		return "Investimento:\n[cd_investimento   = "+cd_investimento  +",\n"
							 +" tipo		  	  = "+tipo.toString()  +",\n"
							 +" ds_investimento   = "+ds_investimento  +",\n"
							 +" pr_rendimento_a_a = "+pr_rendimento_a_a+",\n"
							 +" pr_iof 		      = "+pr_iof		   +",\n"
							 +" pr_ir 			  = "+pr_ir			   +",\n"
							 +" dt_vencimento 	  = "+dt_vencto.format(dt_vencimento.getTime())+"]";
	}
	
}
