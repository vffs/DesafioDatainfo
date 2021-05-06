package com.vffs.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vffs.exceptions.SqlException;
import com.vffs.model.Telefone;
import com.vffs.model.Usuario;

public class TelefoneDao implements Dao<Telefone>{
	private static final String SQL_INCLUIR = "INSERT INTO PUBLIC.TELEFONE(DDD, NUMERO, TIPO, IDUSUARIO) VALUES(?, ?, ?, ?)";
    private final Connection conexao;
    private  List<Telefone> telefones;
    private Telefone telefone;
	
	public TelefoneDao(Connection connection) {
		this.conexao = connection;
	}

	@Override
	public boolean insert(Telefone t) {
		boolean retorno = false;
		
		try {
            PreparedStatement preparedStatement = this.conexao.prepareStatement("INSERT INTO telefone(ddd, numero, tipo, idusuario) VALUES(?, ?, ?, ?)");
            preparedStatement.setInt(1, t.getDdd());
            preparedStatement.setString(2, t.getNumero());
            preparedStatement.setString(3, t.getTipo());
            preparedStatement.setInt(4, t.getIdUsuario());
            retorno = preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Código erro" + ex.getErrorCode());
            System.out.println(ex.getMessage());
            new SqlException(ex).getMensagem();
        }
		
		return retorno;
	}

	
	public List<Telefone> findById(Integer id) {
		 telefone = null;
		try {
            PreparedStatement preparedStatement = this.conexao.prepareStatement("SELECT * FROM telefone WHERE id = ?;");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer ddd = resultSet.getInt("ddd");
                String numero = resultSet.getString("numero");
                String tipo = resultSet.getString("tipo");
                
                telefone = new Telefone(id, ddd, numero,tipo);
                telefones.add(telefone);
            }
        } catch (SQLException ex) {
            System.out.println("Código erro" + ex.getErrorCode());
            System.out.println(ex.getMessage());
            new SqlException(ex).getMensagem();
        }
		return telefones;
	}

	@Override
	public List<Telefone> findAll() {
		telefone = null;
		telefones =  new ArrayList<>();
		try {
			PreparedStatement preparedStatement = this.conexao.prepareStatement("SELECT * FROM Telefone;");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				Integer ddd = resultSet.getInt("ddd");
                String numero = resultSet.getString("numero");
                String tipo = resultSet.getString("tipo");
                
                telefone = new Telefone(id, ddd, numero,tipo);
                telefones.add(telefone);
			}

		} catch (SQLException ex) {
			System.out.println("Código erro" + ex.getErrorCode());
			System.out.println(ex.getMessage());
			new SqlException(ex).getMensagem();
		}

		return telefones;
	}

	@Override
	public void update(Integer id, Telefone t) {
		try {
			PreparedStatement preparedStatement = this.conexao.prepareStatement("UPDATE Telefone SET ddd = ?, numero = ?, tipo = ?, idusuario = ? WHERE id = ?");
			preparedStatement.setInt(1, t.getDdd());
			preparedStatement.setString(2, t.getNumero());
			preparedStatement.setString(3, t.getTipo());
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
			PreparedStatement preparedStatement = this.conexao.prepareStatement("DELETE FROM telefone where id = ?;");
			preparedStatement.setLong(1, id);
			preparedStatement.execute();

		} catch (SQLException ex) {
			System.out.println("Código erro" + ex.getErrorCode());
			System.out.println(ex.getMessage());
			new SqlException(ex).getMensagem();
		}
		
	}

}
