package boot.data.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.MbanswerDto;
import boot.data.mapper.MbanswerMapperInter;
import boot.data.service.MemberService;

@RestController
@RequestMapping("/mbanswer")
public class MbanswerController {
	
	@Autowired
	MbanswerMapperInter mapper;
	
	MemberService mservice;
	
	
	@PostMapping("/ainsert")
	public void insert(@ModelAttribute MbanswerDto mbdto) { //forward 없이 함 (리턴값없음) 

		mapper.insertMbanswer(mbdto);
		
	}
	
	@GetMapping("/alist")
	public List<MbanswerDto> select(String num) {
		List<MbanswerDto> list = new ArrayList<>();
		
		list = mapper.getAllAnswers(num);
		
		return list;
	}
}
