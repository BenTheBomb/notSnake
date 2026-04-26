// This is not snake!
// I started out with that but it turned into something...more.
// You are blue. Collect green, avoid red.
// Score 99 to win!

import processing.core.PApplet;

public class Main extends PApplet {
    Snake s;
    HUD hud;
    Apple a;
    Enemy e;
    boolean[] keys = new boolean[4];

    public void settings() {
        size(420, 420);
    }

    public void setup() {
        s = new Snake(this);
        hud = new HUD();
        a = new Apple(this);
        e = new Enemy(this);
    }

    public void draw() {
        background(255);
        hud.display(this);
        a.display(this);
        s.display(this);
        e.display(this);

        s.move(this);

        if (s.ate(a)) { // collision with apple
            hud.score += 1;
            s.grow(this);
            a = new Apple(this);
        }

        if (s.isDead(e)) { // collision with enemy
            hud.gameOver(this);
        }
    }

    public static void main(String[] args) {
        String[] processingArgs = { "MySketch" };
        Main mySketch = new Main();
        PApplet.runSketch(processingArgs, mySketch);
    }
}
