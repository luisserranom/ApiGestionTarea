package apiGestionTarea.domain.port.in;

import apiGestionTarea.domain.models.Tarea;
import apiGestionTarea.domain.ports.in.IActualizarTareaUseCase;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public interface ActualizarTareaUseCaseTest {

    // Se debe proporcionar un método de configuración que devuelva la instancia de ActualizarTareaUseCase
    default IActualizarTareaUseCase crearMockActualizarTareaUseCase() {
        return mock(IActualizarTareaUseCase.class);
    }

    @Test
    default void testActualizarTareaExistente() {
        // Arrange
        IActualizarTareaUseCase actualizarTareaUseCase = crearMockActualizarTareaUseCase();

        Long tareaId = 1L;
        Tarea tareaActualizada = new Tarea();
        tareaActualizada.setId(tareaId);
        tareaActualizada.setTitulo("Tarea actualizada");

        // Act
        when(actualizarTareaUseCase.actualizarTarea(tareaId, tareaActualizada)).thenReturn(Optional.of(tareaActualizada));
        Optional<Tarea> resultado = actualizarTareaUseCase.actualizarTarea(tareaId, tareaActualizada);

        // Assert
        assertTrue(resultado.isPresent(), "Se esperaba que la tarea actualizada estuviera presente");
        assertEquals(tareaActualizada.getTitulo(), resultado.get().getTitulo(), "El título de la tarea actualizada no coincide");
        verify(actualizarTareaUseCase, times(1)).actualizarTarea(tareaId, tareaActualizada);
    }

    @Test
    default void testActualizarTareaInexistente() {
        // Arrange
        IActualizarTareaUseCase actualizarTareaUseCase = crearMockActualizarTareaUseCase();

        Long tareaId = 2L;
        Tarea tareaActualizada = new Tarea();
        tareaActualizada.setId(tareaId);
        tareaActualizada.setTitulo("Tarea actualizada");

        // Act
        when(actualizarTareaUseCase.actualizarTarea(tareaId, tareaActualizada)).thenReturn(Optional.empty());
        Optional<Tarea> resultado = actualizarTareaUseCase.actualizarTarea(tareaId, tareaActualizada);

        // Assert
        assertFalse(resultado.isPresent(), "No se esperaba que la tarea actualizada estuviera presente");
        verify(actualizarTareaUseCase, times(1)).actualizarTarea(tareaId, tareaActualizada);
    }
}
