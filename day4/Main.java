import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("yo");
        List<String> fileStream = Files.readAllLines(Paths.get("input.txt"));
        //tokenize on spaces and empty lines
        int i=0;
        for(String line : fileStream){
            Stack<String> onePassportData = new Stack<>();

            if(!line.equals("")){
                
             }
             else{ //when it's empty line that's the end of the passport

             }
            
        }

        // for(int j=0; j < 10; j++){
        //     System.out.println(fileStream.get(j));
        // }
        System.out.println(i);
    }

    // public static   parsePassport
}