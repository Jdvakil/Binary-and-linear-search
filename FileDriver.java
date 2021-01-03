import java.io.IOException;

/**
 * This is the driver for the FindFile.java class, it tests the class to find
 * several files.
 * 
 * @author Jay Darshan Vakil
 * @version 02/18/2020
 */
public class FileDriver {
    public static void main(String args[]) throws IOException {
        /*
         * For the path names, you might want to add more directories to the path to get
         * faster results. I used "C:\\Users" for the test directory and the results came in
         * after about ~1.5 minutes or recursively searching.
         */
        testFindFile(100, "file.txt", "C:\\Users");
        System.out.println();
        testFindFile(100, "longwords.txt", "C:\\Users");
        System.out.println();
        testFindFile(10, "css143.txt", "C:\\Users");
        System.out.println();
        testFindFile(2, "FindFile.java", "C:\\Users");
        System.out.println();
        testFindFile(10, "Bill.java", "C:\\Users");
    }

    /**
     * This is the tester for the FindFile class, it makes an object for the class and outputs a message appropriately.
     * @param maxFiles The max number of files.
     * @param targetFile The target file to look for.
     * @param path The path of the file to look for. 
     * @throws IOException If the file is not found.
     */
    private static void testFindFile(int maxFiles, String targetFile, String path) throws IOException {
        FindFile findFile = new FindFile(maxFiles);
        findFile.directorySearch(targetFile, path);

        if (findFile.getCount() > 0) {
            System.out.println("File: \"" + targetFile + "\" is found " + findFile.getCount() + " time(s)");
            System.out.println("\"" + targetFile + "\" is found at locations: ");
            for (String files : findFile.getFiles()) {
                if (files != null) {
                    System.out.println(files);
                }
            }
        } else {
            System.out.println(
                    "File not found in the directory or path, try changing the path name or check if the file name is correct...");
        }
    }
}