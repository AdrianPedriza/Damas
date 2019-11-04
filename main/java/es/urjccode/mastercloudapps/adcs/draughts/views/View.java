package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.AcceptorController;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.ControllersVisitor;

/**
 * View
 */
public abstract class View implements ControllersVisitor {

    public abstract void interact(AcceptorController acceptorController);

    
}