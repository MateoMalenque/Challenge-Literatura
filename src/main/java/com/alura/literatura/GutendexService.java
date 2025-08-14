package com.alura.literatura;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class GutendexService {

    public List<Libro> buscarLibroPorTitulo(String titulo) {
        List<Libro> libros = new ArrayList<>();
        String url = "https://gutendex.com/books/?search=" + titulo.replace(" ", "%20");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json);
            JsonNode resultados = root.get("results");

            for (JsonNode nodoLibro : resultados) {
                String tituloLibro = nodoLibro.get("title").asText();
                String idioma = nodoLibro.get("languages").get(0).asText(); // puede haber más de uno
                int descargas = nodoLibro.get("download_count").asInt();

                List<Autor> autores = new ArrayList<>();
                for (JsonNode nodoAutor : nodoLibro.get("authors")) {
                    String nombre = nodoAutor.get("name").asText();
                    int nacimiento = nodoAutor.get("birth_year").asInt();
                    int muerte = nodoAutor.get("death_year").asInt();
                    autores.add(new Autor(nombre, nacimiento, muerte));
                }

                libros.add(new Libro(tituloLibro, idioma, descargas, autores));
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
        }

        return libros;
    }
}

