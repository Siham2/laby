// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package org.laby.client.managed.ui;

import org.laby.client.managed.activity.NiveauEditActivityWrapper.View;

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.TextBox;

public abstract class NiveauEditView_Roo_Gwt extends Composite implements View<NiveauEditView> {


    @UiField
    TextBox nom;

    @UiField
    TextBox canvaCouloir;

    @UiField
    TextBox canvaMur;

    @UiField
    TextBox canvaBonus;

    @UiField
    TextBox canvaSortie;

    @UiField
    TextBox canvaMechants;

    @UiField
    IntegerBox tailleX;

    @UiField
    IntegerBox tailleY;

}
