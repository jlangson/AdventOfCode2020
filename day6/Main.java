import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException{
      String content = new String(Files.readAllBytes(Paths.get("input.txt")));
        System.out.println("size of content = " + content.length());
       String[] groups = content.split("\n\n");
       int yes=0;

       for(int i=0; i < groups.length; i++){
        HashSet<Character> answers = new HashSet<>();
        for(int j=0; j < groups[i].length(); j++){
            if(groups[i].charAt(j)!='\n'){

            
            answers.add(groups[i].charAt(j));
            }
        } 
        yes+=answers.size();
  
        System.out.println("======\n" + groups[i]);
        

       }

    // String[] testInputs = new String[]{"abc", "abc", "abac", "aaaa","b"};

    //    for(int i=0; i < testInputs.length; i++){
    //     HashSet<Character> answers = new HashSet<>();
    //     for(int j=0; j < testInputs[i].length(); j++){
    //         answers.add(testInputs[i].charAt(j));
    //     } 
    //     yes+=answers.size();
   

    //    }



    // for(int i=0; i < groups.length; i++){
    //     HashMap<Character, Integer> answers = new HashMap<Character, Integer>();
    //     for(int j=0; j < groups[i].length(); j++){
    //         answers.put(groups[i].charAt(j),0);
    //     } 
    //     yes+=answers.size();
    //     answers = null;

    //    }


       System.out.println("yes " + yes);
      


    }
}