package apiGestionTarea.domain.entities;

import apiGestionTarea.domain.models.Tarea;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class TareaEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String nombrePersonal;
    private String primerApellidoPersonal;
    private String segundoApellidoPersonal;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private boolean activo;
    private String estado;

    public TareaEntity() {

    }


    public TareaEntity(Long id, String titulo, String descripcion, String nombrePersonal, String primerApellidoPersonal, String segundoApellidoPersonal, LocalDateTime fechaCreacion, LocalDateTime fechaInicio, LocalDateTime fechaFin, boolean activo,String estado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nombrePersonal = nombrePersonal;
        this.primerApellidoPersonal = primerApellidoPersonal;
        this.segundoApellidoPersonal = segundoApellidoPersonal;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.activo = activo;
        this.estado = "Por Hacer";
    }

    public static TareaEntity fromDomainModel(Tarea tarea){
        return  new TareaEntity(tarea.getId(), tarea.getTitulo(), tarea.getDescripcion(),
                tarea.getNombrePersonal(), tarea.getPrimerApellidoPersonal(),
                tarea.getSegundoApellidoPersonal(), tarea.getFechaCreacion(),
                tarea.getFechaInicio(),tarea.getFechaFin(),tarea.isActivo(),tarea.getEstado());
    }

    public Tarea toDomainModel(){
        return new Tarea(id,titulo,descripcion,nombrePersonal,primerApellidoPersonal,segundoApellidoPersonal,fechaCreacion, fechaInicio,fechaFin,activo,estado);
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombrePersonal() {
        return nombrePersonal;
    }

    public void setNombrePersonal(String nombrePersonal) {
        this.nombrePersonal = nombrePersonal;
    }

    public String getPrimerApellidoPersonal() {
        return primerApellidoPersonal;
    }

    public void setPrimerApellidoPersonal(String primerApellidoPersonal) {
        this.primerApellidoPersonal = primerApellidoPersonal;
    }

    public String getSegundoApellidoPersonal() {
        return segundoApellidoPersonal;
    }

    public void setSegundoApellidoPersonal(String segundoApellidoPersonal) {
        this.segundoApellidoPersonal = segundoApellidoPersonal;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
