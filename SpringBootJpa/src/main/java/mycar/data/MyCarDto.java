package mycar.data;

import java.sql.Timestamp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


import lombok.Data;

@Entity
@Table(name = "mycar") //자동으로 mycar라는 테이블 mysql에 만들어 진다
@Data
public class MyCarDto {
	
	@Id //각 엔티티 구별할 식별 아이디를 갖도록 설계(시퀀스)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long num;
	
	@Column(name="carname")
	private String carname;
	
	@Column
	private int carprice;
	
	@Column
	private String carcolor;
	
	@Column
	private String carguip;
	
	@Column
	private String carphoto;
	
	@CreationTimestamp //엔티티가 생성되는 시점의 시간 자동등록
	@Column(updatable = false) //수정시 이 컬럼은 수정하지 않겠다는 뜻
	//updatable = false 없을시 날짜가 null로 찍힐 것
	private Timestamp guipday;
}
