package com.sathasivam.dvdlibrary.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.sathasivam.dvdlibrary.dto.Dvd;


public interface DvdLibraryDao {
	
	Dvd addDvd(String title, Dvd dvd);
	
	List<Dvd> getAllDvd();
	
	Dvd modifyReleaseDate(String title, LocalDate releaseDate);

	Dvd modifyMpaaRating(String title, String mpaaRating);
	
	Dvd modifyDirectorName(String title, String directorName);
	
	Dvd modifyStudio(String title, String studio);
	
	Dvd modifyUserRating(String title, String userRating);
	
	Dvd getDvd(String title);
	
	Map<String, Dvd> getDvdsLastYears(Integer years);
	    
	Map<String, Dvd> getDvdsByMpaaRating(String mpaaRating);
	
	Map<String, Dvd> getDvdsByDirector(String directorName);
	
	Map<String, Dvd> getDvdsByStudio(String studio);
	
	Dvd findDvd(String title);
	
	Dvd removeDvd(String title);
	
}
