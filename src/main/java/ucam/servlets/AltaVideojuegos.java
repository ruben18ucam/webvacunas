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
 * Servlet implementation class AltaVideojuegos
 */
@WebServlet("/altavideojuegos")
public class AltaVideojuegos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VARIABLE_VENTA = "VARIABLE_VENTA";
	public static final String VARIABLE_ALQUILER = "VARIABLE_ALQUILER";
	public static final String VARIABLE_VIDEOJUEGO = "VARIABLE_VIDEOJUEGO";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaVideojuegos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramNombre = request.getParameter(AltaVideojuegos.VARIABLE_VIDEOJUEGO);
		String paramVenta = request.getParameter(AltaVideojuegos.VARIABLE_VENTA);
		String paramAlquiler = request.getParameter(AltaVideojuegos.VARIABLE_ALQUILER);
		String paramCategoria = request.getParameter(Categoria.PARAM_CATEGORIA);
		String destino ="jsp/acciones.jsp";
		boolean venta=true;
		boolean alquiler=true;
		
		if(paramVenta==null) {
			venta=false;
		}
		if(paramAlquiler==null) {
			alquiler=false;
		}
		
		if(paramNombre!=null||paramCategoria!=null) {
			
			Hashtable<String,Videojuegos> contenedorVideojuegos = (Hashtable<String,Videojuegos>) request.getServletContext().getAttribute(Login.ATR_VIDEOJUEGOS);
			contenedorVideojuegos.put(paramNombre, new Videojuegos(paramNombre,paramCategoria,venta,alquiler));
			request.setAttribute(Login.MENSAJE_ACCIONES, "Creado perfectamente: "+paramNombre);
			
		}else {
			request.setAttribute(Login.MENSAJE_ACCIONES, "Error al crear el videojuego");
		}
		request.getRequestDispatcher(destino).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
