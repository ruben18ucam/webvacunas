package ucam.servlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ucam.objetos.Categoria;
import ucam.objetos.Videojuegos;

/**
 * Servlet implementation class BorrarVideojuego
 */
@WebServlet("/borrarvideojuego")
public class BorrarVideojuego extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarVideojuego() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		boolean borrar=false;
		String paramNombre = request.getParameter(AltaVideojuegos.VARIABLE_VIDEOJUEGO);
	     System.out.println(paramNombre);
		Hashtable<String,Videojuegos> contenedorVideojuegos = (Hashtable<String,Videojuegos>) request.getServletContext().getAttribute(Login.ATR_VIDEOJUEGOS);

		for(Videojuegos v: contenedorVideojuegos.values()){
			if(v.getNombre().equals(paramNombre)) {				
				 
					borrar=true;
				
			}
		}
		
		if(borrar==true) {
			
			contenedorVideojuegos.remove(paramNombre);
            request.setAttribute(Login.MENSAJE_ACCIONES, "Videojuego borrado correctamente");
		}else {
            request.setAttribute(Login.MENSAJE_ACCIONES, "Videojuego no encontrado");
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
