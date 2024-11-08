package apiGestionTarea.domain.dto.response;

public class RespuestaError {
    private String mensaje;
    private int codigoEstado;

    public RespuestaError(String mensaje, int codigoEstado) {
        this.mensaje = mensaje;
        this.codigoEstado = codigoEstado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getCodigoEstado() {
        return codigoEstado;
    }
}