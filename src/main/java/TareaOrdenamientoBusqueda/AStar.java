package TareaOrdenamientoBusqueda;

import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;

class Nodo implements Comparable<Nodo> {
  int x, y;
  int g, h;
  Nodo parent;
/*La clase Nodo: representa un nodo en el mapa. Tiene dos variables x e y
que representan la posición del nodo en el mapa, y variables g y h que se
utilizan en el cálculo de la función de coste. También tiene una variable
parent que se utiliza para almacenar el nodo padre en la ruta más corta.
La clase implementa la interfaz Comparable para poder ordenar los nodos en una cola de prioridad. */
  public Nodo(int x, int y) {
    this.x = x;
    this.y = y;
    g = 0; //el costo del camino desde el nodo inicial hasta el nodo actual.
    h = 0; //una heurística que estima el costo del camino más barato.
    parent = null;
  }

  public Nodo(int x, int y, int g, int h, Nodo parent) {
    this.x = x;
    this.y = y;
    this.g = g;
    this.h = h;
    this.parent = parent;
  }


  public int f() {
    return g + h;
  }

  public int compareTo(Nodo other) {//compara los nodos
    return this.f() - other.f();
  }
}

public class AStar {
  private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public static void main(String[] args) {
    int[][] mapa = {{0, 0, 0, 0, 0},
                    {0, 1, 1, 0, 0},
                    {0, 0, 0, 0, 0},
                    {0, 1, 1, 1, 0},
                    {0, 0, 0, 0, 0}};

    Nodo start = new Nodo(0, 0);
    Nodo meta = new Nodo(4, 4);

    Set<Nodo> closedSet = new HashSet<>();
    PriorityQueue<Nodo> openSet = new PriorityQueue<>();
    openSet.add(start);

    while (!openSet.isEmpty()) {
      Nodo current = openSet.poll();
      if (current.x == meta.x && current.y == meta.y) {
        // Hemos llegado al objetivo, construimos el camino de vuelta.
        StringBuilder sb = new StringBuilder();
        while (current != null) {
          sb.append(")").append(current.x).append(", ").append(current.y).append("( ");
          current = current.parent;
        }
        System.out.println(sb.reverse().toString());
        return;
      }
      closedSet.add(current);
      for (int[] dir : DIRS) {
        int nextX = current.x + dir[0];
        int nextY = current.y + dir[1];
        if (nextX < 0 || nextX >= mapa.length || nextY < 0 || nextY >= mapa[0].length || mapa[nextX][nextY] == 1) {
          // Si la siguiente casilla no es válida, la ignoramos.
          continue;
        }
        Nodo next = new Nodo(nextX, nextY);
        int newG = current.g + 1;
        int newH = Math.abs(nextX - meta.x) + Math.abs(nextY - meta.y);
        if (closedSet.contains(next)) {
          // Si ya hemos visitado esta casilla, la ignoramos.
          continue;
        }
        if (!openSet.contains(next) || newG + newH < next.f()) {
          // Si hemos encontrado una nueva casilla o una mejor forma de llegar a ella, actualizamos los valores.
          next.g = newG;
          next.h = newH;
          next.parent = current;
          openSet.add(next);

        }
      }
      System.gc();
    }
    // Si llegamos aquí, es que no hemos encontrado ninguna solución.
    System.out.println("No se ha encontrado solución.");
  }
}
