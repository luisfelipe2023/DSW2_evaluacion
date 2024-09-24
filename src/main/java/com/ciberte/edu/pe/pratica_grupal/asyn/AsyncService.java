package com.ciberte.edu.pe.pratica_grupal.asyn;

import com.ciberte.edu.pe.pratica_grupal.service.FileService;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Service
@EnableAsync
public class AsyncService {
    private final FileService fileService;

    public AsyncService(FileService fileService) {
        this.fileService = fileService;
    }

    public CompletableFuture<String> crearArchivos() throws IOException {
        CompletableFuture<String> archivo1 = fileService.crearArchivo10SEG();
        CompletableFuture<String> archivo2 = fileService.crearArchivo5SEG();
        CompletableFuture<String> archivo3 = fileService.crearArchivo7SEG();

        return CompletableFuture.allOf(archivo1, archivo2,archivo3 ).thenApply(result -> {
            try {
                String valarchivo1 = archivo1.join();
                String valarchivo2 = archivo2.join();
                String valarchivo3 = archivo3.join();
                return "ARCHIVOS CREADOS CORRECTAMENTE "+'\n'+
                        valarchivo1+"-"+'\n'+
                        valarchivo2+"-"+'\n'+
                        valarchivo3+"-";

            }catch (Exception ex){
                return "Error al combinar datos"+ex.getMessage();
            }
        }).exceptionally(ex -> "Error al ejecutar las tareas" + ex.getMessage());
    }
}


