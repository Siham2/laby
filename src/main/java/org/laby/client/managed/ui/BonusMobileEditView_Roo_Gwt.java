// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package org.laby.client.managed.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.requestfactory.client.RequestFactoryEditorDriver;
import com.google.gwt.requestfactory.shared.RequestFactory;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.LongBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.datepicker.client.DateBox;
import java.util.Collection;
import java.util.List;
import org.laby.client.managed.activity.BonusEditActivityWrapper;
import org.laby.client.managed.activity.BonusEditActivityWrapper.View;
import org.laby.client.managed.request.BonusProxy;
import org.laby.client.managed.request.NiveauProxy;
import org.laby.client.scaffold.place.ProxyEditView;
import org.laby.client.scaffold.ui.*;

public abstract class BonusMobileEditView_Roo_Gwt extends Composite implements View<BonusMobileEditView> {

    @UiField
    IntegerBox imageX;

    @UiField
    IntegerBox imageY;

    @UiField
    IntegerBox posY;

    @UiField
    IntegerBox posX;

    @UiField
    IntegerBox type;

    @UiField(provided = true)
    ValueListBox<NiveauProxy> niveau = new ValueListBox<NiveauProxy>(org.laby.client.managed.ui.NiveauProxyRenderer.instance(), new com.google.gwt.requestfactory.ui.client.EntityProxyKeyProvider<org.laby.client.managed.request.NiveauProxy>());

    public void setNiveauPickerValues(Collection<NiveauProxy> values) {
        niveau.setAcceptableValues(values);
    }
}
