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
    private Integer byr;
    private Integer iyr;
    private Integer eyr;
    private String hgt;
    private String hcl;
    private String ecl;
    private String pid;
    private String cid;
    private boolean isValid; // prolly should be final

    //use by passing it a passport on one ine. fields can be in any order
    public Passport(String rawPassport){
        //i wrote thiss AFter the datermineValidity sso mhy conditional is WHACK
        //note to self, determine how to not repeat this pattern
        String[] passportFields = rawPassport.split(" "); 
        // ecl:blu byr:1934 hcl:#888785 iyr:2019 pid:905361316 eyr:2021 hgt:150cm
        //{ "ecl:blu", "byr:1934", "hcl:#888785", "iyr:2019", "pid:905361316", "eyr:2021", "hgt:150cm" }
        for(int i=0; i < passportFields.length; i++){
            String field = passportFields[i];
            String[] keyValue = field.split(":");
            //"ecl:blu" -> {"ecl", "blu"}
            switch(keyValue[0])
            {
                // byr (Birth Year) - four digits; at least 1920 and at most 2002.
                case "byr":
                    this.byr=Integer.parseInt(keyValue[1]);
                    break;
                // iyr (Issue Year) - four digits; at least 2010 and at most 2020.
                case "iyr":
                    this.iyr = Integer.parseInt(keyValue[1]);
                    break;
                // eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
                case "eyr":
                    this.eyr = Integer.parseInt(keyValue[1]);
                    break;
                // hgt (Height) - a number followed by either cm or in:
                case "hgt":
                    this.hgt=keyValue[1];
                    break;
                // hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
                case "hcl":
                    this.hcl = keyValue[1];
                    break;
                // ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
                case "ecl":
                    this.ecl = keyValue[1];
                    break;
                // pid (Passport ID) - a nine-digit number, including leading zeroes. 
                case "pid":
                    this.pid = keyValue[1];
                    break;
                    //no default b/c if itss not one of these I don't care im not saving it
            }

        }
        this.isValid = determineValidity();
    }

    // public Passport(int byr, int iyr, int eyr, String hgt, String hcl, String ecl, String pid, String cid) {
    //     this.byr = byr;
    //     this.iyr = iyr;
    //     this.eyr = eyr;
    //     this.hgt = hgt;
    //     this.hcl = hcl;
    //     this.ecl = ecl;
    //     this.pid = pid;
    //     this.cid = cid;
    //     this.isValid = determineValidity();
    // }

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
        //if any are not initalized it's invalid;
        if(this.byr == null || this.iyr==null || this.eyr==null || this.hgt ==null || this.hcl ==null || this.ecl==null || this.pid==null){
            return false; //have to short circuit or you get nulll pointer exceptions later on.
        }
        // for(Field f : this.getDeclaredFields()){


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
            int height = Integer.parseInt( hgt.substring(0, lastDigitLoc)); //hgt:134cm
            
            if(height < 150 || height > 193){
                valid=false;
            }
        }
        else if(this.hgt.contains("in")){
            //height is between : and i
            int lastDigitLoc = hgt.indexOf("i"); //7
            int height = Integer.parseInt( hgt.substring(0, lastDigitLoc)); //hgt:134cm
            if(height < 59 || height > 76 ){
                valid = false;
            }
        }
        else{ //means no units given
            valid=false;
        }
        // hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
        if(!this.hcl.matches("#([0-9]|[a-f]){6}")){ //black magic
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
        if(validEyeColors.get(this.ecl)==null){ //imm dying. this used to be this.hgt so everything was false;
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
        return "Passport [byr=" + byr + ", cid=" + cid + ", ecl=" + ecl + ", eyr=" + eyr + ", hcl=" + hcl + ", hgt="
                + hgt + ", isValid=" + isValid + ", iyr=" + iyr + ", pid=" + pid + "]";
    }



}
