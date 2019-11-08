package amazoncheckmate;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertArrayEquals;
import org.junit.runners.JUnit4;
import junit.framework.Assert;


public class MyTests {
	/*@Test
    public void testBasic() {
        assertArrayEquals( new int[] { 0, 29, 1, 29 }, AmazonCheckmate.amazonCheckmate("a1", "g5") );
        assertArrayEquals( new int[] { 1, 32, 1, 23 }, AmazonCheckmate.amazonCheckmate("a3", "e4") );
        assertArrayEquals( new int[] { 6, 11, 0, 38 }, AmazonCheckmate.amazonCheckmate("f3", "f2") );
        assertArrayEquals( new int[] { 0, 10, 0, 45 }, AmazonCheckmate.amazonCheckmate("b7", "a8") );
        assertArrayEquals( new int[] { 4, 28, 1, 21 }, AmazonCheckmate.amazonCheckmate("f7", "d3") );
        assertArrayEquals( new int[] { 9, 21, 0, 24 }, AmazonCheckmate.amazonCheckmate("g2", "c3") );
        assertArrayEquals( new int[] { 4, 18, 0, 32 }, AmazonCheckmate.amazonCheckmate("f3", "c1") );
        assertArrayEquals( new int[] { 0, 18, 0, 36 }, AmazonCheckmate.amazonCheckmate("d4", "h8") );
    }*/
	
	@Test 
	public void test_isInKingKillzone() {
		AmazonCheckmate.SquareCords victim, king;
		boolean actual;
		
		victim = AmazonCheckmate.SquareCords.a1;
		king = AmazonCheckmate.SquareCords.a2;
		actual = AmazonCheckmate.isInKingKillzone(victim, king);
		assertTrue(actual);
		
		victim = AmazonCheckmate.SquareCords.a1;
		king = AmazonCheckmate.SquareCords.b1;
		actual = AmazonCheckmate.isInKingKillzone(victim, king);
		assertTrue(actual);
		
		victim = AmazonCheckmate.SquareCords.a1;
		king = AmazonCheckmate.SquareCords.b3;
		actual = AmazonCheckmate.isInKingKillzone(victim, king);
		assertFalse(actual);
	}
	
	
	@Test
	public void test_isInAmazonKillzone() {
		AmazonCheckmate.SquareCords victim, amazon;
		boolean actual, expected;
		
		// same col
		victim = AmazonCheckmate.SquareCords.a1;
		amazon = AmazonCheckmate.SquareCords.a8;
		actual = AmazonCheckmate.isInAmazonKillzone(victim, amazon);
		assertTrue(actual);
		
		// knight move
		victim = AmazonCheckmate.SquareCords.a1;
		amazon = AmazonCheckmate.SquareCords.b3;
		actual = AmazonCheckmate.isInAmazonKillzone(victim, amazon);
		org.junit.Assert.assertTrue(actual);
		
		// knight move
		victim = AmazonCheckmate.SquareCords.a1;
		amazon = AmazonCheckmate.SquareCords.c2;
		actual = AmazonCheckmate.isInAmazonKillzone(victim, amazon);
		org.junit.Assert.assertTrue(actual);
		
		victim = AmazonCheckmate.SquareCords.a1;
		amazon = AmazonCheckmate.SquareCords.d2;
		actual = AmazonCheckmate.isInAmazonKillzone(victim, amazon);
		org.junit.Assert.assertFalse(actual);
		
		victim = AmazonCheckmate.SquareCords.a1;
		amazon = AmazonCheckmate.SquareCords.g6;
		actual = AmazonCheckmate.isInAmazonKillzone(victim, amazon);
		org.junit.Assert.assertFalse(actual);
	}

}


