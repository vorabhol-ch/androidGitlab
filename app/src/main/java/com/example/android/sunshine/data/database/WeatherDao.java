package com.example.android.sunshine.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Date;

/**
 * Created by TNGP17-001 on 08-Feb-18.
 */
@Dao
public interface WeatherDao {

    @Query("SELECT * FROM weathere WHERE date = :date")
    WeatherEntry getWeatherByDate(Date date);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsert(WeatherEntry ...weathere);
}
