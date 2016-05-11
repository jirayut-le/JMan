import java.awt.Color;
/**
 * An instance of this class is a Block.
 * @author Jirayut Leeupathumvong 5810546617
 *
 */
public class Block extends Piece{
	/**
	 * Construction of a new Block at position x,y.
	 * @param x position of x.
	 * @param y position of y.
	 * @param m Map field.
	 */
	public Block( int x , int y , Map m){
		super(Piece.BLOCK, m);
		super.setX(x);
		super.setY(y);
		super.setColor(Color.WHITE);
	}

	/**
	 * nothing change of block.
	 */
	@Override
	public void act() {}
	
	/** = representation of this block */
	public String toString() {
        return getColorWord() + " Block at (" + getX() + ", " + getY() + ")";
    }
}
