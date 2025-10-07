import java.io.*;
public class listasSimples {
    public static void main(String[] args) throws IOException
    {
        ListaSimple lista = new ListaSimple();
        Nodo nodo1 = new Nodo(12);
        Nodo nodo2 = new Nodo(10);
        Nodo nodo3 = new Nodo(14);
        lista.appendNodo(nodo1);
        lista.appendNodo(nodo2);
        lista.appendNodo(nodo3);
		lista.removeNodo();
        lista.printLista();
    }  
}

class Nodo
{
    private int dato;
    public Nodo siguiente;

    public Nodo(int d)
    {
        this.dato = d;
        this.siguiente = null;
    }    
    
    public int getDato()
    {
        return dato;
    }
}


class ListaSimple
{
	private Nodo inicio;
	
	public ListaSimple()
	{
		this.inicio = null;
	}
	
	public void appendNodo(Nodo nuevo)
	{
		if(inicio == null)
		{
			inicio = nuevo;
		}
		else
		{
			Nodo temp = inicio;
			while(temp.siguiente!=null)
			{
				temp = temp.siguiente;
			}	
			temp.siguiente = nuevo;
		}
		System.out.println("Nodo ingresado");
	}

	public void popNodo()
	{
		Nodo temp = inicio;
		if(inicio == null){
			System.out.println("No hay nodos ingresados.");
		}
		else if(inicio.siguiente == null){
			inicio = null;
		}else{
			while(temp.siguiente != null){
			temp = temp.siguiente;
		}
			temp = null;
		}
	}
	
	public void removeNodo()
	{
		if(inicio == null){
			System.out.println("No hay nodos ingresados");
		}else if(inicio.siguiente == null){
			inicio = null;
		}else{
			Nodo temp = inicio;
			inicio = inicio.siguiente;
			temp = null;
		}
		System.out.println("Nodo removido exitosamente.");
	}

	public void reordenarLista(){
		
	}

	public void pushNodo(Nodo nuevo)
	{
		if(inicio == null){
			inicio = nuevo;
		}else{
			nuevo.siguiente = inicio;
			nuevo = inicio;
		}
	}

	public void printLista()
	{
		Nodo temp = inicio;
		int dato;
		while(temp != null)
		{
			dato = temp.getDato();
			System.out.print(dato+" / ");
			temp = temp.siguiente;
		}
	}

}