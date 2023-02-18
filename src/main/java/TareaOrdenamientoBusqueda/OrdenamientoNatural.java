package TareaOrdenamientoBusqueda;

import java.sql.*;
import java.util.*;

public class OrdenamientoNatural {

  public static void main(String[] args) {
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

    Collections.sort(
        nombres,
        new Comparator<String>() {

          /*compare() es un método que se utiliza para comparar
          dos objetos de un mismo tipo en Java. En el contexto
          del ejemplo que mostraste, este método se implementa
          dentro de la interfaz */
          public int compare(String s1, String s2) {
            return naturalCompare(s1, s2);
          }
        });

    System.out.println("Lista después del ordenamiento natural: " + nombres);
  }

  public static int naturalCompare(String a, String b) {
    int la = a.length(), lb = b.length();

    /* La variable "ka" representa el índice ó posición actual del carácter
    que se está evaluando en la cadena a, y "kb" representa el índice
    actual del carácter que se está evaluando en la cadena b.*/

    int ka = 0, kb = 0;
    while (true) {
      if (ka == la && kb == lb) {
        return 0;
      }
      if (ka == la) {
        return -1;
      }
      if (kb == lb) {
        return 1;
      }
      char ca = a.charAt(ka), cb = b.charAt(kb);
      if (Character.isDigit(ca) && Character.isDigit(cb)) {
        int na = 0, nb = 0;
        while (ka < la && Character.isDigit(a.charAt(ka))) {
          na = na * 10 + a.charAt(ka++) - '0';
        }
        while (kb < lb && Character.isDigit(b.charAt(kb))) {
          nb = nb * 10 + b.charAt(kb++) - '0';
        }
        if (na != nb) {
          return na - nb;
        }
      } else if (ca != cb) {
        return ca - cb;
      } else {
        ka++;
        kb++;
      }
    }
  }
}
