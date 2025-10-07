public class MinHeap {

    private int capacity;
    private Video[] pq;
    private int size;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.pq = new Video[capacity];
        this.size = 0;
    }


    public int getSize() {return size;}

    public int getCapacity() {return capacity;}

    public Video getTop(){
        if(size == 0){
            throw new IllegalStateException("La lista está vacía");
        }
        else {
            return pq[0];
        }
    }

    private void swap(int v1, int v2){
        Video temp = pq[v1];
        pq[v1] = pq[v2];
        pq[v2] = temp;
    }

    private int compare(Video v1, Video v2)
    {
        return Float.valueOf(v1.getPopularity() - v2.getPopularity()).intValue();
    }

    public void insert(Video video)
    {
        if(size == capacity){
            throw new IllegalStateException("La lista está llena");
        }
        pq[size++] = video;
        swim(size-1);
    }

    private void swim(int k)
    {
        int parent = (k-1)/2;
        if(k>0 && compare(pq[parent], pq[k] ) > 0 ){
            swap(k, parent);
            swim(parent);
        }
    }

    private void sink(int k){
        int left = 2*k+1;
        int right = 2*k+2;
        int lower = k;
        if (left  < size && compare(pq[left], pq[lower]) < 0 ){
            lower = left;
        }
        if (right < size && compare(pq[right], pq[lower]) < 0){
            lower = right;
        }
        if (lower != k)
        {
            swap(k, lower);
            sink(lower);
        }
    }
    public Video deleteMax(){
        if(size == 0){
            throw new IllegalStateException("La lista está vacía");
        }
        float Mayor = Integer.MIN_VALUE;
        int Indice = 0;
        for(int i = 0;i< size ;i++){
            if(Mayor < pq[i].getPopularity()){
                Mayor = pq[i].getPopularity();
                Indice = i;
            }
        }
        Video Eliminado = pq[Indice];
        swap(size-1,Indice);
        this.size--;
        swim(Indice);
        return Eliminado;
    }
    public Video delete(){
        if(size == 0){
            throw new IllegalStateException("La lista está vacía");
        }
        Video video = pq[0];
        pq[0] = pq[--size];
        pq[size] = null;
        sink(0);
        return video;
    }



    public Video getVideo(int k)
    {
        if(k < size && k>= 0){
            return pq[k];
        }
        else{
            return null;
        }
    }

    public void printPriorityQueue()
    {
        for (int i= 0; i < size; i++ ){
            if(pq[i] != null)  {
                System.out.printf("%s ",getVideo(i).getVideoTitle());
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //Test cases
        MinHeap pq = new MinHeap(50);

        pq.insert( new Video("1","video 1", "1","channel title", "12-12-1221",131, 323, 323,22f));
        pq.insert( new Video("2","video 2", "2","channel title", "12-12-1221",131, 323, 323,12f));
        pq.insert( new Video("3","video 3", "3","channel title", "12-12-1221",131, 323, 323,13f));
        pq.insert( new Video("4","video 4", "4","channel title", "12-12-1221",131, 323, 323,14f));
        pq.insert( new Video("5","video 5", "5","channel title", "12-12-1221",131, 323, 323,15f));
        pq.insert( new Video("6","video 6", "6","channel title", "12-12-1221",131, 323, 323,16f));
        pq.insert( new Video("7","video 7", "7","channel title", "12-12-1221",131, 323, 323,17f));
        pq.insert( new Video("8","video 8", "8","channel title", "12-12-1221",131, 323, 323,18f));
        pq.insert( new Video("9","video 9", "9","channel title", "12-12-1221",131, 323, 323,19f));
        pq.insert( new Video("10","video 14", "10","channel title", "12-12-1221",131, 323, 323,20f));
        pq.insert( new Video("11","video 15", "11","channel title", "12-12-1221",131, 323, 323,21f));
        pq.insert( new Video("12","video 16", "12","channel title", "12-12-1221",131, 323, 323,11f));
        pq.printPriorityQueue();
        System.out.println("termina");
        pq.deleteMax().reproduce();
        System.out.println("termina");
        pq.printPriorityQueue();


    }

}