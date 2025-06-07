package com.example.houseservice.application.scheduler;

import com.example.houseservice.infrastructure.repositories.mysql.RealStateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class PublicationSchedulerService {

    private final RealStateRepository realStateRepository;

    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void actualizarEstadoPublicaciones() {
        LocalDate hoy = LocalDate.now();
        log.info("Ejecutando scheduler de publicación para la fecha: {}", hoy);

        int cantidadActualizada = realStateRepository.actualizarPublicacionesPorFecha(hoy);

        log.info("Se actualizaron {} propiedades a estado PUBLICADA", cantidadActualizada);
    }
}
