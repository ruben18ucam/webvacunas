package ucam.servlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ucam.objetos.Usuarios;
import ucam.objetos.Valoracion;


/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String PARAM_NOMBRE ="PARAM_NOMBRE";
	public static final String PARAM_NOMBREVIDEOJUEGO ="PARAM_NOMBREVIDEOJUEGO";
	public static final String PARAM_CLAVE = "PARAM_CLAVE";
	public static final String PARAM_VALORACION = "PARAM_VALORACION";
	public static final String MENSAJE = "MENSAJE";
	public static final String MENSAJE_ACCIONES = "MENSAJE_ACCIONES";
	
	public static final String ATR_USUARIOS ="ATR_USUARIOS";
	public static final String ATR_VIDEOJUEGOS ="ATR_VIDEOJUEGOS";
	public static final String ATR_CATEGORIAS ="ATR_CATEGORIAS";
	public static final String ATR_USUARIO ="ATR_USUARIO";
	public static final String ATR_VALORACIONES ="ATR_VALORACIONES";
	
   // public static Hashtable<String,Valoracion> contenedorValoraciones = new Hashtable<String, Valoracion>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramNombre = request.getParameter(Login.PARAM_NOMBRE);
		String paramClave = request.getParameter(Login.PARAM_CLAVE);
		
		//el contexto lo cojo del request.getserv o this. ....
		System.out.println("llega1");
		Hashtable<String, Usuarios> users = (Hashtable<String, Usuarios>) this.getServletContext().getAttribute(Login.ATR_USUARIOS);
		System.out.println("llega2");
		
		System.out.println(paramNombre);
		
		Usuarios u1 = users.get(paramNombre);
		
		String destino="jsp/acciones.jsp";
		
		if(u1 != null) {
			if(u1.getClave().equals(paramClave)) {
				request.setAttribute(Login.MENSAJE, null);
				request.getSession().setAttribute(Login.ATR_USUARIO, u1.getNombreUsuario());
			}
			else {
				request.setAttribute(Login.MENSAJE, "Contraseña incorrecta");
				destino="jsp/loginusuario.jsp";
			}
			
		}else {
			request.setAttribute(Login.MENSAJE, "usuario nulo");
			destino="jsp/loginusuario.jsp";
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
