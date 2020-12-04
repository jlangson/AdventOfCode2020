import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;


//quick and dirty non-OO approach
public class MainDirty {
    public static void main(String[] args) throws IOException {
        System.out.println("yo");
        List<String> fileStream = Files.readAllLines(Paths.get("input.txt"));
        //tokenize on spaces and empty lines
        String rawPassport="";
        int validPassports=0;
      
        for(String line : fileStream){

            if(!line.equals("")){ //line is not empty so we are grouping the passport data
               rawPassport+=line;
               
             }
             else{  //now we see if it's valid
                int numFields=0;
                for(int i=0; i < rawPassport.length(); i++){
                    if(rawPassport.charAt(i)==':' && rawPassport.charAt(i-3)!='c'){
                        numFields++;
                    }
                   

                }
                if(numFields==7){
                    validPassports++;
                }
                rawPassport="";
                

             }
            
        }

        // for(int j=0; j < 10; j++){
        //     System.out.println(fileStream.get(j));
        // }
        System.out.println(validPassports);
    }

    // public static   parsePassport
}