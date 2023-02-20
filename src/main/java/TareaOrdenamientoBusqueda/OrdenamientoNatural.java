package TareaOrdenamientoBusqueda;
public class OrdenamientoNatural {

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
          na = na * 10 + a.charAt(ka++) - '0'; //se resta el valor de '0' (el carácter cuyo código ASCII es 48) al carácter obtenido, para obtener su valor numérico. Esto se hace porque el código ASCII de los dígitos '0' a '9' están en secuencia, por lo que restar el valor de '0' a cualquier dígito dará su valor numérico real.
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
