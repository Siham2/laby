// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.laby.model;

import java.lang.String;

privileged aspect CaseElement_Roo_ToString {
    
    public String CaseElement.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PosX: ").append(getPosX()).append(", ");
        sb.append("PosY: ").append(getPosY()).append(", ");
        sb.append("ImageY: ").append(getImageY()).append(", ");
        sb.append("ImageX: ").append(getImageX()).append(", ");
        sb.append("Type: ").append(getType()).append(", ");
        sb.append("Niveau: ").append(getNiveau());
        return sb.toString();
    }
    
}
