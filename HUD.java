import processing.core.PApplet;

public class HUD {
    PApplet p;
    int score = 0;

    public HUD() {

    }

    public void display() {
        p.text(score,100,100);
    }

}
