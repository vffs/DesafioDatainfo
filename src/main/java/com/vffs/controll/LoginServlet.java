package com.vffs.controll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.vffs.model.Usuario;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Usuario> usuarios = new ArrayList<>();;

	public LoginServlet() {		
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		usuarios.add(new Usuario("Lorenzo","lorenzo@gmail.com","123456"));
		usuarios.add(new Usuario("Francisca","francisca@gmail.com","123456"));
		usuarios.add(new Usuario("Leticia","leticia@gmail.com","123456"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String email = request.getParameter("eml");
		String senha = request.getParameter("psw");
				
		for(Usuario user: usuarios) {
			if(user.getEmail().equals(email) && user.getSenha().equals(senha)) {
				request.setAttribute("user", user);			
				request.setAttribute("nameUser", user.getNome());
			}		
			
		}
		
		if(request.getAttribute("user") != null) {
			
			request.getRequestDispatcher("WEB-INF/indexLogado.jsp").forward(request, response);
		}
		else {
			request.setAttribute("falhalogin", "Falhou");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
			
		}
		
	}

}
