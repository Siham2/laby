// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package org.laby.client.managed.ui;

import com.google.gwt.text.shared.AbstractRenderer;
import org.laby.client.managed.request.ApplicationEntityTypesProcessor;
import org.laby.client.managed.request.BonusProxy;
import org.laby.client.managed.request.CaseElementProxy;
import org.laby.client.managed.request.JoueurProxy;
import org.laby.client.managed.request.MechantProxy;
import org.laby.client.managed.request.NiveauProxy;
import org.laby.client.managed.request.ScoreProxy;
import org.laby.client.scaffold.place.ProxyListPlace;

public abstract class ApplicationListPlaceRenderer_Roo_Gwt extends AbstractRenderer<ProxyListPlace> {

    public String render(ProxyListPlace object) {
        return new ApplicationEntityTypesProcessor<String>() {

            @Override
            public void handleScore(ScoreProxy isNull) {
                setResult("Scores");
            }

            @Override
            public void handleNiveau(NiveauProxy isNull) {
                setResult("Niveaus");
            }

            @Override
            public void handleMechant(MechantProxy isNull) {
                setResult("Mechants");
            }

            @Override
            public void handleJoueur(JoueurProxy isNull) {
                setResult("Joueurs");
            }

            @Override
            public void handleCaseElement(CaseElementProxy isNull) {
                setResult("CaseElements");
            }

            @Override
            public void handleBonus(BonusProxy isNull) {
                setResult("Bonuss");
            }
        }.process(object.getProxyClass());
    }
}
