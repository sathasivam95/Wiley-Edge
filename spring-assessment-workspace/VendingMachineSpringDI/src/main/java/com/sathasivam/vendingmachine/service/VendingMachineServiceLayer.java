package com.sathasivam.vendingmachine.service;

import java.math.BigDecimal;
import java.util.Map;

import com.sathasivam.vendingmachine.dao.VendingMachinePersistenceException;
import com.sathasivam.vendingmachine.dto.Item;

public interface VendingMachineServiceLayer {
	

	 void checkIfEnoughMoney(Item item, BigDecimal inputMoney)throws 
     InsufficientFundsException;

	 void removeOneItemFromInventory(String name) throws 
     NoItemInventoryException, 
     VendingMachinePersistenceException;

	 Item getItem(String name, BigDecimal inputMoney) throws 
      InsufficientFundsException, 
      NoItemInventoryException, 
      VendingMachinePersistenceException;

   
    Map<String, BigDecimal>  getItemsInStockWithCosts () throws 
            VendingMachinePersistenceException;

    
    Map<BigDecimal, BigDecimal> getChangePerCoin(Item item, BigDecimal money);
    
}