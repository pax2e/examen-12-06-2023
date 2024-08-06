/**
 *  @invar | 0 <= getUitvalshoek() && getUitvalshoek() < 360
 *  @invar | getBronknoop() == null || getBronknoop().getUitgaande().contains(this)
 *  @invar | getDoelknoop() == null || getDoelknoop().getInkomende().contains(this)
 */
public class Boog {
	
	/**
	 * @invar | 0 <= uitvalshoek && uitvalshoek < 360
	 */
	private int uitvalshoek;
	/**
	 * @peerObject
	 */
	private Knoop bronknoop;  //start
	/**
	 * @peerObject
	 */
	private Knoop doelknoop;  //einde
	
	public int getUitvalshoek() {return uitvalshoek;}
	/**
	 * @peerObject
	 */
	public Knoop getBronknoop() {return bronknoop;}
	/**
	 * @peerObject
	 */
	public Knoop getDoelknoop() {return doelknoop;}
	
	/**
	 * @pre | 0 <= ins_uitvalshoek && ins_uitvalshoek < 360
	 * @post | getUitvalshoek() == ins_uitvalshoek 
	 * @post | getBronknoop() == null 
	 * @post | getDoelknoop() == null 
	 */
	public Boog(int ins_uitvalshoek) {
		this.uitvalshoek = ins_uitvalshoek;
		this.bronknoop = null;
		this.doelknoop = null;
	}
	
	/**
	 * @pre | knoop != null
	 * @pre | getBronknoop() == null
	 * @mutates_properties | this.getBronknoop(), knoop.getUitgaande()
	 * @post | getBronknoop() == knoop
	 * @post | knoop.getUitgaande().contains(this)
	 */
	public void setBronknoop(Knoop knoop) {
		this.bronknoop = knoop;
		knoop.uitgaande.add(this);
	}

	/**
	 * @pre | knoop != null
	 * @pre | getDoelknoop() == null
	 * @mutates_properties | this.getDoelknoop(), knoop.getInkomende()
	 * @post | getDoelknoop() == knoop
	 * @post | knoop.getInkomende().contains(this)
	 */
	public void setDoelknoop(Knoop knoop) {
		this.doelknoop = knoop;
		knoop.inkomende.add(this);
	}

	/**
	 * @pre | getBronknoop() != null
	 * @pre | getBronknoop().getUitgaande().contains(this)
	 * @mutates_properties | this.getBronknoop(), old(getBronknoop()).getUitgaande()
	 * @post | getBronknoop() == null
	 * @post | !old(getBronknoop()).getUitgaande().contains(this)
	 */
	public void removeBronknoop() {
		bronknoop.uitgaande.remove(this);
		this.bronknoop = null;
	}

	/**
	 * @pre | getDoelknoop() != null
	 * @pre | getDoelknoop().getInkomende().contains(this)
	 * @mutates_properties | this.getDoelknoop(), old(getDoelknoop()).getInkomende()
	 * @post | getDoelknoop() == null
	 * @post | !old(getDoelknoop()).getInkomende().contains(this)
	 */
	public void removeDoelknoop() {
		doelknoop.inkomende.remove(this);
		this.doelknoop = null;
	}
}
