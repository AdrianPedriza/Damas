package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * GameTest
 */
public class GameTest {

    public GameTest() {

    }

    @Test
    public void givenGameWhenResetGameThenNotError() {
        Game game = new Game();
        assertNull(game.reset());
        assertEquals(game.getBoard(), new Board());
        assertEquals(game.getState(), StateValue.INITIAL);
    }
    
}