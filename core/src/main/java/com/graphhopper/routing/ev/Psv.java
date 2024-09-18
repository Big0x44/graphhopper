package com.graphhopper.routing.ev;

import com.graphhopper.util.Helper;

/**
 * This enum defines the road access of an edge. Most edges are accessible from everyone and so the default value is
 * YES. But some have restrictions like "accessible only for customers" or when delivering. Unknown tags will get the
 * value OTHER. The NO value does not permit any access.
 */
public enum Psv {
    MISSING("missing"), YES("yes"), DESIGNATED("designated"), NO("no");

    public static final String KEY = "psv";

    private final String name;

    Psv(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Psv find(String name) {
        if (name == null)
            return MISSING;
        try {
            return Psv.valueOf(Helper.toUpperCase(name));
        } catch (IllegalArgumentException ex) {
            return MISSING;
        }
    }
}
