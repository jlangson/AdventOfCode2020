import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Toboggan {

    public static void main(String[] args) throws IOException {
        /*
         * Descriptin of problem get a grid with empty and full locations starting top
         * left, go right 3 down 1 until you reach the depth of the grid the grid's
         * depth is unknown but very large the map is incomplete and the pattern repeats
         * itself - there might be an optimization trick here I think a 2D array would
         * be a natural fit while I could use a a primitive array I wouldn't always know
         * the size of the input file.
         * 
         * 
         */
        List<String> fileStream = Files.readAllLines(Paths.get("input.txt"));


   
        // int baseWidth = fileStream.get(0).length();
        // int depth = fileStream.size();
        // int slopeX = 3;
        // int slopeY = 1;
    
        //determinze the size of the char array based on the width of the line
        // the depth of the file * 3 is the actual width of the array.
        // char[][] map = new char[depth*slopeX][depth];
        // LinkedList<String> map = new LinkedList<>();
        int treesHit=0;
        int x=0;
        for(String row : fileStream){
            //map repeats on width so reset x
            if(x >= row.length()){
               x = x - row.length();
            }
            if(row.charAt(x)=='#'){
                treesHit++;
            }
            x+=3; //sleigh moves horizontally 3 per 1 row.
            
        }
        // for(int y=0; y < fileStream.size(); y++){
        //     String row = fileStream.get(y);
        //     for(int x=0; x < row.length(); x+=3){
        //         if(x > row.length()){
        //             x = x % row.length();
        //         }
        //         if(row.charAt(x)=='#'){
        //             treesHit++;
        //         }
        //     }

        // }
        System.out.println("treesHit " + treesHit);
        // for(String line : fileStream){
        //     //populate the grid and duplicate the line entries
        //     //what if I do a linkedlist of linkedlist?
        //     //if I reach the end of the row, reset. 
            
        // }
        // int openSpaces=0;

        // for(String line : fileStream){
        //     System.out.println(line);
        // }

    
    }
}