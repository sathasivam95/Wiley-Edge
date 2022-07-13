package com.sathasivam.vendingmachine;


import com.sathasivam.vendingmachine.controller.VendingMachineController;
import com.sathasivam.vendingmachine.dao.VendingMachineAuditDao;
import com.sathasivam.vendingmachine.dao.VendingMachineAuditDaoFileImpl;
import com.sathasivam.vendingmachine.dao.VendingMachineDao;
import com.sathasivam.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.sathasivam.vendingmachine.service.VendingMachineServiceLayer;
import com.sathasivam.vendingmachine.service.VendingMachineServiceLayerImpl;
import com.sathasivam.vendingmachine.ui.UserIO;
import com.sathasivam.vendingmachine.ui.UserIOConsoleImpl;
import com.sathasivam.vendingmachine.ui.VendingMachineView;

public class App {

	public static void main(String[] args) {
		
		UserIO io = new UserIOConsoleImpl();
        VendingMachineView view = new VendingMachineView(io);
        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoFileImpl();
        VendingMachineDao dao = new VendingMachineDaoFileImpl();
        VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(auditDao, dao);
        VendingMachineController controller = new VendingMachineController(view, service);
        
        controller.run();
	}

}
