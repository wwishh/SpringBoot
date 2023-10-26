package movie.mvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import movie.mvc.dto.MovieDto;

@Repository
public class MovieDao {
	
	@Autowired
	MovieDaoInter inter;
	
	//insert
	public void insertMovie(MovieDto dto)
	{
		inter.save(dto);
	}
	//list
	public List<MovieDto>getAllMovies()
	{
		return inter.findAll(Sort.by(Sort.Direction.DESC,"num"));
	}
	//getdata
	public MovieDto getData(int num)
	{
		return inter.getReferenceById(num);
	}
	//update 
	public void updateMovie(MovieDto dto)
	{
		inter.save(dto);
	}
	//delete
	public void deleteMovie(int num)
	{
		inter.deleteById(num);
	}
	
}