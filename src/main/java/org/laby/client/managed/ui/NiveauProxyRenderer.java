// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package org.laby.client.managed.ui;

import com.google.gwt.requestfactory.ui.client.ProxyRenderer;
import org.laby.client.managed.request.NiveauProxy;

public class NiveauProxyRenderer extends ProxyRenderer<NiveauProxy> {

    private static org.laby.client.managed.ui.NiveauProxyRenderer INSTANCE;

    protected NiveauProxyRenderer() {
        super(new String[] { "nom" });
    }

    public static org.laby.client.managed.ui.NiveauProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new NiveauProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(NiveauProxy object) {
        if (object == null) {
            return "";
        }
        return object.getNom() + " (" + object.getId() + ")";
    }
}
