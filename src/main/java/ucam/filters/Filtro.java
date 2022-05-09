package ucam.filters;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import ucam.objetos.Usuarios;
import ucam.servlets.Login;

/**
 * Servlet Filter implementation class Filtro
 */
@WebFilter("/*")
public class Filtro implements Filter {

    /**
     * Default constructor. 
     */
    public Filtro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Ejecutamos el filtero");
		Usuarios u =null;
		String path = ((HttpServletRequest)request).getServletPath();
		System.out.println(path);
		Hashtable<String,Usuarios> contenedorUsuarios = (Hashtable<String,Usuarios>) request.getServletContext().getAttribute(Login.ATR_USUARIOS);
		//Usuarios u = contenedorUsuarios.get(((HttpServletRequest)request).getSession().getAttribute(Login.ATR_USUARIO));
		if((((HttpServletRequest)request).getSession().getAttribute(Login.ATR_USUARIO) != null)) {
			 u = contenedorUsuarios.get(((HttpServletRequest)request).getSession().getAttribute(Login.ATR_USUARIO));
		}
		if("/index.jsp".equals(path)) {
			System.out.println("ok");
		}else if("/jsp/loginusuario.jsp".equals(path)) {
			System.out.println("ok");
		}else if("/jsp/altausuario.jsp".equals(path)) {
			System.out.println("ok");
		}else if("/altausuairo".equals(path)) {
			System.out.println("ok");
		}else if("/login".equals(path)) {
			System.out.println("ok");
		}else {
			System.out.println("se mete en el null");
			if((((HttpServletRequest)request).getSession().getAttribute(Login.ATR_USUARIO) == null) ) {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				}else {
				if(u.getRol().equals("cliente")) {
					if("/jsp/altausuario.jsp".equals(path)) {
						request.getRequestDispatcher("/jsp/acciones.jsp").forward(request, response);
					}else if("/jsp/verusuarios.jsp".equals(path)) {
						request.getRequestDispatcher("/jsp/acciones.jsp").forward(request, response);
					}else if("/jsp/anadirvideojuego.jsp".equals(path)) {
						request.getRequestDispatcher("/jsp/acciones.jsp").forward(request, response);
					}else if("/jsp/anadircategoria.jsp".equals(path)) {
						request.getRequestDispatcher("/jsp/acciones.jsp").forward(request, response);
					}
				}
		}	
		
		}
		chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
