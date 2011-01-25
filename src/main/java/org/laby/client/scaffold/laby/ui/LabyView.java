
package org.laby.client.scaffold.laby.ui;

import org.laby.client.managed.request.NiveauProxy;
import org.laby.client.scaffold.laby.Laby;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.widgetideas.graphics.client.GWTCanvas;

public class LabyView  extends Composite  {

	/**
	 * Implemented by the owner of the view.
	 */
	public interface Delegate {

		void replayClicked();

		void setDifficulte(int difficulte);

		void saveScore(NiveauProxy niveau, Integer score);

	}
	
	
    private static final Binder BINDER = GWT.create(Binder.class);

    private static LabyView instance;

    NiveauProxy proxy;

    @UiField
    SpanElement displayRenderer;
    
    

    @UiField 
    FocusPanel gamePanel;
    
    GWTCanvas canvas ;
    
    Laby laby;
    
    @UiField
    HasClickHandlers replay;
    

    

    @UiField
    ListBox level;

    
    
    

    private Delegate delegate;

    public LabyView() {
        initWidget(BINDER.createAndBindUi(this));
	   	 level.addItem("Débutant");
		 level.addItem("Intermédiaire");
		 level.addItem("Expert");
     
    }

    public static LabyView instance() {
        if (instance == null) {
            instance = new LabyView();
        }
        return instance;
    }

    public Widget asWidget() {
        return this;
    }

    public boolean confirm(String msg) {
        return Window.confirm(msg);
    }

    public NiveauProxy getValue() {
        return proxy;
    }


    
    
    @UiHandler("replay")
    public void onReplayClicked(ClickEvent e) {
        delegate.replayClicked();
        reloadGame();
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    interface Binder extends UiBinder<HTMLPanel, LabyView> {
    }
        

    public void setValue(NiveauProxy niveau) {
        this.proxy = niveau;
       displayRenderer.setInnerText(LabyProxyRenderer.instance().render(proxy));
       reloadGame();
    }
    

    private void reloadGame() {
    	 gamePanel.clear();
         canvas = new GWTCanvas(400,400);
         gamePanel.add(canvas);
         
 		 if(laby!=null){
 			 laby.stopGame();
 		 }
         
         laby = new Laby(this,canvas,proxy);
 	      
 		
 		 laby.drawGame();
 		 gamePanel.addKeyPressHandler(laby);
 		 gamePanel.addClickHandler(laby);
		
	}

	@UiHandler("level")
    public void onChange(@SuppressWarnings("unused") ChangeEvent ignored) {
      int index = level.getSelectedIndex();
      laby.setDifficulte(index+1);   
    }

	public void displayScorePopup(int score) {
		final PopupPanel scorePanel = new PopupPanel();
		
	    Button saveScore = new Button("Sauvegarder");
	    saveScore.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(laby!=null){
		    		scorePanel.hide();
		    		delegate.saveScore(proxy,laby.getScore());
		    	}
				
			}
		});
	    FlowPanel panel = new FlowPanel();
	    scorePanel.add(panel);
	    Label scorelbl =  new Label("Votre score est: "+score);
	    panel.add(scorelbl);
	    panel.add(saveScore);
		
		scorePanel.show();
		scorePanel.center();
	}

    
}
