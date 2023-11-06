package boot.data.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.ReboardDto;

@Mapper
public interface ReboardMapperInter {
	public int getMaxNum(); //그룹번호 주기 위해 필요
	public int getTotalCount(Map<String, String> map); //검색단어와 카테고리
	public List<ReboardDto> getPagingList(Map<String, Object> map); //페이징 처리한 리스트 출력, 검색단어는 String / startNum perPage는 int라서 Object
	//public List<ReboardDto> getAllDatas(); //전체 리스트 출력
	public void insertReboard(ReboardDto dto);
	public void updateRestep(Map<String, Integer> map);
	public void updateReadCount(int num);
	public ReboardDto getData(int num);
	public void updateReboard(ReboardDto dto);
	public void deleteReboard(int num);
	public void updateLikes(int num);
}
