// 1-3 a: abcde //should have 1 to 3 'a' VALID
// 1-3 b: cdefg //should ahve 1 to 3 'b' INVALID
// 2-9 c: ccccccccc //should have 2 to 9 'c' VALID
public class Password {
    private final String password;
    private final char letter;
    private final int min; //refactor these field names for rule2?
    private final int max;
    //problem one and two define validity differently. 
    private final boolean validRuleOne;
    private final boolean validRuleTwo;

    public Password(String password, char letter, int min, int max) {
        this.password = password;
        this.letter = letter;
        this.min = min;
        this.max = max;
        this.validRuleOne = isValidRuleOne();
        this.validRuleTwo = isValidRuleTwo();
    }

    private boolean isValidRuleOne(){
        int occurence=0;
        for(int i=0; i < password.length(); i++){
            if(password.charAt(i)==letter){
                occurence++;
            }
        }
        return occurence >= this.min && occurence <= this.max;
    }

// Each policy actually describes two positions in the password, 
//where 1 means the first character, 2 means the second character,
// and so on. (Be careful; Toboggan Corporate Policies have no concept of "index zero"!) 
//Exactly one of these positions must contain the given letter. Other occurrences of the letter are irrelevant for the purposes of policy enforcement.

// Given the same example list from above:

// 1-3 a: abcde is valid: position 1 contains a and position 3 does not.
// 1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b.
// 2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c.
    private boolean isValidRuleTwo(){
        //if the charAt first matches XOR charAt end matches true else false
        //must offset the indices because min and max were written for ruleOne
        //in ruleOne min and max are quantities
        //in ruleTwo min and max are indices
        return this.password.charAt(min-1)==letter ^ this.password.charAt(max-1)==letter;
    }

    public String getPassword() {
        return password;
    }

    public char getLetter() {
        return letter;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public boolean getValidRuleOne(){
        return validRuleOne;
    }
    public boolean getValidRuleTwo(){
        return validRuleTwo;
    }
}
