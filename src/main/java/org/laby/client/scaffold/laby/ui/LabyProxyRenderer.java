
package org.laby.client.scaffold.laby.ui;

import com.google.gwt.requestfactory.ui.client.ProxyRenderer;
import org.laby.client.managed.request.NiveauProxy;

public class LabyProxyRenderer extends ProxyRenderer<NiveauProxy> {

    private static LabyProxyRenderer INSTANCE;

    protected LabyProxyRenderer() {
        super(new String[] { "nom" });
    }

    public static LabyProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new LabyProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(NiveauProxy object) {
        if (object == null) {
            return "";
        }
        return object.getNom() + " ( Cliquez pour lancer le jeux ) ";
    }
}
