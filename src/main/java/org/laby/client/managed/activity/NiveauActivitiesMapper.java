// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package org.laby.client.managed.activity;

import org.laby.client.managed.request.ApplicationRequestFactory;
import org.laby.client.managed.request.NiveauProxy;
import org.laby.client.managed.request.NiveauRequest;
import org.laby.client.managed.ui.NiveauEditView;
import org.laby.client.managed.ui.NiveauMobileEditView;
import org.laby.client.scaffold.ScaffoldApp;
import org.laby.client.scaffold.laby.activity.LabyActivity;
import org.laby.client.scaffold.laby.ui.LabyView;
import org.laby.client.scaffold.place.CreateAndEditProxy;
import org.laby.client.scaffold.place.FindAndEditProxy;
import org.laby.client.scaffold.place.ProxyPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.RequestContext;

public class NiveauActivitiesMapper {

    private final ApplicationRequestFactory requests;

    private final PlaceController placeController;

    public NiveauActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new LabyActivity((EntityProxyId<NiveauProxy>) place.getProxyId(), requests, placeController,/* ScaffoldApp.isMobile() ? NiveauMobileDetailsView.instance() : */ LabyView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }

    @SuppressWarnings("unchecked")
    private EntityProxyId<org.laby.client.managed.request.NiveauProxy> coerceId(ProxyPlace place) {
        return (EntityProxyId<NiveauProxy>) place.getProxyId();
    }

    private Activity makeCreateActivity() {
        NiveauEditView.instance().setCreating(true);
        final NiveauRequest request = requests.niveauRequest();
        Activity activity = new CreateAndEditProxy<NiveauProxy>(NiveauProxy.class, request, ScaffoldApp.isMobile() ? NiveauMobileEditView.instance() : NiveauEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(NiveauProxy proxy) {
                request.persist().using(proxy);
                return request;
            }
        };
        return new NiveauEditActivityWrapper(requests, ScaffoldApp.isMobile() ? NiveauMobileEditView.instance() : NiveauEditView.instance(), activity, null);
    }

    private Activity makeEditActivity(ProxyPlace place) {
        NiveauEditView.instance().setCreating(false);
        EntityProxyId<NiveauProxy> proxyId = coerceId(place);
        Activity activity = new FindAndEditProxy<NiveauProxy>(proxyId, requests, ScaffoldApp.isMobile() ? NiveauMobileEditView.instance() : NiveauEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(NiveauProxy proxy) {
                NiveauRequest request = requests.niveauRequest();
                request.persist().using(proxy);
                return request;
            }
        };
        return new NiveauEditActivityWrapper(requests, ScaffoldApp.isMobile() ? NiveauMobileEditView.instance() : NiveauEditView.instance(), activity, proxyId);
    }
}
