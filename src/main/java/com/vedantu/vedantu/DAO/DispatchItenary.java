package com.vedantu.vedantu.DAO;

import java.util.HashMap;
import java.util.Map;

public class DispatchItenary {
    private Map<String ,Map<String, OrderConfig>>dispatchMap = new HashMap<String ,Map<String, OrderConfig>>();

    public DispatchItenary() {
    }

    public DispatchItenary(Map<String, Map<String, OrderConfig>> dispatchMap) {
        this.dispatchMap = dispatchMap;
    }

    public Map<String, Map<String, OrderConfig>> getDispatchMap() {
        return dispatchMap;
    }

    public void setDispatchMap(Map<String, Map<String, OrderConfig>> dispatchMap) {
        this.dispatchMap = dispatchMap;
    }
}
