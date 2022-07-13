package com.sathasivam.vendingmachine;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sathasivam.vendingmachine.controller.VendingMachineController;

@SpringBootApplication
public class App {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		VendingMachineController controller = ctx.getBean("controller", VendingMachineController.class);
		controller.run();
		
	}

}


//UserIO io = new UserIOConsoleImpl();
//VendingMachineView view = new VendingMachineView(io);
//VendingMachineAuditDao auditDao = new VendingMachineAuditDaoFileImpl();
//VendingMachineDao dao = new VendingMachineDaoFileImpl();
//VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(auditDao, dao);
//VendingMachineController controller = new VendingMachineController(view, service);
//
//controller.run();