package modelo;

public class Monte {
	private String nombre;
	private String provincia;
	private double altura;
	private String coordenadas;
	private String macizo;
	private String ruta;
	
	public Monte(String nombre, String provincia, double altura, String coordenadas, String macizo, String ruta) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.altura = altura;
		this.coordenadas = coordenadas;
		this.macizo = macizo;
		this.ruta = ruta;
	}
	
	public Monte(String nombre, String provincia, double altura, String coordenadas, String macizo) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.altura = altura;
		this.coordenadas = coordenadas;
		this.macizo = macizo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}

	public String getMacizo() {
		return macizo;
	}

	public void setMacizo(String macizo) {
		this.macizo = macizo;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	
	
	
}
