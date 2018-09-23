package com.globoforce.trafficsignal.state;

import com.globoforce.trafficsignal.service.TrafficSignalService;

/**
 * Maintains context for {@link TrafficSignalService}
 * @author Prateek Jain.
 *
 */
public interface TrafficSignalContext {
	
	void setTrafficSignalState(TrafficSignalState trafficSignalState);
}
