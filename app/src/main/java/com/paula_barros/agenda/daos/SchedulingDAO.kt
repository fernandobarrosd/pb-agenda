package com.paula_barros.agenda.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.paula_barros.agenda.models.Scheduling

@Dao
interface SchedulingDAO {
    @Query("SELECT * FROM scheduling")
    suspend fun findAll() : List<Scheduling>

    @Insert
    suspend fun insert(scheduling: Scheduling)
}