public class Sleigh {
    //sleigh has a fixed speed but can moves in different places
    //rowLoc can increase or decrease. rowLoc decreases when you reach the end of the map to simulate the map being infinite.
    //colLoc can only increase
    private final int xSpeed;
    private final int ySpeed;
    private int rowLoc;
    private int colLoc;
    private int treesHit;
    Sleigh(int x, int y){
        this.xSpeed = x;
        this.ySpeed = y;
        this.treesHit=0;
        this.rowLoc=0;
        this.colLoc=0;
    }

    public int getTreesHit() {
        return treesHit;
    }

    public void collision() {
        this.treesHit++;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public int getRowLoc() {
        return rowLoc;
    }

    public void setRowLoc(int rowLoc) {
        this.rowLoc = rowLoc;
    }

    public int getColLoc() {
        return colLoc;
    }

    //colLoc can only increase b/c sleigh goes downhill
    public void nextCol() {
        this.colLoc += this.ySpeed;
    }

    //for incrementing the rowLocation in the for loop
    public void nextRow(){
        this.rowLoc += this.xSpeed;
    }

    @Override
    public String toString() {
        return "Sleigh [treesHit=" + treesHit + ", xSpeed=" + xSpeed + ", ySpeed=" + ySpeed + "]";
    }
    

    

}
