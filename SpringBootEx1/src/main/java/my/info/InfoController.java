package my.info;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InfoController {
	
	@GetMapping("/my/info")
	@ResponseBody
	public HashMap<String, String> info(){
		HashMap<String, String> map = new HashMap<>();
		
		map.put("name", "위시온");
		map.put("age", "23");
		map.put("addr", "서울시 강남구");
		
		return map;
	}
}
