package com.sathasivam.dvdlibrary.controller;

import com.sathasivam.dvdlibrary.ui.DvdLibraryView;
import com.sathasivam.dvdlibrary.ui.UserIO;
import com.sathasivam.dvdlibrary.ui.UserIOConsoleImpl;

public class DvdLibraryController {

	private DvdLibraryView view = new DvdLibraryView();
    private UserIO io = new UserIOConsoleImpl();
    

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        
        while (keepGoing) {
         
        	menuSelection = getMenuSelection();
        	

            switch (menuSelection) {
		        case 1:
		        	io.print("CREATE DVD");
		        	break;
		        case 2:
		        	io.print("LIST DVD");
		        	break;
		        case 3:
		        	io.print("EDIT DVD");
		        	break;
		        case 4:
		        	io.print("GET DVD");
		        	break;
		        case 5:
		        	io.print("FIND DVD");
		        	break;
		        case 6:
		        	io.print("REMOVE DVD");
		            break;
		        case 7:
		            keepGoing = false;
		            break;
		        default:
		            io.print("UNKNOWN COMMAND");
            }

        }
        io.print("GOOD BYE");
    }
    
    private int getMenuSelection() {
    	return view.printMenuAndGetSelection();
    }
}