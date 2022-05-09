package ucam.servlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ucam.objetos.Categoria;
import ucam.objetos.Usuarios;
import ucam.objetos.Videojuegos;

/**
 * Servlet implementation class ModificarUsuario
 */
@WebServlet("/modificarusuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombreUsuario = request.getParameter(Usuarios.PARAM_NOMBREE);
		Hashtable<String,Usuarios> contenedorUsuarios = (Hashtable<String,Usuarios>) request.getServletContext().getAttribute(Login.ATR_USUARIOS);
        
		Usuarios u = contenedorUsuarios.get(nombreUsuario);	
		u.setRol("admin");
		request.getRequestDispatcher("/jsp/acciones.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
