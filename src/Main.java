import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static Doubly readFile() throws FileNotFoundException {
        Doubly titanicDataSet = new Doubly();
        File titanic = new File("dataset.csv");
        Scanner reader = new Scanner(titanic);

        boolean survived;
        int pasClass, age, siblings_spouses, parents_children;
        String name, gender;
        double fare;

        String line;
        String temp = "";

        reader.nextLine();
        while (reader.hasNextLine()) {
            line = reader.nextLine();

            int i = 0;
            for (; line.charAt(i) != ','; i++)
                temp += line.charAt(i);
            survived = Integer.parseInt(temp) != 0;
            temp = "";
            i++;

            for (; line.charAt(i) != ','; i++)
                temp += line.charAt(i);
            pasClass = Integer.parseInt(temp);
            temp = "";
            i++;

            for (; line.charAt(i) != ','; i++)
                temp += line.charAt(i);
            name = temp;
            temp = "";
            i++;

            for (; line.charAt(i) != ','; i++)
                temp += line.charAt(i);
            gender = temp;
            temp = "";
            i++;

            for (; line.charAt(i) != ','; i++)
                temp += line.charAt(i);
            age = (int) Double.parseDouble(temp);
            temp = "";
            i++;

            for (; line.charAt(i) != ','; i++)
                temp += line.charAt(i);
            siblings_spouses = Integer.parseInt(temp);
            temp = "";
            i++;

            for (; line.charAt(i) != ','; i++)
                temp += line.charAt(i);
            parents_children = Integer.parseInt(temp);
            temp = "";
            i++;

            for (; i < line.length(); i++)
                temp += line.charAt(i);
            fare = Double.parseDouble(temp);
            temp = "";


            TitanicData data = new TitanicData(survived, pasClass, name, gender, age, siblings_spouses,
                    parents_children, fare);

            titanicDataSet.add(data);
        }

        return titanicDataSet;
    }

    static double findSafetyLevel(int classNum, Doubly titanicDataSet) {
        double survivedPasNum = 0;
        double pasNum = 0;
        for (int i = 0; i < titanicDataSet.size(); i++)
            if (titanicDataSet.get(i).getPasClass() == classNum) {
                pasNum++;
                if (titanicDataSet.get(i).getSurvived())
                    survivedPasNum++;
            }
        return survivedPasNum / pasNum;
    }

    static int safestClass(Doubly titanicDataSet) {
        double[] safestClassArr = new double[3];
        int safestClass = 1;

        for (int i = 0; i < safestClassArr.length; i++)
            safestClassArr[i] = findSafetyLevel(i + 1, titanicDataSet);

        for (int i = 1; i < safestClassArr.length; i++)
            if (safestClassArr[safestClass - 1] < safestClassArr[i])
                safestClass = i + 1;

        return safestClass;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Doubly titanicDataSet = readFile();
        System.out.println("The safest class of the passengers was: Class " + safestClass(titanicDataSet) + ".");
    }
}