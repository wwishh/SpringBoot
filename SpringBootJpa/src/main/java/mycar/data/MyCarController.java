package mycar.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/car")
public class MyCarController {
	
	@Autowired
	MyCarDao dao;
	
	@GetMapping("/carlist") //시작
	public ModelAndView list() {
		
		ModelAndView model = new ModelAndView();
		
		List<MyCarDto> list = dao.getAllDatas();
		
		model.addObject("list", list);
		model.addObject("totalCount", list.size());
		
		model.setViewName("carlist");
		return model;
	}
	
	@GetMapping("/carform")
	public String form() {
		return "addform";
	}
	
	//insert
	@PostMapping("/insert")
	public String insertMyCar(MyCarDto dto) {
		
		dao.insertMyCar(dto);
		
		return "redirect:carlist";
	}
	
	@GetMapping("/updateform")
	public ModelAndView getDataMyCar(Long num) {
		ModelAndView model = new ModelAndView();
		
		MyCarDto dto = dao.getData(num);
		
		model.addObject("dto",dto);
		
		model.setViewName("uform");
		
		return model;
	}
	
	@PostMapping("/update")
	public String updateMyCar(MyCarDto dto) {
		dao.updateMyCar(dto);
		
		return "redirect:carlist";
	}
	
	
	@GetMapping("/delete")
	public String deleteMyCar(Long num) {
		dao.deleteMyCar(num);
		
		return "redirect:carlist";
	}
	 
}
