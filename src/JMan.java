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
	public void step(int x , int y){
		int newX = getX()+x;
		int newY = getY()+y;
		setActed(true);
		if ( getMap().isEmpty(newX, newY) || canEat(getMap().pieceAt(newX, newY)))
			this.getMap().move(getX(), getY(), newX, newY);
	}
	/**
	 * Check next position have a piece of Walker and Pillar and change color of JMan when eat the piece.
	 * @param p Piece at next position.
	 * @return boolean check the next position have the piece that can eat.
	 */
	public boolean canEat( Piece p){
		String colorJMan = getColorWord();
		String colorPiece;
		boolean check = false;
		if ( p != null){
			colorPiece = p.getColorWord();
			check = (p != null) && ( colorJMan.equals("Green") && colorPiece.equals("Red") || colorJMan.equals("Red") && colorPiece.equals("Yellow") || colorJMan.equals("Yellow") && colorPiece.equals("Green"));
		}
		if (check) setColor( p.getColor() );
		return check;
	}

	/** = representation of this piece */
	public String toString() {
		return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
	}
}
