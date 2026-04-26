import processing.core.PApplet;

public class Enemy extends Block {
    public Enemy(PApplet p) {
        x = p.random(100, 300);
        y = p.random(100, 300);
    }

    public void display(PApplet p) {
        p.noStroke();
        p.fill(200, 0, 0);
        p.rect(x, y, size, size);
    }
}
