package es.urjccode.mastercloudapps.adcs.draughts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.ControllerTests;
import es.urjccode.mastercloudapps.adcs.draughts.models.ModelsTests;
import es.urjccode.mastercloudapps.adcs.draughts.views.ViewTests;


@RunWith(Suite.class)
@Suite.SuiteClasses({ ModelsTests.class, ControllerTests.class, ViewTests.class })
public final class DraughtsTests {
}