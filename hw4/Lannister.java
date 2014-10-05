import java.awt.Rectangle;
import java.util.Random;
/**
 * This class for define house Lannister.
 * @author Jing Qin
 *
 */
public class Lannister extends SouthHouse {
    private static int babyCount3 = 0;
    /**
     * input imageFile and limited by bound
     * defined location
     *
     * @param Position X
     * @param Position Y
     * @param bound limitation
     */
    public Lannister(int x, int y, Rectangle bounds) {
        super("lion.png", x, y, bounds);
        maxAge = 70;
        health = 100;
        babyCount3++;
        // imageFilename = new ImageIcon("lion.png");
    }
    /**
     * Check if it is able to reproduce when colliding with another house
     */
    @Override
    public boolean canReproduceWithHouse(House otherHouse) {
        return
            (super.collidesWithHouse(otherHouse)
                && otherHouse instanceof Baratheon);
    }
    /**
     * Reproduction a new house
     */
    @Override
    public House reproduceWithHouse(House otherHouse) {
        double reproductionProbility = new Random().nextDouble();
        int reproductionProbility1 = new Random().nextInt(babyCount3);
        if (this.canReproduceWithHouse(otherHouse)
            && this.currentAge > 25 && this.currentAge < 60
            && otherHouse.currentAge > 25 && otherHouse.currentAge < 60) {
            if (babyCount3 > 50) {
                return null;
            } else {
                if (reproductionProbility1 < 5) {
                    Lannister baby
                        = new Lannister(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 10
                           && reproductionProbility > 0.15) {
                    Lannister baby
                        = new Lannister(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 15
                           && reproductionProbility > 0.45) {
                    Lannister baby
                        = new Lannister(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 30
                           && reproductionProbility > 0.75) {
                    Lannister baby
                        = new Lannister(this.xPos, this.yPos, bound);
                    return baby;
                } else if (reproductionProbility1 < 45
                           && reproductionProbility > 0.85) {
                    Lannister baby
                        = new Lannister(this.xPos, this.yPos, bound);
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
            && (otherHouse instanceof Stark || otherHouse instanceof Tully));
    }
    @Override
    public void harmHouse(House otherHouse) {
        double woundProbility = new Random().nextDouble();
        if (this.canHarmHouse(otherHouse)) {
            if (otherHouse instanceof Stark && woundProbility <= 0.6) {
                otherHouse.health = otherHouse.health - 5;
            } else if (otherHouse instanceof Tully && woundProbility <= 0.8) {
                otherHouse.health = otherHouse.health - 5;
            }
        }
    }
    @Override
    public boolean isDead() {
        if (this.health <= 0) {
            babyCount3--;
            return true;
        } else {
            return false;
        }
    }
}