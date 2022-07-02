package com.sathasivam.dvdlibrary.controller;

import java.time.LocalDate;
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
		        	editDvd();
		        	break;
		        case 4:
		        	viewDvd();
		        	break;
		        case 5:
		        	io.print("FIND DVD");
		        	break;
		        case 6:
		        	removeDvd();
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
    
   private void viewDvd() {
	   view.displayDisplayDvdBanner();    
	   String title = view.getDvdTitleChoice(); 
	   Dvd dvd = dao.getDvd(title);  
	   view.displayDvd(dvd);
   }
   
   
   private void removeDvd() {
	    view.displayRemoveDvdBanner();
	    String title = view.getDvdTitleChoice();
	   	Dvd removedDvd = dao.removeDvd(title);
	    view.displayRemoveResult(removedDvd);
	}
    
   
   // Edit DVD Control
   
   
private void editDvd()   {
   
    view.displayEditDvdBanner();
    String title = view.getDvdTitleChoice();
    Dvd dvdToEdit = dao.getDvd(title);
    if (dvdToEdit==null) {
        view.displayNullDvd();
    } else {
        view.displayDvd(dvdToEdit);
        int editMenuSelection = 0;
        boolean keepGoing = true;
        while (keepGoing) {
            editMenuSelection = view.printEditMenuSelection();

            switch (editMenuSelection){
                case 1:
                    editReleaseDate(title);
                    break;
                case 2:
                    editMpaaRating(title);
                    break;
                case 3:
                    editDirectorName(title);
                    break;
                case 4:
                    editStudio(title);
                    break;
                case 5:
                    editUserRating(title);
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                	  io.print("UNKNOWN COMMAND");
            }
            if (keepGoing == false) {
                break;
            } 
        }
    }
}
     

   private void editReleaseDate(String title)  {
     
       LocalDate newReleaseDate = view.getReleaseDate();
       Dvd editedDvd = dao.modifyReleaseDate(title, newReleaseDate);
       view.displayEditResult();
   }
   private void editMpaaRating(String title)  {
       
       String newMpaaRating = view.getMpaaRating();
       Dvd editedDvd = dao.modifyMpaaRating(title, newMpaaRating);
       view.displayEditResult();
   }
   private void editDirectorName(String title) {
       
       String newDirectorName = view.getDirectorName();
       Dvd editedDvd = dao.modifyDirectorName(title, newDirectorName);
       view.displayEditResult();
   }
   private void editUserRating(String title)  {
       String newUserRating = view.getUserRating();
       Dvd editedDvd = dao.modifyUserRating(title, newUserRating);
       view.displayEditResult();
   }
   private void editStudio(String title)  {
       String newStudio = view.getStudio();
       Dvd editedDvd = dao.modifyStudio(title, newStudio);
       view.displayEditResult();
   }
   

    
}