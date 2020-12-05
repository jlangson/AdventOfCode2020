import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;



public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("yo");
        List<String> fileStream = Files.readAllLines(Paths.get("input.txt"));
        LinkedList<BoardingPass> allBoardingPasses = new LinkedList<>();
        ArrayList<Integer> ids = new ArrayList<>(819);
        int maxId=Integer.MIN_VALUE;
        int minId = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int minRow = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
         for(String f :fileStream){
             BoardingPass pass = new BoardingPass(f);
             allBoardingPasses.add(pass);
             ids.add(pass.id);
            //  System.out.println(pass);
             if(pass.id > maxId){
                 maxId = pass.id;
             }
             if(pass.id < minId){
                 minId = pass.id;
             }
             if(pass.row > maxRow){
                 maxRow = pass.row;
             }
             if(pass.row < minRow){
                 minRow = pass.row;
             }
             if(pass.col < minCol){
                 minCol = pass.col;
             }
             if(pass.col > maxCol){
                 maxCol = pass.col;
             }
         }
         Collections.sort(ids); //ascending 
         //looking for all the ids that are within 2 of each other and nothing in the middle
         for(int i=0; i < ids.size()-1; i++){
             int a = ids.get(i);
             int b = ids.get(i+1);
             if(a+2==b){
                 System.out.println(a+1);
             }
         }
        // BoardingPass testPass = new BoardingPass("FBFBBFFRLR");
        // System.out.println(testPass); //expect row 44 and col 5
        // System.out.printf("maxId is%d minId is%d maxRow is %d minRow is %d", maxId, minId, maxRow, minRow); //answer 842 maxId
        System.out.printf("%d <= id =< %d\t %d =< row =< %d\t %d =< col =< %d%n",  minId, maxId, minRow, maxRow, minCol, maxCol); //answer 842 maxId
    }
}
