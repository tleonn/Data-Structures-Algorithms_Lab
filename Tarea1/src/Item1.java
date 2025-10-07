import java.util.*;
public class Item1 {
    public static class Participante{
        String Nombre;
        int Poder;
        Participante(String n, int p){
            this.Nombre = n;
            this.Poder = p;
        }
        public void printStats(){
        System.out.println(this.Nombre + " " + this.Poder);
        }
    }

    public static class CompareByPower implements Comparator<Participante> {
        public int compare(Participante p1, Participante p2) {
            return p1.Poder - p2.Poder;
        }
    } 

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        if(N > 2500){
            System.out.println("Excede la cantidad de participantes posibles.");
        }
        ArrayList<Participante> participantes = new ArrayList<>();
        for(int i = 0; i < N; i++){ //Ingresar participantes.
            String nombre = input.next();
            int poder = input.nextInt();
            Participante p = new Participante(nombre, poder);
            participantes.add(p);
        }
        input.close();
        Collections.sort(participantes, new CompareByPower());
        for(Participante i : participantes){ //Leer todos los participantes.
            i.printStats();
        }
    }
}