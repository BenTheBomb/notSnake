import processing.core.PApplet;

public class Apple extends Block {

    public Apple(PApplet p) {
        x = 20 * p.random(20);
        y = 20 * p.random(20);
    }

    public void display(PApplet p) {
        p.noStroke();
        p.fill(0, 200, 0);
        p.rect(x, y, size, size);
    }

}
