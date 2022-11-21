package br.com.fiap.fintech.Dao.Movimentacao;

import br.com.fiap.fintech.entity.ContaUsuario;
import br.com.fiap.fintech.entity.Movimentacao;
import br.com.fiap.fintech.exception.DBException;

import java.util.Date;
import java.util.List;

public interface MovimentacaoDAO {
	
	void insertByID (Movimentacao movimentacao) throws DBException;

	List<Movimentacao> getAll();
	
	Movimentacao getByID(Integer cd_usuario, Integer cd_conta, Integer cd_movimentacao);
	
	void updateByID (Movimentacao movimentacao) throws DBException;
	
	void deleteByID (Integer cd_usuario, Integer cd_conta, Integer cd_movimentacao) throws DBException;
	
	List<Movimentacao> getAll_ContaByDate(ContaUsuario conta, Date date_from, Date date_to);
	
	List<Movimentacao> getAllByConta(Integer cd_usuario, Integer cd_conta);

}
