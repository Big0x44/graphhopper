package com.graphhopper.routing.util.parsers;

import com.graphhopper.reader.ReaderWay;
import com.graphhopper.routing.ev.EnumEncodedValue;
import com.graphhopper.routing.ev.Psv;
import com.graphhopper.storage.IntsRef;

public class OSMPsvParser implements TagParser {
    EnumEncodedValue<Psv> psvEnc;

    public OSMPsvParser(EnumEncodedValue<Psv> psvEnc) {
        this.psvEnc = psvEnc;
    }

    @Override
    public void handleWayTags(IntsRef edgeFlags, ReaderWay way, IntsRef relationFlags) {
        psvEnc.setEnum(false, edgeFlags, Psv.find(way.getTag(Psv.KEY)));
    }
}
