package com.sathasivam.vendingmachine.controller;

import java.math.RoundingMode;

import com.sathasivam.vendingmachine.dto.Item;
import com.sathasivam.vendingmachine.ui.UserIO;
import com.sathasivam.vendingmachine.ui.UserIOConsoleImpl;

public class VendingMachineController {
	
	private UserIO io = new UserIOConsoleImpl();
	
	

	public void run() {
		boolean keepGoing = true;
		int itemSelection = 0;
		while(keepGoing) {
			io.print("Vending Machine Selection: ");
			io.print("1. Mars, $1.40");
			io.print("2. Milky Bar, $1.50");
			io.print("3. Kit Kat, $1.80");
			io.print("4. Coke, $1.60");
			io.print("5. Pepsi, $1.70");
			io.print("6. Exit");
			
			itemSelection = io.readInt("Please select an item from the above list" 1,6);
			
			
		}
		
	}

}
