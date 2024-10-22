package apiGestionTarea.infrastructure.config;

import apiGestionTarea.application.service.TareaService;
import apiGestionTarea.application.useCases.ActualizarTareaUseCaseImpl;
import apiGestionTarea.application.useCases.CrearTareaUseCaseImpl;
import apiGestionTarea.application.useCases.EliminarTareaUseCaseImpl;
import apiGestionTarea.application.useCases.RecuperarTareaUseCaseImpl;
import apiGestionTarea.domain.ports.out.TareaRepositoryPort;
import apiGestionTarea.infrastructure.repositories.JpaTareaRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public TareaService tareaService(TareaRepositoryPort tareaRepositoryPort){
        return new TareaService(
                new CrearTareaUseCaseImpl(tareaRepositoryPort),
                new EliminarTareaUseCaseImpl(tareaRepositoryPort),
                new RecuperarTareaUseCaseImpl(tareaRepositoryPort),
                new ActualizarTareaUseCaseImpl(tareaRepositoryPort)
        );
    }

    @Bean
    public TareaRepositoryPort tareaRepositoryPort(JpaTareaRepositoryAdapter jpaTareaRepositoryAdapter){
        return  jpaTareaRepositoryAdapter;
    }

}
