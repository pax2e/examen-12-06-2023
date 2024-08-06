import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

//TEST SUITE IN ANDERE PACKAGE

class TestClass {

	@Test
	void rechthoekig() {
		Rechthoekig RH = new Rechthoekig(5,4);
		assertEquals(5, RH.getHoogte());
		assertEquals(4, RH.getBreedte());
		assertTrue(RH.getInkomende().equals(new HashSet<Boog>()));
		assertTrue(RH.getUitgaande().equals(new HashSet<Boog>()));
	}
	
	@Test
	void cirkelvormig() {
		Cirkelvormig CV = new Cirkelvormig(5);
		assertEquals(5, CV.getStraal());
		assertTrue(CV.getInkomende().equals(new HashSet<Boog>()));
		assertTrue(CV.getUitgaande().equals(new HashSet<Boog>()));
	}
	
	@Test
	void cirkelvormig_defensief() {
		assertThrows(IllegalArgumentException.class, () -> new Cirkelvormig(-2));
	}
	
	@Test
	void isomorfisme() {
		Cirkelvormig CV1 = new Cirkelvormig(5);
		Cirkelvormig CV2 = new Cirkelvormig(5);
		Cirkelvormig CV3 = new Cirkelvormig(8);
		Rechthoekig RH1 = new Rechthoekig(1,2);
		Rechthoekig RH2 = new Rechthoekig(5,7);
		Rechthoekig RH3 = new Rechthoekig(1,2);

		assertTrue(CV1.isomorfMet(CV2));
		assertFalse(CV3.isomorfMet(CV1));
		assertFalse(CV2.isomorfMet(CV3));

		assertTrue(RH1.isomorfMet(RH3));
		assertFalse(RH3.isomorfMet(RH2));
		assertFalse(RH2.isomorfMet(RH1));
		
		assertFalse(RH2.isomorfMet(CV2));
		assertFalse(CV2.isomorfMet(RH1));
		assertFalse(CV1.isomorfMet(RH3));
	}
	
	@Test
	void berekenInfo() {
		Cirkelvormig CV1 = new Cirkelvormig(5);
		int[] CV1_info = CV1.berekenInfo(new int[2]);
		
		assertEquals(5*2*314/100, CV1_info[0]);
		assertEquals(5*5*314/100, CV1_info[1]);
		
		Rechthoekig RH1 = new Rechthoekig(1,2);
		int[] RH1_info = RH1.berekenInfo(new int[2]);
		
		assertEquals(6, RH1_info[0]);
		assertEquals(2, RH1_info[1]);
		

	}

	@Test
	void Boog() {
		Boog b = new Boog(134);
		assertEquals(134, b.getUitvalshoek());
		assertNull(b.getBronknoop());
		assertNull(b.getDoelknoop());
	}
	
	@Test
	void removeAndSetBoog() {
		Boog b = new Boog(12);
		assertEquals(12, b.getUitvalshoek());
		assertNull(b.getBronknoop());
		assertNull(b.getDoelknoop());
		
		Cirkelvormig CV1 = new Cirkelvormig(5);
		Rechthoekig RH1 = new Rechthoekig(1,2);

		b.setBronknoop(RH1);
		
		HashSet<Boog> expected = new HashSet<Boog>();
		expected.add(b);
		assertEquals(RH1, b.getBronknoop());
		assertTrue(RH1.getUitgaande().equals(expected));
		assertTrue(RH1.getInkomende().equals(new HashSet<Boog>()));
		
		b.setDoelknoop(CV1);

		HashSet<Boog> expected2 = new HashSet<Boog>();
		expected2.add(b);
		assertEquals(RH1, b.getBronknoop());
		assertEquals(CV1, b.getDoelknoop());
		assertTrue(RH1.getUitgaande().equals(expected));
		assertTrue(CV1.getInkomende().equals(expected2));
		
		b.removeBronknoop();
		assertEquals(null, b.getBronknoop());
		assertEquals(CV1, b.getDoelknoop());
		assertTrue(RH1.getUitgaande().equals(new HashSet<Boog>()));
		assertTrue(CV1.getInkomende().equals(expected2));

		
		b.removeDoelknoop();
		assertEquals(null, b.getBronknoop());
		assertEquals(null, b.getDoelknoop());
		assertTrue(RH1.getUitgaande().equals(new HashSet<Boog>()));
		assertTrue(CV1.getInkomende().equals(new HashSet<Boog>()));

		
	}
	
	
}
