# med-replay

Device-agnostic medical signal ingestion, immutable storage, and deterministic replay engine designed to preserve the exact historical truth of vital data streams.

This project focuses on **reliability, traceability, and deterministic reconstruction** of medical device signals such as heart rate, SpO₂, and other vital measurements.

---

## Purpose

Medical monitoring systems often display real-time data but fail to preserve the exact sequence of events required for:

* incident investigation
* system debugging
* reliability analysis
* training and simulation
* protocol validation

`med-replay` solves this by capturing vital signals as an **immutable event stream** and allowing deterministic replay of recorded data.

This ensures that historical system state can be reconstructed exactly as observed.

---

## Core Principles

### 1. Event-based, not state-based

The system stores events, not current values.

Instead of:

```
heart_rate = 72
```

we store:

```
heart_rate event at precise time with full context
```

This allows complete reconstruction of the system timeline.

---

### 2. Immutable storage

Recorded data is never modified or deleted.

This guarantees:

* auditability
* reproducibility
* integrity

---

### 3. Deterministic replay

Replay produces the exact same sequence and timing of events as originally observed.

This enables:

* debugging of historical failures
* simulation of real device behavior
* validation of downstream systems

---

### 4. Device-agnostic architecture

The system does not depend on specific hardware vendors.

Any device or simulator that emits structured signals can be integrated.

Supported input sources will include:

* TCP streams
* serial devices
* simulated signal generators
* vendor SDK integrations

---

## Architecture Overview

```
Device / Simulator
        │
        ▼
Ingestion Layer
        │
        ▼
Validation & Normalization
        │
        ▼
Immutable Event Store
        │
        ├── Live consumption
        │
        └── Replay Engine
```

---

## Project Structure

```
med-replay/
├── simulator/     # Signal generators for testing
├── ingestion/     # Input handling and parsing
├── protocol/      # Signal protocol definitions
├── storage/       # Immutable event storage
├── replay/        # Deterministic replay engine
├── tests/         # Determinism and integrity tests
└── docs/          # Design and protocol documentation
```

---

## Example Event

```json
{
  "timestamp_device": "2026-02-10T12:01:03.421Z",
  "timestamp_received": "2026-02-10T12:01:03.438Z",
  "source": "simulator-01",
  "type": "HEART_RATE",
  "value": 72,
  "unit": "bpm",
  "sequence": 18421,
  "quality": "OK"
}
```

---

## Planned Features

* Signal simulator
* TCP and serial ingestion
* Protocol validation and corruption detection
* Immutable append-only storage
* Deterministic replay engine
* Replay speed control
* Fault injection simulation
* Clock drift handling

---

## Non-Goals

This project does not perform:

* medical diagnosis
* clinical decision making
* signal processing for medical interpretation

It is focused solely on **data integrity and reproducibility**.

---

## Technology Stack

* Java 17+
* Append-only storage model
* Deterministic event processing
* Protocol-driven architecture

---

## Status

Early development.

Protocol and simulator implementation planned first.

---

## Motivation

Reliable historical reconstruction of system state is essential in safety-critical environments. This project aims to provide a clean, deterministic foundation for signal ingestion and replay systems.

---

## License

TBD
