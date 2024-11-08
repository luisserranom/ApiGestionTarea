package apiGestionTarea.domain.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
@Data

public class TareaResponse {
    private Long id;
    private String titulo;
    private String descripcion;
    private String nombrePersonal;
    private String primerApellidoPersonal;
    private String SegundoApellidoPersonal;
    private  LocalDateTime fechaCreacion;
    private boolean activo;
    private String estado;


    public TareaResponse(Long id, String titulo, String descripcion, String nombrePersonal, String primerApellidoPersonal, String segundoApellidoPersonal, LocalDateTime fechaCreacion, boolean activo, String estado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nombrePersonal = nombrePersonal;
        this.primerApellidoPersonal = primerApellidoPersonal;
        this.SegundoApellidoPersonal = segundoApellidoPersonal;
        this.fechaCreacion = LocalDateTime.now();
        this.activo = activo;
        this.estado = estado;
    }

    public TareaResponse() {
    }

    public void setMensaje(String s) {
    }
}
