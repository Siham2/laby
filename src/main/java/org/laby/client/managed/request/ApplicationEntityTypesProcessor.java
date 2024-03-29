// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package org.laby.client.managed.request;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.google.gwt.requestfactory.shared.EntityProxy;

public abstract class ApplicationEntityTypesProcessor<T> {

    private final T defaultValue;

    private T result;

    public ApplicationEntityTypesProcessor() {
        defaultValue = null;
    }

    public ApplicationEntityTypesProcessor(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    public static Set<java.lang.Class<? extends com.google.gwt.requestfactory.shared.EntityProxy>> getAll() {
        Set<Class<? extends EntityProxy>> rtn = new HashSet<Class<? extends EntityProxy>>();
        rtn.add(NiveauProxy.class);
        rtn.add(ScoreProxy.class);
        return Collections.unmodifiableSet(rtn);
    }

    private static void process(org.laby.client.managed.request.ApplicationEntityTypesProcessor<?> processor, Class<?> clazz) {
        if (ScoreProxy.class.equals(clazz)) {
            processor.handleScore((ScoreProxy) null);
            return;
        }
        if (NiveauProxy.class.equals(clazz)) {
            processor.handleNiveau((NiveauProxy) null);
            return;
        }
     
        processor.handleNonProxy(null);
    }

    private static void process(org.laby.client.managed.request.ApplicationEntityTypesProcessor<?> processor, Object proxy) {
        if (proxy instanceof ScoreProxy) {
            processor.handleScore((ScoreProxy) proxy);
            return;
        }
        if (proxy instanceof NiveauProxy) {
            processor.handleNiveau((NiveauProxy) proxy);
            return;
        }
     
        processor.handleNonProxy(proxy);
    }

    public void handleNonProxy(Object object) {
    }

    public abstract void handleScore(ScoreProxy proxy);

    public abstract void handleNiveau(NiveauProxy proxy);


    public T process(Class<?> clazz) {
        setResult(defaultValue);
        ApplicationEntityTypesProcessor.process(this, clazz);
        return result;
    }

    public T process(Object proxy) {
        setResult(defaultValue);
        ApplicationEntityTypesProcessor.process(this, proxy);
        return result;
    }

    protected void setResult(T result) {
        this.result = result;
    }
}
