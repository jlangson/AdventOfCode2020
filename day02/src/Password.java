// 1-3 a: abcde //should have 1 to 3 'a' VALID
// 1-3 b: cdefg //should ahve 1 to 3 'b' INVALID
// 2-9 c: ccccccccc //should have 2 to 9 'c' VALID
public class Password {
    private final String password;
    private final char letter;
    private final int min;
    private final int max;
    private final boolean valid;

    public Password(String password, char letter, int min, int max) {
        this.password = password;
        this.letter = letter;
        this.min = min;
        this.max = max;
        this.valid = isValid();
    }

    private boolean isValid(){
        int occurence=0;
        for(int i=0; i < password.length(); i++){
            if(password.charAt(i)==letter){
                occurence++;
            }
        }
        return occurence >= this.min && occurence <= this.max;
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

    public boolean getValid(){
        return valid;
    }
}
