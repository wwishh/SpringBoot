package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.MemBoardDto;
import boot.data.service.MemBoardService;
import boot.data.service.MemberService;

@Controller
@RequestMapping("/memboard")
public class MemBoardController {

	@Autowired
	MemBoardService service;

	@Autowired
	MemberService mservice;

	@GetMapping("/list")
	public ModelAndView list(@RequestParam(defaultValue = "1") int currentPage) {
		/*
		 * ModelAndView model = new ModelAndView();
		 * 
		 * int totalCount = service.getTotalCount();
		 * 
		 * model.addObject("totalCount", totalCount);
		 * model.setViewName("/memboard/memlist");
		 */

		ModelAndView model = new ModelAndView();

		// 페이징 처리에 필요한 변수 선언
		int totalCount = service.getTotalCount(); // 전체객수
		int totalPage; // 총 페이지수
		int startPage; // 각블럭에서 보여질 시작페이지
		int endPage; // 각블럭에서 보여질 끝페이지
		int startNum; // db에서 가져올 글의 시작번호(mysql은 첫글이 0,오라클은 1)
		int perPage = 3; // 한페이지당 보여질 글의 갯수
		int perBlock = 5; // 한블럭당 보여질 페이지 개수

		// 총페이지수 구하기
		// 총글의 갯수/한페이지당 보여질 개수로 나눔(7/5=1)
		// 나머지가 1이라도 있으면 무조건 1페이지 추가(1+1=2페이지가 필요)
		totalPage = totalCount / perPage + (totalCount % perPage == 0 ? 0 : 1);

		// 각블럭당 보여야할 시작페이지
		// perBlock=5일경우는 현재페이지 1~5 시작:1 끝:5
		// 현재페이지 13 시작:11 끝:15
		startPage = (currentPage - 1) / perBlock * perBlock + 1;

		endPage = startPage + perBlock - 1;

		// 총페이지가 23일경우 마지막블럭은 25가아니라 23이다
		if (endPage > totalPage)
			endPage = totalPage;

		// 각페이지에서 보여질 시작번호
		// 1페이지: 0,2페이지:5 3페이지:10....
		startNum = (currentPage - 1) * perPage;

		// 각페이지당 출력할 시작번호 구하기 no
		// 총글개수가 23이면 1페이지 23,2페이지는 18,3페이지 13.....
		// 출력시 1씩 감소하며 출력
		int no = totalCount - (currentPage - 1) * perPage;

		// 각 페이지에서 필요한 게시글 가져오기
		List<MemBoardDto> list = service.getList(startNum, perPage);

		/*
		 * //list의 각 글에 댓글 개수 표시 for(MemBoardDto d:list) {
		 * d.setAcount(service.getAnswerList(d.getNum()).size()); }
		 */

		model.addObject("totalCount", totalCount);
		model.addObject("startPage", startPage);
		model.addObject("endPage", endPage);
		model.addObject("totalPage", totalPage);
		model.addObject("no", no);
		model.addObject("currentPage", currentPage);
		model.addObject("list", list); // 댓글 포함 후 전달

		model.setViewName("/memboard/memlist");

		return model;
	}

	@GetMapping("/form")
	public String form() {
		return "/memboard/addform";
	}

	@PostMapping("insert")
	public String insert(MemBoardDto dto, HttpSession session) {

		String path = session.getServletContext().getRealPath("/savefile");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

		dto.setUploadfile(dto.getUpload().getOriginalFilename());

		if (dto.getUpload().getOriginalFilename().equals("")) {
			dto.setUploadfile("no");
		} else {

			String uploadFile = sdf.format(new Date()) + dto.getUpload().getOriginalFilename();
			dto.setUploadfile(uploadFile);

			try {
				dto.getUpload().transferTo(new File(path + "/" + uploadFile));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		String myid = (String) session.getAttribute("myid");
		dto.setMyid(myid);

		String name = mservice.getName(myid);
		// String name = (String)session.getAttribute("loginname");
		dto.setName(name);

		// insert
		service.insertBoard(dto);

		return "redirect:content?num=" + service.getMaxNum();
	}

	@GetMapping("/content")
	public ModelAndView content(String num, @RequestParam(defaultValue = "1") String currentPage) {
		ModelAndView model = new ModelAndView();

		// 조회수 증가
		service.updatereadcount(num);

		MemBoardDto dto = service.getData(num);
		model.addObject("dto", dto);

		// 업로드 파일의 확장자 얻기
		int dotloc = dto.getUploadfile().lastIndexOf("."); // 마지막 점의 위치
		String ext = dto.getUploadfile().substring(dotloc + 1); // 다음글자부터 끝까지 추출

		System.out.println(dotloc + "," + ext);

		if (ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("png") || ext.equalsIgnoreCase("git")
				|| ext.equalsIgnoreCase("jpeg")) {
			model.addObject("bupload", true);
		} else {
			model.addObject("bupload", false);
		}

		model.addObject("currentPage", currentPage);
		model.setViewName("/memboard/content");

		return model;
	}
	
	@GetMapping("/updateform")
	public ModelAndView uform() {
		ModelAndView model = new ModelAndView();
		
		model.setViewName("/memboard/uform");
		
		return model;
	}
	
	@GetMapping("/delete")
	public String delete() {
		return "redirect:list";
	}
}
