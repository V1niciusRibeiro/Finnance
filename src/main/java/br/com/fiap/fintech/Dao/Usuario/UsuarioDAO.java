package br.com.fiap.fintech.Dao.Usuario;

import java.util.List;

import br.com.fiap.fintech.entity.Usuario;
import br.com.fiap.fintech.exception.DBException;

public interface UsuarioDAO {

	Usuario validarUsuario(String email, String senha);
	
	void insertByID(Usuario usuario) throws DBException;

	List<Usuario> getAll();

	Usuario getByID(Integer cd_usuario);

	void updateByID(Usuario usuario) throws DBException;

	void deleteByID(Integer cd_usuarioa) throws DBException;
	
	int getLastCode() throws DBException;
	
}


