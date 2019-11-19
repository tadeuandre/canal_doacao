package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import conexao.Conexao;
import modelo.Produto;

public class ProdutoDao {
	
	public static Produto obterPorId(int id){
		
		Produto produto = BrinquedoDao.obterPorId(id); 			
		
		if(produto == null) {
			produto = DescartavelDao.obterPorId(id);
			
			if(produto == null) {
				produto = RoupaDao.obterPorId(id);							
			}
		}
	
		return produto;
	}
	public static Set<Produto> obterListaPorDoacao(int idDoacao){
		Set<Produto> lista = new HashSet<Produto>();

		String sql = "SELECT * FROM TDoacaoProduto where idDoacao = ?";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, idDoacao);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				lista.add(
						obterPorId(rs.getInt("idProduto"))						
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public static Produto incluir(Produto produto) {
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"INSERT INTO TProduto"
							+ "(nome, novo, quantidade) "
							+ "VALUES "
							+ "(?,?,?)", 
							Statement.RETURN_GENERATED_KEYS
						);

			ps.setString(1, produto.getNome());
			ps.setBoolean(2, produto.isNovo());
			ps.setFloat(3, produto.getQuantidade());
			
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				produto.setId(rs.getInt(1));
				return produto;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;		
	}

	public static boolean excluir(int id){
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"DELETE FROM TProduto WHERE id = ?"
						);

			ps.setInt(1, id);
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}

	public static Set<Produto> obterLista(boolean emprestado){
		Set<Produto> lista = new HashSet<Produto>();
		
		lista.addAll(BrinquedoDao.obterLista(emprestado));
		lista.addAll(DescartavelDao.obterLista(emprestado));
		lista.addAll(RoupaDao.obterLista(emprestado));

		return lista;
	}	

	public static Set<Produto> obterLista(){
		Set<Produto> lista = new HashSet<Produto>();
		
		lista.addAll(BrinquedoDao.obterLista());
		lista.addAll(DescartavelDao.obterLista());
		lista.addAll(RoupaDao.obterLista());

		return lista;
	}	
}