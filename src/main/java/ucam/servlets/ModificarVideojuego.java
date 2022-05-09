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
 * Servlet implementation class ModificarVideojuego
 */
@WebServlet("/modificarvideojuego")
public class ModificarVideojuego extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarVideojuego() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreVideojuego = request.getParameter(AltaVideojuegos.VARIABLE_VIDEOJUEGO);
		Hashtable<String,Videojuegos> contenedorVideojuegos = (Hashtable<String,Videojuegos>) request.getServletContext().getAttribute(Login.ATR_VIDEOJUEGOS);
        
		Videojuegos u = contenedorVideojuegos.get(nombreVideojuego);	
		String paramVenta = request.getParameter(AltaVideojuegos.VARIABLE_VENTA);
		String paramAlquiler = request.getParameter(AltaVideojuegos.VARIABLE_ALQUILER);
		
		
		if(paramVenta ==null) {
			u.setVenta(false);
		}else {
			u.setVenta(true);
		}
       if(paramAlquiler==null) {
    	   u.setAlquiler(false);
       }else {
    	   u.setAlquiler(true);
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
