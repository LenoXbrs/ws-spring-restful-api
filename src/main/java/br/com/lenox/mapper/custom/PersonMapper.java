package br.com.lenox.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.lenox.data.vo.v2.PersonVOV2;
import br.com.lenox.model.Person;

@Service
public class PersonMapper {
	
	public PersonVOV2 convetEntityToVo(Person person) {
		
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setBirthDay(new Date());
		
		vo.setGender(person.getGender());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		
		return vo;
	}
		public Person convertVoToEntity(PersonVOV2 person) {
			
			Person entity = new Person();
			entity.setId(person.getId());
			entity.setAddress(person.getAddress());
		
			
			entity.setGender(person.getGender());
			entity.setFirstName(person.getFirstName());
			entity.setLastName(person.getLastName());
			
			return entity;
		
	}

}
