public class Passport {
    // byr (Birth Year)
    // iyr (Issue Year)
    // eyr (Expiration Year)
    // hgt (Height)
    // hcl (Hair Color)
    // ecl (Eye Color)
    // pid (Passport ID)
    // cid (Country ID)
    //if every field but cid is present it is valid
    private String byr;
    private String iyr;
    private String hgt;
    private String hcl;
    private String ecl;
    private String pid;
    private String cid;
    private boolean isValid; //prolly should be final

    

    public String getByr() {
        return byr;
    }

    public void setByr(String byr) {
        this.byr = byr;
    }

    public String getIyr() {
        return iyr;
    }

    public void setIyr(String iyr) {
        this.iyr = iyr;
    }

    public String getHgt() {
        return hgt;
    }

    public void setHgt(String hgt) {
        this.hgt = hgt;
    }

    public String getHcl() {
        return hcl;
    }

    public void setHcl(String hcl) {
        this.hcl = hcl;
    }

    public String getEcl() {
        return ecl;
    }

    public void setEcl(String ecl) {
        this.ecl = ecl;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Passport(String byr, String iyr, String hgt, String hcl, String ecl, String pid, String cid) {
        this.byr = byr;
        this.iyr = iyr;
        this.hgt = hgt;
        this.hcl = hcl;
        this.ecl = ecl;
        this.pid = pid;
        this.cid = cid;
        this.isValid = determineValidity();
    }

    private boolean determineValidity(){
        return this.byr!=null && this.ecl!=null  && this.hcl!=null && this.hgt!=null && this.iyr!=null && this.pid!=null;
    }

    

    public Passport() {
    }


    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean getValid(){
        return this.isValid;
    }

    @Override
    public String toString() {
        return "Passport [byr=" + byr + ", cid=" + cid + ", ecl=" + ecl + ", hcl=" + hcl + ", hgt=" + hgt + ", isValid="
                + isValid + ", iyr=" + iyr + ", pid=" + pid + "]";
    }

}
