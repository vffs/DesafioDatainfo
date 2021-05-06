package com.vffs.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.vffs.exceptions.SqlException;
import com.vffs.model.Usuario;


public class UsuarioDao implements Dao<Usuario>{
	private static final String SQL_INCLUIR = "INSERT INTO PUBLIC.USUARIO(NOME, EMAIL, SENHA) VALUES(?, ?, ?)";
	private final Connection conexao;
	
	public UsuarioDao(Connection connection) {
		this.conexao = connection;
	}
	
	@Override
	public boolean insert(Usuario t) {
		boolean retorno = false;
		 try {
	            PreparedStatement preparedStatement = this.conexao.prepareStatement("INSERT INTO usuario(nome, email, senha) VALUES(?, ?, ?)");
	            preparedStatement.setString(1, t.getNome());
	            preparedStatement.setString(2, t.getEmail());
	            preparedStatement.setString(3, t.getSenha());;
	            retorno =  preparedStatement.execute();
	        } catch (SQLException ex) {
	            System.out.println("Código erro" + ex.getErrorCode());
	            System.out.println(ex.getMessage());
	            new SqlException(ex).getMensagem();
	        }
		 
		 return retorno;
	}

		public Usuario findById(Integer id) {
		Usuario usuario = null;
		try {
            PreparedStatement preparedStatement = this.conexao.prepareStatement("SELECT * FROM usuario WHERE id = ?;");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                
                usuario = new Usuario(id, nome, email,senha);
            }
        } catch (SQLException ex) {
            System.out.println("Código erro" + ex.getErrorCode());
            System.out.println(ex.getMessage());
            new SqlException(ex).getMensagem();
        }
		return usuario;
	}

	@Override
	public List<Usuario> findAll() {
		 List<Usuario> usuarios = new ArrayList<>();

	        try {
	            PreparedStatement preparedStatement = this.conexao.prepareStatement("SELECT * FROM usuario;");

	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	            	Integer id = resultSet.getInt("id");
	            	String nome = resultSet.getString("nome");
	                String email = resultSet.getString("email");
	                String senha = resultSet.getString("senha");
	                
	                usuarios.add(new Usuario(id, nome, email,senha));
	            }

	        } catch (SQLException ex) {
	            System.out.println("Código erro" + ex.getErrorCode());
	            System.out.println(ex.getMessage());
	            new SqlException(ex).getMensagem();
	        }

	        return usuarios;
	}

	@Override
	public void update(Integer id, Usuario t) {
		try {
            PreparedStatement preparedStatement = this.conexao.prepareStatement("UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?");
            preparedStatement.setString(1, t.getNome());
            preparedStatement.setString(2, t.getEmail());
            preparedStatement.setString(3, t.getSenha());
            preparedStatement.setLong(4, id);
            preparedStatement.execute();

        } catch (SQLException ex) {
            System.out.println("Código erro" + ex.getErrorCode());
            System.out.println(ex.getMessage());
            new SqlException(ex).getMensagem();
        }
	}

	@Override
	public void delete(Integer id) {
		try {
            PreparedStatement preparedStatement = this.conexao.prepareStatement("DELETE FROM usuario where id = ?;");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

        } catch (SQLException ex) {
            System.out.println("Código erro" + ex.getErrorCode());
            System.out.println(ex.getMessage());
            new SqlException(ex).getMensagem();
        }
		
	}

}
