package com.mantovanello.poc.frezze;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mantovanello.poc.frezze.controller.FetchSpotifyController;
import com.mantovanello.poc.frezze.controller.TrackRecommendationsController;

/**
 * @author Mantovanello
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FrezzeApplicationTests {

	@Autowired
    private FetchSpotifyController fetchSpotifyController;
	
	@Autowired
	private TrackRecommendationsController trackRecommendationsController;

    @Test
    public void contexLoads() throws Exception {
        assertThat(fetchSpotifyController).isNotNull();
        assertThat(trackRecommendationsController).isNotNull();
    }
}
