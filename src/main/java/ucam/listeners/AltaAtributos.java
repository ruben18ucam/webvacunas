package ucam.listeners;

import java.util.Hashtable;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import ucam.objetos.Categoria;
import ucam.objetos.Usuarios;
import ucam.objetos.Valoracion;
import ucam.objetos.Videojuegos;



/**
 * Application Lifecycle Listener implementation class AltaAtributos
 *
 */
@WebListener
public class AltaAtributos implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AltaAtributos() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("Inicializando atributos de contexto...");
    	System.out.println("Vamos a introducir el admin");
    	Hashtable<String, Usuarios> contenedorUsuarios= new  Hashtable<String, Usuarios>();
    	contenedorUsuarios.put("admin", new Usuarios("admin","admin","admin"));
        arg0.getServletContext().setAttribute("ATR_USUARIOS", contenedorUsuarios);
         
         
         Hashtable<String,Videojuegos> contenedorVideojuegos = new Hashtable<String, Videojuegos>();
         contenedorVideojuegos.put("fifa", new Videojuegos("fifa","deportes", true,true));
         contenedorVideojuegos.put("call of duty", new Videojuegos("call of duty","accion", true,true));
         arg0.getServletContext().setAttribute("ATR_VIDEOJUEGOS", contenedorVideojuegos);
         
         Hashtable<String,Categoria> contenedorCategorias = new Hashtable<String, Categoria>();
         contenedorCategorias.put("deportes", new Categoria("deportes"));
         contenedorCategorias.put("accion", new Categoria("accion"));
         arg0.getServletContext().setAttribute("ATR_CATEGORIAS", contenedorCategorias);
              
        Hashtable<String,Valoracion> contenedorValoraciones = new Hashtable<String, Valoracion>();
         arg0.getServletContext().setAttribute("ATR_VALORACIONES", contenedorValoraciones);
         
    }
	
}
