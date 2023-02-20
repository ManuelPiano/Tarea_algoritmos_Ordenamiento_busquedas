# Alumno: Manuel Alfredo Alvarado Rivera
# Tarea algoritmos Ordenamiento busquedas

## 	Algoritmo de ordenación natural


# 1. Qué hace
 es un algoritmo de ordenamiento que se utiliza para ordenar datos que tienen una estructura natural, como números en orden ascendente o palabras en orden alfabético. En lugar de comparar cada par de elementos, el algoritmo de ordenación natural agrupa los elementos en sublistas ordenadas, basándose en la estructura natural de los datos, y luego fusiona estas sublistas para obtener la lista ordenada final. El proceso de agrupar los elementos en sublistas ordenadas se conoce como clasificación.


# 2. Cómo funciona (detalles)
El algoritmo funciona en tres pasos principales:

Clasificación: En este paso, se recorre la lista de datos y se identifican las sublistas ordenadas. Dependiendo de la estructura natural de los datos, las sublistas pueden ser de diferentes longitudes y pueden estar ordenadas de diferentes maneras. Por ejemplo, si la lista contiene palabras en orden alfabético, cada secuencia de palabras que comienzan con la misma letra se considera una sublista.

Fusión: En este paso, se fusionan las sublistas en una lista ordenada final. Para ello, se utiliza un enfoque similar al de la fusión de dos listas ordenadas. Se compara el primer elemento de cada sublista y se mueve el más pequeño a la lista final. Luego se avanza al siguiente elemento en la sublista de donde se movió el elemento y se vuelve a comparar con el siguiente elemento en la otra sublista. Se repite este proceso hasta que se hayan fusionado todas las sublistas.

Repetición: En el último paso, se repiten los pasos 1 y 2 hasta que se hayan fusionado todas las sublistas y la lista esté completamente ordenada. Cada vez que se repite el proceso, las sublistas pueden ser diferentes ya que se reorganizan de acuerdo con la estructura natural de los datos.


# 3. Una solución Java (puede buscarla y usarla, siempre dando crédito al autor y proporcionando fuente de consulta; y lo mas importante: entenderla completamente)
(Ver Código)
*Creditos al Canal de Mario Garrido en youtube donde explica la clase compare y su implementacion https://www.youtube.com/watch?v=6trV1QUaIns
*busqueda en chatgpt con respecto a la explicacion del algoritmo


# 4. Cómo funciona el algoritmo con los diferentes tipos de memorias y stacks en Java (como afecta)
El algoritmo de ordenación natural no tiene un requerimiento específico en cuanto a la memoria o stack en Java. Sin embargo, su rendimiento puede verse afectado por la disponibilidad de memoria y la gestión de la memoria por parte de la JVM.

El algoritmo utiliza la memoria para almacenar las cadenas que se están comparando, así como las variables de índice ka y kb, y las variables na y nb utilizadas para extraer los valores numéricos de las cadenas.

En cuanto al stack, el algoritmo no tiene una profundidad de stack muy grande, ya que no utiliza recursión y no tiene estructuras de datos anidadas. Por lo tanto, el tamaño del stack no debería ser un problema para el algoritmo de ordenación natural.
En general, el algoritmo de ordenación natural puede ser afectado por la disponibilidad y la gestión de la memoria en Java, pero su rendimiento también dependerá del tamaño de las cadenas a ordenar y de la complejidad del conjunto de datos.

# 5. Determinar la complejidad/velocidad/costo de acuerdo a la notación Big (O)

La notación Big O es una herramienta matemática que se utiliza para describir la complejidad de un algoritmo en términos del tamaño de la entrada. En otras palabras, nos permite expresar cuánto tiempo o recursos necesitará un algoritmo para procesar un conjunto de datos de entrada en función del tamaño de dicho conjunto.

En la notación Big O, se describe el orden de magnitud del tiempo de ejecución en función del tamaño de entrada. Se trata de una notación asintótica, es decir, que solo tiene en cuenta el comportamiento del algoritmo a medida que el tamaño de entrada se aproxima al infinito.


Mejor caso: O(n), donde n es la longitud de la cadena más corta a comparar. Esto ocurre cuando las cadenas son idénticas o son iguales hasta la longitud de la cadena más corta.
Peor caso: O(n log n), donde n es la longitud de la cadena más larga a comparar. Esto ocurre cuando las cadenas tienen diferentes prefijos numéricos, y el algoritmo tiene que comparar todos los caracteres de ambas cadenas.
Caso promedio: O(n log n), donde n es la longitud promedio de las cadenas a comparar.
# 6. Su propia opinión sobre el algoritmo
El algoritmo de ordenación natural es una solución interesante para ordenar cadenas que contienen elementos numéricos y no numéricos. 
puede ser un problema en conjuntos de datos grandes por lo que mencionabamos acerca de la memoria ya que se estaria llenando rapidamente
en si el algoritmo es una solución util para problemas en especifico, pero siempre sera importante testear el desempeño de este con otros algoritmos que pueden resultar mas eficientes segun el tipo de datos a utilizar.


## Algoritmo de búsqueda A*

# 1. Qué hace
El algoritmo de búsqueda A* es un algoritmo de búsqueda heurística utilizado para encontrar el camino más corto entre un nodo inicial y un nodo final en un grafo o red de nodos.
Combina la función de costo real de un camino desde el nodo inicial hasta el nodo actual con una heurística que estima el costo del camino más corto desde el nodo actual hasta el nodo final, lo que permite guiar la búsqueda hacia el nodo final de la manera más eficiente posible. Utiliza una estructura de datos llamada cola de prioridad para mantener un conjunto de nodos en el límite de la exploración, ordenados por el valor de una función de costo calculada como la suma de la función heurística y el costo real.
La heurística es una técnica de resolución de problemas que se basa en el uso de conocimiento previo y experiencia para encontrar soluciones posibles en situaciones complejas donde no se dispone de un algoritmo exacto.


# 2. Cómo funciona (detalles)

El algoritmo de búsqueda A* funciona de la siguiente manera:

Se crea una estructura de datos llamada cola de prioridad, que almacena los nodos que están en el límite de la exploración, ordenados por el valor de una función de costo calculada como la suma de la función heurística y el costo real.

Se agrega el nodo inicial a la cola de prioridad y se establece su costo real en 0.

Se extrae el nodo con el menor valor de la cola de prioridad.

Se comprueba si el nodo extraído es el nodo final. Si lo es, se ha encontrado el camino más corto.

Si el nodo extraído no es el nodo final, se expanden sus sucesores y se calcula el costo real de los nuevos caminos desde el nodo inicial hasta cada sucesor.

Para cada sucesor, se calcula el costo total como la suma del costo real y la función heurística que estima el costo del camino más corto desde el sucesor hasta el nodo final.

Se actualiza el costo real y el camino hasta cada sucesor si se ha encontrado un camino más corto.

Se agrega cada sucesor a la cola de prioridad, ordenados por el valor de su costo total.

Se repiten los pasos 3-8 hasta que se alcance el nodo final o hasta que la cola de prioridad esté vacía.

Si la heurística es admisible, el algoritmo de búsqueda A* garantiza encontrar la solución óptima al problema de búsqueda. Además, si la heurística es consistente, A* también puede ser demostrado que es óptimo en tiempo polinómico. A* es un algoritmo eficiente y ampliamente utilizado en áreas como la planificación de rutas, la robótica, la inteligencia artificial y la optimización.

https://gammafp.github.io/pathfinding/ (ejemplo)
https://www.youtube.com/watch?v=X-5JMScsZ14&t=1109s

# 3. Una solución Java (puede buscarla y usarla, siempre dando crédito al autor y proporcionando fuente de consulta; y lo mas importante: entenderla completamente)
# 4. Cómo funciona el algoritmo con los diferentes tipos de memorias y stacks en Java (como afecta)
# 5. Determinar la complejidad/velocidad/costo de acuerdo a la notación Big (O)
# 5. Su propia opinión sobre el algoritmo
