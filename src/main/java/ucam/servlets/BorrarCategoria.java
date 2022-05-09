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
 * Servlet implementation class BorrarCategoria
 */
@WebServlet("/borrarcategoria")
public class BorrarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean borrar=true;
		String paramCategoria = request.getParameter(Categoria.PARAM_CATEGORIA);
	   System.out.println(paramCategoria);
		Hashtable<String,Videojuegos> contenedorVideojuegos = (Hashtable<String,Videojuegos>) request.getServletContext().getAttribute(Login.ATR_VIDEOJUEGOS);

		for(Videojuegos v: contenedorVideojuegos.values()){
			if(v.getCategorias().equals(paramCategoria)) {				
				   System.out.println(v.getCategorias()+paramCategoria);
					borrar=false;
				
			}
		}
		
		if(borrar==true) {
			Hashtable<String, Categoria> contenedorCategoria = (Hashtable<String, Categoria>) request.getServletContext().getAttribute(Login.ATR_CATEGORIAS);
            contenedorCategoria.remove(paramCategoria);
            request.setAttribute(Login.MENSAJE_ACCIONES, "Categoria borrada correctamente");
		}else {
            request.setAttribute(Login.MENSAJE_ACCIONES, "Categoria NO borrada, debido a que hay videojuegos");
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
