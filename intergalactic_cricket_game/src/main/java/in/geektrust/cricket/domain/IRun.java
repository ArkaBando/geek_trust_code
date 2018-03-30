package in.geektrust.cricket.domain;


public interface IRun {
	
	public enum ScoredRun {
		DOT(0),ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),OUT(-1);
		
		private final int scoreValue;
		
		private ScoredRun(int value){
			scoreValue = value;
		}
		
		public int getScoreValue(){
			return scoreValue;
		}
		
		public static ScoredRun getScore(int value){
			ScoredRun score = ScoredRun.DOT;
			
			switch(value){
			case 1 : score = ScoredRun.ONE;
					 break;
			case 2 : score = ScoredRun.TWO;
			 		 break;
			case 3 : score = ScoredRun.THREE;
			         break;
			case 4 : score = ScoredRun.FOUR;
			         break;
			case 5 : score = ScoredRun.FIVE;
			         break;
			case 6 : score = ScoredRun.SIX;
	         		 break;      
	        default: score = ScoredRun.OUT;
	        		 break;
			}	
			return score;
		}
		
		};
	
	public ScoredRun playDelivery(Match context);
}
