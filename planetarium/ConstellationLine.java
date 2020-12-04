package planetarium;

public class ConstellationLine {

   private String constellation;
   private int startStarId;
   private int endStarId;

   public ConstellationLine(String constellation, int startStarId, int endStarId) {

        this.constellation = constellation;
        this.startStarId = startStarId;
        this.endStarId = endStarId;

   }
   
   public int getStartStarId() {
	   return this.startStarId;
   }
   
   public int getEndStarId() {
	   return this.endStarId;
   }

}