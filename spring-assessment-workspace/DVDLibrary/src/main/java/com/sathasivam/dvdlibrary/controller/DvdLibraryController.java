package com.sathasivam.dvdlibrary.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.sathasivam.dvdlibrary.dao.DvdLibraryDao;
import com.sathasivam.dvdlibrary.dao.DvdLibraryDaoException;
import com.sathasivam.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.sathasivam.dvdlibrary.dto.Dvd;
import com.sathasivam.dvdlibrary.ui.DvdLibraryView;
import com.sathasivam.dvdlibrary.ui.UserIO;
import com.sathasivam.dvdlibrary.ui.UserIOConsoleImpl;

public class DvdLibraryController {

	
	public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
	    this.dao = dao;
	    this.view = view;
	}
	
	private DvdLibraryView view;
	private DvdLibraryDao dao;
    private UserIO io = new UserIOConsoleImpl();

    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
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
		        	findDvds();
		        	break;
		        case 6:
		        	removeDvd();
		            break;
		        case 7:
		            keepGoing = false;
		            break;
		        default:
		            unknownCommand();
            }

        }
        exitMessage();
    } catch(DvdLibraryDaoException e) {
    	
    	view.displayErrorMessage(e.getMessage());
    	
    	}
    }
    
    private int getMenuSelection() {
    	return view.printMenuAndGetSelection();
    }
    
    private void createDvd() throws DvdLibraryDaoException{
       view.displayCreateDvdBanner();
       Dvd newDvd = view.getNewDvdInfo();
       dao.addDvd(newDvd.getTitle(), newDvd);
       view.displayCreateSuccessBanner();
    }
    
    private void listDvds() throws DvdLibraryDaoException{
    	view.displayAllDvdBanner();
    	List<Dvd> dvdList = dao.getAllDvd();
    	view.displayDvdList(dvdList);
    }
    
   private void viewDvd() throws DvdLibraryDaoException{
	   view.displayDisplayDvdBanner();    
	   String title = view.getDvdTitleChoice(); 
	   Dvd dvd = dao.getDvd(title);  
	   view.displayDvd(dvd);
   }
   
   
   private void removeDvd() throws DvdLibraryDaoException{
	    view.displayRemoveDvdBanner();
	    String title = view.getDvdTitleChoice();
	   	Dvd removedDvd = dao.removeDvd(title);
	    view.displayRemoveResult(removedDvd);
	}
    
   
   // Edit DVD Control
   
   
private void editDvd()  throws DvdLibraryDaoException {
   
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
   
   private void unknownCommand() {
	    view.displayUnknownCommandBanner();
	}

	private void exitMessage() {
	    view.displayExitBanner();
	}
	
    private void findDvds() throws DvdLibraryDaoException {
        view.displayFindDvdsBanner();
            int findDvdsSelection = 0;
            boolean keepGoing = true;
            while (keepGoing) {
                findDvdsSelection = view.printFindMenuAndGetSelection();
                switch (findDvdsSelection){
                    case 1:
                        findMoviesLastNYears();
                        break;
                    case 2:
                        findMoviesByMpaaRating();
                        break;
                    case 3:
                        findMoviesByDirector();
                        break;
                    case 4:
                        findMoviesByStudio();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
//                if (keepGoing == false) {
//                    break;
            } 
        }
    private void findMoviesLastNYears() throws DvdLibraryDaoException {
        int n = view.getNYears();
        Map<String, Dvd> filteredDvds = dao.getDvdsLastYears(n);
        view.displayDvds(filteredDvds);
    }
    
    private void findMoviesByMpaaRating() throws DvdLibraryDaoException {
        String mpaaRating = view.getMpaaRating();
        Map<String, Dvd> filteredDvds = dao.getDvdsByMpaaRating(mpaaRating);
        view.displayDvds(filteredDvds);
    }
    
    private void findMoviesByDirector() throws DvdLibraryDaoException {
        String director = view.getDirectorName();
        Map<String, Dvd> filteredDvds = dao.getDvdsByDirector(director);
        view.displayDvds(filteredDvds);
    }
    private void findMoviesByStudio() throws DvdLibraryDaoException {
        String studio = view.getStudio();
        Map<String, Dvd> filteredDvds = dao.getDvdsByStudio(studio);
        view.displayDvds(filteredDvds);
    }
 




}