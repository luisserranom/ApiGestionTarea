package apiGestionTarea.infrastructure.controllers;


import apiGestionTarea.application.service.TareaService;
import apiGestionTarea.domain.models.Tarea;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarea") /*localhost:8080/api/tarea*/
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }
    /*localhost:8080/api/tarea/crear*/
    @PostMapping("/crear")
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tarea){
        Tarea crearTarea = tareaService.crearTarea(tarea);
        return new ResponseEntity<>(crearTarea, HttpStatus.CREATED);
    }
    /*localhost:8080/api/tarea/listarPorId/{tareaId}*/
    @GetMapping("/listarPorId/{tareaId}")
    public ResponseEntity<Tarea> obtenerTareaPorId(@PathVariable Long tareaId){
        return tareaService.obtenerTareaPorId(tareaId)
                .map(tarea -> new ResponseEntity<>(tarea, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    /*localhost:8080/api/tarea/listar*/
    @GetMapping("/listar")
    public  ResponseEntity<List<Tarea>> obtenerTareas(){
        List<Tarea> tarea = tareaService.obtenerTareas();
        return new ResponseEntity<>(tarea, HttpStatus.OK);
    }
    /*localhost:8080/api/tarea/actualizar/{tareaId}*/
    @PutMapping("/actualizar/{tareaId}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long tareaId, @RequestBody Tarea actualizarTarea) {
        return tareaService.actualizarTarea(tareaId, actualizarTarea)
                .map(tarea -> new ResponseEntity<>(tarea, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /*localhost:8080/api/tarea/eliminar/{tareaId}*/
    @DeleteMapping("/eliminar/{tareaId}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long tareaId){
        if(tareaService.eliminarTarea(tareaId)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
