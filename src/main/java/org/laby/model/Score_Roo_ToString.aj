// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.laby.model;

import java.lang.String;

privileged aspect Score_Roo_ToString {
    
    public String Score.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Score: ").append(getScore()).append(", ");
        sb.append("Niveau: ").append(getNiveau());
        return sb.toString();
    }
    
}
