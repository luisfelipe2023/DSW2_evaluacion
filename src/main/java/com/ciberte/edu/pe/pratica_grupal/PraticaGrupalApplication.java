package com.ciberte.edu.pe.pratica_grupal;

import com.ciberte.edu.pe.pratica_grupal.asyn.AsyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.CompletableFuture;


@Slf4j
@RequiredArgsConstructor
@EnableAsync // Habilita la ejecución asíncrona
@SpringBootApplication
public class PraticaGrupalApplication implements CommandLineRunner {
	private final AsyncService asyncService;

	public static void main(String[] args) {
		SpringApplication.run(PraticaGrupalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CompletableFuture<String> resultado = asyncService.crearArchivos();

		resultado.thenAccept(res -> log.info(res))
				.exceptionally(ex -> {
					log.error("No se pudo crear los archivos: " + ex.getMessage());
					return null;
				});
	}


}
