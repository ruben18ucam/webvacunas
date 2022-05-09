package ucam.servlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ucam.objetos.Usuarios;
import ucam.objetos.Videojuegos;

/**
 * Servlet implementation class EliminarUsuario
 */
@WebServlet("/eliminarusuario")
public class EliminarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean borrar=false;
		String paramNombre = request.getParameter(Usuarios.PARAM_NOMBREE);
	     System.out.println(paramNombre);
		Hashtable<String,Usuarios> contenedorUsuarios = (Hashtable<String,Usuarios>) request.getServletContext().getAttribute(Login.ATR_USUARIOS);

		for(Usuarios v: contenedorUsuarios.values()){
			if(v.getNombreUsuario().equals(paramNombre)) {				
				 
					borrar=true;
				
			}
		}
		
		if(borrar==true) {
			
			contenedorUsuarios.remove(paramNombre);
            request.setAttribute(Login.MENSAJE_ACCIONES, "Usuarios borrado correctamente");
		}else {
            request.setAttribute(Login.MENSAJE_ACCIONES, "Usuario no encontrado");
		}
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
