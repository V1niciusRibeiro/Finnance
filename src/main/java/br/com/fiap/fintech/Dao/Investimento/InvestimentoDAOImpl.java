package br.com.fiap.fintech.Dao.Investimento;

import java.util.List;
import java.util.Calendar;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.Dao.Tipo.*;
import br.com.fiap.fintech.entity.Tipo;
import br.com.fiap.fintech.entity.Investimento;
import br.com.fiap.fintech.jdbc.ConnectionManager;

public class InvestimentoDAOImpl implements InvestimentoDAO{

	private Connection conexao;
	PreparedStatement pstmt = null;
	
	
	@Override
	public void insertByID(Investimento investimento) {
		
		try {		
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("INSERT INTO T_FIN_INVESTIMENTO VALUES(SEQ_FIN_INVESTIMENTO.NEXTVAL,?,?,?,?,?,?)");
		
			pstmt.setInt   (1, investimento.getTipo().getCd_tipo());
			pstmt.setString(2, investimento.getDs_investimento());
			pstmt.setDouble(3, investimento.getPr_rendimento_a_a());
			pstmt.setDate  (4, new java.sql.Date(investimento.getDt_vencimento().getTimeInMillis()));
			pstmt.setDouble(5, investimento.getPr_iof());
			pstmt.setDouble(6, investimento.getPr_ir());

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
	public List<Investimento> getAll() {
		
		List<Investimento> lista = new ArrayList<Investimento>();
		TipoDAO tipodao = DAOFactory.getTipoDAO();
		ResultSet rs = null;
		
		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_INVESTIMENTO");
						
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				Integer cd_investimento	  = rs.getInt("CD_INVESTIMENTO");
				Tipo    tipo			  = tipodao.getByID(rs.getInt("T_FIN_TIPO_CD_TIPO"));
				String  ds_investimento	  = rs.getString("DS_INVESTIMENTO");
				Double  pr_rendimento_a_a = rs.getDouble("PR_RENDIMENTO_A_A");
				Double  pr_iof 			  = rs.getDouble("PR_IOF");
				Double  pr_ir			  = rs.getDouble("PR_IR");
				
				java.sql.Date dt_vencto	  = rs.getDate("DT_VENCIMENTO");
				Calendar  dt_vencimento   = Calendar.getInstance();
				dt_vencimento.setTimeInMillis(dt_vencto.getTime());
				
				Investimento investimento = new Investimento(cd_investimento,
															 tipo,
															 ds_investimento,
															 pr_rendimento_a_a,
															 dt_vencimento,
															 pr_iof,
															 pr_ir);
				lista.add(investimento);
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
	public Investimento getByID(Integer cd_investimento) {

		ResultSet rs = null;
		TipoDAO tipodao = DAOFactory.getTipoDAO();
		Investimento investimento = null;
		
		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_INVESTIMENTO WHERE CD_INVESTIMENTO = ?");
			
			pstmt.setInt(1, cd_investimento);
						
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				Tipo   tipo				 = tipodao.getByID(rs.getInt("T_FIN_TIPO_CD_TIPO"));
				String ds_investimento	 = rs.getString("DS_INVESTIMENTO");
				Double pr_rendimento_a_a = rs.getDouble("PR_RENDIMENTO_A_A");
				Double pr_iof 			 = rs.getDouble("PR_IOF");
				Double pr_ir			 = rs.getDouble("PR_IR");
				
				java.sql.Date dt_vencto	 = rs.getDate("DT_VENCIMENTO");
				Calendar  dt_vencimento  = Calendar.getInstance();
				dt_vencimento.setTimeInMillis(dt_vencto.getTime());
				
				investimento = new Investimento(cd_investimento,
												tipo,
												ds_investimento,
												pr_rendimento_a_a,
												dt_vencimento,
												pr_iof,
												pr_ir);
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
		
		return investimento;
	}
	
	@Override
	public void updateByID(Investimento investimento) {

		try {		
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("UPDATE T_FIN_INVESTIMENTO SET T_FIN_TIPO_CD_TIPO = ?,"
																	  	  +"DS_INVESTIMENTO    = ?,"
																	  	  +"PR_RENDIMENTO_A_A  = ?,"
																	  	  +"DT_VENCIMENTO 	   = ?,"
																	  	  +"PR_IOF 			   = ?,"
																	  	  +"PR_IR 			   = ?"
											+"WHERE CD_INVESTIMENTO = ?");
		
			pstmt.setInt   (1, investimento.getTipo().getCd_tipo());
			pstmt.setString(2, investimento.getDs_investimento());
			pstmt.setDouble(3, investimento.getPr_rendimento_a_a());
			pstmt.setDate  (4, new java.sql.Date(investimento.getDt_vencimento().getTimeInMillis()));
			pstmt.setDouble(5, investimento.getPr_iof());
			pstmt.setDouble(6, investimento.getPr_ir());
			pstmt.setInt   (7, investimento.getCd_investimento());

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

	public void deleteByID(Integer cd_investimento) {

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_INVESTIMENTO WHERE CD_INVESTIMENTO = ?");
			
			pstmt.setInt(1, cd_investimento);
			
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