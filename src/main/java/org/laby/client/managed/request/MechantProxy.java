// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package org.laby.client.managed.request;

import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;

@RooGwtMirroredFrom("org.laby.model.Mechant")
@ProxyForName("org.laby.model.Mechant")
public interface MechantProxy extends EntityProxy {

    abstract Long getId();

    abstract Integer getVersion();

    abstract Integer getPosX();

    abstract Integer getPosY();

    abstract Integer getImageX();

    abstract Integer getImageY();

    abstract Integer getType();

    abstract NiveauProxy getNiveau();

    abstract void setId(Long id);

    abstract void setVersion(Integer version);

    abstract void setPosX(Integer posX);

    abstract void setPosY(Integer posY);

    abstract void setImageX(Integer imageX);

    abstract void setImageY(Integer imageY);

    abstract void setType(Integer type);

    abstract void setNiveau(NiveauProxy niveau);
}