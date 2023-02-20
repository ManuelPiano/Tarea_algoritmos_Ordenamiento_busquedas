package Conexion;

import static TareaOrdenamientoBusqueda.OrdenamientoNatural.naturalCompare;

import java.sql.*;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class connection {
  public static void main(String[] args) {
    Instant start = Instant.now();

    Connection conn = null;
    String sql = "SELECT * FROM nombre";
    try {
      conn =
          DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/ordenamientonatural", "root", "");
    } catch (SQLException e) {
      System.err.println("Error al conectar con la base de datos: " + e.getMessage());
    }
    ResultSet resultados = null;
    try {
      Statement stmt = conn.createStatement();
      resultados = stmt.executeQuery(sql);
    } catch (SQLException e) {
      System.err.println("Error al ejecutar la consulta: " + e.getMessage());
    }
    List<String> nombres = new ArrayList<>();
    try {
      while (resultados.next()) {
        nombres.add(resultados.getString("nombre"));
      }
    } catch (SQLException e) {
      System.err.println("Error al obtener los resultados: " + e.getMessage());
    }

    System.out.println("Lista antes del ordenamiento natural: " + nombres);

    /*Collections es una clase que proporciona una gran cantidad de métodos
    estáticos para trabajar con colecciones de objetos, como listas, conjuntos y mapas.
    Uno de los metodos de esta clase es Sort que ordena los elementos de una lista en un
    orden específico, utilizando un algoritmo de ordenamiento.*/

    Collections.sort(nombres, new Comparator<String>() {

          /*compare() es un método que se utiliza para comparar
          dos objetos de un mismo tipo en Java. este método se implementa
          dentro de la interfaz */
          public int compare(String s1, String s2) {
            return naturalCompare(s1, s2);
          }
        });

    System.out.println("Lista después del ordenamiento natural: " + nombres);

    Instant end = Instant.now();
    Duration duration = Duration.between(start, end);
    System.out.println("Tiempo de ejecución: " + duration.getSeconds() + " segundos");
  }
}
