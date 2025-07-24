package modulo;

public class cancion {
    //titulo artista y duracion.

    private String titulo;
    private String artista;
    private Integer duracion;

    //constructor
    public cancion() {}

    public cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
    }
    //getters y setters
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public Integer getDuracion() {
        return duracion;
    }
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String mostrarInformacion() {
        return titulo + " - " + artista + " (" + duracion + " segundos)";
       
         }
     }
