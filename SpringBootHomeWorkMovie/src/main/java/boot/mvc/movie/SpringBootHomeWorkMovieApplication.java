package boot.mvc.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("movie.mvc.*")//패키지 등록
@EntityScan("movie.mvc.dto")//테이블이 어디에 있는지 dto 인식
@EnableJpaRepositories("movie.mvc.dao")//dao인식 movie라는 패키지에 있는 dao를 빈에 자동으로 넣어줌
public class SpringBootHomeWorkMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHomeWorkMovieApplication.class, args);
	}

}