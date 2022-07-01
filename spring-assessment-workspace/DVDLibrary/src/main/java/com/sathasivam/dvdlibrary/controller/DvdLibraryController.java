package com.sathasivam.dvdlibrary.controller;

import java.util.List;

import com.sathasivam.dvdlibrary.dao.DvdLibraryDao;
import com.sathasivam.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.sathasivam.dvdlibrary.dto.Dvd;
import com.sathasivam.dvdlibrary.ui.DvdLibraryView;
import com.sathasivam.dvdlibrary.ui.UserIO;
import com.sathasivam.dvdlibrary.ui.UserIOConsoleImpl;

public class DvdLibraryController {

	private DvdLibraryView view = new DvdLibraryView();
    private UserIO io = new UserIOConsoleImpl();
    private DvdLibraryDao dao = new DvdLibraryDaoFileImpl();
    

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        
        while (keepGoing) {
         
        	menuSelection = getMenuSelection();
        	

            switch (menuSelection) {
		        case 1:
		        	createDvd();
		        	break;
		        case 2:
		        	listDvds();
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
    
    private void createDvd() {
       view.displayCreateDvdBanner();
       Dvd newDvd = view.getNewDvdInfo();
       dao.addDvd(newDvd.getTitle(), newDvd);
       view.displayCreateSuccessBanner();
    }
    
    private void listDvds() {
    	view.displayAllDvdBanner();
    	List<Dvd> dvdList = dao.getAllDvd();
    	view.displayDvdList(dvdList);
    }
}