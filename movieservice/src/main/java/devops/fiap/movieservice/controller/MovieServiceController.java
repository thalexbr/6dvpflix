package devops.fiap.movieservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import devops.fiap.movieservice.entity.Movie;
import devops.fiap.movieservice.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(value = "/v1/movieservice")
@Api(value="Serviço de Filmes")
public class MovieServiceController {

	@Autowired
	private MovieService movieService;
	
	
	@ApiOperation(value="Mostra o filme por ID")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message="Filme encontrado"),
			@ApiResponse(code = 404, message="Filme não encontrado"),
	})
	@RequestMapping(value = "/{movieID}", method = RequestMethod.GET)
	public Movie getMovie(@PathVariable(name = "movieID") int movieID) {
		Movie movie = movieService.getMovie(movieID);
		return movie;
	}
	
	@ApiOperation(value="Lista deTodos os Filmes")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message="Lista de filmes encontrados"),
			@ApiResponse(code = 404, message="Nenhum filme encontrado"),
	})
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Movie> getAllMovies() {
		List<Movie> movies = movieService.getAllMovies();
		return movies;
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value="Inserir filmes em lote", notes="Insere uma lista de filmes no catálogo", response = Movie.class)
	@ApiResponses({
		@ApiResponse(code = 201, message="Criados com sucesso!")
	})
	@RequestMapping(value = "/create/batch",method = RequestMethod.PUT)
	public ResponseEntity<?> batchCreate(@RequestBody List<Movie> movies) {

		movies = movieService.batchCreate(movies);
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}
	
	
	@ApiOperation(value="Lista de Filmes por Gênero")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message="Lista de filmes encontrados"),
			@ApiResponse(code = 404, message="Nenhum filme encontrado"),
	})	
	@RequestMapping(value = "/genre/{genre}", method = RequestMethod.GET)
	public List<Movie> getMovie(@PathVariable(name = "genre") String genre) {
		List<Movie> movies = movieService.getMoviesByGenre(genre);
		return movies;
	}
	
	@ApiOperation(value="Lista de Filmes mais assistidos por Gênero")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message="Lista de filmes mais assistidos por Gênero"),
			@ApiResponse(code = 404, message="Nenhum filme encontrado"),
	})
	@RequestMapping(value = "/mostviews/genre/{genre}", method = RequestMethod.GET)
	public Movie getMostViewedMoviesByGenre(@PathVariable(name = "genre") String genre) {
		Movie movies = movieService.getMostViewedMoviesByGenre(genre);
		return movies;
	}
	
	@ApiOperation(value="Lista de Filmes mais assistidos")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message="Lista de filmes mais assistidos"),
			@ApiResponse(code = 404, message="Nenhum filme encontrado"),
	})
	@RequestMapping(value = "/mostviews", method = RequestMethod.GET)
	public List<Movie> getMostViewedMoviesByGenre() {
		List<Movie> movies = movieService.getMostViewedMoviesByGenre();
		return movies;
	}
	
	@ApiOperation(value="Marcar um filme como assistido")
	@ApiResponses(value= {
			@ApiResponse(code = 201, message="Marcado com sucesso!"),			
	})
	@RequestMapping(value = "/addview",method = RequestMethod.PUT)
	public ResponseEntity<?> addView(@RequestBody Movie movie) {

		movie = movieService.addView(movie);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value="Criação de um novo filme", notes="Insere um novo filme no catálogo", response = Movie.class)
	@ApiResponses({
		@ApiResponse(code = 201, message="Novo filme criado!")
	})
	@RequestMapping(value = "/create",method = RequestMethod.PUT)
	public ResponseEntity<?> createMovie(@RequestBody Movie movie) {

		movie = movieService.createMovie(movie);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	

}