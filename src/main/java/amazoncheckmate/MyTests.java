package amazoncheckmate;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
//import org.junit.runners.JUnit4;


public class MyTests {
	@Test
    public void testBasic() {
		
        assertArrayEquals( new int[] { 0, 29, 1, 29 }, AmazonCheckmate.amazonCheckmate("a1", "g5") );
        assertArrayEquals( new int[] { 1, 32, 1, 23 }, AmazonCheckmate.amazonCheckmate("a3", "e4") );
        assertArrayEquals( new int[] { 6, 11, 0, 38 }, AmazonCheckmate.amazonCheckmate("f3", "f2") );
        assertArrayEquals( new int[] { 0, 10, 0, 45 }, AmazonCheckmate.amazonCheckmate("b7", "a8") );
        assertArrayEquals( new int[] { 4, 28, 1, 21 }, AmazonCheckmate.amazonCheckmate("f7", "d3") );
        assertArrayEquals( new int[] { 9, 21, 0, 24 }, AmazonCheckmate.amazonCheckmate("g2", "c3") );
        assertArrayEquals( new int[] { 4, 18, 0, 32 }, AmazonCheckmate.amazonCheckmate("f3", "c1") );
        assertArrayEquals( new int[] { 0, 18, 0, 36 }, AmazonCheckmate.amazonCheckmate("d4", "h8") );
    }
	
	@Test
	public void test_getBlackKingState() {
		// TODO : Write this! STOPPED HERE
	}
	
	@Test
	public void test_canBecomeSafe() {
		// TODO : Write more tests
		
		AmazonCheckmate.SquareCord blackKingLoc, whiteKingLoc, whiteAmazonLoc;
		
		/*
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
		3  | ** | ** | ** | ** | ** |    | !! | !! |
		   -----------------------------------------
		2  | ** | ** | ** | ** | ** |    | !! | WK |
		   -----------------------------------------
		1  |    |    | ** |    |    | ** | !! | !! |
		   -----------------------------------------
		      a    b    c    d    e    f    g    h
		*/
		whiteKingLoc = AmazonCheckmate.SquareCord.h2;
		whiteAmazonLoc = AmazonCheckmate.SquareCord.c4;
		
		blackKingLoc = AmazonCheckmate.SquareCord.h4;
		assertTrue(AmazonCheckmate.canBecomeSafe(blackKingLoc, whiteKingLoc, whiteAmazonLoc));
		
		blackKingLoc = AmazonCheckmate.SquareCord.a4;
		assertFalse(AmazonCheckmate.canBecomeSafe(blackKingLoc, whiteKingLoc, whiteAmazonLoc));
	}
	
	@Test
	public void test_isBlackKingSafe() {
		// Now build out some scenarios
		AmazonCheckmate.SquareCord blackKingLoc, whiteKingLoc, whiteAmazonLoc;
		
		/*
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
		3  | ** | ** | ** | ** | ** | !! |    |    |
		   -----------------------------------------
		2  | ** | ** | ** | ** | WK | !! |    |    |
		   -----------------------------------------
		1  |    |    | ** | !! | !! | ** |    |    |
		   -----------------------------------------
		      a    b    c    d    e    f    g    h
		*/
		whiteKingLoc = AmazonCheckmate.SquareCord.e2;
		whiteAmazonLoc = AmazonCheckmate.SquareCord.c4;
		
		blackKingLoc = AmazonCheckmate.SquareCord.h8;
		assertTrue(AmazonCheckmate.isBlackKingSafe(blackKingLoc, whiteKingLoc, whiteAmazonLoc));
		
		blackKingLoc = AmazonCheckmate.SquareCord.d6;
		assertFalse(AmazonCheckmate.isBlackKingSafe(blackKingLoc, whiteKingLoc, whiteAmazonLoc));
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		/*
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
		3  | ** | ** | ** | ** | ** |    | !! | !! |
		   -----------------------------------------
		2  | ** | ** | ** | ** | ** |    | !! | WK |
		   -----------------------------------------
		1  |    |    | ** |    |    | ** | !! | !! |
		   -----------------------------------------
		      a    b    c    d    e    f    g    h
		*/
		
		whiteKingLoc = AmazonCheckmate.SquareCord.h2;
		whiteAmazonLoc = AmazonCheckmate.SquareCord.c4;
		
		blackKingLoc = AmazonCheckmate.SquareCord.h2;	// Situation where where BK takes WK and ends up safe
		assertTrue(AmazonCheckmate.isBlackKingSafe(blackKingLoc, whiteKingLoc, whiteAmazonLoc));
		
		
		///////////////////////////////////////////////////////////////////////////////////////////
	}
	
	@Test 
	public void test_isInKingKillzone() {
		AmazonCheckmate.SquareCord victim, king;
		boolean actual;
		
		victim = AmazonCheckmate.SquareCord.a1;
		king = AmazonCheckmate.SquareCord.a2;
		actual = AmazonCheckmate.isInKingKillzone(victim, king);
		assertTrue(actual);
		
		victim = AmazonCheckmate.SquareCord.a1;
		king = AmazonCheckmate.SquareCord.b1;
		actual = AmazonCheckmate.isInKingKillzone(victim, king);
		assertTrue(actual);
		
		victim = AmazonCheckmate.SquareCord.a1;
		king = AmazonCheckmate.SquareCord.b3;
		actual = AmazonCheckmate.isInKingKillzone(victim, king);
		assertFalse(actual);
	}
	
	
	@Test
	public void test_isInAmazonKillzone() {
		AmazonCheckmate.SquareCord victim, amazon;
		boolean actual, expected;
		
		// same col
		victim = AmazonCheckmate.SquareCord.a1;
		amazon = AmazonCheckmate.SquareCord.a8;
		actual = AmazonCheckmate.isInAmazonKillzone(victim, amazon);
		assertTrue(actual);
		
		// knight move
		victim = AmazonCheckmate.SquareCord.a1;
		amazon = AmazonCheckmate.SquareCord.b3;
		actual = AmazonCheckmate.isInAmazonKillzone(victim, amazon);
		org.junit.Assert.assertTrue(actual);
		
		// knight move
		victim = AmazonCheckmate.SquareCord.a1;
		amazon = AmazonCheckmate.SquareCord.c2;
		actual = AmazonCheckmate.isInAmazonKillzone(victim, amazon);
		org.junit.Assert.assertTrue(actual);
		
		victim = AmazonCheckmate.SquareCord.a1;
		amazon = AmazonCheckmate.SquareCord.d2;
		actual = AmazonCheckmate.isInAmazonKillzone(victim, amazon);
		org.junit.Assert.assertFalse(actual);
		
		victim = AmazonCheckmate.SquareCord.a1;
		amazon = AmazonCheckmate.SquareCord.g6;
		actual = AmazonCheckmate.isInAmazonKillzone(victim, amazon);
		org.junit.Assert.assertFalse(actual);
	}

}


