package com.invoicing;

import javax.annotation.PostConstruct;

import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableProcessApplication
public class Application {
	

	
	@Autowired
	private ManagementService managementService;

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }
  
  @PostConstruct
	public void startProcess() {
		managementService.toggleTelemetry(false);
	}
  
  @EventListener
  private void processPostDeploy(PostDeployEvent event) {
	  	//ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("startAuditoria");
		//ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).singleResult();
  }

}