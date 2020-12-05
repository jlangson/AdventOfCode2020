public class BoardingPass {
    public final String rowStr;
    public final String colStr;
    public final int id;
    public final int row;
    public final int col;
    
    public BoardingPass(String string){
        this.rowStr = string.substring(0, 7);
        this.colStr = string.substring(7, string.length());
       //function to calulate row
       this.row = calcGeneral(this.rowStr, 'F');
       
       //func to calc col
       this.col = calcGeneral(this.colStr, 'L');

        this.id = this.row * 8 + this.col;
    }

    //takes string and character to match with
    //FL should be F or L never B or R
    private int calcGeneral(String str, char FL){
       //min and max are adjusted to represent the current range the seat could be in
       int min = 0;
       int max =(int) Math.pow(2, str.length())-1;

        //    System.out.printf("Min is %d. Max is %d. %n", min, max);
       for(int i=0; i < str.length(); i++){
            int adjust = (int) Math.pow(2,str.length()-1-i);
            if(str.charAt(i)==FL){
                max-=adjust;
            //    System.out.printf("Min is %d. Max is %d. adjust is -%d. i is %d.%n", min, max, adjust, i);
            } else{ 
                min+=adjust;
            //    System.out.printf("Min is %d. Max is %d. adjust is +%d. i is %d.%n", min, max, adjust, i);
            }
       }
    //    System.out.println("\n\n====\n");
       
            //min and max should be the same
           return min;
       }


    

	@Override
	public String toString() {
		return "BoardingPass [col=" + col + ", colStr=" + colStr + ", id=" + id + ", row=" + row + ", rowStr=" + rowStr
				+ "]";
	}

}
