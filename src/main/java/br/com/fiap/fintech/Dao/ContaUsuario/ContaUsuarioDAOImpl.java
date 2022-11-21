package br.com.fiap.fintech.Dao.ContaUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.entity.ContaUsuario;
import br.com.fiap.fintech.jdbc.ConnectionManager;

public class ContaUsuarioDAOImpl implements ContaUsuarioDAO{

	private Connection conexao;
	PreparedStatement pstmt = null;

	
	@Override
	public void insertByID(ContaUsuario contausuario) {
		try {

			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("INSERT INTO T_FIN_CONTA_USUARIO VALUES(1,?,?,?,?,?)");

			pstmt.setInt   (1, contausuario.getCd_usuario());
			pstmt.setString(2, contausuario.getTp_conta());
			pstmt.setDouble(3, contausuario.getVl_saldo());
	        pstmt.setString(4, contausuario.getNr_cpf());
	        pstmt.setString(5, contausuario.getNr_cnpj());
	        
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
	public List<ContaUsuario> getAll() {
		
		List<ContaUsuario> lista = new ArrayList<ContaUsuario>();
		ResultSet rs = null;
		
		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_CONTA_USUARIO");
			
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Integer cd_conta   = rs.getInt	 ("CD_CONTA");
				Integer cd_usuario = rs.getInt	 ("T_FIN_USUARIO_CD_USUARIO");
				String  tp_conta   = rs.getString("TP_CONTA");
				Double  vl_saldo   = rs.getDouble("VL_SALDO");
				String  nr_cpf     = rs.getString("NR_CPF");
				String  nr_cnpj    = rs.getString("NR_CNPJ");
				
				ContaUsuario contausuario = new ContaUsuario(cd_conta,cd_usuario,tp_conta,vl_saldo,nr_cpf,nr_cnpj);
				lista.add(contausuario);
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
	public ContaUsuario getByID(Integer cd_usuario, Integer cd_conta) {

		ContaUsuario contausuario = null;
		ResultSet rs = null;

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_CONTA_USUARIO "
											+"WHERE T_FIN_USUARIO_CD_USUARIO = ? AND CD_CONTA = ?");
			
			pstmt.setInt(1, cd_usuario);
			pstmt.setInt(2, cd_conta);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {

				String  tp_conta   = rs.getString("TP_CONTA");
				Double  vl_saldo   = rs.getDouble("VL_SALDO");
				String  nr_cpf     = rs.getString("NR_CPF");
				String  nr_cnpj    = rs.getString("NR_CNPJ");
				
				contausuario = new ContaUsuario(cd_conta,cd_usuario,tp_conta,vl_saldo,nr_cpf,nr_cnpj);
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
		
		return contausuario;
	}

	@Override
	public void updateByID(ContaUsuario contausuario) {

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("UPDATE T_FIN_CONTA_USUARIO SET TP_CONTA = ? , VL_SALDO = ? , NR_CPF = ? , NR_CNPJ = ? "
											+"WHERE T_FIN_USUARIO_CD_USUARIO = ? AND CD_CONTA = ?");

			pstmt.setString(1, contausuario.getTp_conta());
			pstmt.setDouble(2, contausuario.getVl_saldo());
	        pstmt.setString(3, contausuario.getNr_cpf());
	        pstmt.setString(4, contausuario.getNr_cnpj());
			pstmt.setInt   (5, contausuario.getCd_usuario());
			pstmt.setInt   (6, contausuario.getCd_conta());
			
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
	public void deleteByID(Integer cd_usuario, Integer cd_conta) {

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_CONTA_USUARIO "
											+"WHERE T_FIN_USUARIO_CD_USUARIO = ? AND CD_CONTA = ?");

			pstmt.setInt(1, cd_usuario);
			pstmt.setInt(2, cd_conta);
			
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