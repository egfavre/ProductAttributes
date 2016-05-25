package com.egfavre;
import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static final String SAVE_FILE = "birthdayCake.json";
    public static void main(String[] args) throws FileNotFoundException {
        // get Junit and Json libraries
        //create HashMap for attributes
        HashMap birthdayCake = load(SAVE_FILE);
        if (birthdayCake == null) {
            System.out.println("no file found.");
            birthdayCake = new HashMap();
        }
        update(birthdayCake);
        save(birthdayCake, SAVE_FILE);
    }

        //save method convert hashmap to json file

    public static void save(HashMap birthdayCake, String fileName) {
        File f = new File(fileName);
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(birthdayCake);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //load method: read json file
    public static HashMap load(String fileName) {
        File f = new File(fileName);
        try {
            Scanner scanner = new Scanner(f);
            scanner.useDelimiter("\\Z");
            String contents = scanner.next();
            JsonParser parser = new JsonParser();
            return parser.parse(contents);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void update(HashMap birthdayCake) {
        System.out.println("Your current selection is:");
        System.out.println(birthdayCake);

        //options: update & save file
        System.out.println("Would you like to update your selection? [Y/N]");
        Scanner choiceScanner = new Scanner(System.in);
        String update = choiceScanner.nextLine();

        if (update.equalsIgnoreCase("y")) {
            System.out.println("How many tiers would you like?");
            String tiers = choiceScanner.nextLine();
            int tiersNum = Integer.valueOf(tiers);
            System.out.println("What accent color would you like?");
            String color = choiceScanner.nextLine();
            System.out.println("What theme would you like?");
            String theme = choiceScanner.nextLine();
            System.out.println("What flavor cake would you like?");
            String flavor = choiceScanner.nextLine();
            System.out.println("What type of frosting would you like?");
            String frosting = choiceScanner.nextLine();
            birthdayCake.put("tiers", tiersNum);
            birthdayCake.put("accent color", color);
            birthdayCake.put("flavor", flavor);
            birthdayCake.put("frosting type", frosting);
            birthdayCake.put("theme", theme);
        }
    }
}

