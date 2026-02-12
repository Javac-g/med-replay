package com.medreplay.protocol;

import java.time.Instant;

public final class SignalEvent {

    private final Instant deviceTimestamp;
    private final Instant receivedTimestamp;

    private final String source;
    private final String type;

    private final double value;
    private final String unit;

    private final long sequence;

    public SignalEvent(
            Instant deviceTimestamp,
            Instant receivedTimestamp,
            String source,
            String type,
            double value,
            String unit,
            long sequence
    ) {
        this.deviceTimestamp = deviceTimestamp;
        this.receivedTimestamp = receivedTimestamp;
        this.source = source;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.sequence = sequence;
    }

    public Instant getDeviceTimestamp() {
        return deviceTimestamp;
    }

    public Instant getReceivedTimestamp() {
        return receivedTimestamp;
    }

    public String getSource() {
        return source;
    }

    public String getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public long getSequence() {
        return sequence;
    }

}
