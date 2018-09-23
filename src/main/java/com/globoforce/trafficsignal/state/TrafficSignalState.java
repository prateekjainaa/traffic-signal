package com.globoforce.trafficsignal.state;

public abstract class TrafficSignalState {

	private TrafficSignalStateName trafficSignalStateName;
	protected TrafficSignalContext trafficSignalContext;

	public TrafficSignalState(TrafficSignalContext trafficSignalContext,
			TrafficSignalStateName trafficSignalStateName) {
		this.trafficSignalContext = trafficSignalContext;
		this.trafficSignalStateName = trafficSignalStateName;
	}

	public abstract void execute(final Integer pauseDuration);

	public TrafficSignalStateName getTrafficSignalStateName() {
		return this.trafficSignalStateName;
	}

}
