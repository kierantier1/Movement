package gdx.movement;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Movement extends ApplicationAdapter implements InputProcessor {
    BitmapFont bmfName;
    SpriteBatch batch;
    Texture txDude, txRock;
    Sprite sprDude, sprRock;
    float fSx, fSy;
    
    @Override
    public void create() {
        batch = new SpriteBatch();
        txRock = new Texture("rock.png");
        sprRock = new Sprite(txRock);
        sprRock.setSize(100,100);
        sprRock.setPosition(300,300);
        txDude = new Texture("Boi.jpg");
        sprDude = new Sprite(txDude);
        sprDude.setSize(45, 80);
        sprDude.setPosition(200, 200);
        
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        fSy = sprDude.getY();
        fSx = sprDude.getX();
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            sprDude.setX(sprDude.getX() - 5);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            sprDude.setX(sprDude.getX() + 5);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            sprDude.setY(sprDude.getY() + 5);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            sprDude.setY(sprDude.getY() - 5);
        }
        if(isHit(sprDude, sprRock)){
            sprDude.setX(fSx);
            sprDude.setY(fSy);
            System.out.println("Yes");
        }
        batch.begin();
        sprDude.draw(batch);
        sprRock.draw(batch);
        batch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public void dispose() {
    }

    public static boolean isHit(Sprite spr1, Sprite spr2) {
        return spr1.getBoundingRectangle().overlaps(spr2.getBoundingRectangle()); //System.out.println("is hit");

    }
}
