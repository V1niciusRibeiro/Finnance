package br.com.fiap.fintech.Dao.Investimento;

import java.util.List;

import br.com.fiap.fintech.entity.Investimento;
import br.com.fiap.fintech.exception.DBException;

public interface InvestimentoDAO {

	void insertByID (Investimento investimento) throws DBException;
	
	List<Investimento> getAll();
	
	Investimento getByID(Integer cd_investimento);
	
	void updateByID (Investimento investimento) throws DBException;
	
	void deleteByID (Integer cd_investimento) throws DBException;
}
