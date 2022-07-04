package com.sathasivam.dvdlibrary;

import com.sathasivam.dvdlibrary.controller.DvdLibraryController;
import com.sathasivam.dvdlibrary.dao.DvdLibraryDao;
import com.sathasivam.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.sathasivam.dvdlibrary.ui.DvdLibraryView;
import com.sathasivam.dvdlibrary.ui.UserIO;
import com.sathasivam.dvdlibrary.ui.UserIOConsoleImpl;

public class App {

	public static void main(String[] args) {
	
		UserIO myIO = new UserIOConsoleImpl();
		DvdLibraryView myView = new DvdLibraryView(myIO);
		DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
		DvdLibraryController controller = new DvdLibraryController(myDao,myView);
		controller.run();
    
	}
}  