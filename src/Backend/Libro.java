package Backend;

class Libro implements Comparable<Libro> {

    private String isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private int edicion;
    private int anioPublicacion;
    
   /* SECCIÓN CONSTRUCTORES*/
    
    public Libro() {
    	this.isbn = null;
    	this.titulo = null;
    	this.autor = null;
    	this.editorial = null;
    	this.edicion = 0;
    	this.anioPublicacion = 0;
    }
    
    public Libro(String isbn, String titulo, String autor, String editorial, int edicion, int anioPublicacion) {
    	this.isbn = isbn;
    	this.titulo = titulo;
    	this.autor = autor;
    	this.editorial = editorial;
    	this.edicion = edicion;
    	this.anioPublicacion = anioPublicacion;
    }
    

    /* MÉTODOS POR IMPLEMENTAR COMPARABLE */
    
    @Override
    public boolean equals(Object libro) {
        return this==libro || (libro instanceof Libro && this.isbn.equals(((Libro)libro).isbn));
    }

    @Override
    public int compareTo(Libro libro) {
        return this.isbn.compareTo(libro.isbn);
    }
    
   /* PARA IMPRIMIR POR CONSOLA*/
    
    @Override
    public String toString() {
        return
            "isbn               : " + this.isbn + "\n" +
            "titulo             : " + this.titulo + "\n" +
            "autor              : " + this.autor + "\n" +
            "editorial          : " + this.editorial + "\n" +
            "edicion            : " + this.edicion + "\n" +
            "anio de publicacion: " + this.anioPublicacion + "\n";
    }

    /* SECCIÓN GETTERS Y SETTERS */
    
    public String getIsbn() {
		return this.isbn;
	}
    
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

    public String getTitulo() {
        return this.titulo;
    }
    
	public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return this.editorial;
    }
    
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getEdicion() {
        return this.edicion;
    }
    
    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }
	public int getAnioPublicacion() {
		return this.anioPublicacion;
	}
	
	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}
   
}    
