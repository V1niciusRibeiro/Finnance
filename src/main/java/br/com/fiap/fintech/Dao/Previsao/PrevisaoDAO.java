package br.com.fiap.fintech.Dao.Previsao;

import java.util.List;

import br.com.fiap.fintech.entity.Meta;
import br.com.fiap.fintech.entity.Previsao;
import br.com.fiap.fintech.exception.DBException;

public interface PrevisaoDAO {

	void insertByID (Previsao previsao) throws DBException;

	List<Previsao> getAll();
	
	Previsao getByID(Meta meta, Integer cd_previsao);
	
	void updateByID (Previsao previsao) throws DBException;
	
	void deleteByID (Meta meta, Integer cd_previsao) throws DBException;
	
}
