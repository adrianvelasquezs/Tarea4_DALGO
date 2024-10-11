# Tarea 4 DALGO 2024-20
## Integrantes
1) **Nombre:** Adrian Velasquez, **Código:** 202222737
2) **Nombre:** Andrés Botero Ruiz, **Código:** 202223503

## Instrucciones de uso
En el proyecto hay una serie de paquetes titulados "problemaX" donde X es el número del problema. Cada uno de estos
paquetes contiene un archivo `MainProblemX.java` que contiene el código de la solución al problema. A continuación se
detallan las instrucciones de uso para cada uno de los problemas. Por otro lado, en el paquete `documentos` se 
encuentran archivos varios utilizados para la realización de los problemas (por ejemplo, las instrucciones de la tarea). 

### Problema 1
**Nombre del archivo ejecutable:** `MainProblem1.java`
#### Descripción de la implementación
Para resolver el problema se implementaron 3 algoritmos diferentes, los cuales fueron
el algoritmo de Dijkstra, el algoritmo de Bellman Ford y el algoritmo de Floyd Warshall. Para cada uno de estos
se creó una clase que implementa la interfaz MinimumSpanningTree. Estas clases son `DijkstraMinimumDistanceMatrix`,
`BellmanFordMinimumDistanceMatrix` y `FloydWarshallMinimumDistanceMatrix` respectivamente. Para hacer uso de ellas, es necesario modificar
el código en el archivo `MainProblem1.java` y cambiar la instancia de la clase `MinimumDistanceMatrix` por la clase
que se desee utilizar (línea 27). Cada una de estas implementaciones encuentra las distancias mínimas entre todos los nodos.
#### Consideraciones
Para ejecutar el programa, es necesario pasar como argumento la ubicación del archivo de entrada.
Por ejemplo, si mi archivo se encuentra en la carpeta `C:/p1/src/documentos` y se llama `input.txt`, entonces el 
primer argumento del programa sería: `"C:/p1/src/documentos/input.txt"`  
Con esto en mente, el programa imprimirá en consola el resultado de la ejecución. Para guardar
dicho resultado en un archivo, se puede redirigir la salida estándar a un archivo de la siguiente manera:  
`"C:/p1/src/documentos/input.txt" > "C:/p1/src/documentos/output.txt"`  
Si desea probar el programa con el ejemplo de entrada proporcionado en la tarea, el comando sería 
(puede redirigir la salida siguiendo las instrucciones anteriores):  
`"[ubicacion_del_proyecto]/problema1/inputProblem1.txt"`.  
#### Tiempo de ejecución
- Para el algoritmo de Dijkstra, el tiempo de ejecución es de aproximadamente __2 ms__.  
- Para el algoritmo de Bellman Ford, el tiempo de ejecución es de aproximadamente __0 ms__.  
- Para el algoritmo de Floyd Warshall, el tiempo de ejecución es de aproximadamente __0 ms__.
#### Formato de entrada y salida
1) El formato del archivo de entrada son líneas de la forma  
`[origen] [destino] [costo]`, separadas por tabulaciones.  
2) El formato de la salida del programa es una matriz de con las distancias mínimas entre los nodos. 
Cada fila representa el nodo origen y cada columna el nodo destino. Si es imposible llegar, se imprime un INTEGER.MAX_VALUE.
Cada elemento en la fila está separado por 4 espacios, y cada fila está separada por una tabulación.

### Problema 2
**Nombre del archivo ejecutable:** `MainProblem2.java`
- Abra en una terminal externa el directorio `problema2`, por ejemplo `"C:/p1/Tarea4_DALGO/problema2"`
- En el mismo directorio se encuentra un archivo `in.txt` y `out.txt`. Ingrese en el primero de estos los arcos del grafo. En el archivo ya se encuentra un ejemplo de input
- Ejecute en su terminal `java -cp bin MainProblem2 < in.txt > out.txt`
- Revice en `out.txt` el resultado

### Problema 3
**Nombre del archivo ejecutable:** `MainProblem3.java`
- Abra en una terminal externa el directorio `problema3`, por ejemplo `"C:/p1/Tarea4_DALGO/problema3"`
- En el mismo directorio se encuentra un archivo `in.txt` y `out.txt`. Ingrese en el primero de estos los arcos del grafo. En el archivo ya se encuentra un ejemplo de input
- Ejecute en su terminal `java -cp bin MainProblem3 < in.txt > out.txt`
- Revice en `out.txt` el resultado

### Problema 4
**Nombre del archivo ejecutable:** `MainProblem4.java`
