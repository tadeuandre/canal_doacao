package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Brinquedo;

public class BrinquedoDao {

	public static boolean incluir(Brinquedo brinquedo) {
		try {
			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT into TBrinquedo (tipo, faixa_etaria, genero) values (?,?,?)");
			ps.setString(1, brinquedo.getTipo());
			ps.setString(2, brinquedo.getFaixaEtaria());
			ps.setString(3, brinquedo.getNome());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static List<Brinquedo> obterLista() {
		List<Brinquedo> lista = new ArrayList<Brinquedo>();

		String sql = "SELECT * FROM TBrinquedo ORDER BY nome";

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
}
