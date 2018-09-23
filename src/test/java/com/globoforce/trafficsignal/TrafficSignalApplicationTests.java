package com.globoforce.trafficsignal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.globoforce.trafficsignal.service.TrafficSignalService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrafficSignalApplicationTests {
	
	@Autowired
	TrafficSignalService trafficSignalService;

	@Test
	public void contextLoads() {
	}

	@Test(expected= TimeoutException.class )
	public void testService() throws InterruptedException, ExecutionException, TimeoutException {

		final Runnable trafficSignal = new Thread() {
			  @Override 
			  public void run() { 
				  trafficSignalService.start(2000);
			  }
			};

			final ExecutorService executor = Executors.newSingleThreadExecutor();
			final Future future = executor.submit(trafficSignal);
			executor.shutdown(); // This does not cancel the already-scheduled task.
			future.get(10, TimeUnit.SECONDS);
	}
	
}
