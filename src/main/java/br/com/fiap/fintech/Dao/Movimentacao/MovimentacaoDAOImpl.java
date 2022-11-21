package br.com.fiap.fintech.Dao.Movimentacao;

import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.entity.Categoria;
import br.com.fiap.fintech.entity.ContaUsuario;
import br.com.fiap.fintech.entity.Movimentacao;

import br.com.fiap.fintech.jdbc.ConnectionManager;

public class MovimentacaoDAOImpl implements MovimentacaoDAO	{
	
	private Connection conexao;
	PreparedStatement pstmt = null;
	
	
	private List<Movimentacao> saveValues(ResultSet rs){

		List<Movimentacao> lista = new ArrayList<Movimentacao>();

		try {
			while (rs.next()) {
				
				Integer   cd_usuario 	   = rs.getInt   ("T_FIN_CONTA_USUARIO_CD_USUARIO");
				Integer   cd_conta 		   = rs.getInt   ("T_FIN_CONTA_USUARIO_CD_CONTA");
				Integer   cd_movimentacao  = rs.getInt   ("CD_MOVIMENTACAO");
				Double    vl_moviementacao = rs.getDouble("VL_MOVIMENTACAO");
				String    tp_moviementacao = rs.getString("TP_MOVIMENTACAO");
				Categoria categoria 	   = DAOFactory.getCategoriaDAO().getByID(rs.getInt("T_FIN_CATEGORIA_CD_CATEGORIA"));
	
				java.sql.Date dt_movtacao  = rs.getDate("DT_MOVIMENTACAO");
				Calendar  dt_movimentacao  = Calendar.getInstance();
				dt_movimentacao.setTimeInMillis(dt_movtacao.getTime());
	
				Movimentacao movimentacao = new Movimentacao(cd_usuario,
															 cd_conta,
															 cd_movimentacao,
															 categoria,
															 dt_movimentacao,
															 vl_moviementacao,
															 tp_moviementacao);
				lista.add(movimentacao);
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
	public void insertByID(Movimentacao movimentacao) {

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("INSERT INTO T_FIN_MOVIMENTACAO VALUES(?,?,SEQ_FIN_MOVIMENTACAO.NEXTVAL,?,?,?,?)");
			
			pstmt.setInt   (1, movimentacao.getCd_usuario());
			pstmt.setInt   (2, movimentacao.getCd_conta());

			if (movimentacao.getCategoria() != null) {
				pstmt.setInt(3, movimentacao.getCategoria().getCd_categoria());
			} else {
				pstmt.setNull(3, 0);
			}
			
			pstmt.setDate  (4, new java.sql.Date(movimentacao.getDt_movimentacao().getTimeInMillis()));
			pstmt.setDouble(5, movimentacao.getVl_movimentacao());
			pstmt.setString(6, movimentacao.getTp_movimentacao());
			
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
	public List<Movimentacao> getAll() {

		List<Movimentacao> lista = new ArrayList<Movimentacao>();
		ResultSet rs = null;
		
		try {
		
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_MOVIMENTACAO");
			
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
	public Movimentacao getByID(Integer cd_usuario, Integer cd_conta, Integer cd_movimentacao) {

		Movimentacao movimentacao = null;
		ResultSet rs = null;
		
		try {
		
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_MOVIMENTACAO "
											+"WHERE T_FIN_CONTA_USUARIO_CD_USUARIO = ? AND T_FIN_CONTA_USUARIO_CD_CONTA = ? AND CD_MOVIMENTACAO = ?");
			
			pstmt.setInt(1, cd_usuario);
			pstmt.setInt(2, cd_conta);
			pstmt.setInt(3, cd_movimentacao);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
			
				Double    vl_moviementacao = rs.getDouble("VL_MOVIMENTACAO");
				String    tp_moviementacao = rs.getString("TP_MOVIMENTACAO");
				Categoria categoria 	   = DAOFactory.getCategoriaDAO().getByID(rs.getInt("T_FIN_CATEGORIA_CD_CATEGORIA"));

				java.sql.Date dt_movtacao  = rs.getDate("DT_MOVIMENTACAO");
				Calendar  dt_movimentacao  = Calendar.getInstance();
				dt_movimentacao.setTimeInMillis(dt_movtacao.getTime());

				movimentacao = new Movimentacao(cd_usuario,
												cd_conta,
												cd_movimentacao,
												categoria,
												dt_movimentacao,
												vl_moviementacao,
												tp_moviementacao);
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
		
		return movimentacao;
	}
	
	@Override
	public void updateByID(Movimentacao movimentacao) {

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("UPDATE T_FIN_MOVIMENTACAO SET T_FIN_CATEGORIA_CD_CATEGORIA = ?,"
																		  +"DT_MOVIMENTACAO    = ?,"
																		  +"VL_MOVIMENTACAO	   = ?,"
																		  +"TP_MOVIMENTACAO    = ? "
											+"WHERE T_FIN_CONTA_USUARIO_CD_USUARIO = ? AND T_FIN_CONTA_USUARIO_CD_CONTA = ? AND CD_MOVIMENTACAO = ?");
			
			if (movimentacao.getCategoria() != null) {
				pstmt.setInt(1, movimentacao.getCategoria().getCd_categoria());
			} else {
				pstmt.setNull(1, 0);
			}
			
			pstmt.setDate  (2, new java.sql.Date(movimentacao.getDt_movimentacao().getTimeInMillis()));
			pstmt.setDouble(3, movimentacao.getVl_movimentacao());
			pstmt.setString(4, movimentacao.getTp_movimentacao());
			pstmt.setInt   (5, movimentacao.getCd_usuario());
			pstmt.setInt   (6, movimentacao.getCd_conta());
			pstmt.setInt   (7, movimentacao.getCd_movimentacao());
			
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
	public void deleteByID(Integer cd_usuario, Integer cd_conta, Integer cd_movimentacao) {

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_MOVIMENTACAO "
											+"WHERE T_FIN_USUARIO_CD_USUARIO = ? AND T_FIN_CONTA_USUARIO_CD_CONTA = ? AND CD_MOVIMENTACAO = ?");
			
			pstmt.setInt(1, cd_usuario);
			pstmt.setInt(2, cd_conta);
			pstmt.setInt(3, cd_movimentacao);
			
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

	public List<Movimentacao> getAll_ContaByDate(ContaUsuario conta, Date date_from, Date date_to) {

		List<Movimentacao> lista = new ArrayList<Movimentacao>();
		ResultSet rs = null;

		try {
		
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_MOVIMENTACAO "
											+"WHERE T_FIN_CONTA_USUARIO_CD_USUARIO = ? AND T_FIN_CONTA_USUARIO_CD_CONTA = ? "
											+"AND DT_MOVIMENTACAO BETWEEN ? AND ?");
			
			pstmt.setInt (1, conta.getCd_usuario());
			pstmt.setInt (2, conta.getCd_conta());
			pstmt.setDate(3, new java.sql.Date(date_from.getTime()));
			pstmt.setDate(4, new java.sql.Date(date_to.getTime()));

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

	public List<Movimentacao> getAllByConta(Integer cd_usuario, Integer cd_conta){

		List<Movimentacao> lista = new ArrayList<Movimentacao>();
		ResultSet rs = null;

		try {
		
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_MOVIMENTACAO "
											+"WHERE T_FIN_CONTA_USUARIO_CD_USUARIO = ? AND T_FIN_CONTA_USUARIO_CD_CONTA = ? ");
			
			pstmt.setInt (1, cd_usuario);
			pstmt.setInt (2, cd_conta);

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

}


	




