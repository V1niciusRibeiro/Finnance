package br.com.fiap.fintech.Dao.ContaUsuario;

import java.util.List;

import br.com.fiap.fintech.entity.ContaUsuario;
import br.com.fiap.fintech.exception.DBException;

public interface ContaUsuarioDAO {

	void insertByID(ContaUsuario contausuario) throws DBException;

	List<ContaUsuario> getAll();

	ContaUsuario getByID(Integer cd_usuario, Integer cd_conta);

	void updateByID(ContaUsuario contausuario) throws DBException;

	void deleteByID(Integer cd_usuario, Integer cd_conta) throws DBException;
}
