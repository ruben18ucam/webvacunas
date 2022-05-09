package ucam.tags;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import ucam.objetos.Valoracion;
import ucam.servlets.Login;

public class TagValoracion extends TagSupport{

	private String nombreVideojuego;
	private String nombreCliente;
	private int valoracion;

    public int doStartTag() throws JspException {
        try{
           System.out.println("etiqueta");
       
           Valoracion v = new Valoracion(nombreVideojuego, nombreCliente, valoracion);
           
           Hashtable<String,Valoracion> contenedorValoraciones = (Hashtable<String, Valoracion>) pageContext.getServletContext().getAttribute(Login.ATR_VALORACIONES);
           Valoracion prueba = contenedorValoraciones.get(nombreVideojuego);
         
           if(prueba!=null) {
        	   if(prueba.getNombreCliente().equals(nombreCliente)) {
        		   pageContext.getOut().println("Juego valorado con anterioridad: Error");
        		   pageContext.getRequest().setAttribute(Login.MENSAJE_ACCIONES, "Juego valorado con anterioridad:");
        	   }else {
        		   pageContext.getOut().println("Juego valorado correctamente: "+nombreVideojuego +" | "+nombreCliente +" | "+valoracion);
        		   pageContext.getRequest().setAttribute(Login.MENSAJE_ACCIONES, "Juego valorado correctamente: "+nombreVideojuego +" | "+nombreCliente +" | "+valoracion);
             	  contenedorValoraciones.put(nombreVideojuego, v);
        	   }
           }else {
        	  pageContext.getOut().println("Juego valorado correctamente: "+nombreVideojuego +" | "+nombreCliente +" | "+valoracion);
        	  contenedorValoraciones.put(nombreVideojuego, v);
        	  pageContext.getRequest().setAttribute(Login.MENSAJE_ACCIONES, "Juego valorado correctamente: "+nombreVideojuego +" | "+nombreCliente +" | "+valoracion);
           }
           
           
        } catch (IOException e) {
            throw new JspException ("Error: IOException" + e.getMessage());
        }
      

        return SKIP_BODY;
    }
	
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

	

	public void setNombreVideojuego(String nombreVideojuego) {
		//this.nombreVideojuego = nombreVideojuego;
		System.out.println((String) pageContext.getRequest().getParameter(Login.PARAM_NOMBREVIDEOJUEGO));
		this.nombreVideojuego= (String) pageContext.getRequest().getParameter(Login.PARAM_NOMBREVIDEOJUEGO);
	
	}


	public void setNombreCliente(String nombreCliente) {
	System.out.println((String) pageContext.getSession().getAttribute(Login.ATR_USUARIO));
	this.nombreCliente = (String) pageContext.getSession().getAttribute(Login.ATR_USUARIO);
	
	}

	
	public void setValoracion(String valoracion) {
		System.out.println((String) pageContext.getRequest().getParameter(Login.PARAM_VALORACION));
		this.valoracion = Integer.parseInt( (String) pageContext.getRequest().getParameter(Login.PARAM_VALORACION));
		
	}

   
	
}
