public class BoadingPass {
    public static final String row;
    public static final String col;
    
    public BoardingPass(String string){
        this.row = string.substring(0, 8);
        this.col = string.substring(8, string.length());
    }


}
