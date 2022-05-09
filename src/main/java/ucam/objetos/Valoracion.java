package ucam.objetos;

public class Valoracion {

	private String nombreVideojuego;
	private String nombreCliente;
	private int valoracion;
	
	
	public Valoracion(String nombreVideojuego, String nombreCliente, int valoracion) {
		super();
		this.nombreVideojuego = nombreVideojuego;
		this.nombreCliente = nombreCliente;
		this.valoracion = valoracion;
	}
	
	
	public String getNombreVideojuego() {
		return nombreVideojuego;
	}
	public void setNombreVideojuego(String nombreVideojuego) {
		this.nombreVideojuego = nombreVideojuego;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public int getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	
	
	
}
