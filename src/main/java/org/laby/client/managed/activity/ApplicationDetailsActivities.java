// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package org.laby.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import org.laby.client.managed.request.ApplicationEntityTypesProcessor;
import org.laby.client.managed.request.ApplicationRequestFactory;
import org.laby.client.managed.request.BonusProxy;
import org.laby.client.managed.request.CaseElementProxy;
import org.laby.client.managed.request.JoueurProxy;
import org.laby.client.managed.request.MechantProxy;
import org.laby.client.managed.request.NiveauProxy;
import org.laby.client.managed.request.ScoreProxy;
import org.laby.client.scaffold.place.ProxyPlace;

public class ApplicationDetailsActivities extends ApplicationDetailsActivities_Roo_Gwt {

    @Inject
    public ApplicationDetailsActivities(ApplicationRequestFactory requestFactory, PlaceController placeController) {
        this.requests = requestFactory;
        this.placeController = placeController;
    }
}
