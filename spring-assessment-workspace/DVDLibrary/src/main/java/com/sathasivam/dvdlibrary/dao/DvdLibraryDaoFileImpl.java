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
	public Dvd editTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Dvd editReleaseDate(String title, LocalDate releaseDate) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Dvd editMpaaRating(String title, String mpaaRating) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Dvd editDirectorName(String title, String directorName) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Dvd editStudio(String title, String studio) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Dvd editUserRating(String title, String userRating) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Dvd getDvd(String title) {
        throw new UnsupportedOperationException("Not supported yet.");
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
        throw new UnsupportedOperationException("Not supported yet.");
	}



}
