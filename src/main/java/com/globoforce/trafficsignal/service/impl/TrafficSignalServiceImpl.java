package com.globoforce.trafficsignal.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.globoforce.trafficsignal.service.TrafficSignalService;
import com.globoforce.trafficsignal.state.TrafficSignalContext;
import com.globoforce.trafficsignal.state.TrafficSignalGreenState;
import com.globoforce.trafficsignal.state.TrafficSignalState;

/**
 * Default implementation of {@link TrafficSignalService}
 * @author Prateek Jain
 *
 */
@Service("trafficSignalService")
public class TrafficSignalServiceImpl implements TrafficSignalService, TrafficSignalContext {

	private static final Logger logger = Logger.getLogger(TrafficSignalServiceImpl.class);
	//Can't be inject by spring as, states have cyclic dependency.
	private TrafficSignalState trafficSignalState;
	
	@Override
	public void start(Integer pauseDuration) {
		this.trafficSignalState = new TrafficSignalGreenState(this);
		this.setTrafficSignalState(this.trafficSignalState);
		logger.info("\n\nStarted Traffic signal with light "+ this.trafficSignalState.getTrafficSignalStateName().name() );
		while (true) {
			/** TODO fetch pauseDuration from DB like,
			 myDbService.getCurrentDuration(); */
			this.trafficSignalState.execute(pauseDuration);
		}
	}

	@Override
	public void setTrafficSignalState(TrafficSignalState trafficSignalState) {
		this.trafficSignalState = trafficSignalState;
	}

}
