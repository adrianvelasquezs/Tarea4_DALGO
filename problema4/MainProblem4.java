package problema4;

import java.util.*;

/**
 * Main class for problem 4.
 * This class is used to test the implementation of the classes in the problem 4.
 *
 * @author Adrian Velasquez 202222737
 */
public class MainProblem4 {

    private static int getMaximumBooks(List<Factory> factories, List<Warehouse> warehouses, List<Library> libraries,
                                       List<Truck> trucks) {
        int totalBooks = 0;
        int i;

        // Mapa para almacenar la capacidad disponible en cada bodega
        Map<String, Integer> warehouseCapacity = new HashMap<>();
        i = 1;
        for (Warehouse warehouse : warehouses) {
            warehouseCapacity.put("W"+i, warehouse.getCapacity());
            i++;
        }

        // Mapa para almacenar la capacidad disponible en cada librería
        Map<String, Integer> libraryCapacity = new HashMap<>();
        i = 1;
        for (Library library : libraries) {
            libraryCapacity.put("L"+i, library.getCapacity());
            i++;
        }

        // Procesar cada camión
        for (Truck truck : trucks) {
            String startPoint = truck.getStartPoint();
            String endPoint = truck.getEndPoint();
            int truckCapacity = truck.getCapacity();

            if (startPoint.startsWith("F") && endPoint.startsWith("W")) {
                // Transporte de fábrica a bodega
                int availableCapacity = Math.min(truckCapacity, warehouseCapacity.get(endPoint));
                totalBooks += availableCapacity;
                warehouseCapacity.put(endPoint, warehouseCapacity.get(endPoint) - availableCapacity);
            } else if (startPoint.startsWith("W") && endPoint.startsWith("L")) {
                // Transporte de bodega a librería
                int availableCapacity = Math.min(truckCapacity, libraryCapacity.get(endPoint));
                totalBooks += availableCapacity;
                libraryCapacity.put(endPoint, libraryCapacity.get(endPoint) - availableCapacity);
            } else if (startPoint.startsWith("F") && endPoint.startsWith("L")) {
                // Transporte directo de fábrica a librería
                int availableCapacity = Math.min(truckCapacity, libraryCapacity.get(endPoint));
                totalBooks += availableCapacity;
                libraryCapacity.put(endPoint, libraryCapacity.get(endPoint) - availableCapacity);
            }
        }

        return totalBooks;
    }

    public static void main(String[] args) {
        List<Factory> factories = new ArrayList<>();
        List<Warehouse> warehouses = new ArrayList<>();
        List<Library> libraries = new ArrayList<>();
        List<Truck> trucks = new ArrayList<>();

        // Ejemplo de datos
        factories.add(new Factory(500));
        warehouses.add(new Warehouse(300));
        libraries.add(new Library(400));
        trucks.add(new Truck(100, "F1", "W1"));
        trucks.add(new Truck(200, "W1", "L1"));
        trucks.add(new Truck(150, "F1", "L1"));

        System.out.println(getMaximumBooks(factories, warehouses, libraries, trucks));
    }
}
