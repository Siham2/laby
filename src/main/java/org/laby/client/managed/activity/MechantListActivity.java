// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package org.laby.client.managed.activity;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.view.client.Range;
import java.util.List;
import org.laby.client.managed.request.ApplicationRequestFactory;
import org.laby.client.managed.request.MechantProxy;
import org.laby.client.managed.request.NiveauProxy;
import org.laby.client.scaffold.ScaffoldMobileApp;
import org.laby.client.scaffold.activity.IsScaffoldMobileActivity;
import org.laby.client.scaffold.place.AbstractProxyListActivity;
import org.laby.client.scaffold.place.ProxyListView;

public class MechantListActivity extends AbstractProxyListActivity<MechantProxy> implements IsScaffoldMobileActivity {

    private final ApplicationRequestFactory requests;

    public MechantListActivity(ApplicationRequestFactory requests, ProxyListView<org.laby.client.managed.request.MechantProxy> view, PlaceController placeController) {
        super(placeController, view, MechantProxy.class);
        this.requests = requests;
    }

    public Place getBackButtonPlace() {
        return ScaffoldMobileApp.ROOT_PLACE;
    }

    public String getBackButtonText() {
        return "Entities";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return "Mechants";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<java.util.List<org.laby.client.managed.request.MechantProxy>> createRangeRequest(Range range) {
        return requests.mechantRequest().findMechantEntries(range.getStart(), range.getLength());
    }

    protected void fireCountRequest(Receiver<Long> callback) {
        requests.mechantRequest().countMechants().fire(callback);
    }
}