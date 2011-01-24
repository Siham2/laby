// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package org.laby.client.managed.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import java.util.Set;
import org.laby.client.managed.request.ApplicationRequestFactory;
import org.laby.client.managed.request.NiveauProxy;
import org.laby.client.managed.request.ScoreProxy;
import org.laby.client.scaffold.activity.IsScaffoldMobileActivity;
import org.laby.client.scaffold.place.ProxyDetailsView;
import org.laby.client.scaffold.place.ProxyDetailsView.Delegate;
import org.laby.client.scaffold.place.ProxyListPlace;
import org.laby.client.scaffold.place.ProxyPlace;
import org.laby.client.scaffold.place.ProxyPlace.Operation;

public abstract class ScoreDetailsActivity_Roo_Gwt extends AbstractActivity implements Delegate, IsScaffoldMobileActivity {

    protected ApplicationRequestFactory requests;

    protected EntityProxyId<ScoreProxy> proxyId;

    protected void find(Receiver<EntityProxy> callback) {
        requests.find(proxyId).with("niveau").fire(callback);
    }
}
