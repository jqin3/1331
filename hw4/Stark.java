import java.awt.Rectangle;
import java.util.Random;
/**
 * This class for define house Stark.
 * @author Jing Qin
 *
 */
public class Stark extends NorthHouse {
    private static int babyCount2 = 0;
    /**
     * input imageFile and limited by bound
     * defined location
     *
     * @param Position X
     * @param Position Y
     * @param bound limitation
     */
    public Stark(int x, int y, Rectangle bounds) {
        super("direwolf.png", x, y, bounds);
        maxAge = 150;
        health = 100;
        babyCount2++;
    }
    /**
     * Check if it is able to reproduce when colliding with another house
     */
    @Override
    public boolean canReproduceWithHouse(House otherHouse) {
        return (super.collidesWithHouse(otherHouse)
                && otherHouse instanceof Tully);
    }
    /**
     * Reproduction a new house
     */
    @Override
    public House reproduceWithHouse(House otherHouse) {
        double reproductionProbility = new Random().nextDouble();
        int reproductionProbility1 = new Random().nextInt(babyCount2);
        if (this.canReproduceWithHouse(otherHouse)
            && this.currentAge > 25 && this.currentAge < 60
            && otherHouse.currentAge > 25 && otherHouse.currentAge < 60) {
            if (babyCount2 > 50) {
                return null;
            } else {
                if (reproductionProbility1 < 5) {
                    Stark baby = new Stark(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 10
                           && reproductionProbility > 0.15) {
                    Stark baby = new Stark(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 15
                           && reproductionProbility > 0.45) {
                    Stark baby = new Stark(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 30
                           && reproductionProbility > 0.75) {
                    Stark baby = new Stark(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 45
                           && reproductionProbility > 0.85) {
                    Stark baby = new Stark(this.xPos, this.yPos, bound);
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
        if (this.canHarmHouse(otherHouse) && woundProbility <= 0.4) {
            otherHouse.health = otherHouse.health - 5;
        }
    }
    @Override
    public boolean isDead() {
        if (this.health <= 0) {
            babyCount2--;
            return true;
        } else {
            return false;
        }
    }
}