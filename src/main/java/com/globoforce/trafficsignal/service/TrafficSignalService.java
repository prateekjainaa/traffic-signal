package com.globoforce.trafficsignal.service;

/**
 * Entry point for Traffic Signal service.
 * @author Prateek Jain
 *
 */
public interface TrafficSignalService {
	
	/**
	 * This will start traffic signal service with specified pauseDuration in milli-seconds.
	 * @param pauseDuration
	 */
	void start(final Integer pauseDuration);
}
