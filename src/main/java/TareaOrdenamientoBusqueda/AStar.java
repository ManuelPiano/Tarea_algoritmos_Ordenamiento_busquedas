package TareaOrdenamientoBusqueda;

import java.util.*;

public class AStar {
  public static int[] aStar(int[][] graph, int start, int end) {
    int n = graph.length;
    int[] cameFrom = new int[n];
    double[] gScore = new double[n];
    Arrays.fill(gScore, Double.POSITIVE_INFINITY);
    gScore[start] = 0;
    double[] fScore = new double[n];
    Arrays.fill(fScore, Double.POSITIVE_INFINITY);
    fScore[start] = heuristic(start, end);
    PriorityQueue<Integer> openSet =
        new PriorityQueue<>(Comparator.comparingDouble(i -> fScore[i]));
    openSet.offer(start);
    while (!openSet.isEmpty()) {
      int current = openSet.poll();
      if (current == end) {
        return reconstructPath(cameFrom, end);
      }
      for (int neighbor = 0; neighbor < n; neighbor++) {
        if (graph[current][neighbor] == 0) {
          continue;
        }
        double tentativeGScore = gScore[current] + graph[current][neighbor];
        if (tentativeGScore < gScore[neighbor]) {
          cameFrom[neighbor] = current;
          gScore[neighbor] = tentativeGScore;
          fScore[neighbor] = gScore[neighbor] + heuristic(neighbor, end);
          if (!openSet.contains(neighbor)) {
            openSet.offer(neighbor);
          }
        }
      }
    }
    return null;
  }

  private static int[] reconstructPath(int[] cameFrom, int current) {
    List<Integer> path = new ArrayList<>();
    while (current != 0) {
      path.add(current);
      current = cameFrom[current];
    }
    path.add(0);
    Collections.reverse(path);
    return path.stream().mapToInt(Integer::intValue).toArray();
  }

  private static double heuristic(int a, int b) {
    // manhattan distance as the heuristic
    int x1 = a % 6, y1 = a / 6;
    int x2 = b % 6, y2 = b / 6;
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
  }

  public static void main(String[] args) {
    int[][] graph = {
      {0, 4, 0, 0, 0, 0},
      {0, 0, 2, 0, 5, 0},
      {0, 0, 0, 3, 0, 0},
      {0, 0, 0, 0, 0, 6},
      {0, 0, 0, 0, 0, 3},
      {0, 0, 0, 0, 0, 0}
    };
    int start = 0;
    int end = 5;
    int[] path = aStar(graph, start, end);
    if (path == null) {
      System.out.println("No path found");
    } else {
      System.out.println(
          "Shortest path from " + start + " to " + end + ": " + Arrays.toString(path));
    }
  }
}
