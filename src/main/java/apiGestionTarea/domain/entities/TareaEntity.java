package apiGestionTarea.domain.entities;

import apiGestionTarea.domain.models.Tarea;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


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

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaCreacion;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaFin;
    private boolean activo;
    private String estado;




    public TareaEntity() {

    }


    public TareaEntity(Long id, String titulo, String descripcion, String nombrePersonal, String primerApellidoPersonal, String segundoApellidoPersonal, Date fechaCreacion, Date fechaInicio, Date fechaFin, boolean activo,String estado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nombrePersonal = nombrePersonal;
        this.primerApellidoPersonal = primerApellidoPersonal;
        this.segundoApellidoPersonal = segundoApellidoPersonal;
        this.fechaCreacion = fechaInicio;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
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
