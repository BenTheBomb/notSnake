import processing.core.PApplet;

public class Main extends PApplet {
    Snake s;
    HUD hud;
    Apple a;
    boolean[] keys = new boolean[4];
    public void settings() {
        size(400, 400);
    }

    public void setup() {
        s = new Snake();
        hud = new HUD();
        a = new Apple();
    }

    public void draw() {
        background(255);
        hud.display();
        s.display();
        a.display();
        
        s.move(keys);

        if (s.ate(a)) { // collision with apple
            hud.score += 1;
            s.grow();
            a = new Apple();
        }

        if (s.isDead()) { // collision with wall or itself
            hud.score = 0;
        }

    }
    public static void main(String[] args) {
        String[] processingArgs = { "MySketch" };
        Main mySketch = new Main();
        PApplet.runSketch(processingArgs, mySketch);
    }
}