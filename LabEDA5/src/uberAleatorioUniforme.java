import java.util.*;
import java.io.*;

class Uber {
    int posX;
    int posY;

    public Uber(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
}

class uberRequest {
    Uber origen;
    Uber destino;
    int tiempo;

    public uberRequest(Uber origen, Uber destino, int tiempo) {
        this.origen = origen;
        this.destino = destino;
        this.tiempo = tiempo;
    }
}

public class uberAleatorioUniforme {
    public static void main(String[] args) {
        List<Uber> uberManana = posicionUbers("");
        List<Uber> uberTarde = posicionUbers("");
        List<Uber> uberNoche = posicionUbers("");

        List<uberRequest> requests1 = peticionUbers("");
        List<uberRequest> requests2 = peticionUbers("");
        List<uberRequest> requests3 = peticionUbers("");

        List<String> outputManana = procesarSolicitudes(uberManana, requests1);
        List<String> outputTarde = procesarSolicitudes(uberTarde, requests2);
        List<String> outputNoche = procesarSolicitudes(uberNoche, requests3);
        archivoOutput("manana.dat", outputManana);
        archivoOutput("tarde.dat", outputTarde);
        archivoOutput("noche.dat", outputNoche);
    }
    public static List<String> procesarSolicitudes(List<Uber> ubers, List<uberRequest> solicitudes) {
        List<String> resultados = new ArrayList<>();

        for (uberRequest solicitud : solicitudes) {
            Uber uberSeleccionado = seleccionarUberAleatorio(ubers);
            if (uberSeleccionado != null) {
                int distancia = calcularDistancia(uberSeleccionado, solicitud.destino);
                resultados.add(solicitud.tiempo + " " + distancia);
            }
        }

        return resultados;
    }

    public static List<Uber> posicionUbers(String archivo) {
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

    public static List<uberRequest> peticionUbers(String archivo) {
        List<uberRequest> solicitudes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(" ");
                int xi = Integer.parseInt(datos[0]);
                int yi = Integer.parseInt(datos[1]);
                int xf = Integer.parseInt(datos[3]);
                int yf = Integer.parseInt(datos[4]);
                int tiempo = Integer.parseInt(datos[6]);
                Uber origen = new Uber(xi, yi);
                Uber destino = new Uber(xf, yf);
                solicitudes.add(new uberRequest(origen, destino, tiempo));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return solicitudes;
    }

    public static Uber seleccionarUberAleatorio(List<Uber> ubers) {
        if (ubers.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(ubers.size());
        Uber uberSeleccionado = ubers.get(index);
        ubers.remove(index);
        return uberSeleccionado;
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

    public static int calcularDistancia(Uber origen, Uber destino) {
        int distanciaM = Math.abs(origen.posX - destino.posX) + Math.abs(origen.posY - destino.posY);
        return distanciaM;
    }
}