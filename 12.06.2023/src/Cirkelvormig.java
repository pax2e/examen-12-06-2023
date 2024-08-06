import java.util.HashSet;
/**
 * @invar | getStraal() > 0
 */
public class Cirkelvormig extends Knoop {
	
	/**
	 * @invar | straal > 0
	 */
	private int straal;

	public int getStraal() {return straal;}
	
	/**
	 * @throws IllegalArgumentException | ins_straal <= 0
	 * @param ins_straal
	 */
	public Cirkelvormig(int ins_straal) {
		if (ins_straal <= 0) 
			throw new IllegalArgumentException("Straal met groter dan nul zijn");
		else
			this.straal = ins_straal;
	}
	
	@Override
	/**
	 * @throws IllegalArgumentException | resultaat == null
	 * @throws IllegalArgumentException | resultaat.length != 2
	 * @post | resultaat[0] == getStraal() * 2* 314 / 100
	 * @post | resultaat[1] == getStraal()*getStraal()* 314 / 100
	 */
	public int[] berekenInfo(int[] resultaat) {
		if (resultaat == null) 
			throw new IllegalArgumentException("Invalid input");
		if (resultaat.length != 2) 
			throw new IllegalArgumentException("Invalid input");
		resultaat[0] = straal * 2* 314 / 100 ;
		resultaat[1] = straal*straal* 314 / 100;
		return resultaat;
	}
	
	@Override
	/**
	 * @pre | andere != null
	 * @post| result == ((andere instanceof Cirkelvormig) && berekenInfo(new int[2])[0] == (andere.berekenInfo(new int[2]))[0] && this.berekenInfo(new int[2])[1] == (andere.berekenInfo(new int[2]))[1])
	 */
	public boolean isomorfMet(Knoop andere) {
		if (andere instanceof Cirkelvormig) {
			return (this.berekenInfo(new int[2])[0] == (andere.berekenInfo(new int[2]))[0] &&this.berekenInfo(new int[2])[1] == (andere.berekenInfo(new int[2]))[1]);
		} else
			return false;
	}

}
