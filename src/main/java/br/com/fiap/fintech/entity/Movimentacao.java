package br.com.fiap.fintech.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Movimentacao {
	
	private Integer   cd_usuario;
	private Integer   cd_conta;
    private Integer   cd_movimentacao;
    private Categoria categoria;
    private Calendar  dt_movimentacao;
    private Double    vl_movimentacao;
    private String    tp_movimentacao;


    public Movimentacao() {}
    
	public Movimentacao(Integer	  cd_usuario,
						Integer	  cd_conta,
						Integer	  cd_movimentacao,
						Categoria categoria,
						Calendar  dt_movimentacao,
						Double 	  vl_movimentacao,
						String 	  tp_movimentacao) {

		this.cd_usuario		 = cd_usuario;
		this.cd_conta 		 = cd_conta;
		this.cd_movimentacao = cd_movimentacao;
		this.categoria 	 	 = categoria;
		this.dt_movimentacao = dt_movimentacao;
		this.vl_movimentacao = vl_movimentacao;
		this.tp_movimentacao = tp_movimentacao;	
	}
	
	
	public Integer getCd_usuario() {
		return cd_usuario;
	}

	public void setCd_usuario(Integer cd_usuario) {
		this.cd_usuario = cd_usuario;
	}

    public Integer getCd_conta() {
		return cd_conta;
	}

	public void setCd_conta(Integer cd_conta) {
		this.cd_conta = cd_conta;
	}

	public Integer getCd_movimentacao() {
		return cd_movimentacao;
	}

	public void setCd_movimentacao(Integer cd_movimentacao) {
		this.cd_movimentacao = cd_movimentacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCd_categoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Calendar getDt_movimentacao() {
		return dt_movimentacao;
	}

	public void setDt_movimentacao(Calendar dt_movimentacao) {
		this.dt_movimentacao = dt_movimentacao;
	}

	public Double getVl_movimentacao() {
		return vl_movimentacao;
	}

	public void setVl_movimentacao(Double vl_movimentacao) {
		this.vl_movimentacao = vl_movimentacao;
	}

	public String getTp_movimentacao() {
		return tp_movimentacao;
	}

	public void setTp_movimentacao(String tp_movimentacao) {
		this.tp_movimentacao = tp_movimentacao;
	}
	
	@Override
	public String toString() {
		
		SimpleDateFormat dt_movtacao = new SimpleDateFormat("dd/mm/yyyy");
		
		return "Movimentacao:\n[cd_usuario 	    = "+cd_usuario		  	+",\n"
					   		 +" cd_conta	    = "+cd_conta		  	+",\n"
					   		 +" cd_movimentacao = "+cd_movimentacao	  	+",\n"
					   		 +" cd_categoria    = "+categoria.toString()+",\n"
					   		 +" vl_movimentacao = "+vl_movimentacao	  	+",\n"
					   		 +" tp_movimentacao = "+tp_movimentacao	  	+",\n"
							 +" dt_movimentacao = "+dt_movtacao.format(dt_movimentacao.getTime())+"]";
	}
	
}
