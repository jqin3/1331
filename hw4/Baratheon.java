import java.awt.Rectangle;
import java.util.Random;
/**
 * This class for define house Baratheon.
 * @author Jing Qin
 *
 */
public class Baratheon extends SouthHouse {
    private static int babyCount4 = 0;
    /**
     * input imageFile and limited by bound
     * defined location
     *
     * @param Position X
     * @param Position Y
     * @param bound limitation
     */
    public Baratheon(int x, int y, Rectangle bounds) {
        super("stag.png", x, y, bounds);
        maxAge = 100;
        health = 100;
        babyCount4++;
    }
    /**
     * Check if it is able to reproduce when colliding with another house
     */
    @Override
    public boolean canReproduceWithHouse(House otherHouse) {
        return (super.collidesWithHouse(otherHouse)
            && otherHouse instanceof Lannister);
    }
    /**
     * Reproduction a new house
     */
    @Override
    public House reproduceWithHouse(House otherHouse) {
        double reproductionProbility = new Random().nextDouble();
        int reproductionProbility1 = new Random().nextInt(babyCount4);
        if (this.canReproduceWithHouse(otherHouse)
            && this.currentAge > 25 && this.currentAge < 60
            && otherHouse.currentAge > 25 && otherHouse.currentAge < 60) {
            if (babyCount4 > 50) {
                return null;
            } else {
                if (reproductionProbility1 < 5) {
                    Baratheon baby = new Baratheon(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 10
                           && reproductionProbility > 0.15) {
                    Baratheon baby = new Baratheon(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 15
                           && reproductionProbility > 0.45) {
                    Baratheon baby = new Baratheon(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 30
                           && reproductionProbility > 0.75) {
                    Baratheon baby = new Baratheon(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 45
                           && reproductionProbility > 0.85) {
                    Baratheon baby = new Baratheon(this.xPos, this.yPos, bound);
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
                && otherHouse instanceof Targaryan);
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
            babyCount4--;
            return true;
        } else {
            return false;
        }
    }
}