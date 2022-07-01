package com.sathasivam.dvdlibrary.ui;

import java.time.LocalDate;
import java.util.List;

import com.sathasivam.dvdlibrary.dto.Dvd;

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
  
  public Dvd getNewDvdInfo() {
	  
	  String title = io.readString("Please enter the title");
	  LocalDate releaseDate = io.readDate("Please enter the relase date in (yyyy/mm/dd)");
	  String mpaaRating = io.readString("Please enter the MPAA rating");
	  String directorName = io.readString("Please enter the director's name");
	  String studio = io.readString("Please enter the studio");
	  String userRating = io.readString("Please enter the rating");
  
	  Dvd currentDvd = new Dvd(title);
	  currentDvd.setReleaseDate(releaseDate);
	  currentDvd.setMpaaRating(mpaaRating);
	  currentDvd.setDirectorName(directorName);
	  currentDvd.setStudio(studio);
	  currentDvd.setUserRating(userRating);
	  
	  return currentDvd;
	  
  }
  
  public void displayCreateDvdBanner() {
	  io.print("=== Create DVD ===");
  }
  
  public void displayCreateSuccessBanner() {
	  io.readString(
			  "Dvd successfully created. Please hit enter to continue");
  }
  
  public void displayDvdList(List<Dvd> dvdList) {
	  for(Dvd currentDvd : dvdList) {
		  String dvdInfo = String.format("%25s | %12s | %4s | %17s | %7s | %25s", 
				  
				  currentDvd.getTitle(),
				  currentDvd.getReleaseDate(),
				  currentDvd.getMpaaRating(),
				  currentDvd.getDirectorName(),
				  currentDvd.getStudio(),
				  currentDvd.getUserRating());
		  
				  io.print(dvdInfo);
	  }
	  io.readString("Please hit enter to continue.");
  }
  
  public void displayAllDvdBanner() {
	  io.print("=== Display All DVDs ===");
  }
  
  
  
	  
	  
}