package com.HoodieStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HoodieStore.model.Form;
import com.HoodieStore.repository.FormRepository;
@Service
public class FormServiceImpl implements FormService {
  @Autowired
   private FormRepository fr;
	@Override
	public String saveformdata(Form form) {
		 Form formdata = new Form();
		 formdata.setName(form.getName());
		 formdata.setEmail(form.getEmail());
		 formdata.setPhoneno(form.getPhoneno());
		 formdata.setAddress(form.getAddress());
		 fr.save(formdata);
		return "helo";
	}

}
