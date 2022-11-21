package br.com.fiap.fintech.Dao.Previsao;

import java.util.List;
import java.util.Calendar;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import br.com.fiap.fintech.entity.Meta;
import br.com.fiap.fintech.entity.Previsao;
import br.com.fiap.fintech.entity.Investimento;

import br.com.fiap.fintech.jdbc.ConnectionManager;

import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.Dao.Meta.MetaDAO;
import br.com.fiap.fintech.Dao.Investimento.InvestimentoDAO;

public class PrevisaoDAOImpl implements PrevisaoDAO{

	private Connection conexao;
	PreparedStatement pstmt = null;
	
	
	@Override
	public void insertByID(Previsao previsao) {

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("INSERT INTO T_FIN_PREVISAO VALUES(?,?,SEQ_FIN_PREVISAO.NEXTVAL,?,?,?)");
			
			pstmt.setInt   (1, previsao.getMeta().getCd_usuario());
			pstmt.setInt   (2, previsao.getMeta().getCd_meta());
			pstmt.setInt   (3, previsao.getInvestimento().getCd_investimento());
			pstmt.setDouble(4, previsao.getVl_mensal());
			pstmt.setDate  (5, new java.sql.Date(previsao.getDt_previsao().getTimeInMillis()));
			
			pstmt.executeUpdate();
			
		} catch(SQLException e){
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				conexao.close();
				
			} catch(SQLException e) {
				System.out.println(e);
			}
		}			
	}

	@Override
	public List<Previsao> getAll() {

		List<Previsao> lista = new ArrayList<Previsao>();
		MetaDAO metadao = DAOFactory.getMetaDAO();
		InvestimentoDAO investimentodao = DAOFactory.getInvestimentoDAO();
		ResultSet rs = null;
		
		try {
		
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_PREVISAO");
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
			
				Meta		  meta		   = metadao.getByID(rs.getInt("T_FIN_META_CD_META"), rs.getInt("T_FIN_USUARIO_CD_USUARIO"));
				Integer 	  cd_previsao  = rs.getInt("CD_PREVISAO");
				Investimento  investimento = investimentodao.getByID(rs.getInt("T_FIN_INVESTIMENTO_CD_INVESTIMENTO"));
				Double 		  vl_mensal    = rs.getDouble("VL_MENSAL");
				java.sql.Date dt_prev      = rs.getDate("DT_PREVISAO");
				Calendar 	  dt_previsao  = Calendar.getInstance();
				dt_previsao.setTimeInMillis(dt_prev.getTime());
				
				Previsao previsao = new Previsao(meta, cd_previsao, investimento, vl_mensal, dt_previsao);
				lista.add(previsao);
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
	public Previsao getByID(Meta meta, Integer cd_previsao) {

		Previsao previsao = null;
		InvestimentoDAO investimentodao = DAOFactory.getInvestimentoDAO();
		ResultSet rs = null;
		
		try {
		
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_PREVISAO "
											+"WHERE T_FIN_USUARIO_CD_USUARIO = ? AND T_FIN_META_CD_META = ? AND CD_MOVIMENTACAO = ?");
			
			pstmt.setInt(1, meta.getCd_usuario());
			pstmt.setInt(2, meta.getCd_meta());
			pstmt.setInt(3, cd_previsao);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
			
				Investimento  investimento = investimentodao.getByID(rs.getInt("T_FIN_INVESTIMENTO_CD_INVESTIMENTO"));
				Double 		  vl_mensal    = rs.getDouble("VL_MENSAL");
				java.sql.Date dt_prev      = rs.getDate("DT_PREVISAO");
				Calendar 	  dt_previsao  = Calendar.getInstance();
				dt_previsao.setTimeInMillis(dt_prev.getTime());
				
				previsao = new Previsao(meta, cd_previsao, investimento, vl_mensal, dt_previsao);
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
		
		return previsao;
	}

	@Override
	public void updateByID(Previsao previsao) {

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("UPDATE T_FIN_MOVIMENTACAO SET T_FIN_INVESTIMENTO_CD_INVESTIMENTO = ?,"
																		  					 +"VL_MENSAL 	   = ?,"
																		  					 +"DT_PREVISAO     = ? "
											+"WHERE T_FIN_USUARIO_CD_USUARIO = ? AND T_FIN_META_CD_META = ? AND CD_MOVIMENTACAO = ?");
			
			pstmt.setInt   (1, previsao.getInvestimento().getCd_investimento());
			pstmt.setDouble(2, previsao.getVl_mensal());
			pstmt.setDate  (3, new java.sql.Date(previsao.getDt_previsao().getTimeInMillis()));
			pstmt.setInt   (4, previsao.getMeta().getCd_usuario());
			pstmt.setInt   (5, previsao.getMeta().getCd_meta());
			pstmt.setInt   (6, previsao.getCd_previsao());
			
			pstmt.executeUpdate();
			
		} catch(SQLException e){
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				conexao.close();
				
			} catch(SQLException e) {
				System.out.println(e);
			}
		}
	}

	@Override
	public void deleteByID(Meta meta, Integer cd_previsao) {

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_PREVISAO "
											+"WHERE T_FIN_USUARIO_CD_USUARIO = ? AND T_FIN_META_CD_META = ? AND CD_MOVIMENTACAO = ?");
			
			pstmt.setInt(1, meta.getCd_usuario());
			pstmt.setInt(2, meta.getCd_meta());
			pstmt.setInt(3, cd_previsao);
			
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
