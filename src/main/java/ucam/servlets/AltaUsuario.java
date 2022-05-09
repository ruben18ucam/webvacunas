package ucam.servlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ucam.objetos.Usuarios;



/**
 * Servlet implementation class AltaUsuario
 */
@WebServlet("/altausuario")
public class AltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       System.out.println("ALTAUSUARIO");
       String paramNombre = request.getParameter(Login.PARAM_NOMBRE);
       String paramClave = request.getParameter(Login.PARAM_CLAVE);
       String destino = null;
       
       if("".equals(paramClave)||"".equals(paramNombre)) {
    	   destino ="jsp/altausuario.jsp";
    	   request.setAttribute(Login.MENSAJE, "DEBES RELLENAR LOS CAMPOS");
       }else {
    	   if(paramNombre==null || paramClave ==null) {
    		   destino ="jsp/altausuario.jsp";
    		   request.setAttribute(Login.MENSAJE, "ERROR EN CONTRASEÑA O USUARIO");
    	   }else {
    		   request.setAttribute(Login.MENSAJE, null);
    		   destino ="jsp/loginusuario.jsp";
    		   
    		   
    		Hashtable<String, Usuarios> usuarios =   (Hashtable<String, Usuarios>) request.getServletContext().getAttribute(Login.ATR_USUARIOS);
    		usuarios.put(paramNombre, new Usuarios(paramNombre,paramClave,"cliente"));
    		   
    	   }
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
