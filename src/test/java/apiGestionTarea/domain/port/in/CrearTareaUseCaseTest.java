package apiGestionTarea.domain.port.in;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public interface CrearTareaUseCaseTest {

    /*private CrearTareaUseCaseImpl crearTareaUseCase;
    private TareaRepositoryPort tareaRepositoryPort;

    @BeforeEach
    default void setUp() {
        tareaRepositoryPort = Mockito.mock(TareaRepositoryPort.class);
        crearTareaUseCase = new CrearTareaUseCaseImpl(tareaRepositoryPort);
    }

    @Test
    default void shouldCreateTaskSuccessfully() {
        // Arrange
        Tarea nuevaTarea = new Tarea("Título de la tarea", "Descripción de la tarea");

        // Act
        crearTareaUseCase.crearTarea(nuevaTarea);

        // Assert
        verify(tareaRepositoryPort).save(any(Tarea.class));
    }

    @Test
    default void shouldThrowExceptionWhenTaskIsNull() {
        // Arrange
        Tarea tareaNula = null;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            crearTareaUseCase.crearTarea(tareaNula);
        });
    }

    @Test
    default void shouldThrowExceptionWhenTitleIsEmpty() {
        // Arrange
        Tarea tareaConTituloVacio = new Tarea("", "Descripción de la tarea");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            crearTareaUseCase.crearTarea(tareaConTituloVacio);
        });
    }

    @Test
    default void shouldThrowExceptionWhenDescriptionIsEmpty() {
        // Arrange
        Tarea tareaConDescripcionVacia = new Tarea("Título de la tarea", "");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            crearTareaUseCase.crearTarea(tareaConDescripcionVacia);
        });
    }

    @Test
    default void shouldHandleDatabaseException() {
        // Arrange
        Tarea nuevaTarea = new Tarea("Título de la tarea", "Descripción de la tarea");
        when(tareaRepositoryPort.save(any(Tarea.class))).thenThrow(new RuntimeException("Error de base de datos"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> {
            crearTareaUseCase.crearTarea(nuevaTarea);
        });
    }*/
}
