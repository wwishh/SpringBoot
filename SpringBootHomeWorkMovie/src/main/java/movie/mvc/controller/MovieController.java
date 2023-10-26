package movie.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import movie.mvc.dao.MovieDao;
import movie.mvc.dto.MovieDto;

@Controller
@RequestMapping("/movie")
public class MovieController {

		@Autowired
		MovieDao dao;
		
		//list
		@GetMapping("/list")
		public ModelAndView list()
		{
			ModelAndView model = new ModelAndView();
			List<MovieDto>list = dao.getAllMovies();
			
			model.addObject("totalcount", list.size());
			model.addObject("list", list);
			
			model.setViewName("movielist");
			return model;
		}
		
		//addform
		@GetMapping("/writeform")
		public String addform()
		{
			return "addform";
		}
		//insert
		@PostMapping("/insert")
		public String insert(@ModelAttribute MovieDto dto,
				MultipartFile upload,
				HttpSession session)
		{
			String path=session.getServletContext().getRealPath("/moviephoto");
			System.out.println(path);
			
			dto.setPoster(upload.getOriginalFilename());
			
			//실제 업로드
			try {
				upload.transferTo(new File(path+"/"+upload.getOriginalFilename()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			dao.insertMovie(dto);
			
			return "redirect:list";
		}
		@GetMapping("detail")
		public String detail(int num, Model model)
		{
			MovieDto dto =dao.getData(num);
			model.addAttribute("dto", dto);
			return "detail";
		}
		
		
		
}