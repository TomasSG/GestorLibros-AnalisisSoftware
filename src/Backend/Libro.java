package Backend;

class Libro implements Comparable<Libro> {

    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private int edicion;
    private int anno_de_publicacion;

    /* MÉTODOS POR IMPLEMENTAR COMPARABLE */
    
    @Override
    public boolean equals(Object libro) {
        return this==libro || (libro instanceof Libro && this.ISBN.equals(((Libro)libro).ISBN));
    }

    @Override
    public int compareTo(Libro libro) {
        return this.ISBN.compareTo(libro.ISBN);
    }
    
   /* PARA IMPRIMIR POR CONSOLA*/
    
    @Override
    public String toString() {
        return
            "ISBN               : " + this.ISBN + "\n" +
            "titulo             : " + this.titulo + "\n" +
            "autor              : " + this.autor + "\n" +
            "editorial          : " + this.editorial + "\n" +
            "edicion            : " + this.edicion + "\n" +
            "anio de publicacion: " + this.anno_de_publicacion + "\n";
    }

    /* SECCIÓN GETTERS Y SETTERS */
    
    public String getISBN() {
        return this.ISBN;
    }
    
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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

    public int getAnno_de_publicacion() {
        return this.anno_de_publicacion;
    }
    
    public void setAnno_de_publicacion(int anno_de_publicacion) {
        this.anno_de_publicacion = anno_de_publicacion;
    }
}    
