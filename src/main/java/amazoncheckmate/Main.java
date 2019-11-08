package amazoncheckmate;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//'a' - ''
		//System.out.printf("%d",'a'-'b');
		
		//boolean tc = Main.isInAmazonKillzone(SquareCords.a1, SquareCords.h8);
		//System.out.println(tc);
		
		//char c = 'b'-1;
		//System.out.println(c);

		//List<AmazonCheckmate.SquareCords> moves;
		//moves = AmazonCheckmate.getPossibleKingMoves(AmazonCheckmate.SquareCords.e4);
		
		//System.out.println(moves);
		String s = Arrays.toString(AmazonCheckmate.amazonCheckmate("a1", "g5"));
		
		System.out.println(s);
		
		//System.out.println("Please run unit tests!");
		
	}
	

	
	
	
	
	
	

}
