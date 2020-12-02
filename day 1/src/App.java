import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

// solutions
// 980499
// 200637446
public class App {
  public static int findTwo(ArrayList<Integer> numbers){
    int a = 0;
    int b = 0;
    //make the key the sum then lookup the numbers
    //O(n^2) to make the keys and O(1) to lookup = O(n^2)

    //keys are all the combinations and values are the sum? then do containsValue

    //make two hashmaps? 

    //rule do ONE iteration
    
    //what if I make a hashmap of a hashmap?
    //first hashmap has the numbers and the second hashmap has the SUM as the key with the match as the second number
    //O(n) to iterate through the hashmap and then O(1) to lookup?
    //sum might not be unique
    // HashMap<Integer,HashMap<sum,matchinginteger>>
    // HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

    //what if I assume sum will be unique and if it's not who cares? we just need ONE match
    //HashMap<sum, {num1, num2}>
    //how do I calculate all possible sums?
    // for(int i=0; i<numbers.size(); i++){
    //   for(int j=i+1; j<numbers.size(); j++){
    //     int a=numbers.get(i); 
    //     int b=numbers.get(j);
    //     // map.add(a+b, {a,b});

    //   }
    // }

    //step 1: make a HashMap of value and location for every element of the array O(n)
    //HashMap<number.get(i), i>
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i=0; i < numbers.size(); i++){
      map.put(numbers.get(i), i);
    }

    //something fancy to solve this. another loop. O(n)
    for(int i=0; i < numbers.size(); i++){
      int diff = 2020 - numbers.get(i); //1209 and 811 are it
      if(map.containsKey(diff)){ //O(1)
        a=numbers.get(i);
        b=diff;
        // System.out.println("a "+ a + "\tb " + b + "\tdiff" + diff);
        break;
      }     
    }


    //HashMap<sum, HashMap<num1, num2>>


    //or make each number a key and lookup an arraylist of the sums? 
    //O(n) to go through the keys and O(n) to traverse arraylist = O(n^2)

    //make a hashmap that does what?
    // HashMap<,> map = new HashMap<>();
  
    // map.add(numbers.get(0),sumsto2020);
    
    // Collections.sort(numbers);


    //brute-force implementation
    // for (int i = 0; i < numbers.size(); i++) {
    //   for (int j = i + 1; j < numbers.size(); j++) {
    //       if (numbers.get(i) + numbers.get(j) == 2020) {
    //           first = (int) numbers.get(i);
    //           second = (int) numbers.get(j);
    //           break;
          
    //     }
    //   }
    // }

    return a * b;
  }

  public static void main(String[] args) throws Exception {
    File input = new File("puzzle-input.txt");
    Scanner scanner = new Scanner(input);
    int first = 0;
    int second = 0;
    int third = 0;
    ArrayList<Integer> numbers = new ArrayList<Integer>(200);
    while (scanner.hasNextLine()) {
        numbers.add(Integer.parseInt(scanner.nextLine()));
    }

    for (int i = 0; i < numbers.size(); i++) {
      for (int j = i + 1; j < numbers.size(); j++) {
          for(int k = j+1; k < numbers.size(); k++){
            if (numbers.get(i) + numbers.get(j) + numbers.get(k)== 2020) {
                first = (int) numbers.get(i);
                second = (int) numbers.get(j);
                third = (int) numbers.get(k);
                break;
            }
          }
      }
    }
    int twoTimes = findTwo(numbers);
    System.out.println(twoTimes);
    System.out.println(first * second * third);
    scanner.close();
  }
}