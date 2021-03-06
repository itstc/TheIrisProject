/*
 * Copyright (c) Team 7, CMPUT301, University of Alberta - All Rights Reserved. You may use, distribute, or modify this code under terms and conditions of the Code of Students Behavior at University of Alberta
 *
 *
 */

package com.team7.cmput301.android.theirisproject;

import android.app.Application;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.team7.cmput301.android.theirisproject.model.User;
import com.searchly.jestdroid.JestDroidClient;
import com.team7.cmput301.android.theirisproject.task.Callback;
import com.team7.cmput301.android.theirisproject.task.GetUserDataTask;

import io.searchbox.client.JestClient;

/**
 * IrisProjectApplication is the main class to start our app.
 * This class will initialize all the global states of models
 * which can then allow our activity controllers to populate it.
 *
 * @author itstc
 * */
public class IrisProjectApplication extends Application {
    // use this index for any request to database
    public static final String INDEX = "cmput301f18t07test";

    // our database connection
    transient private static JestDroidClient db = null;
    transient private static User currentUser = null;

    /**
     * getDB is a function to retrieve the online database
     * if the db variable is currently null we will initialize a
     * new connection to the database.
     * @return JestClient: our database
     * */
    public static JestDroidClient getDB() {
        // create new JestClient instance if none
        if (db == null) {
            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(new DroidClientConfig
                    .Builder("http://cmput301.softwareprocess.es:8080")
                    .build());
            db = (JestDroidClient) factory.getObject();
        }
        return db;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

}
