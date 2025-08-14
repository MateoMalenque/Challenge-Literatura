package com.alura.literatura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AutorDAO {
    public void guardarAutor(Autor autor, int libroId) {
        String sql = "INSERT INTO autores (nombre, libro_id) VALUES (?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, autor.getNombre());
            stmt.setInt(2, libroId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar el autor: " + e.getMessage());
        }
    }
}

