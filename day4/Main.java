import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("yo");
        List<String> fileStream = Files.readAllLines(Paths.get("input.txt"));
        //tokenize on spaces and empty lines
        String rawPassport="";
        int validPassports=0;
        LinkedList<Passport> allPassports = new LinkedList<>();
      
        for(String line : fileStream){

            if(!line.equals("")){ //line is not empty so we are grouping the passport data
               rawPassport+=line;
               
             }
             else{  
                 //construct the passport
                 Passport passport = new Passport(rawPassport); 
                 allPassports.add(passport);

                //if pp is valid increase counter
                if(passport.getValid()){
                    validPassports++;
                }
            }
            rawPassport="";

        }
            
        

        // for(int j=0; j < 10; j++){
        //     System.out.println(fileStream.get(j));
        // }
        //go through a few passports to see what is going on. cause i'm getting all are invalid
       for(int i=0; i < 10; i++){
          System.out.println(allPassports.pop()); //ez way to look at a few passports
          //lol turns out my constructor is borked and everything is nulll
       }
        System.out.println("\n=======\n" + validPassports);
  

    // public static   parsePassport
}
}
