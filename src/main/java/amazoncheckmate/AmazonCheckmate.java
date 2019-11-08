package amazoncheckmate;

//import static org.hamcrest.CoreMatchers.containsString;

import java.util.ArrayList;
import java.util.List;

public class AmazonCheckmate {
	
	
	/*  Example chess board layout squares are represented by a letter+number combination
	      -----------------------------------------
	   8  | -- | -- | -- | -- | -- | -- | -- | -- |
	      -----------------------------------------
	   7  | -- | -- | -- | -- | -- | -- | -- | -- |
	      -----------------------------------------
	   6  | -- | -- | -- | -- | -- | -- | -- | -- |
	      -----------------------------------------
	   5  | -- | -- | -- | -- | -- | -- | -- | -- |
	      -----------------------------------------
	   4  | -- | -- | -- | -- | -- | -- | -- | -- |
	      -----------------------------------------
	   3  | -- | -- | -- | -- | -- | -- | -- | -- |
	      -----------------------------------------
	   2  | -- | -- | -- | -- | -- | -- | -- | -- |
	      -----------------------------------------
	   1  | -- | -- | -- | -- | -- | -- | -- | -- |
	      -----------------------------------------
	         a    b    c    d    e    f    g    h
	*/
	
	/* An Amazon Chess piece is a piece that can act as a queen or a knight
	 * Here is an example of a chess board with a white amazon piece at c4 and all
	 * The places it can reach
	      -----------------------------------------
	   8  |    |    | ** |    |    |    | ** |    |
	      -----------------------------------------
	   7  |    |    | ** |    |    | ** |    |    |
   	      -----------------------------------------
	   6  | ** | ** | ** | ** | ** |    |    |    |
	      -----------------------------------------
	   5  | ** | ** | ** | ** | ** | ** |    |    |
	      -----------------------------------------
	   4  | ** | ** | WA | ** | ** | ** | ** | ** |
	      -----------------------------------------
	   3  | ** | ** | ** | ** | ** |    |    |    |
	      -----------------------------------------
	   2  | ** | ** | ** | ** | ** |    |    |    |
	      -----------------------------------------
	   1  |    |    | ** |    |    | ** |    |    |
   	      -----------------------------------------
	         a    b    c    d    e    f    g    h
	 */
	         
	public enum SquareCords
	{
		a8,b8,c8,d8,e8,f8,g8,h8,
		a7,b7,c7,d7,e7,f7,g7,h7,
		a6,b6,c6,d6,e6,f6,g6,h6,
		a5,b5,c5,d5,e5,f5,g5,h5,
		a4,b4,c4,d4,e4,f4,g4,h4,
		a3,b3,c3,d3,e3,f3,g3,h3,
		a2,b2,c2,d2,e2,f2,g2,h2,
		a1,b1,c1,d1,e1,f1,g1,h1
	}
	
	// Create an enumeration for states
	public static enum BlackKingStates 
	{
		CHECKMATE,
		CHECK,
		STALEMATE,
		SAFE
	}
	
		// SAFE - Black king is in a position where it can't be captured
		//  and there is at least one move that can be made that he would 
		//  remain safe.
		
		// STALEMATE - same as SAFE, except there is no move he can make 
		//  without being captured.
		
		// CHECKMATE - Black King can be attacked and any possible move
		//  would also put him in a captured position.
		
		// CHECK - Black King can be captured in the current state, but
		//  there is at least one move he can make to become safe.
		
	
	
	/**
	 * Codewars objective
	 * @param king
	 * @param amazon
	 * @return
	 */
	public static int[] amazonCheckmate(String king, String amazon) {

		// coding and coding..
		return null;
	}
	
	static BlackKingStates getBlackKingState(SquareCords blackKingLoc, SquareCords whiteKingLoc, SquareCords whiteAmazonLoc) {
		BlackKingStates ret = null;
		
		
		
		// Test SAFE
		boolean blackKingSafe = ((isInAmazonKillzone(blackKingLoc, whiteAmazonLoc) == false) && (isInKingKillzone(blackKingLoc, whiteKingLoc)== false));
		

		return ret;
	}
	

	/**
	 * Determine if the Black King can make a move that will make him safe.
	 * @param blackKingLoc
	 * @param whiteKingLoc
	 * @param whiteAmazonLoc
	 * @return
	 */
	static boolean canBecomeSafe(SquareCords blackKingLoc, SquareCords whiteKingLoc, SquareCords whiteAmazonLoc) {
		boolean ret = false;
		
		String l = blackKingLoc.toString().substring(0,1);
		String n = blackKingLoc.toString().substring(1,2);
		boolean canMoveUp    = "7654321".contains(l);
		boolean canMoveDown  = "8765432".contains(l);
		boolean canMoveLeft  = "bcdefgh".contains(n);
		boolean canMoveRight = "abcdefg".contains(n);
		
		if (canMoveLeft) {
			String s0 = Character.toString(blackKingLoc.toString().charAt(0) - 1);
			String s1 = n;
			SquareCords.valueOf(s0 + s1);
		}
		
		//Integer.parseInt(s)
		
		//"bcdefgh".containsString(substring)
		//if ((blackKingLoc.toString().charAt(0) >= 'b') && (blackKingLoc.toString().charAt(1)) {
		
		
		// iterate over the possible moves
		// determine if King is safe after making that move
		
		return ret;
	}
	
	
	/**
	 * Based off the current location of a king piece, determine all the possible moves it can make
	 * @param kingLoc current location of the king
	 * @return a list of board coordinates that are reachable
	 */
	static List<SquareCords> getPossibleKingMoves(SquareCords kingLoc) {
		List<SquareCords> moves = new ArrayList<SquareCords>();
		
		String l = kingLoc.toString().substring(0,1);
		String n = kingLoc.toString().substring(1,2);
		boolean canMoveUp    		= "7654321".contains(l);
		boolean canMoveDown  		= "8765432".contains(l);
		boolean canMoveLeft  		= "bcdefgh".contains(n);
		boolean canMoveRight 		= "abcdefg".contains(n);
		boolean canMoveUpLeft 		= (canMoveUp && canMoveLeft);
		boolean canMoveUpRight 		= (canMoveUp && canMoveRight);
		boolean canMoveDownLeft 	= (canMoveDown && canMoveLeft);
		boolean canMoveDownRight 	= (canMoveDown && canMoveRight);
		
		if (canMoveLeft) {
			String s = Character.toString(kingLoc.toString().charAt(0)-1) + Character.toString(kingLoc.toString().charAt(1));
			moves.add(SquareCords.valueOf(s));
		}
		if (canMoveUpLeft) {
			String s = Character.toString(kingLoc.toString().charAt(0)-1) + Character.toString(kingLoc.toString().charAt(1)+1);
			moves.add(SquareCords.valueOf(s));
		}
		if (canMoveUp) {
			String s = Character.toString(kingLoc.toString().charAt(0)) + Character.toString(kingLoc.toString().charAt(1)+1);
			moves.add(SquareCords.valueOf(s));
		}
		if (canMoveUpRight) {
			String s = Character.toString(kingLoc.toString().charAt(0)+1) + Character.toString(kingLoc.toString().charAt(1)+1);
			moves.add(SquareCords.valueOf(s));
		}
		if (canMoveRight) {
			String s = Character.toString(kingLoc.toString().charAt(0)+1) + Character.toString(kingLoc.toString().charAt(1));
			moves.add(SquareCords.valueOf(s));
		}
		if (canMoveDownRight) {
			String s = Character.toString(kingLoc.toString().charAt(0)+1) + Character.toString(kingLoc.toString().charAt(1)-1);
			moves.add(SquareCords.valueOf(s));
		}
		if (canMoveDown) {
			String s = Character.toString(kingLoc.toString().charAt(0)) + Character.toString(kingLoc.toString().charAt(1)-1);
			moves.add(SquareCords.valueOf(s));
		}
		if (canMoveDownLeft) {
			String s = Character.toString(kingLoc.toString().charAt(0)-1) + Character.toString(kingLoc.toString().charAt(1)-1);
			moves.add(SquareCords.valueOf(s));
		}		
		
		return moves;
	}
	
	
	
	
	/**
	 * Determine if a particular location is vulnerable to an Amazon Piece
	 * @param victimLoc	Location of the Victim Piece
	 * @param amazonLoc Location of the Amazon Piece
	 * @return
	 */
	static boolean isInAmazonKillzone(SquareCords victimLoc, SquareCords amazonLoc) {
		
		// Check same Row / Column
		if (victimLoc.toString().charAt(0) == amazonLoc.toString().charAt(0)) return true;	// same row
		if (victimLoc.toString().charAt(1) == amazonLoc.toString().charAt(1)) return true;	// same column
		
		// Check Diagonals
		int a = Math.abs(victimLoc.toString().charAt(0)-amazonLoc.toString().charAt(0));	// horz distance
		int b = Math.abs(victimLoc.toString().charAt(1)-amazonLoc.toString().charAt(1));	// vert distance
		if (a == b) return true; 
		
		// Check Knight move
		if (((a==1) && (b==2)) || ((a==2) && (b==1))) return true;

		
		return false;
	}
	
	static boolean isInKingKillzone(SquareCords victimLoc, SquareCords kingLoc) {
		int a = Math.abs(victimLoc.toString().charAt(0)-kingLoc.toString().charAt(0));	// horz distance
		int b = Math.abs(victimLoc.toString().charAt(1)-kingLoc.toString().charAt(1));	// vert distance
		return ((a<=1) && (b<=1));
	}

}
