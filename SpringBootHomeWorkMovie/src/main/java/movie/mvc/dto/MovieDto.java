package movie.mvc.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity //create table
@Table(name="mycine") //테이블명
@Data //getter setter
public class MovieDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int num;
	
	@Column
	private String title;
	
	@Column
	private String poster;
	
	@Column
	private String director;
	
	@Column
	private String opendate;

}