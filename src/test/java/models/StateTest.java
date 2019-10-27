package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * StateTest
 */
public class StateTest {

    public StateTest() {

    }

    @BeforeClass
    public static void initGame() {
        Game game = new Game();
    }

    @Test
    public void givenStateWhenNextStateThenNexStateValue() {
        State state1 = new State(StateValue.INITIAL);
        State state2 = new State(StateValue.IN_GAME);
        State state3 = new State(StateValue.FINAL);
        state1.next();
        state2.next();
        state3.next();
        assertEquals(StateValue.IN_GAME, state1.getValue());
        assertEquals(StateValue.FINAL, state2.getValue());
        assertEquals(StateValue.EXIT, state3.getValue());

    }
}
