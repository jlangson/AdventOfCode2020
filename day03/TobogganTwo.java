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
        sleighs.add(new Sleigh(1,2)); 

        ArrayList<String> grid = new ArrayList<>(fileStream.size());

       //populate the grid
       for(int i=0; i < fileStream.size(); i++){
           grid.add(fileStream.get(i));
       }

       //go through the grid row by row. Pretend each iteration is 1 second of the sleigh traveling
       //each iteration compare the position of the sleigh to the location in the grid
       for(int t=0; t < grid.size(); t++){
           for(Sleigh sleigh : sleighs){
               //prevents going off the grid vertically
               if(sleigh.getColLoc() > grid.size()){
                   continue;
               }
               //used x and y to make it more readable
               int x = sleigh.getRowLoc();
               int y = sleigh.getColLoc();
               if(x >= grid.get(y).length()){
                   sleigh.setRowLoc(sleigh.getRowLoc() - grid.get(y).length());
                   x = sleigh.getRowLoc();
               }
               if(grid.get(y).charAt(x)=='#'){ 
                   sleigh.collision();
               }
                sleigh.nextRow();
                sleigh.nextCol();   
           }
       }
        //for calculating product
        int product = 1;
        for(Sleigh sleigh : sleighs){
            System.out.println(sleigh);
            product *= sleigh.getTreesHit();
        }
        System.out.println(product);
    }
}