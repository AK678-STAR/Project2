package manager;

import model.Tour;
import model.Homestay;
import java.time.LocalDate;
import java.util.*;

public class TourManager {

    private List<Tour> list = new ArrayList<>();

    public boolean isDuplicate(String id) {
        return findByID(id) != null;
    }

    public Tour findByID(String id) {
        for (Tour t : list)
            if (t.getTourID().equals(id))
                return t;
        return null;
    }

    public void add(Tour t) {
        list.add(t);
        System.out.println("Tour added!");
    }

    public void showAll() {
        for (Tour t : list)
            System.out.println(t);
    }

    public List<Tour> getList() {
        return list;
    }
}