package com.paula_barros.agenda.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scheduling")
data class Scheduling(
    @PrimaryKey
    val id : Long = 0L,

    @ColumnInfo("allowed_hour")
    val allowedHour: String
)
