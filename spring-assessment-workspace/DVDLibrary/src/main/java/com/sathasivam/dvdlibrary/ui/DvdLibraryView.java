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
	  LocalDate releaseDate = io.readDate("Please enter the relaase date");
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
	  io.print("=== All DVDs ===");
  }
  
  
  public void displayDisplayDvdBanner() {
	  io.print("=== Display DVDs ===");
  }
  
  
  public String getDvdTitleChoice() {
	  return io.readString("Please enter the DVD title.");
  }
  
  
  // Get DVD
  public void displayDvd(Dvd dvd) {
	  if(dvd != null) {
		  io.print("Title: "+ dvd.getTitle());
		  io.print("Release date: " + dvd.getReleaseDate().toString());
		  io.print("MPAA Rating: " + dvd.getMpaaRating());
		  io.print("Director's Name: " + dvd.getDirectorName());
		  io.print("Studio: " + dvd.getStudio());
		  io.print("User Rating: "+ dvd.getUserRating());
		  
		  
	  }else {
		  io.print("No such DVD exists.");
	  }
	  io.readString("Please enter to continue");
  }
  
  // Remove View
  public void displayRemoveDvdBanner () {
	    io.print("=== Remove DVD ===");
	}

	public void displayRemoveResult(Dvd dvdRecord) {
	    if(dvdRecord != null){
	      io.print("Dvd successfully removed.");
	    }else{
	      io.print("No such DVD exists.");
	    }
	    io.readString("Please hit enter to continue.");
	}

   // Edit View
  public int printEditMenuSelection() {
	     
    io.print("Edit DVD Menu");
    io.print("1. Change Release Date");
    io.print("2. Change MPAA rating");
    io.print("3. Change Director's Name");
    io.print("4. Change Studio");
    io.print("5. Change User Rating");
    io.print("6. Exit");

    return io.readInt("Please select from the"
            + " above choices.", 1, 6);
    }
  
  
  public LocalDate getReleaseDate() {
	  return io.readDate("Please enter the new release date.");
	  
  }
  
  public String getMpaaRating() {
	  return io.readString("Please enter the new MPAA rating.");
	  
  }
  
  public String getDirectorName() {
	  return io.readString("Please enter the new director's name.");
	  
  }
  public String getUserRating() {
	  return io.readString("Please enter the new user rating.");
	  
  }
  public String getStudio() {
	  return io.readString("Please enter the new studio.");
	  
  }
  
  
  public void displayEditResult(){
      io.print("DVD successfully edited.");
  }
  
  public void displayEditDvdBanner() {
	  io.print("=== Edit DVD ===");
  }
  
  public void displayNullDvd() {
	  io.print("No DVD exists.");
  }
	
 
}