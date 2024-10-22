package apiGestionTarea.domain.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class TareaTest {

    @Test
    void testConstructorAndGetters() {
        // Arrange
        Long id = 1L;
        String titulo = "Tarea 1";
        String descripcion = "Descripción de la tarea 1";
        String nombrePersonal = "Juan";
        String primerApellidoPersonal = "Pérez";
        String segundoApellidoPersonal = "González";
        LocalDateTime fechaCreacion = LocalDateTime.now();
        LocalDateTime fechaInicio = LocalDateTime.now().plusDays(1);
        LocalDateTime fechaFin = LocalDateTime.now().plusDays(5);
        boolean activo = true;
        String estado = "Pendiente";

        // Act
        Tarea tarea = new Tarea(id, titulo, descripcion, nombrePersonal, primerApellidoPersonal, segundoApellidoPersonal, fechaCreacion, fechaInicio, fechaFin, activo, estado);

        // Assert
        assertEquals(id, tarea.getId());
        assertEquals(titulo, tarea.getTitulo());
        assertEquals(descripcion, tarea.getDescripcion());
        assertEquals(nombrePersonal, tarea.getNombrePersonal());
        assertEquals(primerApellidoPersonal, tarea.getPrimerApellidoPersonal());
        assertEquals(segundoApellidoPersonal, tarea.getSegundoApellidoPersonal());
        assertEquals(fechaCreacion, tarea.getFechaCreacion());
        assertEquals(fechaInicio, tarea.getFechaInicio());
        assertEquals(fechaFin, tarea.getFechaFin());
        assertTrue(tarea.isActivo());
        assertEquals(estado, tarea.getEstado());
    }

    @Test
    void testSetters() {
        // Arrange
        Tarea tarea = new Tarea(null, null, null, null, null, null, null, null, null, false, null);

        // Act
        tarea.setId(1L);
        tarea.setTitulo("Tarea 1");
        tarea.setDescripcion("Descripción de la tarea 1");
        tarea.setNombrePersonal("Juan");
        tarea.setPrimerApellidoPersonal("Pérez");
        tarea.setSegundoApellidoPersonal("González");
        tarea.setFechaCreacion(LocalDateTime.now());
        tarea.setFechaInicio(LocalDateTime.now().plusDays(1));
        tarea.setFechaFin(LocalDateTime.now().plusDays(5));
        tarea.setActivo(true);
        tarea.setEstado("Pendiente");

        // Assert
        assertNotNull(tarea.getId());
        assertNotNull(tarea.getTitulo());
        assertNotNull(tarea.getDescripcion());
        assertNotNull(tarea.getNombrePersonal());
        assertNotNull(tarea.getPrimerApellidoPersonal());
        assertNotNull(tarea.getSegundoApellidoPersonal());
        assertNotNull(tarea.getFechaCreacion());
        assertNotNull(tarea.getFechaInicio());
        assertNotNull(tarea.getFechaFin());
        assertTrue(tarea.isActivo());
        assertNotNull(tarea.getEstado());
    }
}
