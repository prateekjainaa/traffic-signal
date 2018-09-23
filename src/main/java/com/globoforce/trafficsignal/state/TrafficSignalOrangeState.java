package com.globoforce.trafficsignal.state;

import org.apache.log4j.Logger;

public class TrafficSignalOrangeState extends TrafficSignalState {

	private static final Logger logger = Logger.getLogger(TrafficSignalOrangeState.class);
	public TrafficSignalOrangeState(TrafficSignalContext trafficSignalContext) {
		super(trafficSignalContext, TrafficSignalStateName.ORANGE);
		
	}

	@Override
	public void execute(final Integer pauseDuration) {
		
		logger.info("ORANGE");
		try {
			Thread.sleep(pauseDuration);
		} catch (InterruptedException e) {
			logger.error("Failed to signal ORANGE ", e);
		}
		this.trafficSignalContext.setTrafficSignalState(new TrafficSignalRedState(this.trafficSignalContext));
	}
	
	
}
