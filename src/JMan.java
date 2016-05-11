import java.awt.*;

/** An instance of this class is a J*Man.
 There should at most one J*Man in a game board at a time
 * @author Jirayut Leeupathumvong 5810546617
 */
public class JMan extends Piece {

	/** Constructor: a new J*Man at position (x, y) on Map m
     with color red if c = 0, green if c = 1, and yellow if c = 2. 
     * @param x position of x
	 * @param y position of y
	 * @param c number color
	 * @param m Map field
     */
	public JMan(int x, int y, int c, Map m){
		super(Piece.JMAN, m);
		super.setX(x);
		super.setY(y);
		if (c == 0) super.setColor(Color.RED);
		else if (c == 1) super.setColor(Color.GREEN);
		else if (c == 2) super.setColor(Color.YELLOW);
	}

	/** Constructor: a new J*Man at position (x, y) on Map m
     with color c. Precondition: c is one of
     Color.RED, Color.GREEN, and Color.YELLOW.
     * @param x position of x.
	 * @param y position of y.
	 * @param c Color of piece.
	 * @param m Map field.
     */
	public JMan(int x, int y, Color c, Map m){
		super(Piece.JMAN, m);
		super.setX(x);
		super.setY(y);
		if (c.equals(Color.RED) || c.equals(Color.GREEN) || c.equals(Color.YELLOW))
			super.setColor(c);
	}

	/** J*Man should move based on what button is pushed.
     This method is not used. */
	public void act(){
		return;
	}

	/** Move J*Man one step based on the value of i:
        0 = up, 1 = down, 2 = left, 3 = right. */
	public void step(int i){
		setActed(true);
		if ( i == 0 && (getMap().isEmpty(getX(), getY()-1) || canEat(getMap().pieceAt(getX(), getY()-1))) ){
			this.getMap().move(this.getX(), this.getY(), this.getX(), this.getY() - 1);

		} else if ( i == 1 && (getMap().isEmpty(getX(), getY()+1) || canEat(getMap().pieceAt(getX(), getY()+1))) ){
			this.getMap().move(this.getX(), this.getY(), this.getX(), this.getY() + 1);

		} else if ( i == 2 && (getMap().isEmpty(getX()-1, getY()) || canEat(getMap().pieceAt(getX()-1, getY()))) ){
			this.getMap().move(this.getX(), this.getY(), this.getX() -1, this.getY());

		} else if ( i == 3 && (getMap().isEmpty(getX()+1, getY()) || canEat(getMap().pieceAt(getX()+1, getY()))) ){
			this.getMap().move(this.getX(), this.getY(), this.getX() +1, this.getY());

		}

	}
	/**
	 * Check next position have a piece of Walker and Pillar and change color of JMan when eat the piece.
	 * @param p Piece at next position.
	 * @return boolean check the next position have the piece that can eat.
	 */
	public boolean canEat( Piece p){
		boolean check = (p != null) && (getColorWord().equals("Green") && p.getColorWord().equals("Red") || getColorWord().equals("Red") && p.getColorWord().equals("Yellow") || getColorWord().equals("Yellow") && p.getColorWord().equals("Green"));
		if (check){
			if ( p.getColorWord().equals("Red")) setColor(Color.RED);
			else if ( p.getColorWord().equals("Green")) setColor(Color.GREEN);
			else if ( p.getColorWord().equals("Yellow")) setColor(Color.YELLOW);
		}
		return check;
	}

	/** = representation of this piece */
	public String toString() {
		String color= "";
		return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
	}
}
