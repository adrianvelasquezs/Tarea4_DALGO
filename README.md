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

#### Consideraciones
Para ejecutar el programa, es necesario pasar como argumento la ubicación del archivo de entrada.
Por ejemplo, si mi archivo se encuentra en la carpeta `C:/p1/src/documentos` y se llama `input.txt`, entonces el 
comando para ejecutar el programa sería:  
`java MainProblem1.java "C:/p1/src/documentos/input.txt"`  
Con esto en mente, el programa imprimirá en consola el resultado de la ejecución. Para guardar
dicho resultado en un archivo, se puede redirigir la salida estándar a un archivo de la siguiente manera:  
`java MainProblem1.java "C:/p1/src/documentos/input.txt" > "C:/p1/src/documentos/output.txt"`  

Si desea probar el programa con el ejemplo de entrada proporcionado en la tarea, el comando sería 
(puede redirigir la salida siguiendo las instrucciones anteriores):  
`java MainProblem1.java "[ubicacion_del_proyecto]/problema1/inputProblem1.txt"`  

#### Formato de entrada y salida
1) El formato del archivo de entrada son líneas de la forma  
`[origen] [destino] [costo]`  
separadas por tabulaciones.  
2) El formato de la salida del programa son líneas de la forma  
`source: [origen], destination: [destino], weight: [costo]`  
separadas por tabulaciones.

#### Descripción de la implementación
Finalmente, para resolver el problema se implementaron 3 algoritmos diferentes, los cuales fueron
el algoritmo de Dijkstra, el algoritmo de Bellman Ford y el algoritmo de Floyd Warshall. Para cada uno de estos
se creó una clase que implementa la interfaz MinimumSpanningTree. Estas clases son `DijkstraMST.java`, 
`BellmanFordMST.java` y `FloydWarshallMST.java` respectivamente. Para hacer uso de ellas, es necesario modificar
el código en el archivo `MainProblem1.java` y cambiar la instancia de la clase `MinimumSpanningTree` por la clase
que se desee utilizar (línea 27).

### Problema 2

**Nombre del archivo ejecutable:** `MainProblem2.java`

### Problema 3

**Nombre del archivo ejecutable:** `MainProblem3.java`

### Problema 4

**Nombre del archivo ejecutable:** `MainProblem4.java`