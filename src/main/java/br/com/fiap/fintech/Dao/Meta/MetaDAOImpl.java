package br.com.fiap.fintech.Dao.Meta;

import java.util.List;
import java.util.Calendar;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import br.com.fiap.fintech.entity.Meta;
import br.com.fiap.fintech.jdbc.ConnectionManager;

public class MetaDAOImpl implements MetaDAO	{
	
	private Connection conexao;
	PreparedStatement pstmt = null;
	
	
	public void insertByID(Meta meta){
		
		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("INSERT INTO T_FIN_META VALUES(?,SEQ_FIN_META.NEXTVAL,?,?,?,?,?)");
			
			pstmt.setInt   (1, meta.getCd_usuario());
			pstmt.setString(2, meta.getNm_meta());
			pstmt.setDouble(3, meta.getVl_meta());
			pstmt.setDouble(4, meta.getVl_reservado());
			pstmt.setString(5, meta.getTx_meta());
			pstmt.setDate  (6, new java.sql.Date(meta.getDt_limite_conclusao().getTimeInMillis()));
			
			pstmt.executeUpdate();
			
		} catch(SQLException e){
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				conexao.close();
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}	
	}

	public List<Meta> getAll() {
		
		List<Meta> lista = new ArrayList<Meta>();
		ResultSet rs = null;

		try {
		
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_META");
			
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Integer cd_usuario   	= rs.getInt   ("T_FIN_USUARIO_CD_USUARIO");
				Integer cd_meta 	 	= rs.getInt   ("CD_META");
				String  nm_meta 	 	= rs.getString("NM_META");
				Double  vl_meta 	 	= rs.getDouble("VL_META");
				Double  vl_reservado	= rs.getDouble("VL_RESERVADO");
				String  tx_meta 	  	= rs.getString("TX_META");
				java.sql.Date dt_limite = rs.getDate  ("DT_LIMITE_CONCLUSAO");
				Calendar dt_limite_conclusao = Calendar.getInstance();
				dt_limite_conclusao.setTimeInMillis(dt_limite.getTime());
				
				Meta meta = new Meta(cd_usuario, cd_meta, nm_meta, vl_meta, vl_reservado, tx_meta, dt_limite_conclusao);
				lista.add(meta);
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

	public Meta getByID(Integer cd_meta, Integer cd_usuario) {

		Meta meta = null;
		ResultSet rs = null;
		
		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_META WHERE T_FIN_USUARIO_CD_USUARIO = ? AND CD_META = ?");
			
			pstmt.setInt(1, cd_usuario);
			pstmt.setInt(2, cd_meta);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				
				String  nm_meta 	 	= rs.getString("NM_META");
				Double  vl_meta 	 	= rs.getDouble("VL_META");
				Double  vl_reservado	= rs.getDouble("VL_RESERVADO");
				String  tx_meta 	  	= rs.getString("TX_META");
				java.sql.Date dt_limite = rs.getDate  ("DT_LIMITE_CONCLUSAO");
				Calendar dt_limite_conclusao = Calendar.getInstance();
				dt_limite_conclusao.setTimeInMillis(dt_limite.getTime());
				
				meta = new Meta(cd_usuario, cd_meta, nm_meta, vl_meta, vl_reservado, tx_meta, dt_limite_conclusao);
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
		
		return meta;
	}
		
	@Override
	public void updateByID(Meta meta) {

		try {

			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("UPDATE T_FIN_META SET NM_META 			= ?,"
															 	  +"VL_META 			= ?,"
															 	  +"VL_RESERVADO 		= ?,"
															 	  +"TX_META 			= ?,"
															 	  +"DT_LIMITE_CONCLUSAO = ? "
											+"WHERE T_FIN_USUARIO_CD_USUARIO = ? AND CD_META = ?");
			
			pstmt.setString(1, meta.getNm_meta());
			pstmt.setDouble(2, meta.getVl_meta());
			pstmt.setDouble(3, meta.getVl_reservado());
			pstmt.setString(4, meta.getTx_meta());
			pstmt.setDate  (5, new java.sql.Date(meta.getDt_limite_conclusao().getTimeInMillis()));
			pstmt.setInt   (6, meta.getCd_usuario());
			pstmt.setInt   (7, meta.getCd_meta());

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
	public void deleteByID(Integer cd_meta, Integer cd_usuario) {

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_META WHERE T_FIN_USUARIO_CD_USUARIO = ? AND CD_META = ?");
			
			pstmt.setInt(1, cd_usuario);
			pstmt.setInt(2, cd_meta);
			
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
