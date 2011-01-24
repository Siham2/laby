package org.laby.client.scaffold.laby;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.widgetideas.graphics.client.GWTCanvas;

public abstract class SimpleCanvasGame {

	/**
	   * Single shared canvas reference.
	   * We should treat it nice and save/restore our 
	   * context on entering/leaving drawDemo()
	   */
	  protected GWTCanvas canvas;
	  
	  /**
	   * Demos that allow some interaction with the user
	   * can add controls to the lower panel
	   * by creating a Composite object.
	   */
	  protected Composite controls;
	  
	  protected String gameName;
	  
	  /**
	   * Height that the canvas will be set to.
	   */
	  protected int height = 400;
	  
	  /**
	   * Width that the canvas will be set to.
	   */
	  protected int width = 400;
	  
	  public SimpleCanvasGame(GWTCanvas theCanvas) {
	    this.canvas = theCanvas;
	  }
	  
	  /**
	   * Should set controls variable to some
	   * Composite object.
	   */
	  public abstract void createControls();
	  
	  /**
	   * The function that "starts" the demo. Entry point for
	   * drawing code should go here.
	   */
	  public abstract void drawGame();
	  
	  public Composite getControls() {
	    if (controls == null) {
	      createControls();
	    }
	    return controls;
	  }
	  
	  public String getName() {
	    return gameName;
	  }
	  
	  /**
	   * Performs any teardowns/object destruction that should
	   * happen when a demo stops.
	   */
	  public abstract void stopGame(); 
	
}
