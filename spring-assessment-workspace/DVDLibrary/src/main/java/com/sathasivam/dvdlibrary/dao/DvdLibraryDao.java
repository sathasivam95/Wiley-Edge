package com.sathasivam.dvdlibrary.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.sathasivam.dvdlibrary.dto.Dvd;



public interface DvdLibraryDao {
	
	Dvd createDvd(String title, Dvd dvd);
	
	List<Dvd> getAllDvd();
	
	Dvd editTitle(String title);
	
	Dvd editReleaseDate(String title, LocalDate releaseDate);

	Dvd editMpaaRating(String title, Double mpaaRating);
	
	Dvd editDirectorName(String title, String directorName);
	
	Dvd editStudio(String title, String studio);
	
	Dvd editUserRating(String title, String userRating);
	
	Dvd getDvd(String title);
	
	Map<String, Dvd> getDvdsLastYears(Integer years);
	    
	Map<String, Dvd> getDvdsByMpaaRating(String mpaaRating);
	
	Map<String, Dvd> getDvdsByDirector(String directorName);
	
	Map<String, Dvd> getDvdsByStudio(String studio);
	
	Dvd findDvd(String title);
	
	Dvd removeDvd(String title);
	

	

}
