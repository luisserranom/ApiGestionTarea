package apiGestionTarea.application.service;

import apiGestionTarea.domain.models.Tarea;
import apiGestionTarea.domain.ports.in.ActualizarTareaUseCase;
import apiGestionTarea.domain.ports.in.CrearTareaUseCase;
import apiGestionTarea.domain.ports.in.EliminarTareaUseCase;
import apiGestionTarea.domain.ports.in.RecuperarTareaUseCase;

import java.util.List;
import java.util.Optional;

public class TareaService implements CrearTareaUseCase, EliminarTareaUseCase,RecuperarTareaUseCase,ActualizarTareaUseCase {

    private final CrearTareaUseCase crearTareaUseCase;
    private final EliminarTareaUseCase eliminarTareaUseCase;
    private final RecuperarTareaUseCase recuperarTareaUseCase;
    private final ActualizarTareaUseCase actualizarTareaUseCase;

    public TareaService(CrearTareaUseCase crearTareaUseCase, EliminarTareaUseCase eliminarTareaUseCase, RecuperarTareaUseCase recuperarTareaUseCase, ActualizarTareaUseCase actualizarTareaUseCase) {
        this.crearTareaUseCase = crearTareaUseCase;
        this.eliminarTareaUseCase = eliminarTareaUseCase;
        this.recuperarTareaUseCase = recuperarTareaUseCase;
        this.actualizarTareaUseCase = actualizarTareaUseCase;
    }



    @Override
    public Tarea crearTarea(Tarea tarea) {
        return crearTareaUseCase.crearTarea(tarea);
    }

    @Override
    public boolean eliminarTarea(Long id) {
        return eliminarTareaUseCase.eliminarTarea(id);
    }

    @Override
    public Optional<Tarea> obtenerTareaPorId(Long id) {
        return recuperarTareaUseCase.obtenerTareaPorId(id);
    }

    @Override
    public List<Tarea> obtenerTareas() {
        return recuperarTareaUseCase.obtenerTareas();
    }

    @Override
    public Optional<Tarea> actualizarTarea(Long id, Tarea actualizarTarea) {
        actualizarTarea.setId(id);
        return actualizarTareaUseCase.actualizarTarea(id, actualizarTarea);
    }

}
