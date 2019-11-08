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
	
	/* The codewars challenge basically boils down to this :
	 *  Given a White Amazon Piece and  a White King Piece on the Chess Board, determine
	 *  how many places for a Black King Piece would yield a CHECKMAKE, CHECK, STALEMATE, or SAFE
	 *  situation for the Black player.  Considering that's it's Black's turn.
	 */
	         
	public enum SquareCord
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
	
	
	public static enum BlackKingState 
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
	 * @return an array with 4 elements.  
	 * 			[0] - # of check-mate positions 
	 * 			[1] - # of check positions
	 * 			[3] - # of stale-mate positions
	 * 			[4] - # of safe positions with a safe next move
	 */
	public static int[] amazonCheckmate(String king, String amazon) {
		// TODO : Write this !
		int[] ret = {0,0,0,0};
		// DEBUGGING BELOW
		List<SquareCord> CheckMateLocations = new ArrayList<SquareCord>();
		List<SquareCord> CheckLocations = new ArrayList<SquareCord>();
		List<SquareCord> StaleMateLocations = new ArrayList<SquareCord>();
		List<SquareCord> SafeLocations = new ArrayList<SquareCord>();
		
		// DEBUGGING ABOVE
		
		
		// build a list of positions that are unoccupied
		for (SquareCord sc : AmazonCheckmate.SquareCord.values()) {
			if (sc==SquareCord.valueOf(king) || sc == SquareCord.valueOf(amazon)) continue;
			
			BlackKingState bks = getBlackKingState(sc, SquareCord.valueOf(king), SquareCord.valueOf(amazon));
			
			if (bks == BlackKingState.CHECKMATE) {
				ret[0]++;
				CheckMateLocations.add(sc);
			}
			
			if (bks == BlackKingState.CHECK) {
				ret[1]++;
				CheckLocations.add(sc);
			}
			
			if (bks == BlackKingState.STALEMATE) {
				ret[2]++;
				StaleMateLocations.add(sc);
			}
			
			if (bks == BlackKingState.SAFE) {
				ret[3]++;
				SafeLocations.add(sc);
			}
		}
		
		// TODO : print out the results here so we can troubleshoot STALEMATE not adding up to what we are expecting
		System.out.printf("Checkmate Locations (%2d) : ", CheckMateLocations.size());
		System.out.println(CheckMateLocations);
		System.out.printf("Check Locations     (%2d) : ", CheckLocations.size());
		System.out.println(CheckLocations);
		System.out.printf("Stalemate Locations (%2d) : ", StaleMateLocations.size());
		System.out.println(StaleMateLocations);
		System.out.printf("Safe Locations      (%2d) : ", SafeLocations.size());
		System.out.println(SafeLocations);
		

		return ret;
	}
	
	
	
	// TODO : WRITE THIS!  Stopped here!
	static BlackKingState getBlackKingState(SquareCord blackKingLoc, SquareCord whiteKingLoc, SquareCord whiteAmazonLoc) {

		boolean blackIsSafe = isBlackKingSafe(blackKingLoc, whiteKingLoc, whiteAmazonLoc);
		boolean blackCanBecomeSafe = canBecomeSafe(blackKingLoc, whiteKingLoc, whiteAmazonLoc);
		
		if (blackIsSafe && blackCanBecomeSafe) return BlackKingState.SAFE;
		if (blackIsSafe && !blackCanBecomeSafe) return BlackKingState.STALEMATE;
		if (!blackIsSafe && blackCanBecomeSafe) return BlackKingState.CHECK;
		if (!blackIsSafe && !blackCanBecomeSafe) return BlackKingState.CHECKMATE;
		
		return null;	// this should never happen
	}
	

	/**
	 * Determine if the Black King can make a move that will make him safe.
	 * @param blackKingLoc
	 * @param whiteKingLoc
	 * @param whiteAmazonLoc
	 * @return
	 */
	static boolean canBecomeSafe(SquareCord blackKingLoc, SquareCord whiteKingLoc, SquareCord whiteAmazonLoc) {
		
		// TODO : Write more unit Tests for this
		List<SquareCord> moves = getPossibleKingMoves(blackKingLoc);
		for (SquareCord m : moves) {
			if (isBlackKingSafe(m, whiteKingLoc, whiteAmazonLoc)) return true;
		}
		
		return false;
	}
	
	/**
	 * Determine if the black king is safe.  Black king coordinates can match white king or white amazon
	 *  coordinates.  In this situation, this would be an example of the black king capturing one of the 
	 *  opponent pieces 
	 *  
	 * @param blackKingLoc
	 * @param whiteKingLoc
	 * @param whiteAmazonLoc
	 * @return
	 */
	static boolean isBlackKingSafe(SquareCord blackKingLoc, SquareCord whiteKingLoc, SquareCord whiteAmazonLoc) {
		// TODO : Build Unit Test, and test well!
		if (blackKingLoc == whiteKingLoc) {
			// only check if White Amazon can capture the Black King
			return !isInAmazonKillzone(blackKingLoc, whiteAmazonLoc);
		} else if (blackKingLoc == whiteAmazonLoc) {
			return !isInKingKillzone(blackKingLoc, whiteKingLoc);
		} else {
			if ((isInKingKillzone(blackKingLoc, whiteKingLoc)) || (isInAmazonKillzone(blackKingLoc, whiteAmazonLoc))) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Based off the current location of a king piece, determine all the possible moves it can make
	 * @param kingLoc current location of the king
	 * @return a list of board coordinates that are reachable
	 */
	static List<SquareCord> getPossibleKingMoves(SquareCord kingLoc) {
		List<SquareCord> moves = new ArrayList<SquareCord>();
		
		String l = kingLoc.toString().substring(0,1);
		String n = kingLoc.toString().substring(1,2);
		boolean canMoveUp    		= "7654321".contains(n);
		boolean canMoveDown  		= "8765432".contains(n);
		boolean canMoveLeft  		= "bcdefgh".contains(l);
		boolean canMoveRight 		= "abcdefg".contains(l);
		boolean canMoveUpLeft 		= (canMoveUp && canMoveLeft);
		boolean canMoveUpRight 		= (canMoveUp && canMoveRight);
		boolean canMoveDownLeft 	= (canMoveDown && canMoveLeft);
		boolean canMoveDownRight 	= (canMoveDown && canMoveRight);
		
		if (canMoveLeft) {
			String s = Character.toString(kingLoc.toString().charAt(0)-1) + Character.toString(kingLoc.toString().charAt(1));
			moves.add(SquareCord.valueOf(s));
		}
		if (canMoveUpLeft) {
			String s = Character.toString(kingLoc.toString().charAt(0)-1) + Character.toString(kingLoc.toString().charAt(1)+1);
			moves.add(SquareCord.valueOf(s));
		}
		if (canMoveUp) {
			String s = Character.toString(kingLoc.toString().charAt(0)) + Character.toString(kingLoc.toString().charAt(1)+1);
			moves.add(SquareCord.valueOf(s));
		}
		if (canMoveUpRight) {
			String s = Character.toString(kingLoc.toString().charAt(0)+1) + Character.toString(kingLoc.toString().charAt(1)+1);
			moves.add(SquareCord.valueOf(s));
		}
		if (canMoveRight) {
			String s = Character.toString(kingLoc.toString().charAt(0)+1) + Character.toString(kingLoc.toString().charAt(1));
			moves.add(SquareCord.valueOf(s));
		}
		if (canMoveDownRight) {
			String s = Character.toString(kingLoc.toString().charAt(0)+1) + Character.toString(kingLoc.toString().charAt(1)-1);
			moves.add(SquareCord.valueOf(s));
		}
		if (canMoveDown) {
			String s = Character.toString(kingLoc.toString().charAt(0)) + Character.toString(kingLoc.toString().charAt(1)-1);
			moves.add(SquareCord.valueOf(s));
		}
		if (canMoveDownLeft) {
			String s = Character.toString(kingLoc.toString().charAt(0)-1) + Character.toString(kingLoc.toString().charAt(1)-1);
			moves.add(SquareCord.valueOf(s));
		}		
		
		return moves;
	}
	
	
	
	
	/**
	 * Determine if a particular location is vulnerable to an Amazon Piece
	 * @param victimLoc	Location of the Victim Piece
	 * @param amazonLoc Location of the Amazon Piece
	 * @return
	 */
	static boolean isInAmazonKillzone(SquareCord victimLoc, SquareCord amazonLoc) {
		
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
	
	static boolean isInKingKillzone(SquareCord victimLoc, SquareCord kingLoc) {
		int a = Math.abs(victimLoc.toString().charAt(0)-kingLoc.toString().charAt(0));	// horz distance
		int b = Math.abs(victimLoc.toString().charAt(1)-kingLoc.toString().charAt(1));	// vert distance
		return ((a<=1) && (b<=1));
	}

}
