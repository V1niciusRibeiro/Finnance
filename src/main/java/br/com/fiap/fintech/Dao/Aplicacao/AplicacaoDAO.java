package br.com.fiap.fintech.Dao.Aplicacao;

import java.util.List;

import br.com.fiap.fintech.entity.Aplicacao;
import br.com.fiap.fintech.exception.DBException;

public interface AplicacaoDAO {

	void insertByID(Aplicacao aplicacao) throws DBException;

	List<Aplicacao> getAll();

	Aplicacao getByID(Integer cd_usuario, Integer cd_investimento);

	void updateByID(Aplicacao aplicacao) throws DBException;

	void deleteByID(Integer cd_usuario, Integer cd_investimento) throws DBException;
}
