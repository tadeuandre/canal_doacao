package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import modelo.Produto;
import negocio.Brinquedo;

public class BrinquedoDao {
	
	private static String SQL_DOACAO = "SELECT * FROM  TPRODUTO P INNER JOIN TDESCARTAVEL D ON P.ID = D.ID_PRODUTO LEFT JOIN TDOACAOPRODUTO DP ON P.ID = DP.ID_PRODUTO";
	private static String SQL_DOADO_NAO = SQL_DOACAO + "WHERE ID_DOACAO IS NULL";
	private static String SQL_DOADO_SIM = SQL_DOACAO + "WHERE ID_DOACAO IS NOT NULL";

	public static boolean incluir(Brinquedo brinquedo) {
		try {
			Produto produto = ProdutoDao.incluir(brinquedo);

			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT into TBrinquedo (idProduto, tipo, faixaEtaria, genero) values (?, ?, ?, ?)");
			ps.setInt(1, produto.getId());
			ps.setString(2, brinquedo.getTipo());
			ps.setString(3, brinquedo.getFaixaEtaria());
			ps.setString(4, brinquedo.getGenero());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static List<Brinquedo> obterLista() {
		List<Brinquedo> lista = new ArrayList<Brinquedo>();

		String sql = "SELECT * FROM TBrinquedo";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Brinquedo brinquedo = new Brinquedo();
				brinquedo.setId(rs.getInt("idBrinquedo"));
				brinquedo.setTipo(rs.getString("tipo"));
				brinquedo.setGenero(rs.getString("genero"));
				brinquedo.setFaixaEtaria(rs.getString("faixaEtaria"));
				lista.add(brinquedo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}
	
	public static List<Brinquedo> obterLista(boolean doado) {
		List<Brinquedo> lista = new ArrayList<Brinquedo>();

		String sql = doado ? SQL_DOADO_SIM : SQL_DOADO_NAO;

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Brinquedo brinquedo = new Brinquedo();
				brinquedo.setId(rs.getInt("idBrinquedo"));
				brinquedo.setTipo(rs.getString("tipo"));
				brinquedo.setGenero(rs.getString("genero"));
				brinquedo.setFaixaEtaria(rs.getString("faixaEtaria"));
				lista.add(brinquedo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public static Brinquedo recuperar(int id) {
		Brinquedo brinquedo = new Brinquedo();
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement("SELECT * FROM TBrinquedo ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				brinquedo.setId(rs.getInt("idBrinquedo"));
				brinquedo.setTipo(rs.getString("tipo"));
				brinquedo.setGenero(rs.getString("genero"));
				brinquedo.setFaixaEtaria(rs.getString("faixaEtaria"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return brinquedo;
	}

	public static void excluir(int id) {
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement("DELETE FROM TBrinquedo WHERE idBrinquedo = ?");
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
