package boot.data.service;

import java.util.List;

import boot.data.dto.MemBoardDto;

public interface MemBoardServiceInter {
	public int getTotalCount();
	public void updatereadcount(String num);
	public void insertBoard(MemBoardDto dto);
	public MemBoardDto getData(String num);
	public int getMaxNum();
	public List<MemBoardDto> getList(int start, int perpage);
	public void updateBoard(MemBoardDto dto);
	public void deleteBoard(String num);
}
