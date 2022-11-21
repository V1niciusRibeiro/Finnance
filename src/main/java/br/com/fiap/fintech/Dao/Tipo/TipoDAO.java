package br.com.fiap.fintech.Dao.Tipo;

import br.com.fiap.fintech.entity.Tipo;
import br.com.fiap.fintech.exception.DBException;

import java.util.List;
	
public interface TipoDAO {

	void insertByID (Tipo tipo) throws DBException;
	
	List<Tipo> getAll();
	
	Tipo getByID(Integer cd_tipo);
	
	void updateByID (Tipo tipo) throws DBException;
	
	void deleteByID (Integer cd_tipo) throws DBException;
}


