package com.demo.formapi.service;

import java.util.List;

import com.demo.formapi.model.DentalFormApiModel;

public interface DentalFormApiService {

	public List<DentalFormApiModel> getAllPatientDtls();
	public void savePatientDentalForm(DentalFormApiModel patientDentalForm);

}
