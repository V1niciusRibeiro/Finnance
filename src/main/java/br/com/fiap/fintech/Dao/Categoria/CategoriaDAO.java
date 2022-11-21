package br.com.fiap.fintech.Dao.Categoria;

import java.util.List;

import br.com.fiap.fintech.entity.Categoria;
import br.com.fiap.fintech.exception.DBException;

public interface CategoriaDAO {

	void insertByID (Categoria categoria) throws DBException;
	
	List<Categoria> getAll();
	
	List<Categoria> getAllByUser(Integer cd_usuario);
	
	Categoria getByID(Integer cd_categoria);
	
	void updateByID (Categoria categoria) throws DBException;
	
	void deleteByID (Integer cd_categoria) throws DBException;
}
