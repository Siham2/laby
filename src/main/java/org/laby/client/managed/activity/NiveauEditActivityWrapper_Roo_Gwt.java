// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package org.laby.client.managed.activity;

import org.laby.client.managed.activity.NiveauEditActivityWrapper.View;
import org.laby.client.managed.request.ApplicationRequestFactory;
import org.laby.client.managed.request.NiveauProxy;
import org.laby.client.scaffold.activity.IsScaffoldMobileActivity;
import org.laby.client.scaffold.place.ProxyEditView;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public abstract class NiveauEditActivityWrapper_Roo_Gwt implements Activity, IsScaffoldMobileActivity {

    protected Activity wrapped;

    protected View<?> view;

    protected ApplicationRequestFactory requests;

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
       
        wrapped.start(display, eventBus);
    }

    public interface View_Roo_Gwt<V extends org.laby.client.scaffold.place.ProxyEditView<org.laby.client.managed.request.NiveauProxy, V>> extends ProxyEditView<NiveauProxy, V> {

       
    }
}
