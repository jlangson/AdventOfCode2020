import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Day02 {
// 1-3 a: abcde //should have 1 to 3 'a' VALID
// 1-3 b: cdefg //should ahve 1 to 3 'b' INVALID
// 2-9 c: ccccccccc //should have 2 to 9 'c' VALID
//determine how many valid passwords
    public static void main(String[] args) throws Exception {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Password> passwords = new ArrayList<Password>(1000);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Password password = parsePassword(line);
            passwords.add(password);
        }
        scanner.close();
        int numValidRuleOnePassswords=0;
        int numValidRuleTwoPasswords=0;
        for(Password password : passwords){
            if(password.getValidRuleOne()){
                numValidRuleOnePassswords++;
            }
            //NOT if else because a passsword can be valid by both rules
            if(password.getValidRuleTwo()){
                numValidRuleTwoPasswords++;
            }
        }

       
        System.out.println(numValidRuleOnePassswords);
        System.out.println(numValidRuleTwoPasswords);
    }

    public static Password parsePassword(String line){
        //1-3 a: abcde
        //1-3 b: cdefg
        //2-9 c: ccccccccc
        //Password has password, letter, min, max
        String password;
        char letter;
        int min;
        int max;

        //indices 
        //-1 so compiler doesn't complain that the value was not set b/c it's set in the if statement
        int minBegin = 0;
        int minEnd = -1;
        int maxBegin = -1;
        int maxEnd = -1;
        int letterLoc = -1;
        int passwordBegin = -1;
        int passwordEnd = line.length()-1;

        //find indices
        for(int i=0; i < line.length(); i++){
            if(line.charAt(i)=='-'){
                minEnd = i-1;
                maxBegin = i+1;
            }
            else if(line.charAt(i)==':'){
                maxEnd = i-3;
                letterLoc = i-1;
                passwordBegin = i+2;
            }
        }

        //split string around indices
        //substring has inclusive begin and exclusive end
        password = line.substring(passwordBegin, passwordEnd+1);
        letter = line.charAt(letterLoc);
        min = Integer.parseInt(line.substring(minBegin, minEnd+1));
        max = Integer.parseInt(line.substring(maxBegin, maxEnd+1));


        return  new Password(password, letter, min, max);
    }

   
}