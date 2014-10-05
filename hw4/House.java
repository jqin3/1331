/**
 * The abstract House for the Game of Thrones Simulation
 *
 */
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * This abstract class for a game of Thrones.
 * @author Jing Qin
 *
 */

public abstract class House {
    protected ImageIcon image;
    protected String imageFilename;
    protected final Rectangle bound;
    protected Rectangle location;
    protected int xPos;
    protected int yPos;
    protected int bWidth, bHeight, xspeed, yspeed;
    protected int maxAge, currentAge;
    protected int health;

    //Put constructors here!
    /**
     * input imageFile and limited by bound
     * defined location
     *
     * @param imageFile name
     * @param Position X
     * @param Position Y
     * @param bound limitation
     */
    public House(String imageFilename, int xPos, int yPos, Rectangle bound) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.bound = bound;
        image = new ImageIcon(imageFilename);
        location = new Rectangle(xPos, yPos, image.getIconWidth(),
                                            image.getIconHeight());
    }
    /**
     * Should draw the House at its location.
     */
    protected void draw(Graphics g) {
        image.paintIcon(null, g, xPos, yPos);
    }
    /**
     * abstract method defined movement for each house
     */
    public abstract void move();
    /**
     * Check if it is colliding with another house
     */
    public boolean collidesWithHouse(House otherHouse) {
        return (Math.abs(this.xPos - otherHouse.xPos)
                <= image.getIconWidth()
                && Math.abs(this.yPos - otherHouse.yPos)
                <= image.getIconHeight()
                && Math.abs(this.xPos - otherHouse.xPos) > 0
                && Math.abs(this.yPos - otherHouse.yPos) > 0);
    }
    /**
     * Check if it is able to reproduce when colliding with another house
     */
    public abstract boolean canReproduceWithHouse(House otherHouse);
    /**
     * Reproduction a new house
     */
    public abstract House reproduceWithHouse(House otherHouse);
    /**
     * Check if it is too old
     */
    public boolean isOld() {
        return (this.currentAge == this.maxAge);
    }
    /**
     * Check if it will harm another house when colliding with another house
     */
    public abstract boolean canHarmHouse(House otherHouse);
    /**
     * Decrease other house's health
     */
    public abstract void harmHouse(House otherHouse);
    /**
     * set condition for die
     */
    public void die() {
        this.health = 0;
    }
    /**
     * whether or not the house is dead
     */
    public boolean isDead() {
        if (this.health <= 0) {
            return true;
        }
        return false;
    }
}
