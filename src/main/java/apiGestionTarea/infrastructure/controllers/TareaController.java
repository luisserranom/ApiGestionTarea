package apiGestionTarea.infrastructure.controllers;


import apiGestionTarea.application.adapter.TareaMapper;
import apiGestionTarea.domain.dto.response.TareaResponse;
import apiGestionTarea.domain.models.Tarea;
import apiGestionTarea.domain.service.ITareaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tarea") /*localhost:8080/api/tarea*/
public class TareaController {



    private final ITareaService tareaService;

    private final TareaMapper tareaMapper;

    public TareaController(ITareaService tareaService, TareaMapper tareaMapper) {
        this.tareaService = tareaService;
        this.tareaMapper = tareaMapper;
    }

    /*localhost:8080/api/tarea/crear*/
    @PostMapping("/crear")
    public ResponseEntity<TareaResponse> crearTarea(@RequestBody Tarea tarea){
        try {
            Tarea crearTarea = tareaService.guardarTarea(tarea);
            TareaResponse tareaResponse = tareaMapper.tareaResponse(crearTarea);
            return new ResponseEntity<>(tareaResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            TareaResponse tareaResponse = new TareaResponse();
            tareaResponse.setMensaje("Ocurrió un error al crear la tarea");
            return new ResponseEntity<>(tareaResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*localhost:8080/api/tarea/listarPorId/{tareaId}*/
    @GetMapping("/listarPorId/{tareaId}")
    public ResponseEntity<TareaResponse> obtenerTareaPorId(@PathVariable Long tareaId){

        try {
            Tarea tarea = tareaService.obtenerTareaPorId(tareaId);
            TareaResponse tareaResponse =  tareaMapper.tareaResponse(tarea);
            return ResponseEntity.ok(tareaResponse);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



    /*localhost:8080/api/tarea/eliminar/{tareaId}*/
    @DeleteMapping("/eliminar/{tareaId}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long tareaId){
        try{
            tareaService.eliminarTarea(tareaId);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    /*localhost:8080/api/tarea/listar*/
    @GetMapping("/listar")
    public  ResponseEntity<Page<TareaResponse>> obtenerTareas(Pageable pageable){
        try {
            Page<Tarea> tareas = tareaService.listarTareas(pageable);
            Page<TareaResponse> tareaResponses = tareas.map(tareaMapper::tareaResponse);
            return ResponseEntity.ok(tareaResponses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PatchMapping("/actualizarEstado/{id}")
    public ResponseEntity<TareaResponse> actualizarEstadoTarea(@PathVariable Long id, @RequestParam String estado) {
        Tarea tareaActualizada = tareaService.actualizarEstadoTarea(id, estado);
        TareaResponse tareaResponse = tareaMapper.tareaResponse(tareaActualizada);
        return ResponseEntity.ok(tareaResponse);
    }


}
