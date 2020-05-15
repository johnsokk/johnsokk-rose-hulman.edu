package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ticketPackage.Card;

class TransactionLogWriterTests {

	//@Test
	//public void testValidFileValidData() {
		
		//fail("Not yet implemented");
		
	//}
	
	@Test
	
	public void testAddBalance() {
		
		Card card1 = new Card();
		card1.addBalance(1000);
		assertEquals(1000, card1.gethcbalance());
		
		Card card2 = new Card();
		card2.addBalance(200);
		assertEquals(200, card2.gethcbalance());
		
		Card card3 = new Card();
		card3.addBalance(0);
		assertEquals(0, card3.gethcbalance());
		
	}
	
	@Test
	
	public void testSubtractBalance() {
		
		Card card4 = new Card();
		card4.subtractBalance(0);
		assertEquals(0, card4.gethcbalance());
		
		Card card5 = new Card();
		card5.subtractBalance(1200);
		assertEquals(-1200, card5.gethcbalance());
		
		Card card6 = new Card();
		card6.subtractBalance(600);
		assertEquals(-600, card6.gethcbalance());
	}

}
