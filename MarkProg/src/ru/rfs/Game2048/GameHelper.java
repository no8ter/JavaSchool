package ru.rfs.Game2048;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameHelper {
    public List<Integer> moveAndMergeEqual(List<Integer> list) {
        List<Integer> ret = new ArrayList<>(Collections.nCopies(list.size(), null));

        int currentId = 0;
        for (int i = 0; i < list.size(); i++) {

            // First step
            if (i == 0) {
                if (list.get(i) != null) {
                    ret.set(currentId, list.get(i));
                }
            // Main logic
            } else {
                if (list.get(i) != null) {                       // Not null cell
                    if (ret.get(currentId) != list.get(i)) {     // Common number
                        if (ret.get(currentId) != null) {
                            currentId++;
                        }
                        ret.set(currentId, list.get(i));
                    } else {                                     // Found duplicate
                        ret.set(currentId, list.get(i)*2);
                        currentId++;
                    }
                }
            }
        }

        return ret;
    }
}