import java.io.*;
import java.util.*;

class UberRequest {
    int x1;
    int y1;
    int x2;
    int y2;
    int tiempo;

    public UberRequest(int x1, int y1, int x2, int y2, int tiempo) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.tiempo = tiempo;
    }
}

class Uber {
    int posX;
    int posY;
    boolean ocupado;

    public Uber(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.ocupado = false;
    }
}

public class uberGreedy {
    public static void main(String[] args) {
    List<Uber> uberManana = posicionUbers("D:\\Codes\\Java\\ClaseEDA\\LabEDDA5\\src\\manana.dat");
    List<Uber> uberTarde = posicionUbers("D:\\Codes\\Java\\ClaseEDA\\LabEDDA5\\src\\tarde.dat");
    List<Uber> uberNoche = posicionUbers("D:\\Codes\\Java\\ClaseEDA\\LabEDDA5\\src\\noche.dat");

    List<UberRequest> solicitud = peticionUbers("D:\\Codes\\Java\\ClaseEDA\\LabEDDA5\\src\\requests_1.dat");
    solicitud.addAll(peticionUbers("D:\\Codes\\Java\\ClaseEDA\\LabEDDA5\\src\\requests_2.dat"));
    solicitud.addAll(peticionUbers("D:\\Codes\\Java\\ClaseEDA\\LabEDDA5\\src\\requests_3.dat"));

    Collections.sort(solicitud, Comparator.comparingInt(request -> request.tiempo)); //Ordenar por tiempo

    int totalCost = 0;
    List<String> outputManana = new ArrayList<>();
    List<String> outputTarde = new ArrayList<>();
    List<String> outputNoche = new ArrayList<>();

    for (UberRequest request : solicitud) {
        int minDistance = Integer.MAX_VALUE;
        Uber nearestUber = null;

        for (Uber uber : uberDisponible(request.tiempo, uberManana, uberTarde, uberNoche)) {
            int distanciaM = Math.abs(uber.posX - request.x1) + Math.abs(uber.posY - request.y1);
            if (distanciaM < minDistance) {
                minDistance = distanciaM;
                nearestUber = uber;
            }
        }

        if (nearestUber != null) {
            totalCost += minDistance + Math.abs(request.x1 - request.x2) + Math.abs(request.y1 - request.y2);
            nearestUber.posX = request.x2;
            nearestUber.posY = request.y2;
            nearestUber.ocupado = true;

            String outputLine = request.tiempo + " " + totalCost;
            if (request.tiempo < 12) {
                outputManana.add(outputLine);
            } else if (request.tiempo < 18) {
                outputTarde.add(outputLine);
            } else {
                outputNoche.add(outputLine);
            }
        }
    }

    archivoOutput("manana.dat", outputManana);
    archivoOutput("tarde.dat", outputTarde);
    archivoOutput("noche.dat", outputNoche);
}


    private static List<Uber> posicionUbers(String archivo) {
        List<Uber> ubers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(archivo))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] coordenadas = linea.split(" ");
                int posX = Integer.parseInt(coordenadas[0]);
                int posY = Integer.parseInt(coordenadas[1]);
                ubers.add(new Uber(posX, posY));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ubers;
    }

    private static List<UberRequest> peticionUbers(String archivo) {
        List<UberRequest> solicitud = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(archivo))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(" ");
                int x1 = Integer.parseInt(datos[0]);
                int y1 = Integer.parseInt(datos[1]);
                int x2 = Integer.parseInt(datos[3]);
                int y2 = Integer.parseInt(datos[4]);
                int tiempo = Integer.parseInt(datos[6]);
                solicitud.add(new UberRequest(x1, y1, x2, y2, tiempo));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return solicitud;
    }

    private static List<Uber> uberDisponible(int tiempo, List<Uber> uberManana, List<Uber> uberTarde, List<Uber> uberNoche) {
        if (tiempo < 12) {
            return uberManana;
        } else if (tiempo < 18) {
            return uberTarde;
        } else {
            return uberNoche;
        }
    }

    private static void archivoOutput(String archivo, List<String> calculosOutput) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            for (String linea : calculosOutput) {
                writer.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}