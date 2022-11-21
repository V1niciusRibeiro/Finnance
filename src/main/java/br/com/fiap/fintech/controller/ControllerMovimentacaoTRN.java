package br.com.fiap.fintech.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.entity.Categoria;
import br.com.fiap.fintech.entity.Movimentacao;

public class ControllerMovimentacaoTRN {

	private Integer		  	cd_movimentacao;
	private String  	    title_mode;
	private String          title_type;
	private List<String>    receita_config;
	private List<String>    despesa_config;
	private Double          vl_movimentacao;
	private String          dt_movimentacao;
	private List<Categoria> categorias;
	private Integer		  	categoria;
	
	
	public ControllerMovimentacaoTRN(String mode, Integer cd_usuario, Integer cd_conta, Integer cd_movimentacao){
		
		this.setCd_movimentacao(cd_movimentacao);
		this.setTitle_type("Movimentação");
		this.setCategorias(DAOFactory.getCategoriaDAO().getAllByUser(cd_usuario));

		List<String> rec_config = new ArrayList<String>();
		List<String> des_config = new ArrayList<String>();
		
		if (mode.substring(0,3).toUpperCase().trim().equals("INS")) {
			
			this.setTitle_mode("Inclui");
			this.setDt_movimentacao(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
		
		} else {
			
			this.setTitle_mode("Altera");
			
			Movimentacao movimentacao = DAOFactory.getMovimentacaoDAO().getByID(cd_usuario, cd_conta, cd_movimentacao);
			this.setVl_movimentacao(movimentacao.getVl_movimentacao());
			this.setDt_movimentacao(new SimpleDateFormat("yyyy-MM-dd").format(movimentacao.getDt_movimentacao().getTime()));
			this.setCategoria(movimentacao.getCategoria() != null ? movimentacao.getCategoria().getCd_categoria() : null);
			
			if (movimentacao.getTp_movimentacao().toUpperCase().trim().equals("R")){
				rec_config.add("checked");
				des_config.add("");
			} else {
				des_config.add("checked");
				rec_config.add("");
			}
			
			rec_config.add("");
			des_config.add("");
		}
		
		switch (mode.toUpperCase().trim()) {
		
			case "INSR":
				this.setTitle_type("Receitas");
				rec_config.add("checked");
				rec_config.add("");

				des_config.add("disabled");
				des_config.add("Input_Disabled");
				break;
		
			case "INSD":
				this.setTitle_type("Despesas");
				des_config.add("checked");
				des_config.add("");

				rec_config.add("disabled");
				rec_config.add("Input_Disabled");
				break;
		}
		
		this.setReceita_config(rec_config);
		this.setDespesa_config(des_config);
	}


	public Integer getCd_movimentacao() {
		return cd_movimentacao;
	}


	public void setCd_movimentacao(Integer cd_movimentacao) {
		this.cd_movimentacao = cd_movimentacao;
	}


	public String getTitle_mode() {
		return title_mode;
	}


	public void setTitle_mode(String title_mode) {
		this.title_mode = title_mode;
	}


	public String getTitle_type() {
		return title_type;
	}


	public void setTitle_type(String title_type) {
		this.title_type = title_type;
	}


	public List<String> getReceita_config() {
		return receita_config;
	}


	public void setReceita_config(List<String> receita_config) {
		this.receita_config = receita_config;
	}


	public List<String> getDespesa_config() {
		return despesa_config;
	}


	public void setDespesa_config(List<String> despesa_config) {
		this.despesa_config = despesa_config;
	}


	public Double getVl_movimentacao() {
		return vl_movimentacao;
	}


	public void setVl_movimentacao(Double vl_movimentacao) {
		this.vl_movimentacao = vl_movimentacao;
	}


	public String getDt_movimentacao() {
		return dt_movimentacao;
	}


	public void setDt_movimentacao(String dt_movimentacao) {
		this.dt_movimentacao = dt_movimentacao;
	}


	public List<Categoria> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}


	public Integer getCategoria() {
		return categoria;
	}


	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
	
}
