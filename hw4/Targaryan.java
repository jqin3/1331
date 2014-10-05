import java.awt.Rectangle;
import java.util.Random;
/**
 * This class for create house Targaryan.
 * @author Jing Qin
 *
 */
public class Targaryan extends House {
    private static int babyCount5 = 0;
    /**
     * input imageFile and limited by bound
     * defined location
     *
     * @param Position X
     * @param Position Y
     * @param bound limitation
     */
    public Targaryan(int x, int y, Rectangle bounds) {
        super("dragon.png", x, y, bounds);
        babyCount5++;
        health = 100;
        maxAge = 1;
    }
    /**
     * abstract method defined movement for each house
     */
    @Override
    public void move() {
        int xspeed = new Random().nextInt(40) - 20;
        int yspeed = new Random().nextInt(40) - 20;
        int bWidth = (int) bound.getWidth();
        int bHeight = (int) bound.getHeight();
        xPos = xPos + xspeed;
        yPos = yPos + yspeed;
        currentAge++;
        maxAge++;
        if (xPos + image.getIconWidth() >= bWidth) {
            xPos = xPos - new Random().nextInt(20);
        } else if (yPos + image.getIconHeight() >= bHeight) {
            yPos = yPos - new Random().nextInt(20);
        } else if (xPos <= 0) {
            xPos = xPos + new Random().nextInt(20);
        } else if (yPos <= 0) {
            yPos = yPos + new Random().nextInt(20);
        }
    }
    /**
     * Check if it is able to reproduce when colliding with another house
     */
    @Override
    public boolean canReproduceWithHouse(House otherHouse) {
        return (super.collidesWithHouse(otherHouse)
                && otherHouse instanceof Targaryan);
    }
    /**
     * Reproduction a new house
     */
    @Override
    public House reproduceWithHouse(House otherHouse) {
        double reproductionProbility = new Random().nextDouble();
        int reproductionProbility1 = new Random().nextInt(babyCount5);
        if (this.canReproduceWithHouse(otherHouse)
            && this.currentAge > 25 && this.currentAge < 60
            && otherHouse.currentAge > 25 && otherHouse.currentAge < 60) {
            if (babyCount5 > 50) {
                return null;
            } else {
                if (reproductionProbility1 < 5) {
                    Targaryan baby
                        = new Targaryan(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 10
                           && reproductionProbility > 0.15) {
                    Targaryan baby
                        = new Targaryan(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 15
                           && reproductionProbility > 0.45) {
                    Targaryan baby
                        = new Targaryan(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 30
                           && reproductionProbility > 0.75) {
                    Targaryan baby
                        = new Targaryan(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 45
                           && reproductionProbility > 0.85) {
                    Targaryan baby
                        = new Targaryan(this.xPos, this.yPos, bound);
                    return baby;
                }
            }
        } else {
            return null;
        }
        return null;
    }
    @Override
    public boolean canHarmHouse(House otherHouse) {
        return (super.collidesWithHouse(otherHouse)
                && (otherHouse instanceof Stark
                || otherHouse instanceof Tully
                || otherHouse instanceof Lannister));
    }
    @Override
    public void harmHouse(House otherHouse) {
        if (this.canHarmHouse(otherHouse)) {
            otherHouse.health = otherHouse.health - 5;
        }
    }
    @Override
    public boolean isDead() {
        if (this.health <= 0) {
            babyCount5--;
            return true;
        } else {
            return false;
        }
    }
}