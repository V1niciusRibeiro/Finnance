package br.com.fiap.fintech.Dao.Aplicacao;

import java.util.List;
import java.util.Calendar;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.Dao.Investimento.InvestimentoDAO;

import br.com.fiap.fintech.entity.Aplicacao;
import br.com.fiap.fintech.entity.Investimento;
import br.com.fiap.fintech.jdbc.ConnectionManager;

public class AplicacaoDAOImpl implements AplicacaoDAO {
	
	private Connection conexao;
	PreparedStatement pstmt = null;


	@Override
	public void insertByID(Aplicacao aplicacao) {
		try {

			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("INSERT INTO T_FIN_APLICACAO VALUES(?,?,?,?)");

			pstmt.setInt   (1, aplicacao.getCd_usuario());
			pstmt.setInt   (2, aplicacao.getInvestimento().getCd_investimento());
			pstmt.setDouble(3, aplicacao.getVl_aplicacao());
	        pstmt.setDate  (4, new java.sql.Date(aplicacao.getDt_aplicacao().getTimeInMillis()));
	        
	        pstmt .executeUpdate();
	        
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				conexao.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Aplicacao> getAll() {
		
		List<Aplicacao> lista = new ArrayList<Aplicacao>();
		InvestimentoDAO investimentodao = DAOFactory.getInvestimentoDAO();
		ResultSet rs = null;
		
		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_APLICACAO");
			
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Integer 	  cd_usuario   = rs.getInt("T_FIN_USUARIO_CD_USUARIO");
				Investimento  investimento = investimentodao.getByID(rs.getInt("T_FIN_INVESTIMENTO_CD_INVESTIMENTO"));
				Double        vl_aplicacao = rs.getDouble("VL_APLICACAO");
				java.sql.Date dt_apli      = rs.getDate("DT_APLICACAO");
				Calendar      dt_aplicacao = Calendar.getInstance();
				dt_aplicacao.setTimeInMillis(dt_apli.getTime());
				
				Aplicacao aplicacao = new Aplicacao(cd_usuario, investimento, vl_aplicacao, dt_aplicacao);
				lista.add(aplicacao);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				rs.close();
				pstmt.close();
				conexao.close();
		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lista;
	}
		
	@Override
	public Aplicacao getByID(Integer cd_usuario, Integer cd_investimento) {
		
		Aplicacao aplicacao = null;
		InvestimentoDAO investimentodao = DAOFactory.getInvestimentoDAO();
		ResultSet rs = null;

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_APLICACAO "
											+"WHERE T_FIN_USUARIO_CD_USUARIO = ? AND T_FIN_INVESTIMENTO_CD_INVESTIMENTO = ?");
			
			pstmt.setInt(1, cd_usuario);
			pstmt.setInt(2, cd_investimento);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {

				Investimento  investimento = investimentodao.getByID(cd_investimento);
				Double  	  vl_aplicacao = rs.getDouble("VL_APLICACAO");
				java.sql.Date dt_apli 	   = rs.getDate("DT_APLICACAO");
				Calendar	  dt_aplicacao = Calendar.getInstance();
				dt_aplicacao.setTimeInMillis(dt_apli.getTime());
				
				aplicacao = new Aplicacao(cd_usuario, investimento, vl_aplicacao, dt_aplicacao);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				rs.close();
				pstmt.close();
				conexao.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return aplicacao;
	}

	@Override
	public void updateByID(Aplicacao aplicacao) {

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("UPDATE T_FIN_APLICACAO SET DT_APLICACAO = ? , VL_APLICACAO = ? "
											+"WHERE T_FIN_USUARIO_CD_USUARIO = ? AND T_FIN_INVESTIMENTO_CD_INVESTIMENTO = ?");

			pstmt.setDate  (1, new java.sql.Date(aplicacao.getDt_aplicacao().getTimeInMillis()));
			pstmt.setDouble(2, aplicacao.getVl_aplicacao());
			pstmt.setInt   (3, aplicacao.getCd_usuario());
			pstmt.setInt   (4, aplicacao.getInvestimento().getCd_investimento());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				conexao.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteByID(Integer cd_usuario, Integer cd_investimento) {

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_APLICACAO "
											+"WHERE T_FIN_USUARIO_CD_USUARIO = ? AND T_FIN_INVESTIMENTO_CD_INVESTIMENTO = ?");

			pstmt.setInt(1, cd_usuario);
			pstmt.setInt(2, cd_investimento);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			try {
				pstmt.close();
				conexao.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
