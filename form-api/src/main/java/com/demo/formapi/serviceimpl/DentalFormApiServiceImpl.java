package com.demo.formapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.formapi.entity.bean.DentalFormApiEntity;
import com.demo.formapi.model.DentalFormApiModel;
import com.demo.formapi.repository.DentalFormApiRepository;
import com.demo.formapi.service.DentalFormApiService;

@Service
public class DentalFormApiServiceImpl implements DentalFormApiService {

	@Autowired
	private DentalFormApiRepository dentalFormApiRepository;

	@Override
	public List<DentalFormApiModel> getAllPatientDtls() {
		List<DentalFormApiEntity> entityList= (List<DentalFormApiEntity>) dentalFormApiRepository.findAll();
		List<DentalFormApiModel> modelList= new ArrayList<>();
		for(DentalFormApiEntity entity:entityList) {
			DentalFormApiModel model = new DentalFormApiModel();
			BeanUtils.copyProperties(entity, model);
			modelList.add(model);
		}
		return modelList;
		
	}

	@Override
	public void savePatientDentalForm(DentalFormApiModel model) {
		DentalFormApiEntity entity=new DentalFormApiEntity();
		BeanUtils.copyProperties(model, entity);
		dentalFormApiRepository.save(entity);
	}
	
	
	
}