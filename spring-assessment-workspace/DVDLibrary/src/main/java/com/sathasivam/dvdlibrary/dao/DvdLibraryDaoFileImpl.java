package com.sathasivam.dvdlibrary.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sathasivam.dvdlibrary.dto.Dvd;

public class DvdLibraryDaoFileImpl implements DvdLibraryDao{


	private Map<String, Dvd> dvds = new HashMap<>();
	
	@Override
	public Dvd addDvd(String title, Dvd dvd) {
		Dvd prevDvd = dvds.put(title, dvd);
		return prevDvd;
       
	}

	@Override
	public List<Dvd> getAllDvd() {
        return new ArrayList<Dvd>(dvds.values());
	}


	@Override
	public Dvd getDvd(String title) {
        return dvds.get(title);
	}

	@Override
	public Map<String, Dvd> getDvdsLastYears(Integer years) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Map<String, Dvd> getDvdsByMpaaRating(String mpaaRating) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Map<String, Dvd> getDvdsByDirector(String directorName) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Map<String, Dvd> getDvdsByStudio(String studio) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Dvd findDvd(String title) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Dvd removeDvd(String title) {
        Dvd removeDvd = dvds.remove(title);
        return removeDvd;
	}

	@Override
	public Dvd modifyReleaseDate(String title, LocalDate releaseDate) {
		Dvd dvdToEdit = dvds.get(title);
		dvdToEdit.setReleaseDate(releaseDate);
		return dvdToEdit;
	}

	@Override
	public Dvd modifyMpaaRating(String title, String mpaaRating) {
		Dvd dvdToEdit = dvds.get(title);
		dvdToEdit.setMpaaRating(mpaaRating);
		return dvdToEdit;
	}

	@Override
	public Dvd modifyDirectorName(String title, String directorName) {
		Dvd dvdToEdit = dvds.get(title);
		dvdToEdit.setDirectorName(directorName);
		return dvdToEdit;
	}

	@Override
	public Dvd modifyStudio(String title, String studio) {
		Dvd dvdToEdit = dvds.get(title);
		dvdToEdit.setStudio(studio);
		return dvdToEdit;
	}

	@Override
	public Dvd modifyUserRating(String title, String userRating) {
		Dvd dvdToEdit = dvds.get(title);
		dvdToEdit.setUserRating(userRating);
		return dvdToEdit;
	}



}
