package com.example.android.sunshine.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.util.Log;

/**
 * Created by TNGP17-001 on 08-Feb-18.
 */


    @Database(entities = {WeatherEntry.class}, version = 1)
    @TypeConverters(DateConverter.class)
    public abstract class SunshineDatabase extends RoomDatabase{
        private static final String LOG_TAG = com.example.android.sunshine.data.database.SunshineDatabase.class.getSimpleName();
        private static final String DatabaseName  = "weather";

        private static final Object LOCK = new Object();

        private static  SunshineDatabase sInstance;

        public static  SunshineDatabase getsInstance(Context context){
            Log.d(LOG_TAG,"Getting the database");
            if(sInstance == null){
                synchronized (LOCK) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            SunshineDatabase.class, SunshineDatabase.DatabaseName).build();
                    Log.d(LOG_TAG,"Made new database");
                }
            }
            return sInstance;
        }
    public abstract WeatherDao weatherDao();
}
