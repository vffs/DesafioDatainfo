package com.vffs.controll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vffs.model.Telefone;
import com.vffs.model.Usuario;
import com.vffs.persistencia.ConnectionFactory;
import com.vffs.persistencia.TelefoneDao;
import com.vffs.persistencia.UsuarioDao;

public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private Telefone telefone;
	private UsuarioDao usuarioDao;
	private TelefoneDao telefoneDao;
	private List<Telefone> telefones;
	private List<Usuario> usuarios;
	
	@Override
	public void init() throws ServletException {	
		super.init();
		telefones = new ArrayList<>();
		usuarios = new ArrayList<>();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    //usuarioDao = new UsuarioDao(ConnectionFactory.getInstance().getConnection());
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		Integer dddRes = Integer.parseInt(request.getParameter("ddd"));
		String numero = request.getParameter("fone");
		String tipoRes = request.getParameter("tipo");
		Integer dddCel = Integer.parseInt(request.getParameter("dddCel"));
		String celular = request.getParameter("cel");
		String tipoCel = request.getParameter("tipoCel");
		
		usuario = new Usuario(nome, email, senha);
		
		if(dddRes != null && numero != null && tipoRes != null) {
			telefone = new Telefone(dddRes, numero, tipoRes);
			telefones.add(telefone);
		}
		
		telefone = new Telefone(dddCel, celular, tipoCel);
		telefones.add(telefone);
		usuario.setTelefones(telefones);
		//boolean inserir = usuarioDao.insert(usuario);	
		usuarios.add(usuario);
		
		if(usuarios.isEmpty()) {
			session.setAttribute("mensagem", "Erro ao cadastrar Usuario!");
		}	
		else {
			session.setAttribute("mensagem", "Usuario cadastrado com sucesso!");
		
		}
		
		response.sendRedirect("index.jsp");;
		
		
		
	}	
}
