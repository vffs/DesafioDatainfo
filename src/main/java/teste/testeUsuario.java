package teste;

import java.util.ArrayList;
import java.util.List;

import com.vffs.model.Telefone;
import com.vffs.model.Usuario;
import com.vffs.persistencia.ConnectionFactory;
import com.vffs.persistencia.TelefoneDao;
import com.vffs.persistencia.UsuarioDao;

public class testeUsuario {

	public static void main(String[] args) {
		UsuarioDao usuarioDao = new UsuarioDao(ConnectionFactory.getInstance().getConnection());
		TelefoneDao telefoneDao = new TelefoneDao(ConnectionFactory.getInstance().getConnection());
		List<Telefone> telefones = new ArrayList<>();
		Usuario user = new Usuario("Joao","joao@gmail.com","123456");
		Telefone telefone = new Telefone(81,"3333-2222","RESIDENCIAL");
		telefones.add(telefone);
		telefone = new Telefone(81,"98888-7777","CELULAR");
		telefones.add(telefone);
		user.setTelefones(telefones);
		
		usuarioDao.insert(user);
		
				
		System.out.println(usuarioDao.findById(1));	
		
		for(Usuario u : usuarioDao.findAll()) {
			System.out.println("Id: " + u.getId());
			System.out.println("Nome: " + u.getNome());
			System.out.println("Senha: " + u.getSenha());
			System.out.println("Email: " + u.getEmail());
		}
		
		Usuario usuarioAlterar = usuarioDao.findById(1);
		usuarioAlterar.setNome("João Fransico");
		usuarioDao.update(1, usuarioAlterar);
		System.out.println(usuarioDao.findById(1));
		usuarioDao.delete(2);
		System.out.println(usuarioDao.findById(2));
	}

}
