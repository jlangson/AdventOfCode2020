import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MainPart2 {
    public static void main(String[] args) throws IOException{
      System.out.println("yo");
      String content = new String(Files.readAllBytes(Paths.get("input.txt")));
        // System.out.println("size of content = " + content.length());
       String[] groups = content.split("\n\n");
       int yes=0;
      //  groups.length;
       for(int i=0; i < groups.length; i++){
        HashMap<Character, Integer> answers = new HashMap<>(); 
        //count how many for each answer. if it's the same for the group size then increment
        int members=1; //\n s
        // int count=0;
        for(int j=0; j < groups[i].length(); j++){
          char key = groups[i].charAt(j);
       
            if(groups[i].charAt(j)!='\n'){
              if(answers.containsKey(key)){
                  answers.put(key, answers.get(key)+1);
              } else{
                answers.put(groups[i].charAt(j),1);
              }
            
            }
            else{
              ++members;
            }
          
            
      
        }
        for(Integer value : answers.values()){
          if(value==members){
            ++yes;
          }
        } 

        // yes+=

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

    // public static void countAnswers(Map mp) {
    //   Iterator it = mp.entrySet().iterator();
    //   while (it.hasNext()) {
    //       Map.Entry pair = (Map.Entry)it.next();
    //       System.out.println(pair.getKey() + " = " + pair.getValue());
    //       it.remove(); // avoids a ConcurrentModificationException
    //   }
  }
