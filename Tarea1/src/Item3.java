import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Item3 {
    public static class Luchador{
        int vida;
        int resistencia;
        int durabilidad;
        int ataque;
        int superPatada;
        Luchador(int v, int r, int d, int a, int sP){
            this.vida = v;
            this.resistencia = r;
            this.durabilidad = d;
            this.ataque = a;
            this.superPatada = sP;
        }
        public void printStats(){
            System.out.println(this.vida + " " + this.resistencia + " " + this.durabilidad + " " + this.ataque + " " + this.superPatada);
        }
        public int getVida(){
            return this.vida;
        }
        public void setVida(int v){
            this.vida = v;
        }
        public int getResistencia(){
            return resistencia;
        }
        public void setResistencia(int r){
            this.resistencia = r;
        }
        public void setDurabilidad(int d){
            this.durabilidad = d;
        }
        public int getDurabilidad(){
            return durabilidad;
        }
        public int getSuperPatada(){
            return superPatada;
        }
        public void checkInstaKill(Luchador l){
            if(l.getVida() == this.getSuperPatada()){ //Eliminacion por SuperPatada
                l.setVida(0);
                return;
            } else if(this.getVida() == l.getSuperPatada()){
                this.setVida(0);
            }
        }
        
        public void peleaContra(Luchador l){
            int resistenciaEnemigo = l.getResistencia();
            
        if(l.getDurabilidad() > 0){
                int danio = this.ataque - resistenciaEnemigo;
                l.setVida(l.getVida() - danio);
                l.setDurabilidad(l.getDurabilidad() - 1);
        }else{
            l.setVida(l.getVida() - this.ataque);
        if(l.getVida() < 1){
            return;
        }
        }if(this.durabilidad > 0){
            int danio = l.ataque - this.resistencia;
            this.setVida(this.vida - danio);
            this.setDurabilidad(this.getDurabilidad() - 1);
        }else{
            this.setVida(this.vida - l.ataque);
        }
        if(this.getVida() < 1){
            return;
        }
    }
}

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        Luchador[] luchadores = new Luchador[N];
        for(int i = 0; i < N; i++){
            int vida = input.nextInt();
            int resistencia = input.nextInt();
            int durabilidad = input.nextInt();
            int ataque = input.nextInt();
            int superPatada = input.nextInt();
            Luchador l = new Luchador(vida, resistencia, durabilidad, ataque, superPatada);
            luchadores[i] = l;
        }
        input.close();
        int j = 0;
        for(int i = 1; i < N; i++){
            Luchador L1 = luchadores[j];
            Luchador L2 = luchadores[i];
            while(L1.getVida() > 0 || L2.getVida() > 0){
                L2.checkInstaKill(L1);
                if(L1.getVida() < 1){
                    j = i;
                    break;
                }else if(L2.getVida() < 1){
                    break;
                }
                L1.peleaContra(L2);
            }
        }
        //Comprobar el ganador
        if(j == 0){
            System.out.println("gane yo :D");
        }else{
            System.out.println(j+1);
        }
    }
}