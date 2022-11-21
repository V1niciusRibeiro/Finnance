package br.com.fiap.fintech.Dao.Meta;

import br.com.fiap.fintech.entity.Meta;
import br.com.fiap.fintech.exception.DBException;

import java.util.List;

public interface MetaDAO {
	
	void insertByID (Meta meta) throws DBException;
	
	List<Meta> getAll();
	
	Meta getByID(Integer cd_meta, Integer cd_usuario);
	
	void updateByID (Meta meta) throws DBException;
	
	void deleteByID (Integer cd_meta, Integer cd_usuario) throws DBException;

}
