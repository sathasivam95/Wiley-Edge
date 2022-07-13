package com.sathasivam.vendingmachine.dto;

public enum Coin {
	
    //Enum is a special class that represents a group of constants, like final variables
    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);
	
    private final int value;
    
    Coin (int value) {
        this.value = value;
    }
    
    private int getValue() {
        return value;
    }
         
    public String toString(){
        switch (this) {
        case PENNY:
            return "1";
        case NICKEL:
            return "5";
        case DIME:
            return "10";
        case QUARTER:
            return "25";
       
        }
        return null;
    }
    
 
}

