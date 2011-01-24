// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package org.laby.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.RequestContext;
import org.laby.client.managed.request.ApplicationRequestFactory;
import org.laby.client.managed.request.CaseElementProxy;
import org.laby.client.managed.request.CaseElementRequest;
import org.laby.client.managed.request.NiveauProxy;
import org.laby.client.managed.ui.CaseElementDetailsView;
import org.laby.client.managed.ui.CaseElementEditView;
import org.laby.client.managed.ui.CaseElementListView;
import org.laby.client.managed.ui.CaseElementMobileDetailsView;
import org.laby.client.managed.ui.CaseElementMobileEditView;
import org.laby.client.scaffold.ScaffoldApp;
import org.laby.client.scaffold.place.CreateAndEditProxy;
import org.laby.client.scaffold.place.FindAndEditProxy;
import org.laby.client.scaffold.place.ProxyPlace;

public class CaseElementActivitiesMapper {

    private final ApplicationRequestFactory requests;

    private final PlaceController placeController;

    public CaseElementActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new CaseElementDetailsActivity((EntityProxyId<CaseElementProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? CaseElementMobileDetailsView.instance() : CaseElementDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }

    @SuppressWarnings("unchecked")
    private EntityProxyId<org.laby.client.managed.request.CaseElementProxy> coerceId(ProxyPlace place) {
        return (EntityProxyId<CaseElementProxy>) place.getProxyId();
    }

    private Activity makeCreateActivity() {
        CaseElementEditView.instance().setCreating(true);
        final CaseElementRequest request = requests.caseElementRequest();
        Activity activity = new CreateAndEditProxy<CaseElementProxy>(CaseElementProxy.class, request, ScaffoldApp.isMobile() ? CaseElementMobileEditView.instance() : CaseElementEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(CaseElementProxy proxy) {
                request.persist().using(proxy);
                return request;
            }
        };
        return new CaseElementEditActivityWrapper(requests, ScaffoldApp.isMobile() ? CaseElementMobileEditView.instance() : CaseElementEditView.instance(), activity, null);
    }

    private Activity makeEditActivity(ProxyPlace place) {
        CaseElementEditView.instance().setCreating(false);
        EntityProxyId<CaseElementProxy> proxyId = coerceId(place);
        Activity activity = new FindAndEditProxy<CaseElementProxy>(proxyId, requests, ScaffoldApp.isMobile() ? CaseElementMobileEditView.instance() : CaseElementEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(CaseElementProxy proxy) {
                CaseElementRequest request = requests.caseElementRequest();
                request.persist().using(proxy);
                return request;
            }
        };
        return new CaseElementEditActivityWrapper(requests, ScaffoldApp.isMobile() ? CaseElementMobileEditView.instance() : CaseElementEditView.instance(), activity, proxyId);
    }
}