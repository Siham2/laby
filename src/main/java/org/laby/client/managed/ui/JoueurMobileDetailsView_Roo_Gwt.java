// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package org.laby.client.managed.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import org.laby.client.managed.request.JoueurProxy;
import org.laby.client.managed.request.NiveauProxy;
import org.laby.client.scaffold.place.ProxyDetailsView;

public abstract class JoueurMobileDetailsView_Roo_Gwt extends Composite implements ProxyDetailsView<JoueurProxy> {

    @UiField
    Element id;

    @UiField
    Element version;

    @UiField
    Element posX;

    @UiField
    Element posY;

    @UiField
    Element niveau;

    JoueurProxy proxy;

    public void setValue(JoueurProxy proxy) {
        this.proxy = proxy;
        id.setInnerText(proxy.getId() == null ? "" : String.valueOf(proxy.getId()));
        version.setInnerText(proxy.getVersion() == null ? "" : String.valueOf(proxy.getVersion()));
        posX.setInnerText(proxy.getPosX() == null ? "" : String.valueOf(proxy.getPosX()));
        posY.setInnerText(proxy.getPosY() == null ? "" : String.valueOf(proxy.getPosY()));
        niveau.setInnerText(proxy.getNiveau() == null ? "" : org.laby.client.managed.ui.NiveauProxyRenderer.instance().render(proxy.getNiveau()));
    }
}