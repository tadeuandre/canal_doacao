package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import modelo.Produto;
import negocio.Roupa;

public class RoupaDao {

	private static String SQL_DOACAO = "SELECT * FROM  TPRODUTO P INNER JOIN TDESCARTAVEL D ON P.IDPRODUTO = D.IDPRODUTO LEFT JOIN TDOACAOPRODUTO DP ON P.IDPRODUTO = DP.IDPRODUTO";
	private static String SQL_DOADO_NAO = SQL_DOACAO + "WHERE ID_DOACAO IS NULL";
	private static String SQL_DOADO_SIM = SQL_DOACAO + "WHERE ID_DOACAO IS NOT NULL";

	public static boolean incluir(Roupa roupa) {
		try {
			Produto produto = ProdutoDao.incluir(roupa);

			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT into TRoupa (idProduto, tamanho, tipo, faixaEtaria, marca) values (?, ?, ?, ?, ?)");
			ps.setInt(1, produto.getId());
			ps.setString(2, roupa.getTamanho());
			ps.setString(3, roupa.getTipo());
			ps.setString(4, roupa.getFaixaEtaria());
			ps.setString(5, roupa.getMarca());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static List<Roupa> obterLista() {
		List<Roupa> lista = new ArrayList<Roupa>();

		String sql = "SELECT * FROM TRoupa r INNER JOIN TProduto p ON r.idProduto = p.idProduto";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Roupa roupa = new Roupa();
				roupa.setId(rs.getInt("idRoupa"));
				roupa.setNome(rs.getString("nome"));
				roupa.setTipo(rs.getString("tipo"));
				roupa.setMarca(rs.getString("marca"));
				roupa.setTamanho(rs.getString("tamanho"));
				roupa.setFaixaEtaria(rs.getString("faixaEtaria"));
				roupa.setNovo(rs.getBoolean("novo"));
				roupa.setQuantidade(rs.getFloat("quantidade"));
				lista.add(roupa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}
	
	public static List<Roupa> obterLista(boolean doado) {
		List<Roupa> lista = new ArrayList<Roupa>();

		String sql = doado ? SQL_DOADO_SIM : SQL_DOADO_NAO;

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Roupa roupa = new Roupa();
				roupa.setId(rs.getInt("idRoupa"));
				roupa.setNome(rs.getString("nome"));
				roupa.setTipo(rs.getString("tipo"));
				roupa.setMarca(rs.getString("marca"));
				roupa.setTamanho(rs.getString("tamanho"));
				roupa.setFaixaEtaria(rs.getString("faixaEtaria"));
				roupa.setNovo(rs.getBoolean("novo"));
				roupa.setQuantidade(rs.getFloat("quantidade"));
				lista.add(roupa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public static Roupa recuperar(int id) {
		Roupa roupa = new Roupa();
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement("SELECT * FROM TRoupa r idRoupa = ? INNER JOIN TProduto p ON r.idProduto = p.idProduto");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				roupa.setId(rs.getInt("idRoupa"));
				roupa.setNome(rs.getString("nome"));
				roupa.setTipo(rs.getString("tipo"));
				roupa.setMarca(rs.getString("marca"));
				roupa.setTamanho(rs.getString("tamanho"));
				roupa.setFaixaEtaria(rs.getString("faixaEtaria"));
				roupa.setNovo(rs.getBoolean("novo"));
				roupa.setQuantidade(rs.getFloat("quantidade"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return roupa;
	}
	
	public static void excluir(int id) {
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement("DELETE FROM TRoupa WHERE idRoupa = ?");
			ps.setInt(0, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
