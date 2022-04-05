/**
 * Created by Yulya Telysheva
 */
package lesson5.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AppData {
    private String[] headers;
    private Integer[][] data;

    @Override
    public String toString() {
        return "AppData " +
                "headers = " + Arrays.toString(headers) +
                ", data = " + Arrays.deepToString(data);
    }

    void load(String fileName) {
        ArrayList<Integer[]> integersFromCSV = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            headers = bufferedReader.readLine().split(";");
            integersFromCSV.add(StringToIntArr(bufferedReader.readLine().split(";")));
            integersFromCSV.add(StringToIntArr(bufferedReader.readLine().split(",")));
            data = integersFromCSV.toArray(new Integer[][]{{}});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Integer[] StringToIntArr(String[] strings) {
        Integer[] intsFromStrings = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            intsFromStrings[i] = Integer.parseInt(strings[i]);
        }
        return intsFromStrings;
    }

    void save(String fileToSave) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileToSave))) {
            bufferedWriter.write(headersToString());
            bufferedWriter.write(firstRowFromDataToSave());
            bufferedWriter.write(secondRowFromDataToSave());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    String headersToString() {
        String headersToSave = "";
        for (int i = 0; i < headers.length; i++) {
            if (i < headers.length - 1) {
                headersToSave += headers[i] + ";";
            } else {
                headersToSave += headers[i] + "\n";
            }
        }
        return headersToSave;
    }

    String firstRowFromDataToSave() {
        StringBuilder firstRow = new StringBuilder();
        for (int i = 0; i < data[0].length; i++) {
            if (i < data[0].length - 1) {
                firstRow.append(data[0][i]).append(";");
            } else {
                firstRow.append(data[0][i]).append("\n");
            }
        }
        return firstRow.toString();
    }

    String secondRowFromDataToSave() {
        StringBuilder firstRow = new StringBuilder();
        for (int i = 0; i < data[1].length; i++) {
            if (i < data[1].length - 1) {
                firstRow.append(data[1][i]).append(";");
            } else {
                firstRow.append(data[1][i]).append("\n");
            }
        }
        return firstRow.toString();
    }
}
