import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
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
    System.out.println(first * second * third);
    scanner.close();
  }
}