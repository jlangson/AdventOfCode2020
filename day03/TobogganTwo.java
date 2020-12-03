import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class TobogganTwo {

    public static void main(String[] args) throws IOException {
        /*
        Right 1, down 1.
        Right 3, down 1. (This is the slope you already checked.)
        Right 5, down 1.
        Right 7, down 1.
        Right 1, down 2. //this will be tricky TODO

        In the above example, these slopes would find 2, 7, 3, 4, and 2 tree(s) respectively;
        multiplied together, these produce the answer 336.*/
        List<String> fileStream = Files.readAllLines(Paths.get("input.txt"));
        ArrayList<Sleigh> sleighs = new ArrayList<>(5);
        sleighs.add(new Sleigh(1,1));
        sleighs.add(new Sleigh(3,1));
        sleighs.add(new Sleigh(5,1));
        sleighs.add(new Sleigh(7,1));
        // sleighs.add(new Sleigh(1,2)); //will have to hardcode this since I didn't make a grid

      
        for(String row : fileStream){
            for(Sleigh sleigh : sleighs){
                if(sleigh.getRowLoc() >= row.length()){ //simulates a map of infinite width
                    sleigh.setRowLoc(sleigh.getRowLoc() - row.length());
                }
              
                if(row.charAt(sleigh.getRowLoc())=='#'){
                    sleigh.collision();
                }
                sleigh.nextCol();
                sleigh.nextRow();
            }
        }
        //for calculating sum
        int product = 1;
        for(Sleigh sleigh : sleighs){
            System.out.println(sleigh);
            product *= sleigh.getTreesHit();
        }
        System.out.println(product);
       
       
       

    //map repeats on width so reset x
            // if(x >= row.length()){
            //    x = x - row.length();
            // }
            // if(row.charAt(x)=='#'){
                
            // }
            // x+=3; //sleigh moves horizontally 3 per 1 row.
    }
}