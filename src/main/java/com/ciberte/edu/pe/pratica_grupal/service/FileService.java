package com.ciberte.edu.pe.pratica_grupal.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class FileService {
    private static final String FILE_PATH = "archivo";
    @Async
    public CompletableFuture<String> crearArchivo10SEG() throws IOException{
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("La operación fue interrumpida", e);
        }

        String nombreArchivo = FILE_PATH + "10.txt";
        String contenido = generarContenidoAleatorio();

        try (FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivo);
             DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {
            dataOutputStream.writeBytes(contenido);
        }



        return CompletableFuture.completedFuture("Archivo10 Creado Correctamente");
    }
    @Async
    public CompletableFuture<String> crearArchivo5SEG() throws IOException{
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("La operación fue interrumpida", e);
        }

        String nombreArchivo = FILE_PATH + "5.txt";
        String contenido = generarContenidoAleatorio();

        try (FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivo);
             DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {
            dataOutputStream.writeBytes(contenido);
        }


        return CompletableFuture.completedFuture("Archivo Creado Correctamente");
    }
    @Async
    public CompletableFuture<String> crearArchivo7SEG() throws IOException{
        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("La operación fue interrumpida", e);
        }

        String nombreArchivo = FILE_PATH + "7.txt";
        String contenido = generarContenidoAleatorio();

        try (FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivo);
             DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {
            dataOutputStream.writeBytes(contenido);
        }

        return CompletableFuture.completedFuture("Archivo 7 Creado Correctamente");
    }

    private String generarContenidoAleatorio() {

        Random random = new Random();
        return "Contenido aleatorio: " + random.nextInt(100);
    }
}
