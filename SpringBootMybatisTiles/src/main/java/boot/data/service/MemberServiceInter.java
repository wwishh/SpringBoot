package boot.data.service;

import java.util.List;
import java.util.Map;

import boot.data.dto.MemberDto;

public interface MemberServiceInter {

	public void insertMember(MemberDto dto);
	public List<MemberDto> getAllMembers();
	public int getSerchId(String id);
	public String getName(String id);
	public int loginPassCheck(String id, String pass); //여기서는 풀어서 써도 됨
	public MemberDto getDataById(String id);
	public void deleteMember(String num);
	public void updatePhoto(String photo, String num);
	public void updateMember(MemberDto dto);
	
}