import java.io.*;
import java.util.Scanner;

public class AdventureTime {
    public static void main(String[] args) throws IOException {
int challengeOneAnswer = challengeOne("inputOneTwo.txt");
int challengeTwoAnswer = challengeTwo("inputOneTwo.txt");
int challengeThreeAnswer = challengeThree ("inputThreeFour.txt");
int challengeFourAnswer = challengeFour("inputThreeFour.txt");

writeFileAllAnswers("AdventureTime.txt", challengeOneAnswer, challengeTwoAnswer, challengeThreeAnswer, challengeFourAnswer);

    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int[] temp = readFileInt(fileName);
        int c = 0;
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] > temp[i-1]){
            c++;
        }
    }
        return c;
    }


    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] temp = readFileInt(fileName);
        int count = 0;
        for (int i = 3; i<temp.length; i++){
            int sum1 = temp[i-3] + temp[i-2] + temp[i-1];
            int sum2 = temp[i-2] + temp[i-1] + temp[i];
            if (sum2> sum1){
                count ++;
            }

        }
        return count;
    }

    public static int challengeThree(String fileName) throws FileNotFoundException {
        String[] cs = readFileString(fileName).split("\n");
        int h = 0;
        int d = 0;

        for (String c : cs) {
            String[] parts = c.split(" ");
            int v = Integer.parseInt(parts[1]);
            switch (parts[0]) {
                case "forward":
                    h += v;
                    break;
                case "down":
                    d += v;
                    break;
                case "up":
                    d -= v;
                    break;
            }
        }
        return h * d;
    }

    public static int challengeFour(String filename) throws FileNotFoundException {
        String[] commands = readFileString(filename).split("\n"); // Read commands from the file
        int h = 0;
        int d = 0;
        int a = 0;

        for (String command : commands) {
            String[] ps = command.split(" ");
            String direction = ps[0];
            int v = Integer.parseInt(ps[1]);

            switch (direction) {
                case "down":
                    a += v;
                    break;
                case "up":
                    a -= v;
                    break;
                case "forward":
                    h += v;
                    d += a * v;
                    break;
            }
        }

        return h * d;
    }
    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFileInt(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;

        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static String readFileString(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        StringBuilder dataBuilder = new StringBuilder();

        while (scanner.hasNextLine()) {
            dataBuilder.append(scanner.nextLine()).append(System.lineSeparator());
        }
        scanner.close();

        return dataBuilder.toString().trim(); // Trim to remove the last newline
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}