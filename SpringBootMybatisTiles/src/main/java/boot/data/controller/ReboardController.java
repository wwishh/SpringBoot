package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.MemBoardDto;
import boot.data.dto.ReboardDto;
import boot.data.service.ReboardService;

@Controller
@RequestMapping("/reboard")
public class ReboardController {

	@Autowired
	ReboardService service;

	@GetMapping("/list")
	public ModelAndView list(@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(value = "searchcolumn", required = false) String sc,
			@RequestParam(value = "searchword", required = false) String sw) { // 값이 없을경우 null이 넘어오는데 오류 방지 위해 required
																				// =false 사용

		ModelAndView model = new ModelAndView();

		// 페이징 처리에 필요한 변수 선언
		int totalCount = service.getTotalCount(sc, sw); // 전체갯수
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
		List<ReboardDto> list = service.getPagingList(sc, sw, startNum, perPage);

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

		System.out.println("totalCount=" + totalCount);

		model.setViewName("/reboard/boardlist");

		return model;
	}

	@GetMapping("/form")
	public String reform(@RequestParam(defaultValue = "0") int num, @RequestParam(defaultValue = "0") int regroup,
			@RequestParam(defaultValue = "0") int restep, @RequestParam(defaultValue = "0") int relevel,
			@RequestParam(defaultValue = "1") int currentPage, Model model) {

		// 답글일 경우에만 넘어오는 값들이다
		// 새 글일 경우는 모두 null이므로 defaultValue만 값으로 전달된다
		model.addAttribute("num", num);
		model.addAttribute("regroup", regroup);
		model.addAttribute("restep", restep);
		model.addAttribute("relevel", relevel);
		model.addAttribute("currentPage", currentPage);

		// 새 글일 경우는 "", 답글일 경우에는 원글 제목 가져오기
		String subject = "";
		if (num > 0) {
			subject = service.getData(num).getSubject();
		}

		model.addAttribute("subject", subject);

		return "/reboard/addform";
	}

	@PostMapping("/insert")
	public String insert(ReboardDto dto, ArrayList<MultipartFile> upload, HttpSession session) {

		String path = session.getServletContext().getRealPath("/rephoto");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

		String uploadName = "";

		// dto.setPhoto(upload.getOriginalFilename());

		if (upload.get(0).getOriginalFilename().equals("")) {
			uploadName = null;
		} else {
			for (MultipartFile list : upload) {

				String uploadFile = sdf.format(new Date()) + "_" + list.getOriginalFilename();
				uploadName += uploadFile + ",";
				

				try {
					list.transferTo(new File(path + "/" + uploadFile));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			uploadName=uploadName.substring(0, uploadName.length()-1);

		}
		dto.setPhoto(uploadName);
		// insert
		service.insertReboard(dto);

		//return "redirect:content?num=" + service.getMaxNum();
		return "redirect:list";
	}

	@GetMapping("/content")
	public String content() {
		return "/reboard/content";
	}
}