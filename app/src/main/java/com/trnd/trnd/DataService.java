package com.trnd.trnd;

import java.util.ArrayList;

/**
 * Created by Prasad.Marineni on 6/15/2017.
 */

public class DataService {

    private ArrayList<Data> array;

    public ArrayList<Data> getData() {
        array = new ArrayList<>();
        array.add(new Data("http://www.androidtutorialpoint.com/wp-content/uploads/2016/11/Katrina-Kaif.jpg", "Hi I am Katrina Kaif. Wanna chat with me ?. " +
                "  Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        array.add(new Data("http://www.androidtutorialpoint.com/wp-content/uploads/2016/11/Emma-Watson.jpg", "Hi I am Emma Watson. Wanna chat with me ? " +
                "  Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        array.add(new Data("http://www.androidtutorialpoint.com/wp-content/uploads/2016/11/Scarlett-Johansson.jpg", "Hi I am Scarlett Johansson. Wanna chat with me ? " +
                "  Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        array.add(new Data("http://www.androidtutorialpoint.com/wp-content/uploads/2016/11/Priyanka-Chopra.jpg", "Hi I am Priyanka Chopra. Wanna chat with me ? " +
                "  Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        array.add(new Data("http://www.androidtutorialpoint.com/wp-content/uploads/2016/11/Deepika-Padukone.jpg", "Hi I am Deepika Padukone. Wanna chat with me ? " +
                "  Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        array.add(new Data("http://www.androidtutorialpoint.com/wp-content/uploads/2016/11/Anjelina-Jolie.jpg", "Hi I am Anjelina Jolie. Wanna chat with me ? " +
                "  Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        array.add(new Data("http://www.androidtutorialpoint.com/wp-content/uploads/2016/11/Aishwarya-Rai.jpg", "Hi I am Aishwarya Rai. Wanna chat with me ? " +
                "  Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));

        return array;
    }

    public Data getNextItem(Integer itemNumber) {
        if(array == null || array.isEmpty()) {
            this.getData();
        }
        if(array != null && array.size() > itemNumber) {
            return array.get(itemNumber);
        } else {
            return null;
        }
    }

    public int getDataSize() {
        if(array == null || array.isEmpty()) {
            this.getData();
            return array.size();
        } else {
            return array.size();
        }
    }
}
