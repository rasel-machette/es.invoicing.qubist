package com.invoicing.controller;

import org.apache.log4j.Logger;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.invoicing.controller.InvoicingController;

@Controller
public class InvoicingController {
	
	private static final Logger LOGGER = Logger.getLogger(InvoicingController.class.getName());
	
	@Autowired
	  private RuntimeService runtimeService;
	
	@PostMapping(path = "/startProcess", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> startProcess() {
		LOGGER.info("Start process");
		runtimeService.createProcessInstanceByKey("startCollaboration_0ne2uuj")
        .businessKey("startCollaboration_0ne2uuj")
        //.setVariable("nombre_cliente", json)//Se colocan los nombres de los archivos separados por 
        .execute();
		return ResponseEntity.ok().build();
	}

}



