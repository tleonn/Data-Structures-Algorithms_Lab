import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

 class Platform {
    Video head;
    Platform(){
        head = null;
    }
    Platform(Video v){
        head = v;
    }

    static class Video {
        String videoID;
        String videoTitle;
        String channelID;
        String channelTitle;
        String publishedAt;
        long viewCount;
        long likeCount;
        long commentCount;
        long popularity;
//se cambio todo a long
        Video next;
        Video(String videoID, String videoTitle, String channelID, String channelTitle, String publishedAt, long viewCount, long likeCount, long commentCount){
            this.videoID = videoID;
            this.videoTitle = videoTitle;
            this.channelID = channelID;
            this.channelTitle = channelTitle;
            this.publishedAt = publishedAt;
            this.viewCount = viewCount;
            this.likeCount = likeCount;
            this.commentCount = commentCount;
            next = null;
            if(this.likeCount == 0){
                this.popularity = 0;
            }else{
                this.popularity = (this.viewCount / this.likeCount);
            }
        }

        void play(){
            System.out.println(videoID +" "+videoTitle);
        }
    }

    Video begin(){
        return head;
    }

    long isNumericLong(String s){
        long d = 0;
        try {
            d = Long.parseLong(s);
        }
        catch (NumberFormatException ignored){}
        return d;
    }// funcion no utilizada "inecesaria:
    int isNumericInt(String s){
        int i = 0;
        try {
            i = Integer.parseInt(s);
        }
        catch (NumberFormatException ignored){}
        return i;
    }// funcion no utilizada "inecesaria:

    Video arrayToVideo(ArrayList<String> array){
        long Visitas;
        long Likes;
        long Comentarios;
        if(array.get(5) == ""){//se cambio por el caso borde si alguno es nulo que significa que es 0
            Visitas = 0;
        }else{
             Visitas = Long.parseLong(array.get(5));
        }
        if(array.get(6) == ""){
            Likes = 0;
        }else{
            Likes = Long.parseLong(array.get(6));
        }
        if(array.get(7) == ""){
            Comentarios = 0;
        }else{ 
            Comentarios = Long.parseLong(array.get(7));
        }
        Video v = new Video(array.get(0),
                array.get(1),
                array.get(2),
                array.get(3),
                array.get(4),
                Visitas,// Cambio de array.get a Long.parseLong;
                Likes,// Cambio de array.get a Long.parseLong;
                Comentarios// Cambio de array.get a Long.parseLong;
        );
        return v;
    }
    void insertFromFile(String file){
        String string;
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            //Skip first
            br.readLine();
            while((string = br.readLine()) != null){
                boolean inQuotes = false;
                int start = 0;
                ArrayList<String> newLines = new ArrayList<>();
                for (int i = 0; i < string.length(); i++) {
                    if (string.charAt(i) == '\"') {
                        inQuotes = !inQuotes;
                    } else if (string.charAt(i) == ',' && !inQuotes) {
                        newLines.add(string.substring(start, i));
                        start = i + 1;
                    }
                }
                newLines.add(string.substring(start));
                Video newVideo = arrayToVideo(newLines);
                insertAtEnd(newVideo);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    Video recursiveLast(Video v){
        Video aux = v;
        if(aux == null){
            return aux;
        }
        else if ( aux.next != null){
            return recursiveLast(aux.next);
        }else{
            return aux;
        }
    }
    Video iterativeLast(Video v){
        Video aux = v;
        if(aux == null){
            return aux;
        }
        while(aux.next != null){
            aux = aux.next;
        }
        return aux;
    }

    void insertAtEnd(Video v){
        Video tail = iterativeLast(head);
        if ( tail == null){
            head = v;
            return;
        }
        tail.next = v;
    }
    void recursivePrint(Video v){
            Video aux = v;
            if(aux == null){
                return;
            }
            aux.play();
            recursivePrint(aux.next);
        }

    void iterativePrint(Video v){
        Video actual = v;
        while (actual != null){// se cambio de v.next a -> v ya que se lleva al ultimo termino y su ultimo es null;
            /*while(!(Objects.equals(actual.videoID,v.videoID))){
                actual = actual.next;
            }*/
            actual.play();
            actual = actual.next;
        }
    }

    Video search(Video v, String VideoID){
        //implemente esta función, puede ser iterativa o recursiva.
        Video aux = v;
        while(aux != null) {
            if (aux.videoID.equals(VideoID)) {
                 return aux;
            }
            aux = aux.next;
        }
        return null;
    }

    void reverse(Video v){
        //implemente esta función, puede ser iterativa o recursiva.
        if(v == null){
            return;
        }
        Video Videoprev = null;
        Video aux = head;
        Video Videonext = null;
        while(aux != null){
            Videonext = aux.next;
            aux.next = Videoprev;
            Videoprev = aux;
            aux = Videonext;
        }
        head = Videoprev;
    }
    public static void main(String[] args) {
        //pruebas para la API
        Platform platform = new Platform();
        String file = "D:\\Codes\\Java\\ClaseEDA\\LabEDA2\\src\\YoutubeDTSV2.csv";
        platform.insertFromFile(file);
        platform.iterativePrint(platform.begin());
        platform.reverse(platform.begin());
        platform.iterativePrint(platform.begin());
        System.out.println("search: " + platform.search(platform.begin(),"7A_BNXG88i8"));
    }
}