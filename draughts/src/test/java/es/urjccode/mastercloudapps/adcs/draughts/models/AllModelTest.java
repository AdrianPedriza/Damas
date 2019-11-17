package es.urjccode.mastercloudapps.adcs.draughts.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    CoordinateTest.class, 
    PieceTest.class,
    GameDraughtsTest.class,
    GameBlockedTest.class,
    GamePawnTest.class, } )
public final class AllModelTest {
}
