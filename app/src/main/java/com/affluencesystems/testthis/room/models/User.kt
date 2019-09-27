package com.affluencesystems.testthis.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class User {

    @PrimaryKey(autoGenerate = true)
    var id: Int = -1

    @ColumnInfo(name = "user_name")
    lateinit var name: String

    @ColumnInfo(name = "user_age")
    lateinit var age: String

    constructor(name: String, age: String) {
        this.name = name
        this.age = age
    }
}