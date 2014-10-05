import java.awt.Rectangle;
import java.util.Random;
/**
 * This abstract class for SouthHouse.
 * @author Jing Qin
 *
 */
public abstract class SouthHouse extends House {
    /**
     * input imageFile and limited by bound
     * defined location
     *
     * @param imageFile name
     * @param Position X
     * @param Position Y
     * @param bound limitation
     */
    public SouthHouse(String imageFilename, int x, int y, Rectangle bounds) {
        super(imageFilename, x, y, bounds);
    }
    /**
     * abstract method defined movement for each house
     */
    @Override
    public void move() {
        xspeed = new Random().nextInt(20) - 10;
        yspeed = new Random().nextInt(20) - 10;
        bWidth = (int) bound.getWidth();
        bHeight = (int) bound.getHeight();
        if (yPos < bHeight / 2) {
            xPos = xPos + xspeed;
            yPos = yPos + yspeed;
            currentAge++;
            if (xPos + image.getIconWidth() >= bWidth) {
                xPos = xPos - new Random().nextInt(10);
            } else if (xPos <= 0) {
                xPos = xPos + new Random().nextInt(10);
            } else if (yPos <= 0) {
                yPos = yPos + new Random().nextInt(10);
            }
        } else {
            xPos = xPos + new Random().nextInt(60) - 30;
            yPos = yPos + new Random().nextInt(60) - 30;
            currentAge++;
            if (xPos + image.getIconWidth() >= bWidth) {
                xPos = xPos - new Random().nextInt(30);
            } else if (yPos + image.getIconHeight() >= bHeight) {
                yPos = yPos - new Random().nextInt(30);
            } else if (xPos <= 0) {
                xPos = xPos + new Random().nextInt(30);
            }
        }
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
     * Check if it will harm another house when colliding with another house
     */
    public abstract boolean canHarmHouse(House otherHouse);
    /**
     * Decrease other house's health
     */
    public abstract void harmHouse(House otherHouse);
}