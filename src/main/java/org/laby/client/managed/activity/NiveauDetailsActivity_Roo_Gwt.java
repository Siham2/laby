// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package org.laby.client.managed.activity;

import org.laby.client.managed.request.ApplicationRequestFactory;
import org.laby.client.managed.request.NiveauProxy;
import org.laby.client.scaffold.activity.IsScaffoldMobileActivity;
import org.laby.client.scaffold.place.ProxyDetailsView.Delegate;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.Receiver;

public abstract class NiveauDetailsActivity_Roo_Gwt extends AbstractActivity implements Delegate, IsScaffoldMobileActivity {

    protected ApplicationRequestFactory requests;

    protected EntityProxyId<NiveauProxy> proxyId;

    protected void find(Receiver<EntityProxy> callback) {
        requests.find(proxyId).with("bonus", "vilains", "cases", "joueur").fire(callback);
    }
}
