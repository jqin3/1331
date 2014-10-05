import java.awt.Rectangle;
import java.util.Random;
/**
 * This class for define house Tully.
 * @author Jing Qin
 *
 */
public class Tully extends NorthHouse {
    private static int babyCount1 = 0;
    /**
     * input imageFile and limited by bound
     * defined location
     *
     * @param Position X
     * @param Position Y
     * @param bound limitation
     */
    public Tully(int x, int y, Rectangle bounds) {
        super("trout.png", x, y, bounds);
        babyCount1++;
        maxAge = 200;
        health = 100;
    }
    /**
     * Check if it is able to reproduce when colliding with another house
     */
    @Override
    public boolean canReproduceWithHouse(House otherHouse) {
        return (super.collidesWithHouse(otherHouse)
                && otherHouse instanceof Stark);
    }
    /**
     * Reproduction a new house
     */
    @Override
    public House reproduceWithHouse(House otherHouse) {
        double reproductionProbility = new Random().nextDouble();
        int reproductionProbility1 = new Random().nextInt(babyCount1);
        if (this.canReproduceWithHouse(otherHouse)
            && this.currentAge > 25 && this.currentAge < 60
            && otherHouse.currentAge > 25 && otherHouse.currentAge < 60) {
            if (babyCount1 > 50) {
                return null;
            } else {
                if (reproductionProbility1 < 5) {
                    Tully baby = new Tully(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 10
                           && reproductionProbility > 0.15) {
                    Tully baby = new Tully(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 15
                           && reproductionProbility > 0.45) {
                    Tully baby = new Tully(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 30
                           && reproductionProbility > 0.75) {
                    Tully baby = new Tully(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 45
                           && reproductionProbility > 0.85) {
                    Tully baby = new Tully(this.xPos, this.yPos, bound);
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
                && otherHouse instanceof Lannister);
    }
    @Override
    public void harmHouse(House otherHouse) {
        double woundProbility = new Random().nextDouble();
        if (this.canHarmHouse(otherHouse) && woundProbility <= 0.2) {
            otherHouse.health = otherHouse.health - 5;
        }
    }
    @Override
    public boolean isDead() {
        if (this.health <= 0) {
            babyCount1--;
            return true;
        } else {
            return false;
        }
    }
}