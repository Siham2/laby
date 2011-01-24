// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package org.laby.client.managed.ui;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.text.client.DateTimeFormatRenderer;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.AbstractSafeHtmlRenderer;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.text.shared.SafeHtmlRenderer;
import java.util.HashSet;
import java.util.Set;
import org.laby.client.managed.request.BonusProxy;
import org.laby.client.managed.request.NiveauProxy;
import org.laby.client.scaffold.ScaffoldMobileApp;
import org.laby.client.scaffold.ui.MobileProxyListView;

public abstract class BonusMobileListView_Roo_Gwt extends MobileProxyListView<BonusProxy> {

    protected Set<String> paths = new HashSet<String>();

    public BonusMobileListView_Roo_Gwt(String buttonText, SafeHtmlRenderer<org.laby.client.managed.request.BonusProxy> renderer) {
        super(buttonText, renderer);
    }

    public void init() {
        paths.add("id");
        paths.add("version");
    }
}