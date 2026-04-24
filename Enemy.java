import processing.core.PApplet;

public class Enemy extends Block {
     public Enemy(PApplet p) {
        x = 20*p.random(20);
        y = 20*p.random(20);
    }

    public void display(PApplet p) {
        p.noStroke();
        p.fill(200,0,0);
        p.rect(x, y, size, size);
    }
}
