/*
 * Copyright 2014-2017 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.netflix.spectator.api;

/** Wraps another gauge allowing the underlying type to be swapped. */
final class SwapGauge implements Gauge {

  private volatile Gauge underlying;

  /** Create a new instance. */
  SwapGauge(Gauge underlying) {
    this.underlying = underlying;
  }

  void setUnderlying(Gauge g) {
    underlying = g;
  }

  @Override public Id id() {
    return underlying.id();
  }

  @Override public Iterable<Measurement> measure() {
    return underlying.measure();
  }

  @Override public boolean hasExpired() {
    return underlying.hasExpired();
  }

  @Override public void set(double value) {
    underlying.set(value);
  }

  @Override public double value() {
    return underlying.value();
  }
}
