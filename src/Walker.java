import java.awt.Color;
/**
 * An instance of this class is a Walker.
 * @author Jirayut Leeupathumvong 5810546617
 *
 */
public class Walker extends Piece{

	/** Constructor: a new Walker at position (x, y) on Map m
    with color red if c = 0, green if c = 1, and yellow if c = 2. 
	 * @param x position of x
	 * @param y position of y
	 * @param c number color
	 * @param m Map field
	 */
	public Walker(int x , int y , int c, Map m) {
		super(Piece.WALKER, m);
		super.setX(x);
		super.setY(y);
		if (c == 0) super.setColor(Color.RED);
		else if (c == 1) super.setColor(Color.GREEN);
		else if (c == 2) super.setColor(Color.YELLOW);
	}
	/** Constructor: a new Walker at position (x, y) on Map m
    with color c. Precondition: c is one of
    Color.RED, Color.GREEN, and Color.YELLOW.
    * @param x position of x.
	 * @param y position of y.
	 * @param c Color of piece.
	 * @param m Map field.
    */
	public Walker( int x , int y , Color c , Map m){
		super(Piece.WALKER , m);
		super.setX(x);
		super.setY(y);
		if (c.equals(Color.RED) || c.equals(Color.GREEN) || c.equals(Color.YELLOW))
			super.setColor(c);
	}

	/**
	 * Action to random next position the walker to move.
	 */
	@Override
	public void act() {	
		if ( Piece.rand(0, 2) == 0){
			int random = Piece.rand(0, 2);
			if ( random == 0 && getMap().isEmpty(getX(), getY()-1)){
				getMap().move(getX(), getY(), getX(), getY() -1);
			} else if ( random == 1 && getMap().isEmpty(getX(), getY()+1)){
				getMap().move(getX(), getY(), getX(), getY() +1);
			} else if ( random == 2 && getMap().isEmpty(getX()-1, getY())){
				getMap().move(getX(), getY(), getX() -1, getY());
			} else if ( random == 3 && getMap().isEmpty(getX()+1, getY())){
				getMap().move(getX(), getY(), getX()+1, getY());
			}
		}
	}
	/** = representation of this walker */
	public String toString() {
		return getColorWord() + " Walker at (" + getX() + ", " + getY() + ")";
	}

}
