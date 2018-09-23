package com.globoforce.trafficsignal.state;

import org.apache.log4j.Logger;

public class TrafficSignalRedState extends TrafficSignalState {

	private static final Logger logger = Logger.getLogger(TrafficSignalRedState.class);
	public TrafficSignalRedState(TrafficSignalContext trafficSignalContext) {
		super(trafficSignalContext, TrafficSignalStateName.RED);
	}

	@Override
	public void execute(final Integer pauseDuration) {
		
		logger.info("RED");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			logger.error("Failed to turn signal RED ", e);
		}
		this.trafficSignalContext.setTrafficSignalState(new TrafficSignalGreenState(this.trafficSignalContext));
	}
	
	
}
