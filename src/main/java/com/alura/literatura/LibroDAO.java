package com.alura.literatura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibroDAO {
    public int guardarLibro(Libro libro) {
        String sql = "INSERT INTO libros (titulo, idioma, descargas) VALUES (?, ?, ?) RETURNING id";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getIdioma());
            stmt.setInt(3, libro.getNumeroDescargas());

            var rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id"); // Devuelve el ID generado
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar el libro: " + e.getMessage());
        }
        return -1;
    }
}

