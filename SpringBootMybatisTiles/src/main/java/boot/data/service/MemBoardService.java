package boot.data.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.data.dto.MemBoardDto;
import boot.data.mapper.MemBoardMapperInter;

@Service
public class MemBoardService implements MemBoardServiceInter {

	@Autowired
	MemBoardMapperInter mapperinter;
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return mapperinter.getTotalCount();
	}

	@Override
	public void updatereadcount(String num) {
		// TODO Auto-generated method stub
		mapperinter.updatereadcount(num);
		
	}

	@Override
	public void insertBoard(MemBoardDto dto) {
		// TODO Auto-generated method stub
		mapperinter.insertBoard(dto);
	}

	@Override
	public MemBoardDto getData(String num) {
		// TODO Auto-generated method stub
		return mapperinter.getData(num);
	}

	@Override
	public int getMaxNum() {
		// TODO Auto-generated method stub
		return mapperinter.getMaxNum();
	}

	@Override
	public List<MemBoardDto> getList(int start, int perpage) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("perpage", perpage);
		
		
		return mapperinter.getList(map);
	}

	@Override
	public void updateBoard(MemBoardDto dto) {
		// TODO Auto-generated method stub
		mapperinter.updateBoard(dto);
	}

	@Override
	public void deleteBoard(String num) {
		// TODO Auto-generated method stub
		mapperinter.deleteBoard(num);
	}



}
