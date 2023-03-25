package br.com.lenox.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lenox.data.vo.v1.PersonVO;
import br.com.lenox.data.vo.v2.PersonVOV2;
import br.com.lenox.exceptions.ResourceNotFoundException;
import br.com.lenox.mapper.DozerMapper;
import br.com.lenox.mapper.custom.PersonMapper;
import br.com.lenox.model.Person;
import br.com.lenox.repositories.PersonRepository;

//encara como um objeto que vai ser injetado em runtime em outras classes, vai ser injetado com @Autowired
@Service
public class PersonServices {
	
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonMapper mapper;
	
	
	public List<PersonVO> findAll() {
		logger.info("Finding all persons");

	
		return DozerMapper.parseListObject(repository.findAll(), PersonVO.class); 
		
	}
	
	public PersonVO findById(Long id) {
		
		
		logger.info("Finding one person");
		
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		 
		return  DozerMapper.parseObject(entity, PersonVO.class);
				
	}
	

	
	public PersonVO create(PersonVO person) {
		logger.info("Creating one person!");
		
		var entity =  DozerMapper.parseObject(person, Person.class);
		var vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		
		return vo;

		
	}
	public PersonVOV2 createV2(PersonVOV2 person) {
		logger.info("Creating one person with v2!");
		
		var entity =  mapper.convertVoToEntity(person); 
		var vo =  mapper.convetEntityToVo(repository.save(entity));
		
		return vo;
		
		
	}
	
	
	public PersonVO update(PersonVO person) {
		logger.info("Updating one person!");
		
	var entity = repository.findById(person.getId())
		.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	
	entity.setFirstName(person.getFirstName());
	entity.setAddress(person.getAddress());
	entity.setGender(person.getGender());
	entity.setLastName(person.getLastName());
	
	var vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
	
	return vo;
		
	}
	public void delete(Long id) {
		logger.info("Deleting one person!");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
			repository.delete(entity);
		
	}
}
