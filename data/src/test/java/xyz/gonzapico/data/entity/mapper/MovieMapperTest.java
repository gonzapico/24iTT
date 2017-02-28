package xyz.gonzapico.data.entity.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Response;
import xyz.gonzapico.data.entity.GenreEntity;
import xyz.gonzapico.data.entity.MovieAPIGenre;
import xyz.gonzapico.entity.GenreDomainEntity;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by gfernandez on 28/02/17.
 */
public class MovieMapperTest {
  private static final int FAKE_GENRE_ID = 111;
  private static final String FAKE_NAME = "Adventure";

  private MovieMapper movieMapper;

  @Before public void setUp() throws Exception {
    movieMapper = new MovieMapper();
  }

  @Test public void transformToListOfGenres() throws Exception {
    MovieAPIGenre mockUserEntityOne = mock(MovieAPIGenre.class);
    GenreEntity mockGenreEntityOne = mock(GenreEntity.class);
    GenreEntity mockGenreEntityTwo = mock(GenreEntity.class);
    List<GenreEntity> genreEntityList = new ArrayList<GenreEntity>(5);
    genreEntityList.add(mockGenreEntityOne);
    genreEntityList.add(mockGenreEntityTwo);
    mockUserEntityOne.setGenreEntityList(genreEntityList);

    Collection<GenreDomainEntity> genreCollection = movieMapper.transformToListOfGenres(Response.success(mockUserEntityOne));

    assertThat(genreCollection.toArray()[0], is(instanceOf(GenreDomainEntity.class)));
    assertThat(genreCollection.toArray()[1], is(instanceOf(GenreDomainEntity.class)));
    assertThat(genreCollection.size(), is(2));
  }
}