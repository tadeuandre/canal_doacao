package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Usuario;

public class UsuarioDao {

	public static List<Usuario> obterLista(){
		List<Usuario> lista = new ArrayList<Usuario>();

		String sql = "SELECT * FROM TUsuario ORDER BY nome";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				lista.add(
						new Usuario(
								rs.getInt("id"),
								rs.getString("nome"),
								rs.getString("email"), 
								rs.getString("senha")
							)
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public static Usuario validar(String email, String senha){
		String sql = "SELECT * FROM TUsuario WHERE email = ? AND senha = ?";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, senha);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				return new Usuario(
						rs.getInt("id"), 
						rs.getString("nome"), 
						rs.getString("email"), 
						rs.getString("senha")
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean incluir(Usuario usuario){
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"INSERT into TUsuario (nome, email, senha) values (?,?,?)"
						);

			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getSenha());
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}

	public static boolean alterar(Usuario usuario){
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"UPDATE TUsuario SET nome = ?, email = ?, senha = ? WHERE id = ?"
						);

			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getSenha());
			ps.setInt(4, usuario.getId());
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}
	
	public static boolean excluir(int id){
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"DELETE FROM TUsuario WHERE id = ?"
						);

			ps.setInt(1, id);
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}
}