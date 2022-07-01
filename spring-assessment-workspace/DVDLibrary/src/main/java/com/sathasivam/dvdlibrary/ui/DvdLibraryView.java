package com.sathasivam.dvdlibrary.ui;

public class DvdLibraryView {
	
	  private UserIO io = new UserIOConsoleImpl();

	  public int printMenuAndGetSelection() {
	     
        io.print("DVD Library Main Menu");
        io.print("1. Create DVD");
        io.print("2. List DVD");
        io.print("3. Edit DVD");
        io.print("4. Get DVD");
        io.print("5. Find DVD");
        io.print("6. Remove DVD");
        io.print("7. Exit");

        return io.readInt("Please select from the"
                + " above choices.", 1, 7);
        }
}