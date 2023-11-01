package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.MemberDto;
import boot.data.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	@GetMapping("/member/myinfo")
	public ModelAndView memberform(@RequestParam String id) {
		
		ModelAndView mav=new ModelAndView();
		
		MemberDto dto=service.getDataById(id);
		
		mav.addObject("dto", dto);
		
		mav.setViewName("/member/myinfo");
		
		return mav;
	}
	
	@GetMapping("/member/list")
	public ModelAndView memberlist() {
		
		ModelAndView mav=new ModelAndView();
		
		List<MemberDto> list=service.getAllMembers();
		
		mav.addObject("list", list);
		mav.addObject("totalCount", list.size());
		
		mav.setViewName("/member/memberlist");
		
		return mav;
	}
	
	@GetMapping("/member/add")
	public String add() {
		return "/member/addform";
	}
	
	//아이디체크
	@GetMapping("/member/idcheck")
	@ResponseBody
	public Map<String, Integer> idcheck(@RequestParam String id) {
		
		Map<String, Integer> map=new HashMap<>();
		
		int check=service.getSerchId(id);
		
		map.put("count", check);	//0 or 1
		
		return map;
	}
	
	//insert(list로 가는데 admin이 아니면 gaipsuccess로 이동)
	@PostMapping("/member/insert")
	public String insert(@ModelAttribute MemberDto dto,
			MultipartFile myphoto,
			HttpSession session, Model model) {
		

		String path=session.getServletContext().getRealPath("/membersave");
		
		dto.setPhoto(myphoto.getOriginalFilename());
		
		try {
			myphoto.transferTo(new File(path+"/"+myphoto.getOriginalFilename()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("dto", dto);
		
		if(!dto.getId().equals("admin")) {
			service.insertMember(dto);
			return "/member/gaipsuccess";
		}
		else {
			service.insertMember(dto);
			return "redirect:list";
		}
	}
	
	//삭제는 ajax
	@GetMapping("/member/delete")
	@ResponseBody
	public void deleteMember(String num) {
		service.deleteMember(num);
	}
	
	@GetMapping("/member/deletemyinfo")
	public String deleteMyinfo(String num, HttpSession session) {
		service.deleteMember(num);
		
		session.removeAttribute("loginok");
		session.removeAttribute("myid");
		
		return "redirect:list";
	}
	
	
	//사진만 수정
	@PostMapping("/member/updatephoto")
	@ResponseBody
	public void photoupload(String num, MultipartFile photo, HttpSession session) {
		
		
		//업로드할 경로
		String path = session.getServletContext().getRealPath("/membersave");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = sdf.format(new Date())+photo.getOriginalFilename();
		
		//업로드
		try {
			photo.transferTo(new File(path+"/"+fileName));
			
			service.updatePhoto(fileName, num); //db사진 수정
			
			session.setAttribute("loginphoto", fileName); //session사진 수정
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@PostMapping("/member/updatemyinfo")
	@ResponseBody
	public void myinfoupdate(@ModelAttribute MemberDto mdto) {
		
		//MemberDto mdto =new MemberDto();
		/*
		 * mdto.setNum(loginnum); mdto.setName(loginname); mdto.setAddr(loginaddr);
		 * mdto.setEmail(loginemail); dto에 있는 변수명과 넘겨주는 변수의 이름을 갖게 하면 dto로 한 번에 불러올 수 있다
		 */ 
		service.updateMember(mdto);
	}
	
}