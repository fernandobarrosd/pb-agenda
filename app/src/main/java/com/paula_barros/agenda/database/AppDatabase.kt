package com.paula_barros.agenda.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.paula_barros.agenda.daos.SchedulingDAO
import com.paula_barros.agenda.models.Scheduling

@Database(entities = [Scheduling::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getSchedulingDAO() : SchedulingDAO

    companion object {
        private var INSTANCE : AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase? {
            if (INSTANCE == null ) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "scheduling_db"
                ).build()
            }
            return INSTANCE
        }
    }
}