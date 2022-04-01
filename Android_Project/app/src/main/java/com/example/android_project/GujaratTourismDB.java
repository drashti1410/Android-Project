package com.example.android_project;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Registration.class,AttractionClass.class}, version = 2, exportSchema = false)
public abstract class GujaratTourismDB extends RoomDatabase {

    public abstract RegistrationDAO regDAO();
    public abstract AttractionDAO attractionDAO();

    private static volatile GujaratTourismDB INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static GujaratTourismDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (GujaratTourismDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            GujaratTourismDB.class, "GujaratTourism_database")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
