package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Brinquedo;
import negocio.Roupa;

public class RoupaDao {

	private static String SQL_DOACAO = "SELECT * FROM  TPRODUTO P INNER JOIN TDESCARTAVEL D ON P.ID = D.ID_PRODUTO LEFT JOIN TDOACAOPRODUTO DP ON P.ID = DP.ID_PRODUTO";
	private static String SQL_DOADO_NAO = SQL_DOACAO + "WHERE ID_DOACAO IS NULL";
	private static String SQL_DOADO_SIM = SQL_DOACAO + "WHERE ID_DOACAO IS NOT NULL";

	public static boolean incluir(Roupa roupa) {
		try {
			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT into TRoupa (tamanho, tipo, faixa_etaria, marca) values (?,?,?,?)");
			ps.setString(1, roupa.getTamanho());
			ps.setString(2, roupa.getTipo());
			ps.setString(3, roupa.getFaixaEtaria());
			ps.setString(4, roupa.getMarca());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static List<Roupa> obterLista() {
		List<Roupa> lista = new ArrayList<Roupa>();

		String sql = "SELECT * FROM TRoupa";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Roupa roupa = new Roupa();
				roupa.setTipo(rs.getString("tipo"));
				roupa.setMarca(rs.getString("marca"));
				roupa.setTamanho(rs.getString("tamanho"));
				roupa.setFaixaEtaria(rs.getString("faixa_etaria"));
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
				roupa.setTipo(rs.getString("tipo"));
				roupa.setMarca(rs.getString("marca"));
				roupa.setTamanho(rs.getString("tamanho"));
				roupa.setFaixaEtaria(rs.getString("faixa_etaria"));
				lista.add(roupa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public static void excluir(int id) {
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement("DELETE FROM TRoupa WHERE id = ?");
			ps.setInt(0, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
