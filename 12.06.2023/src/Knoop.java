import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class Knoop {
	
	/**
	 * @peerObjects
	 * @representationObject
	 * @invar | inkomende != null
	 * @invar | getInkomende().stream().allMatch(b -> b != null && b.getDoelknoop() == this)
	 */
	HashSet<Boog> inkomende;
	
	/**
	 * @peerObjects
	 * @representationObject
	 * @invar | uitgaande != null
	 * @invar | getUitgaande().stream().allMatch(b -> b != null && b.getBronknoop() == this)
	 */
	HashSet<Boog> uitgaande;
	
	/**
	 * @perrObjects
	 * @creates | result
	 * @post | result != null
	 */
	public Set<Boog> getInkomende() {
		return Set.copyOf(inkomende);
	}
	
	/**
	 * @perrObjects
	 * @creates | result
	 * @post | result != null
	 * 
	 */
	public Set<Boog> getUitgaande() {
		return Set.copyOf(uitgaande);	
	}
	
	/**
	 * @pre | resultaat != null
	 * @pre | resultaat.length == 2
	 * 
	 */
	public abstract int[] berekenInfo(int[] resultaat); //gedragssubtypering: de specs van de impl in subklassen zijn strenger en specifieker
														//geen return!!!! met void werken.. ?
	public abstract boolean isomorfMet(Knoop andere);

		
	public Knoop() {
		this.inkomende = new HashSet<Boog>();
		this.uitgaande = new HashSet<Boog>();
	} //default inkomende en uitgaande leeg
	
	
	
	public Iterator<Knoop> IteratorDoelknopen() {
		return new Iterator<>() {
			Iterator<Boog> uitgaandeIterator = uitgaande.iterator();
		
			@Override
			public boolean hasNext() {
				return uitgaandeIterator.hasNext();
			}
			
			@Override
			public Knoop next() {
				return uitgaandeIterator.next().getDoelknoop();
			}
		};
	}
	
}
