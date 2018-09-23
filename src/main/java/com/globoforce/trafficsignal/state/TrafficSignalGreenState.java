package com.globoforce.trafficsignal.state;

import org.apache.log4j.Logger;

public class TrafficSignalGreenState extends TrafficSignalState {

	private static final Logger logger = Logger.getLogger(TrafficSignalGreenState.class);
	public TrafficSignalGreenState(TrafficSignalContext trafficSignalContext) {
		super(trafficSignalContext, TrafficSignalStateName.GREEN);
	}

	@Override
	public void execute(final Integer pauseDuration) {
		
		logger.info("GREEN");
		try {
			Thread.sleep(pauseDuration);
		} catch (InterruptedException e) {
			
			logger.error("Failed to signal GREEN ", e);
		}
		this.trafficSignalContext.setTrafficSignalState(new TrafficSignalOrangeState(this.trafficSignalContext));
		
	}
}
