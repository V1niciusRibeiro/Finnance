package br.com.fiap.fintech.Dao;

import br.com.fiap.fintech.Dao.Meta.*;
import br.com.fiap.fintech.Dao.Tipo.*;
import br.com.fiap.fintech.Dao.Previsao.*;
import br.com.fiap.fintech.Dao.Aplicacao.*;
import br.com.fiap.fintech.Dao.Categoria.*;
import br.com.fiap.fintech.Dao.Usuario.*;
import br.com.fiap.fintech.Dao.ContaUsuario.*;
import br.com.fiap.fintech.Dao.Investimento.*;
import br.com.fiap.fintech.Dao.Movimentacao.*;


public abstract class DAOFactory {
	
	public static MetaDAO getMetaDAO() {
		return new MetaDAOImpl();
	}
	
	public static TipoDAO getTipoDAO() {
		return new TipoDAOImpl();
	}
		
	public static PrevisaoDAO getPrevisaoDAO() {
		return new PrevisaoDAOImpl();
	}

	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl();
	}
	public static ContaUsuarioDAO getContaDAO() {
		return new ContaUsuarioDAOImpl();
	}

	public static AplicacaoDAO getAplicacapDAO() {
		return new AplicacaoDAOImpl();
	}

	public static CategoriaDAO getCategoriaDAO() {
		return new CategoriaDAOImpl();
	}
	
	public static InvestimentoDAO getInvestimentoDAO() {
		return new InvestimentoDAOImpl();
	}
	
	public static MovimentacaoDAO getMovimentacaoDAO() {
		return new MovimentacaoDAOImpl();
	}
	
}
