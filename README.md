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
- En el mismo directorio se encuentra un archivo `in.txt` y `out.txt`. Ingrese en el primero de estos los arcos del grafo, y recuerde que **se sigue el mismo formato de entrada que el problema 1**. En el archivo ya se encuentra un ejemplo de input.
- Ejecute en su terminal `java -cp bin MainProblem2 < in.txt > out.txt`
- Revise en `out.txt` el resultado
#### Formato de salida
En cada linea del archivo de texto `out.txt` hay una lista (representada con corchetes) de los nodos que pertenecen a un mismo camino.

Por ejemplo:

`[nodo1, nodo2, nodo3]`

`[nodo4, nodo5]`

### Problema 3
**Nombre del archivo ejecutable:** `MainProblem3.java`
- Abra en una terminal externa el directorio `problema3`, por ejemplo `"C:/p1/Tarea4_DALGO/problema3"`
- En el mismo directorio se encuentra un archivo `in.txt` y `out.txt`. Ingrese en el primero de estos los arcos del grafo, y recuerde que **se sigue el mismo formato de entrada que el problema 1**. En el archivo ya se encuentra un ejemplo de input
- Ejecute en su terminal `java -cp bin MainProblem3 < in.txt > out.txt`
- Revise en `out.txt` el resultado
#### Formato de salida
En `out.txt` se guarda el grafo resultante, puede observar en cada linea del archivo los arcos de dicho grafo.

### Problema 4
**Nombre del archivo ejecutable:** `MainProblem4.java`
- Abra en una terminal externa el directorio `problema4`, por ejemplo `"C:/p1/Tarea4_DALGO/problema4"`
#### Instrucciones de uso
Encontrará 3 archivos, `inputProblem4_Trucks.txt`, `inputProblem4_Warehouses.txt` y `outputProblem4.txt`. 
Si desea utilizar estos archivos de prueba, debe pasarlos como parámetros al programa **en ese mismo orden**. Con esto en mente,
puede seguir las mismas recomendaciones del problema 1 a la hora de ejecutar y redirigir la salida estándar a un archivo.
#### Formato de entrada
El archivo `inputProblem4_Trucks.txt` tiene líneas separadas con tabulaciones con el siguiente formato:  
`[capacidad] [inicio] [camino] [fin]`  
Donde `capacidad` es la capacidad de carga del camión, `inicio` es el nodo de inicio, `camino` es el camino que debe seguir 
el camión (podría no tener benign camino) y `fin` es el nodo final. Para representar una fábrica, se debe poner `FX` 
donde `X` es el número de la fábrica. Para representar una bodega, se debe poner `WX` donde `X` es el número de la bodega. 
Para representar una librería, se debe poner `LX` donde `X` es el número de la librería. Es **esencial** que:
1) La capacidad sea un número entero positivo.
2) El nodo de inicio sea una fábrica.
3) El nodo final sea una librería.
4) El camino no puede contener librerías ni fábricas.
5) Es necesario que el número `X` de cada uno de los elementos sea consecutivo y empiece en 1. No puede haber saltos en los números.

El archivo `inputProblem4_Warehouses.txt` tiene líneas separadas con tabulaciones con el siguiente formato:  
`[capacidad]`  
Donde `capacidad` es la capacidad de carga de la bodega. Es esencial que:
1) La capacidad sea un número entero positivo.
2) La cantidad de líneas en este archivo sea igual a la cantidad de bodegas definidas en el archivo `inputProblem4_Trucks.txt`. 
3) Si no hay bodegas, el archivo debe estar vacío (**debe haber un archivo en cualquier caso**). 
4) Cada línea representa la capacidad de carga de la bodega `X` donde `X` es el número de la línea, empezando en 1.
