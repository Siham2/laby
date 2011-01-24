// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package org.laby.client.managed.ui;

import com.google.gwt.requestfactory.ui.client.ProxyRenderer;
import org.laby.client.managed.request.BonusProxy;
import org.laby.client.managed.request.NiveauProxy;

public class BonusProxyRenderer extends ProxyRenderer<BonusProxy> {

    private static org.laby.client.managed.ui.BonusProxyRenderer INSTANCE;

    protected BonusProxyRenderer() {
        super(new String[] { "id" });
    }

    public static org.laby.client.managed.ui.BonusProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new BonusProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(BonusProxy object) {
        if (object == null) {
            return "";
        }
        return object.getId() + " (" + object.getId() + ")";
    }
}