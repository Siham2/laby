package org.laby.client.scaffold.gae;

import org.laby.client.scaffold.ui.LoginWidget;
import org.laby.shared.gae.GaeUser;
import org.laby.shared.gae.GaeUserServiceRequest;
import org.laby.shared.gae.MakesGaeRequests;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.user.client.Window.Location;

/**
 * Makes GAE requests to drive a LoginWidget.
 */
public class GaeLoginWidgetDriver {
	private final MakesGaeRequests requests;

	public GaeLoginWidgetDriver(MakesGaeRequests requests) {
		this.requests = requests;
	}

	public void setWidget(final LoginWidget widget) {

		GaeUserServiceRequest request = requests.userServiceRequest();

		request.createLogoutURL(Location.getHref()).to(new Receiver<String>() {
			public void onSuccess(String response) {
				widget.setLogoutUrl(response);
			}
		});

		request.getCurrentUser().to(new Receiver<GaeUser>() {
			@Override
			public void onSuccess(GaeUser response) {
				widget.setUserName(response.getNickname());
			}
		});

		request.fire();
	}
}
