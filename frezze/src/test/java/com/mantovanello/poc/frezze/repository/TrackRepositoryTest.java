/**
 * 
 */
package com.mantovanello.poc.frezze.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.mantovanello.poc.frezze.model.Track;
import com.mantovanello.poc.frezze.model.TrackId;

/**
 * @author Mantovanello
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TrackRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private TrackRepository trackRepository;

	@Test
	public void shouldFindNoTrackRecommendationsIfDatabaseIsEmpty() {
		Iterable<Track> tracks = trackRepository.findAll();

		assertThat(tracks).isEmpty();
	}

	@Test
	public void shouldSaveATrackRecommendation() {
		Track track = trackRepository.save(new Track(new TrackId("Mutter", "Rammstein", "Sonne"),
				"https://open.spotify.com/album/1CtTTpKbHU8KbHRB4LmBbv?si=pSEd5zRcSX-qloz1ybJDDA", "http://image",
				"2001", "year", "https://open.spotify.com/artist/6wWVKhxIU2cEi0K81v7HvP?si=21RowCo2TH6fGiCcufhHwA",
				Long.valueOf(272000), "https://open.spotify.com/track/3gVhsZtseYtY1fMuyYq06F?si=nGAbZ7yZQaW2edl8C189Rg",
				3));

		assertThat(track).hasFieldOrPropertyWithValue("trackId", new TrackId("Mutter", "Rammstein", "Sonne"));
	}

	@Test
	public void shouldFindAllTrackRecommendations() {
		Track trackRecommendation1 = new Track(new TrackId("Mutter", "Rammstein", "Sonne"),
				"https://open.spotify.com/album/1CtTTpKbHU8KbHRB4LmBbv?si=pSEd5zRcSX-qloz1ybJDDA", "http://image",
				"2001", "year", "https://open.spotify.com/artist/6wWVKhxIU2cEi0K81v7HvP?si=21RowCo2TH6fGiCcufhHwA",
				Long.valueOf(272000), "https://open.spotify.com/track/3gVhsZtseYtY1fMuyYq06F?si=nGAbZ7yZQaW2edl8C189Rg",
				3);

		Track trackRecommendation2 = new Track(new TrackId("Mutter", "Rammstein", "Feuer frei!"),
				"https://open.spotify.com/album/1CtTTpKbHU8KbHRB4LmBbv?si=pSEd5zRcSX-qloz1ybJDDA", "http://image",
				"2001", "year", "https://open.spotify.com/artist/6wWVKhxIU2cEi0K81v7HvP?si=21RowCo2TH6fGiCcufhHwA",
				Long.valueOf(189000), "https://open.spotify.com/track/5aNH8inF5BsbThDeOLs7zs?si=1RhJSXokQ7iILQG7JeBXTA",
				5);

		Track trackRecommendation3 = new Track(new TrackId("Mutter", "Rammstein", "Mutter"),
				"https://open.spotify.com/album/1CtTTpKbHU8KbHRB4LmBbv?si=pSEd5zRcSX-qloz1ybJDDA", "http://image",
				"2001", "year", "https://open.spotify.com/artist/6wWVKhxIU2cEi0K81v7HvP?si=21RowCo2TH6fGiCcufhHwA",
				Long.valueOf(269000), "https://open.spotify.com/track/7jfZybgHr6yzp4iuMS2K8u?si=oJ-F941kR9unJHHlk2Bb-g",
				6);

		entityManager.persist(trackRecommendation1);
		entityManager.persist(trackRecommendation2);
		entityManager.persist(trackRecommendation3);
		entityManager.flush();

		Iterable<Track> trackRecommendations = trackRepository.findAll();
		assertThat(trackRecommendations).hasSize(3).contains(trackRecommendation1, trackRecommendation2, trackRecommendation3);
	}

}
