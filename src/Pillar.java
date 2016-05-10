import java.awt.Color;
/**
 * 
 * @author Jirayut Leeupathumvong 5810546617
 *
 */
public class Pillar extends Piece{

	/** Constructor: a new Pillar at position (x, y) on Map m
    with color red if c = 0, green if c = 1, and yellow if c = 2. 
	 * @param x position of x
	 * @param y position of y
	 * @param c number color
	 * @param m Map field
	 */
	public Pillar (int x , int y , int c , Map m){
		super(Piece.PILLAR , m);
		super.setX(x);
		super.setY(y);
		if (c == 0) super.setColor(Color.RED);
		else if (c == 1) super.setColor(Color.GREEN);
		else if (c == 2) super.setColor(Color.YELLOW);
	}
	/** Constructor: a new Pillar at position (x, y) on Map m
    with color c. Precondition: c is one of
    Color.RED, Color.GREEN, and Color.YELLOW.
    * @param x position of x.
	 * @param y position of y.
	 * @param c Color of piece.
	 * @param m Map field.
    */
	public Pillar (int x ,int y , Color c , Map m){
		super(Piece.PILLAR , m );
		super.setX(x);
		super.setY(y);
		if (c.equals(Color.RED) || c.equals(Color.GREEN) || c.equals(Color.YELLOW))
			super.setColor(c);
	}

	@Override
	public void act() {
		this.setActed(true);
		if ( Piece.rand(0, 2) == 1){
			int random = Piece.rand(0, 2);
			if ( random == 0) super.setColor(Color.RED);
			else if ( random == 1 ) super.setColor(Color.GREEN);
			else if ( random == 2) super.setColor(Color.YELLOW);
		}
	}
	/** = representation of this Pillar */
	public String toString() {
		return getColorWord() + " Pillar at (" + getX() + ", " + getY() + ")";
	}
}
