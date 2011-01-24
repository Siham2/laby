// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package org.laby.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.laby.client.managed.activity.CaseElementEditActivityWrapper.View;
import org.laby.client.managed.request.ApplicationRequestFactory;
import org.laby.client.managed.request.CaseElementProxy;
import org.laby.client.managed.request.NiveauProxy;
import org.laby.client.scaffold.activity.IsScaffoldMobileActivity;
import org.laby.client.scaffold.place.ProxyEditView;
import org.laby.client.scaffold.place.ProxyListPlace;
import org.laby.client.scaffold.place.ProxyPlace;

public abstract class CaseElementEditActivityWrapper_Roo_Gwt implements Activity, IsScaffoldMobileActivity {

    protected Activity wrapped;

    protected View<?> view;

    protected ApplicationRequestFactory requests;

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        view.setNiveauPickerValues(Collections.<NiveauProxy>emptyList());
        requests.niveauRequest().findNiveauEntries(0, 50).with(org.laby.client.managed.ui.NiveauProxyRenderer.instance().getPaths()).fire(new Receiver<List<NiveauProxy>>() {

            public void onSuccess(List<NiveauProxy> response) {
                List<NiveauProxy> values = new ArrayList<NiveauProxy>();
                values.add(null);
                values.addAll(response);
                view.setNiveauPickerValues(values);
            }
        });
        wrapped.start(display, eventBus);
    }

    public interface View_Roo_Gwt<V extends org.laby.client.scaffold.place.ProxyEditView<org.laby.client.managed.request.CaseElementProxy, V>> extends ProxyEditView<CaseElementProxy, V> {

        void setNiveauPickerValues(Collection<NiveauProxy> values);
    }
}