package mycar.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyCarDao{
	
	@Autowired
	MyCarDaoInter carInter;
	
	//insert
	public void insertMyCar(MyCarDto dto) {
		carInter.save(dto); //id타입 유무에 따라 자동으로 insert or update
	}
	
	//전체출력
	public List<MyCarDto> getAllDatas(){
		
		return carInter.findAll();
	}
	
	//num에 대한 값(dto) 반환
	public MyCarDto getData(Long num) {
		
		return carInter.getReferenceById(num);

	}
	
	//update
	public void updateMyCar(MyCarDto dto) {
		carInter.save(dto);
	}
	
	//delete
	public void deleteMyCar(Long num) {
		carInter.deleteById(num);
	}
	
}
