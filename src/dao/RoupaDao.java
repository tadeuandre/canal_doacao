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

	public static boolean incluir(Roupa roupa) {
		try {
			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT into TRoupa (tipo, faixa_etaria, genero) values (?,?,?)");
			ps.setString(1, roupa.getTipo());
			ps.setString(2, roupa.getFaixaEtaria());
			ps.setString(3, roupa.getNome());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static List<Brinquedo> obterLista() {
		List<Brinquedo> lista = new ArrayList<Brinquedo>();

		String sql = "SELECT * FROM TRoupa ORDER BY nome";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Brinquedo brinquedo = new Brinquedo();
				brinquedo.setTipo(rs.getString("tipo"));
				brinquedo.setGenero(rs.getString("genero"));
				brinquedo.setFaixaEtaria(rs.getString("faixa_etaria"));
				lista.add(brinquedo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}
	
	public static void excluir(int id) {
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement("DELETE * FROM TRoupa WHERE id = ?");
			ps.setInt(0, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
