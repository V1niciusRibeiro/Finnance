package br.com.fiap.fintech.Dao.Tipo;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import br.com.fiap.fintech.entity.Tipo;
import br.com.fiap.fintech.jdbc.ConnectionManager;

public class TipoDAOImpl implements TipoDAO{

	private Connection conexao;
	PreparedStatement pstmt = null;
	
	
	@Override
	public void insertByID(Tipo tipo){
		
		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("INSERT INTO T_FIN_TIPO VALUES(SEQ_FIN_TIPO.NEXTVAL,?)");
			
			pstmt.setString(1, tipo.getNm_tipo());
			
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
	public List<Tipo> getAll() {
		
		List<Tipo> lista = new ArrayList<Tipo>();
		ResultSet rs = null;
		
		try {
		
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_TIPO");
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
			
				Integer cd_tipo = rs.getInt   ("CD_TIPO");
				String  nm_tipo = rs.getString("NM_TIPO");
				
				Tipo tipo = new Tipo(cd_tipo, nm_tipo);
				lista.add(tipo);
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
	public Tipo getByID(Integer cd_tipo) {

		Tipo tipo = null;
		ResultSet rs = null;
		
		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_TIPO WHERE CD_TIPO = ?");
			
			pstmt.setInt(1, cd_tipo);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				
				String nm_tipo = rs.getString("NM_TIPO");
				
				tipo = new Tipo(cd_tipo, nm_tipo);
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
		
		return tipo;
	}
	
	@Override
	public void updateByID(Tipo tipo) {

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("UPDATE T_FIN_TIPO SET NM_TIPO = ? WHERE CD_TIPO = ?");
			
			pstmt.setString(1, tipo.getNm_tipo());
			pstmt.setInt   (2, tipo.getCd_tipo());
			
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
	public void deleteByID(Integer cd_tipo) {

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_TIPO WHERE CD_TIPO = ?");
			
			pstmt.setInt(1, cd_tipo);
			
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
