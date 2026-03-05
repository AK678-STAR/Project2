//HomestrayManger
package manager;

import model.Homestay;
import java.io.*;
import java.util.*;

public class HomestayManager {

    private List<Homestay> list = new ArrayList<>();

    public void loadFromFile(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split("-");
                String id = parts[0];
                String name = parts[1];
                int room = Integer.parseInt(parts[2]);
                String address = parts[3];
                int capacity = Integer.parseInt(parts[4]);

                list.add(new Homestay(id, name, room, address, capacity));
            }
            br.close();
            System.out.println("Loaded Homestays!");
        } catch (Exception e) {
            System.out.println("Error loading Homestays.");
        }
    }

    public Homestay findByID(String id) {
        for (Homestay h : list)
            if (h.getHomeID().equals(id))
                return h;
        return null;
    }
}