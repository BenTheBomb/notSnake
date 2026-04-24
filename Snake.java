import processing.core.PApplet;

public class Snake extends Block {
    int len = 0;
    Block[] tail = new Block[100];

    public Snake(PApplet p) {
        tail[0] = new Block();
        tail[0].x = 20 * p.random(20);
        tail[0].y = 20 * p.random(20);
    }

    public void display(PApplet p) {
        p.fill(0,0, 200);
        for (int i = 0; i <= len; i++) {
            p.rect(tail[i].x, tail[i].y, size, size);
        }
    }

    public void move(PApplet p) {
        for (int i = 0; i <= len; i++) {
            tail[i].current_dir = p.keyCode;
            if (tail[i].current_dir == 38) { // up
                tail[i].y -= 2;
            } else if (tail[i].current_dir == 40) { // down
                tail[i].y += 2;
            } else if (tail[i].current_dir == 37) { // left
                tail[i].x -= 2;
            } else if (tail[i].current_dir == 39) { // right
                tail[i].x += 2;
            }

            if (tail[i].x > p.width) {
                tail[i].x = 0;
            } else if (tail[i].x < 0) {
                tail[i].x = p.width;
            } else if (tail[i].y > p.height) {
                tail[i].y = 0;
            } else if (tail[i].y < 0) {
                tail[i].y = p.height;
            }
        }
    }

    public void grow(PApplet p) {
        len += 1;
        tail[len] = new Block();
        tail[len].x = 20 * p.random(20);
        tail[len].y = 20 * p.random(20);
    }


    // could abstract next two methods since basically same
    public boolean isDead(Enemy e) {
        for (int i = 0; i <= len; i++) {
            if ((e.x > tail[i].x - size && e.x < tail[i].x + size) && e.y > tail[i].y - size && e.y < tail[i].y + size) {
                return true;
            }
        }
        return false;
    }

    public boolean ate(Apple a) {
        for (int i = 0; i <= len; i++) {
            if ((a.x > tail[i].x - size && a.x < tail[i].x + size) && a.y > tail[i].y - size && a.y < tail[i].y + size) {
                return true;
            }
        }
        return false;
    }
}
