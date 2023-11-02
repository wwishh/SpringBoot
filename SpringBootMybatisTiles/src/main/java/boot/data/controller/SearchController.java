package boot.data.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.data.mapper.IpgoMapperInter;

@Controller
public class SearchController {
	
	@Autowired
	IpgoMapperInter immaInter;
	
	@GetMapping("/search/main")
	public String search() {
		return "/search/sangsearch";
	}
	
	@GetMapping("/search/result1")
	@ResponseBody
	public List<String> result1(String sangpum) {
		List<String> list = new ArrayList<>();
		
		list = immaInter.selectSangname(sangpum);
		
		return list;
	}
}
