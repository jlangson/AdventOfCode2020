import java.util.*;

public class Passport {
    // byr (Birth Year) - four digits; at least 1920 and at most 2002.
    // iyr (Issue Year) - four digits; at least 2010 and at most 2020.
    // eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
    // hgt (Height) - a number followed by either cm or in:
    // hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
    // ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
    // pid (Passport ID) - a nine-digit number, including leading zeroes.
    // cid (Country ID) - ignored, missing or not.
    private int byr;
    private int iyr;
    private int eyr;
    private String hgt;
    private String hcl;
    private String ecl;
    private String pid;
    private String cid;
    private boolean isValid; // prolly should be final

    public Passport(int byr, int iyr, int eyr, String hgt, String hcl, String ecl, String pid, String cid) {
        this.byr = byr;
        this.iyr = iyr;
        this.eyr = eyr;
        this.hgt = hgt;
        this.hcl = hcl;
        this.ecl = ecl;
        this.pid = pid;
        this.cid = cid;
        this.isValid = determineValidity();
    }

    // byr (Birth Year) - four digits; at least 1920 and at most 2002.
    // iyr (Issue Year) - four digits; at least 2010 and at most 2020.
    // eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
    // hgt (Height) - a number followed by either cm or in:
    // If cm, the number must be at least 150 and at most 193.
    // If in, the number must be at least 59 and at most 76.
    // hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
    // ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
    // pid (Passport ID) - a nine-digit number, including leading zeroes.
    // cid (Country ID) - ignored, missing or not.
    private boolean determineValidity() {
        boolean valid=true; //so i only need 1 return statement. start it as true and if fails anything make it false b/c it is
        if(byr < 1920 || byr >2002){
            valid=false;
        }
        if(iyr <2010 || iyr >2020){
            valid = false;
        }
        if(eyr<2020 || eyr>2030){
            valid = false;
        }
        
        // hgt (Height) - a number followed by either cm or in:
    // If cm, the number must be at least 150 and at most 193.
    // If in, the number must be at least 59 and at most 76.
    
        //find cm or in  at the END of the number
        if(this.hgt.contains("cm")){
            //height is between : and c
            int lastDigitLoc = hgt.indexOf("c"); //7
            int height = Integer.parseInt( hgt.substring(4, lastDigitLoc)); //hgt:134cm
            
            if(height < 150 || height > 193){
                valid=false;
            }
        }
        else{
            //height is between : and i
            int lastDigitLoc = hgt.indexOf("i"); //7
            int height = Integer.parseInt( hgt.substring(4, lastDigitLoc)); //hgt:134cm
            if(height < 59 || height > 76 ){
                valid = false;
            }
        }
        // hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
        if(!this.hcl.matches("#([0-9]|[a-f]){6})")){ //black magic
            valid=false;
        }
    // ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
    // List<Integer> listOfInts = Arrays.asList(1, 2, 3);
    // ArrayList<String> cities = new ArrayList<>(Arrays.asList("
        // ArrayList<String> validEyeColors = new ArrayList<>(Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl","oth"));
        Map<String, String> validEyeColors = Map.of(
                                            "amb", "",
                                            "blu", "",
                                            "brn", "",
                                            "gry","",
                                            "grn","",
                                            "hzl","",
                                            "oth",""
                                        );
        if(validEyeColors.get(this.hgt)==null){
            valid=false;
        }
        
    // pid (Passport ID) - a nine-digit number, including leading zeroes.
    if(!this.pid.matches("[0-9]{9}")){
        valid=false;
    }

    


        return valid;
    }

    public Passport() {
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean getValid() {
        return this.isValid;
    }

    @Override
    public String toString() {
        return "Passport [byr=" + byr + ", cid=" + cid + ", ecl=" + ecl + ", hcl=" + hcl + ", hgt=" + hgt + ", isValid="
                + isValid + ", iyr=" + iyr + ", pid=" + pid + "]";
    }

}
