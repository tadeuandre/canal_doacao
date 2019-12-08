package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import modelo.Produto;
import negocio.Descartavel;

public class DescartavelDao {
	
	private static String SQL_DOACAO = "SELECT * FROM TPRODUTO P INNER JOIN TDESCARTAVEL D ON P.ID = D.ID_PRODUTO LEFT JOIN TDOACAOPRODUTO DP ON P.ID = DP.ID_PRODUTO";
	private static String SQL_DOADO_NAO = SQL_DOACAO + "WHERE ID_DOACAO IS NULL";
	private static String SQL_DOADO_SIM = SQL_DOACAO + "WHERE ID_DOACAO IS NOT NULL";
	
	public static boolean incluir(Descartavel descartavel) {
		try {
			Produto produto = ProdutoDao.incluir(descartavel);
			
			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT into TDescartavel (idProduto, unidadeMedida, validade, remedio, aberto) values (?,?,?,?,?)");
			ps.setInt(1, produto.getId());
			ps.setString(2, descartavel.getUnidadeMedida());
			ps.setDate(3, new java.sql.Date(descartavel.getValidade().getTime()));
			ps.setBoolean(4, descartavel.isRemedio());
			ps.setBoolean(5, descartavel.isAberto());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static List<Descartavel> obterLista() {
		List<Descartavel> lista = new ArrayList<Descartavel>();

		String sql = "SELECT * FROM TDescartavel d inner join TProduto p ON p.idProduto = d.idProduto";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Descartavel descartavel = new Descartavel();
				descartavel.setId(rs.getInt("idDescartavel"));
				descartavel.setNome(rs.getString("nome"));
				descartavel.setUnidadeMedida(rs.getString("unidadeMedida"));
				descartavel.setQuantidade(rs.getFloat("quantidade"));
				descartavel.setAberto(rs.getBoolean("aberto"));
				descartavel.setRemedio(rs.getBoolean("remedio"));
				descartavel.setNovo(rs.getBoolean("novo"));
				lista.add(descartavel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}
	
	public static List<Descartavel> obterLista(boolean doado) {
		List<Descartavel> lista = new ArrayList<Descartavel>();

		String sql = doado ? SQL_DOADO_SIM : SQL_DOADO_NAO;

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Descartavel descartavel = new Descartavel();
				descartavel.setId(rs.getInt("idDescartavel"));
				descartavel.setNome(rs.getString("nome"));
				descartavel.setUnidadeMedida(rs.getString("unidadeMedida"));
				descartavel.setQuantidade(rs.getFloat("quantidade"));
				descartavel.setAberto(rs.getBoolean("aberto"));
				descartavel.setRemedio(rs.getBoolean("remedio"));
				descartavel.setNovo(rs.getBoolean("novo"));
				lista.add(descartavel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public static Descartavel recuperar(int id) {
		Descartavel descartavel = new Descartavel();
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement("SELECT * FROM TDescartavel where idDescartavel = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				descartavel.setId(rs.getInt("idDescartavel"));
				descartavel.setNome(rs.getString("nome"));
				descartavel.setUnidadeMedida(rs.getString("unidadeMedida"));
				descartavel.setQuantidade(rs.getFloat("quantidade"));
				descartavel.setAberto(rs.getBoolean("aberto"));
				descartavel.setRemedio(rs.getBoolean("remedio"));
				descartavel.setNovo(rs.getBoolean("novo"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return descartavel;
	}

	public static void excluir(int id) {
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement("DELETE FROM TDescartavel WHERE idDescartavel = ?");
			ps.setInt(0, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
