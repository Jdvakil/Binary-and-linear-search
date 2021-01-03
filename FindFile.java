import java.io.*;

/**
 * This class looks through the directories and files to look for the number of
 * occurances of a file.
 * 
 * @author Jay Darshan Vakil
 * @version 02/18/2020
 */
public class FindFile {

    private int maxFiles;// max number of files to look for.
    private int count = 0;// The count of the occurences of the file
    private String[] FilePath;// The array that stores the path of the file.

    /**
     * This is the empty constructor of the class. It sets the max number of files
     * to 1.
     */
    public FindFile() {
        this.setMaxFiles(1);
        this.setFiles();
    }

    /**
     * This is the full constructor of the class, it takes in the max number of
     * files and sets the file array to the size of the max files.
     * 
     * @param maxFiles the max number of files.
     */
    public FindFile(int maxFiles) {
        this.setMaxFiles(maxFiles);
        this.setFiles();
    }

    /**
     * This is method that searches through the path and directories recursively for
     * the file the user wants to be searched for.
     * 
     * @param target The name of the target file.
     * @param folder The folder the user wants to look for the file i
     * @throws IOException If the path is null.
     * PRECONDITIONS: The user will enter a valid and not empty target and folder location.
     * POSTCONDITONS: The method will recursively look for the file.
     */
    public void directorySearch(String target, String folder) throws IOException {
        if (!target.isEmpty() && !folder.isEmpty()) {
            File newFile = new File(folder);
            String[] fileList = newFile.list();
            if (fileList != null) {
                for (String file : fileList) {
                    String path = folder + "\\" + file;// sets the path of the file.
                    File tempFile = new File(path);// temp File object to check if the path is a directory.
                    if (tempFile.isDirectory()) {
                        directorySearch(target, path);// recursive search method.
                    }
                    if (file.equals(target)) {// if the file found in the path equals the target file.
                        FilePath[this.getCount()] = newFile.getAbsolutePath();// adds the path to an array to be
                                                                              // outputted.
                        this.setCount(this.getCount() + 1);// increments 1 to the count
                    }
                    if (this.getCount() > this.getMaxFiles()) {// throws exception if the number of occurences is more
                                                               // than
                                                               // the maxfiles
                        throw new IllegalArgumentException("Number of files greater than max num of files");
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Target file and folder cant be empty...");
        }
    }

    /**
     * The getter for the max number of files
     * 
     * @return
     */
    public int getMaxFiles() {
        int tempMaxFiles = this.maxFiles;
        return tempMaxFiles;
    }

    /**
     * This method checks for a valid number of max number of files and sets the
     * maxFiles to maxFIles.
     * 
     * @param maxFiles the max number of files.
     * PRECONDITIONS: The maxFiles is valid and positive.
     */
    private void setMaxFiles(int maxFiles) {
        if (maxFiles > 0) {
            this.maxFiles = maxFiles;
        } else {
            throw new IllegalArgumentException("Number of files cannot be less than 0");
        }
    }

    /**
     * This method returns the paths of the files found.
     * 
     * @return an array full of file paths.
     */
    public String[] getFiles() {
        String[] tempFiles = new String[FilePath.length];
        int i = 0;
        for (String file : this.FilePath) {
            tempFiles[i] = file;
            i++;
        }
        return tempFiles;
    }

    /**
     * This method sets the file and sets the size to max num of files.
     */
    private void setFiles() {
        this.FilePath = new String[this.getMaxFiles()];
    }

    /**
     * this is the getter for the count of files.
     * 
     * @return the number of occurences of the files.
     */
    public int getCount() {
        int tempCount = this.count;
        return tempCount;
    }

    /**
     * This method checks for validity and sets the count for the occurences of the file.
     * 
     * @param count
     */
    private void setCount(int count) {
        if (count >= 0) {
            this.count = count;
        } else {
            throw new IllegalArgumentException("Count cannot be less than 0");
        }
    }
}