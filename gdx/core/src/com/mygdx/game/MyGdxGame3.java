package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.charMain;

public class MyGdxGame3 extends ApplicationAdapter {

    public static int nHeight = 300;
    public static int nWidth = 1000;
    SpriteBatch batch;
    Texture imgB;
    TextureRegion img;
    Texture imgMap;
    charMain char1, char2, char3;
    int nFunc = 0, nMapX = 0;
    public boolean isFlip = false, isJump = false, isRun = true;

    @Override
    public void create() {
        char1 = new charMain(500);
        char2 = new charMain(300);
        char3 = new charMain(700);
        batch = new SpriteBatch();
        imgMap = new Texture(Gdx.files.absolute("D:/Mogos/gdx/core/assets/map.png"));
    }

    @Override
    public void render() {
        int nEWidth = 35, nEHeight = 70, nTempX = 0, nTempY = 0;
        isJump = false;
        isRun = false;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (char1.nX > 800) {
                if (nMapX + 4800 > 1000) {
                    nMapX -= 2;
                }

            } else {
                nTempX = 2;
            }
            isRun = true;
            isFlip = false;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (char1.nX < 200) {
                if (nMapX < 0) {
                    nMapX += 2;
                }
            } else {
                nTempX = -2;
            }
            isRun = true;
            isFlip = true;
        }
        Gdx.gl.glClearColor(2, 0, 0, 2);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        char1.update(nTempX, nTempY, isFlip, isRun);
        char2.update(nTempX, nTempY, isFlip, isRun);
        char3.update(nTempX, nTempY, isFlip, isRun);
        batch.draw(imgMap, nMapX, 0, 4800, 700);
        batch.draw(char1.img, char1.nX, char1.nY);
        batch.draw(char2.img, char2.nX, char2.nY);
        batch.draw(char3.img, char3.nX, char3.nY);
        batch.draw(char3.img, char3.nX, char3.nY);
        batch.end();
    }
}