import java.util.ArrayList ;
import java.util.Scanner ;



class Playliststack{
    ArrayList<String> stack;

    public Playliststack(){
        stack = new ArrayList<>();
    }

    public void push(String song){
        stack.add(song);
        System.out.println( song + " is added to top of playlist");
    }
    public void pop(){
        if(stack.isEmpty()){
            System.out.println("the playlist is empty");
        }
        String removed = stack.remove(stack.size() - 1);
        System.out.println(removed + " is removed from playlist");
    }
    public void peek(){
        if(stack.isEmpty()){
            System.out.println("playlist is empty");
        }
        else{
            System.out.println("the current song is "+ stack.get(stack.size()-1));}
    }
   public void display(){
       if(stack.isEmpty()){
           System.out.println("playlist is empty");
       }
       else {
           System.out.println("the songs in playlist are : ");
           for (int i = stack.size() - 1; i >= 0; i--) {
               System.out.println("->"+stack.get(i));
           }
       }
   }


}  public class Main {
          public static void main(String[] args) {
              Playliststack playlist = new Playliststack();
              Scanner scanner = new Scanner(System.in);
              int choice;
          do{
              System.out.println("\nPlease choose an option:");
              System.out.println("1. Add a song to play next");
              System.out.println("2. Remove the currently playing song");
              System.out.println("3. View the currently playing song");
              System.out.println("4. Show full playlist");
              System.out.println("5. Exit");
              System.out.print("Your choice: ");
              choice = scanner.nextInt();
              scanner.nextLine();
              switch(choice){
                  case 1 :
                      System.out.print("Enter song name to add: ");
                      String song = scanner.nextLine();
                      playlist.push(song);
                  break;
                  case 2 : playlist.pop();
                  break;
                  case 3 : playlist.peek();
                  break;
                  case 4 : playlist.display();
                  break;
                  case 5 :
                      System.out.println("exiting");
                      break;
                  default:
                      System.out.println("invalid input");
              }
          }while(choice!=5);

        scanner.close();
    }
}
