import java.util.HashSet;

/**
 * @invar | getHoogte()  > 0
 * @invar | getBreedte() > 0
 */
public class Rechthoekig extends Knoop {
	
	/**
	 * @invar | hoogte > 0
	 * @invar | breedte > 0
	 */
	private int hoogte;
	private int breedte;

	public int getHoogte() {return hoogte;}
	public int getBreedte() {return breedte;}
	/**
	 * @pre | ins_hoogte > 0
	 * @pre | ins_breedte > 0
	 * @post | getHoogte() == ins_hoogte
	 * @post | getBreedte() == ins_breedte
	 */
	public Rechthoekig(int ins_hoogte, int ins_breedte) {
		this.hoogte = ins_hoogte;
		this.breedte = ins_breedte;
	}
		
	
	@Override
	/**
	 * @pre | resultaat != null
	 * @pre | resultaat.length == 2
	 * @post | resultaat[0] == 2*getHoogte() + 2*getBreedte()
	 * @post | resultaat[1] == getHoogte() * getBreedte()
	 */
	public int[] berekenInfo(int[] resultaat) {
		resultaat[0] = 2*hoogte + 2*breedte;
		resultaat[1] = hoogte*breedte;
		return resultaat;
	}
	
	@Override
	/**
	 * @pre | andere != null
	 * @post| result == ((andere instanceof Rechthoekig) && berekenInfo(new int[2])[0] == (andere.berekenInfo(new int[2]))[0] && this.berekenInfo(new int[2])[1] == (andere.berekenInfo(new int[2]))[1])
	 */
	public boolean isomorfMet(Knoop andere) {
		if (andere instanceof Rechthoekig) {
			return (this.berekenInfo(new int[2])[0] == (andere.berekenInfo(new int[2]))[0] &&this.berekenInfo(new int[2])[1] == (andere.berekenInfo(new int[2]))[1]);
		} else
			return false;
	}

}
