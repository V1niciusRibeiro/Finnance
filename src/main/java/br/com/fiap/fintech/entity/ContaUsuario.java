package br.com.fiap.fintech.entity;

public class ContaUsuario {

	private Integer cd_conta;
	private Integer cd_usuario;
	private String  tp_conta;
	private Double	vl_saldo;
	private String  nr_cpf;
	private String	nr_cnpj;
	
	public ContaUsuario() {}
	
	public ContaUsuario(Integer cd_conta, Integer cd_usuario, String tp_conta, Double vl_saldo, String nr_cpf, String	nr_cnpj) {

		this.setCd_conta(cd_conta);
		this.setCd_usuario(cd_usuario);
		this.setTp_conta(tp_conta);
		this.setVl_saldo(vl_saldo);
		this.setNr_cpf(nr_cpf);
		this.setNr_cnpj(nr_cnpj);
		
	}

	
	public Integer getCd_conta() {
		return cd_conta;
	}

	public void setCd_conta(Integer cd_conta) {
		this.cd_conta = cd_conta;
	}

	public Integer getCd_usuario() {
		return cd_usuario;
	}

	public void setCd_usuario(Integer cd_usuario) {
		this.cd_usuario = cd_usuario;
	}

	public String getTp_conta() {
		return tp_conta;
	}

	public void setTp_conta(String tp_conta) {
		this.tp_conta = tp_conta;
	}

	public Double getVl_saldo() {
		return vl_saldo;
	}

	public void setVl_saldo(Double vl_saldo) {
		this.vl_saldo = vl_saldo;
	}

	public String getNr_cpf() {
		return nr_cpf;
	}

	public void setNr_cpf(String nr_cpf) {
		this.nr_cpf = nr_cpf;
	}

	public String getNr_cnpj() {
		return nr_cnpj;
	}

	public void setNr_cnpj(String nr_cnpj) {
		this.nr_cnpj = nr_cnpj;
	}
	
}
