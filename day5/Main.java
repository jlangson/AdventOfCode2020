import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;



public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("yo");
        List<String> fileStream = Files.readAllLines(Paths.get("input.txt"));
        LinkedList<BoardingPass> allBoardingPasses = new LinkedList<>();
        int maxId=Integer.MIN_VALUE;
         for(String f :fileStream){
             BoardingPass pass = new BoardingPass(f);
             allBoardingPasses.add(pass);
            //  System.out.println(pass);
             if(pass.id > maxId){
                 maxId = pass.id;
             }
         }
        // BoardingPass testPass = new BoardingPass("FBFBBFFRLR");
        // System.out.println(testPass); //expect row 44 and col 5
        System.out.println(maxId);
        
    }
}
