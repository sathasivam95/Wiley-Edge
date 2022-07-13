package com.sathasivam.vendingmachine.controller;

import java.math.BigDecimal;
import java.util.Map;

import com.sathasivam.vendingmachine.dao.VendingMachinePersistenceException;
import com.sathasivam.vendingmachine.dto.Item;
import com.sathasivam.vendingmachine.service.InsufficientFundsException;
import com.sathasivam.vendingmachine.service.NoItemInventoryException;
import com.sathasivam.vendingmachine.service.VendingMachineServiceLayer;
import com.sathasivam.vendingmachine.ui.UserIO;
import com.sathasivam.vendingmachine.ui.UserIOConsoleImpl;
import com.sathasivam.vendingmachine.ui.VendingMachineView;

public class VendingMachineController {
	
    private UserIO io = new UserIOConsoleImpl();
    private VendingMachineView view;
    private VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineView view, VendingMachineServiceLayer service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        boolean keepGoing = true;
        String itemSelection = "";
        BigDecimal inputMoney;
        view.displayMenuBanner();
        try {
            getMenu();
        } catch (VendingMachinePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
        inputMoney = getMoney();
            while (keepGoing) {
            try {
                //Display the menu and get a selection
                itemSelection = getItemSelection();
                
                //If the user selects Exit, the program is exited
                if (itemSelection.equalsIgnoreCase("Exit")) {
                    keepGoing = false;
                    break;
                }
                getItem(itemSelection, inputMoney);
                keepGoing = false;
                break;

            } catch (InsufficientFundsException | NoItemInventoryException | VendingMachinePersistenceException e) {
                view.displayErrorMessage(e.getMessage());
                view.displayPleaseTryAgainMsg();
            }
            }
            exitMessage();

    }
    private void getMenu() throws VendingMachinePersistenceException {
        Map<String, BigDecimal> itemsInStockWithCosts = service.getItemsInStockWithCosts();
        view.displayMenu(itemsInStockWithCosts);
    }    
    
    private BigDecimal getMoney() {
        return view.getMoney();
    }
    
    private String getItemSelection(){
        return view.getItemSelection();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void getItem(String name, BigDecimal money) throws InsufficientFundsException, NoItemInventoryException, VendingMachinePersistenceException {
        Item wantedItem = service.getItem(name, money);
        Map<BigDecimal, BigDecimal> changeDuePerCoin = service.getChangePerCoin(wantedItem, money);
        view.displayChangeDuePerCoin(changeDuePerCoin);
        view.displayEnjoyBanner(name);
    }
    

}
    