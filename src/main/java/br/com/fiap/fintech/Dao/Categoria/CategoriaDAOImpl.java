package br.com.fiap.fintech.Dao.Categoria;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import br.com.fiap.fintech.entity.Categoria;
import br.com.fiap.fintech.jdbc.ConnectionManager;

public class CategoriaDAOImpl implements CategoriaDAO{

	private Connection conexao;
	PreparedStatement pstmt = null;
	
	
	public List<Categoria> saveValues(ResultSet rs){

		List<Categoria> lista = new ArrayList<Categoria>();

		try {
			while (rs.next()) {
				
				Integer cd_categoria = rs.getInt   ("CD_CATEGORIA");
				String  nm_categoria = rs.getString("NM_CATEGORIA");
				Integer cd_usuario   = rs.getInt   ("T_FIN_USUARIO_CD_USUARIO");
				
				Categoria categoria = new Categoria(cd_categoria, nm_categoria, cd_usuario);		
				lista.add(categoria);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lista;
	}
	
	@Override
	public void insertByID(Categoria categoria){
		
		try {		
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("INSERT INTO T_FIN_CATEGORIA VALUES(SEQ_FIN_CATEGORIA.NEXTVAL,?,?)");
			
			pstmt.setString(1, categoria.getNm_categoria());
			pstmt.setInt   (2, categoria.getCd_usuario());
			
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
	public List<Categoria> getAll() {
		
		List<Categoria> lista = new ArrayList<Categoria>();
		ResultSet rs = null;

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_CATEGORIA");
			
			rs = pstmt.executeQuery();

			lista = saveValues(rs);
			
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
		
		return lista;
	}

	public List<Categoria> getAllByUser(Integer cd_usuario){
		
		List<Categoria> lista = new ArrayList<Categoria>();
		ResultSet rs = null;

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_CATEGORIA "
											+"WHERE T_FIN_USUARIO_CD_USUARIO = ?");
			
			pstmt.setInt(1, cd_usuario);
			
			rs = pstmt.executeQuery();

			lista = saveValues(rs);
			
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
		
		return lista;
	}
	
	@Override
	public Categoria getByID(Integer cd_categoria) {

		Categoria categoria = null;
		ResultSet rs = null;
		
		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_CATEGORIA WHERE CD_CATEGORIA= ?");
			
			pstmt.setInt(1, cd_categoria);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
			
				String  nm_categoria = rs.getString("NM_CATEGORIA");
				Integer cd_usuario	 = rs.getInt   ("T_FIN_USUARIO_CD_USUARIO");
				
				categoria = new Categoria(cd_categoria, nm_categoria, cd_usuario);
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
		
		return categoria;
	}
		
	@Override
	public void updateByID(Categoria categoria) {

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("UPDATE T_FIN_CATEGORIA SET NM_CATEGORIA = ? WHERE CD_CATEGORIA = ?");
			
			pstmt.setString(1, categoria.getNm_categoria());
			pstmt.setInt(2, categoria.getCd_categoria());
			
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
	public void deleteByID(Integer cd_categoria) {

		try {
		
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_CATEGORIA WHERE CD_CATEGORIA = ?");
			
			pstmt.setInt(1, cd_categoria);
			
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
