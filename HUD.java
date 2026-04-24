import processing.core.PApplet;

public class HUD {
    PApplet p;
    int score = 0;

    public HUD() {
    }

    public void display(PApplet p) {
        p.fill(0);
        p.textSize(20);
        p.text("Score: " + score, 10, 20);
        if (score == 99) {
            p.textSize(90);
            p.text("You Win!", 20, 200);
            p.noLoop();
        }
    }

    public void gameOver(PApplet p) {
        p.textSize(90);
        p.text("You Lose!", 20, 200);
        p.noLoop();
    }
}
