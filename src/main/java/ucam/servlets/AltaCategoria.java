package ucam.servlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ucam.objetos.Categoria;

/**
 * Servlet implementation class AltaCategoria
 */
@WebServlet("/altacategoria")
public class AltaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Aqui si llega suuuuuuuuuuuu");
		String nombreCategoria = request.getParameter(Categoria.PARAM_CATEGORIA);
		String destino = "jsp/acciones.jsp";
		if("".equals(nombreCategoria)||nombreCategoria==null) {
			request.setAttribute(Login.MENSAJE_ACCIONES, "Error al crear la categoria");
		}else {
			request.setAttribute(Login.MENSAJE_ACCIONES, "Categoria creada correctamente: "+ nombreCategoria);
			Hashtable<String,Categoria> contenedorCategorias= (Hashtable<String,Categoria>)request.getServletContext().getAttribute(Login.ATR_CATEGORIAS);
			contenedorCategorias.put(nombreCategoria, new Categoria(nombreCategoria));
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
