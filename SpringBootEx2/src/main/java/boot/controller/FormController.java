package boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boot.dto.PersonDto;

@Controller
public class FormController {
	
	@GetMapping("/sist/form1")
	public String form1() {
		return "form/form1";
	}
	
	@PostMapping("/sist/read1")
	public ModelAndView result1(String irum, int java, int spring) {
		ModelAndView model = new ModelAndView();
		
		int total = java + spring;
		double avg = total/2;
		
		model.addObject("irum", irum);
		model.addObject("java", java);
		model.addObject("spring", spring);
		model.addObject("total", total);
		model.addObject("avg", avg);
		
		model.setViewName("result/result1");
		
		return model;
	}
	
	@GetMapping("/sist/form2")
	public String form2() {
		return "form/form2";
	}
	
	//dto
	@PostMapping("/sist/write2")
	public ModelAndView result2(PersonDto dto) {
		ModelAndView model = new ModelAndView();
		
		model.addObject("dto", dto);
		
		model.setViewName("result/result2");
		
		return model;
	}
	
	@GetMapping("/sist/form3")
	public String form3() {
		return "form/form3";
	}
	
	//map으로 읽을경우 폼의 name이 key값으로 입력값은 value
	@PostMapping("/sist/map3")
	public ModelAndView result3(@RequestParam Map<String, String> map) {
		ModelAndView model = new ModelAndView();
		
		String name = map.get("name");
		String blood = map.get("blood");
		String age = map.get("age");
			
		model.addObject("name", name);
		model.addObject("blood", blood);
		model.addObject("age", age);
		
		model.setViewName("result/result3");
		
		return model;
	}
}
