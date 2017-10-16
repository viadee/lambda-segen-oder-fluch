package de.viadee.lambda.codeexamples.lesbarkeit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class QueryCollections1 {

	protected Album nevermind;
	protected Album metallica;
	protected Album numberOfTheBeast;
	protected Track smells;
	protected Track bloom;
	protected Track come;
	protected Track sandman;
	protected Track sad;
	protected Track holier;
	protected Track invaders;
	protected Track children;
	protected List<Album> albums;
	protected List<Track> tracks;

	@Before
	public void setUp() {
		nevermind = new Album();
		nevermind.setName("Nevermind");
		smells = new Track("Smells Like Teen Sprit", 1);
		bloom = new Track("In Bloom", 2);
		come = new Track("Come As You Are", 3);
		nevermind.setTracks(Arrays.asList(smells, bloom, come));
		metallica = new Album();
		metallica.setName("Metallica (The Black Album)");
		sandman = new Track("Enter Sandman", 1);
		sad = new Track("Sad But True", 2);
		holier = new Track("Holier Than Thou", 3);
		metallica.setTracks(Arrays.asList(sandman, sad, holier));
		numberOfTheBeast = new Album();
		numberOfTheBeast.setName("The Number of the Beast");
		invaders = new Track("Invaders", 1);
		children = new Track("Children of the Damned", 2);
		numberOfTheBeast.setTracks(Arrays.asList(invaders, children));

		albums = Arrays.asList(nevermind, metallica, numberOfTheBeast);
		tracks = Arrays.asList(smells, bloom, come, sandman, sad, holier, invaders, children);
	}

	@Test
	public void testGroupAlbumTracksByNumber() {
		// Group album tracks by number
		Map<Integer, List<Track>> tracksByNumber = albums.stream().flatMap(album -> album.getTracks().stream())
				.collect(Collectors.groupingBy(Track::getNumber));
		assertTracksByNumber(tracksByNumber);
	}

	protected void assertTracksByNumber(Map<Integer, List<Track>> tracksByNumber) {
		// Number 1
		assertEquals(3, tracksByNumber.get(1).size());
		assertTrue(tracksByNumber.get(1).containsAll(Arrays.asList(smells, sandman, invaders)));
		// Number 2
		assertEquals(3, tracksByNumber.get(2).size());
		assertTrue(tracksByNumber.get(2).containsAll(Arrays.asList(bloom, sad, children)));
		// Number 3
		assertEquals(2, tracksByNumber.get(3).size());
		assertTrue(tracksByNumber.get(3).containsAll(Arrays.asList(come, holier)));
	}

	protected class Album {
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Track> getTracks() {
			return tracks;
		}

		public void setTracks(List<Track> tracks) {
			this.tracks = tracks;
		}

		private String name;
		private List<Track> tracks;
	}

	protected class Track {
		public Track(String name, Integer number) {
			this.name = name;
			this.number = number;
		}

		private String name;

		public String getName() {
			return name;
		}

		private Integer number;

		public Integer getNumber() {
			return number;
		}

	}

}
