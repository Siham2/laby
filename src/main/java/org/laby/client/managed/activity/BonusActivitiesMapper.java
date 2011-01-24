// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package org.laby.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.RequestContext;
import org.laby.client.managed.request.ApplicationRequestFactory;
import org.laby.client.managed.request.BonusProxy;
import org.laby.client.managed.request.BonusRequest;
import org.laby.client.managed.request.NiveauProxy;
import org.laby.client.managed.ui.BonusDetailsView;
import org.laby.client.managed.ui.BonusEditView;
import org.laby.client.managed.ui.BonusListView;
import org.laby.client.managed.ui.BonusMobileDetailsView;
import org.laby.client.managed.ui.BonusMobileEditView;
import org.laby.client.scaffold.ScaffoldApp;
import org.laby.client.scaffold.place.CreateAndEditProxy;
import org.laby.client.scaffold.place.FindAndEditProxy;
import org.laby.client.scaffold.place.ProxyPlace;

public class BonusActivitiesMapper {

    private final ApplicationRequestFactory requests;

    private final PlaceController placeController;

    public BonusActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new BonusDetailsActivity((EntityProxyId<BonusProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? BonusMobileDetailsView.instance() : BonusDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }

    @SuppressWarnings("unchecked")
    private EntityProxyId<org.laby.client.managed.request.BonusProxy> coerceId(ProxyPlace place) {
        return (EntityProxyId<BonusProxy>) place.getProxyId();
    }

    private Activity makeCreateActivity() {
        BonusEditView.instance().setCreating(true);
        final BonusRequest request = requests.bonusRequest();
        Activity activity = new CreateAndEditProxy<BonusProxy>(BonusProxy.class, request, ScaffoldApp.isMobile() ? BonusMobileEditView.instance() : BonusEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(BonusProxy proxy) {
                request.persist().using(proxy);
                return request;
            }
        };
        return new BonusEditActivityWrapper(requests, ScaffoldApp.isMobile() ? BonusMobileEditView.instance() : BonusEditView.instance(), activity, null);
    }

    private Activity makeEditActivity(ProxyPlace place) {
        BonusEditView.instance().setCreating(false);
        EntityProxyId<BonusProxy> proxyId = coerceId(place);
        Activity activity = new FindAndEditProxy<BonusProxy>(proxyId, requests, ScaffoldApp.isMobile() ? BonusMobileEditView.instance() : BonusEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(BonusProxy proxy) {
                BonusRequest request = requests.bonusRequest();
                request.persist().using(proxy);
                return request;
            }
        };
        return new BonusEditActivityWrapper(requests, ScaffoldApp.isMobile() ? BonusMobileEditView.instance() : BonusEditView.instance(), activity, proxyId);
    }
}