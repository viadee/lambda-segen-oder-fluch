package de.viadee.lambda.codeexamples.lesbarkeit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class QueryCollections2 extends QueryCollections1 {

	@Test
	@Override
	public void testGroupAlbumTracksByNumber() {
		// Merge tracks from all albums
		Stream<Track> allTracks = allTracksFromAllAlbums(albums);
		
		// Group album tracks by number
		Map<Integer, List<Track>> tracksByNumber = groupTracksByNumber(allTracks);
		assertTracksByNumber(tracksByNumber);
	}
	
	@Test
	public void testAllTracksFromAllAlbums() {
		List<Track> trackList = allTracksFromAllAlbums(albums).collect(Collectors.toList());
		assertEquals(8, trackList.size());
		assertTrue(trackList.containsAll(tracks));
	}

	private Map<Integer, List<Track>> groupTracksByNumber(Stream<Track> allTracks) {
		return allTracks.collect(
				Collectors.groupingBy(Track::getNumber));
	}

	private Stream<Track> allTracksFromAllAlbums(List<Album> albums) {
		return albums.stream().flatMap(album -> album.getTracks().stream());
	}

}
