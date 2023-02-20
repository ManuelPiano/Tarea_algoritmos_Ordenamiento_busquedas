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
