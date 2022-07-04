package com.sathasivam.dvdlibrary.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.sathasivam.dvdlibrary.dto.Dvd;

public class DvdLibraryDaoFileImpl implements DvdLibraryDao{

	private Map<String, Dvd> dvds = new HashMap<>();
	
	public static final String LIBRARY_FILE = "dvdlibrary.txt";
	public static final String DELIMITER = "::";
	
	@Override
	public Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException{
		loadLibrary();
		Dvd prevDvd = dvds.put(title, dvd);
		writeLibrary();
		return prevDvd;
       
	}

	@Override
	public List<Dvd> getAllDvd() throws DvdLibraryDaoException{
        loadLibrary();
		return new ArrayList<Dvd>(dvds.values());
	}


	@Override
	public Dvd getDvd(String title) throws DvdLibraryDaoException {
        loadLibrary();
		return dvds.get(title);
	}


	@Override
	public Dvd removeDvd(String title) throws DvdLibraryDaoException {
		loadLibrary();
        Dvd removeDvd = dvds.remove(title);
        writeLibrary();
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
	
	// UnmarshallingDVD
	
	private Dvd unmarshallDvd(String dvdAsText) {
		
		String[] dvdTokens = dvdAsText.split(DELIMITER);
		
		String title = dvdTokens[0];
	    String releaseDate = dvdTokens[1];
        String mpaaRating = dvdTokens[2];
        String directorName = dvdTokens[3];
        String studio = dvdTokens[4];
        String userRating = dvdTokens[5];
        
		Dvd dvdFromFile = new Dvd(title);
		
		dvdFromFile.setReleaseDate(LocalDate.parse(releaseDate));

		dvdFromFile.setMpaaRating(mpaaRating);
	
		dvdFromFile.setDirectorName(directorName);

		dvdFromFile.setStudio(studio);
	
		dvdFromFile.setUserRating(userRating);
		
		return dvdFromFile;
		
	}
	
	private void loadLibrary() throws DvdLibraryDaoException {
	    Scanner scanner;

	    try {
	        // Create Scanner for reading the file
	        scanner = new Scanner(
	                new BufferedReader(
	                        new FileReader(LIBRARY_FILE)));
	    } catch (FileNotFoundException e) {
	        throw new DvdLibraryDaoException(
	                "-_- Could not load library data into memory.", e);
	    }
	    
	    String currentLine;
	   
	    Dvd currentDvd;
	   
	    while (scanner.hasNextLine()) {
	        // get the next line in the file
	        currentLine = scanner.nextLine();
	       
	        currentDvd = unmarshallDvd(currentLine);

	        dvds.put(currentDvd.getTitle(), currentDvd);
	   
	}
	    // close scanner
	    scanner.close();
	}
	
	private String marshallStudent(Dvd aDvd){
	   
	    String dvdAsText = aDvd.getTitle() + DELIMITER;

	    dvdAsText += aDvd.getReleaseDate() + DELIMITER;

	    dvdAsText += aDvd.getMpaaRating() + DELIMITER;

	    dvdAsText += aDvd.getDirectorName() + DELIMITER;

	    dvdAsText += aDvd.getStudio() + DELIMITER;
	
	    dvdAsText += aDvd.getUserRating() + DELIMITER;
	   
	    return dvdAsText;
	}
	
	/**
	 * Writes all students in the roster out to a ROSTER_FILE.  See loadRoster
	 * for file format.
	 * 
	 * @throws ClassRosterDaoException if an error occurs writing to the file
	 */
	private void writeLibrary() throws DvdLibraryDaoException {
	
	    PrintWriter out;

	    try {
	        out = new PrintWriter(new FileWriter(LIBRARY_FILE));
	    } catch (IOException e) {
	        throw new DvdLibraryDaoException(
	                "Could not save DVD data.", e);
	    }

	 
	    String dvdAsText;
	    List<Dvd> dvdList = this.getAllDvd();
	    for (Dvd currentDvd : dvdList) {
	        // turn a Student into a String
	        dvdAsText = marshallStudent(currentDvd);
	        // write the Student object to the file
	        out.println(dvdAsText);
	        // force PrintWriter to write line to the file
	        out.flush();
	    }
	    // Clean up
	    out.close();
	}

    @Override
    public Map<String, Dvd> getDvdsLastYears(int years) throws DvdLibraryDaoException {
        LocalDate now = LocalDate.now();
        LocalDate sinceThisDate = now.minusYears(years);
        loadLibrary();
        Map<String, Dvd> dvdsLastYears = dvds.entrySet().stream()
                .filter((dvd) -> dvd.getValue().getReleaseDate().isAfter(sinceThisDate))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return dvdsLastYears;
    }
    @Override
    public Map<String, Dvd> getDvdsByMpaaRating(String mpaaRating) throws DvdLibraryDaoException {
        loadLibrary();
        Map<String, Dvd> dvdsMpaRating = dvds
                .entrySet()
                .stream()
                .filter((dvd) -> dvd.getValue().getMpaaRating().equalsIgnoreCase(mpaaRating))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return dvdsMpaRating;
    }
    @Override
    public Map<String, Dvd> getDvdsByDirector(String directorName) throws DvdLibraryDaoException {
        loadLibrary();
        Map<String, Dvd> dvdsByDirector = dvds
                .entrySet()
                .stream()
                .filter((dvd) -> dvd.getValue().getDirectorName().equalsIgnoreCase(directorName))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return dvdsByDirector;
    }
    @Override
    public Map<String, Dvd> getDvdsByStudio(String studioName) throws DvdLibraryDaoException {
        loadLibrary();
        Map<String, Dvd> dvdsByStudio = dvds
                .entrySet().stream().filter((dvd) -> dvd.getValue().getStudio().equalsIgnoreCase(studioName))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return dvdsByStudio;
    }


}




