package com.example.foodrecipeapp.entities

import androidx.annotation.ColorInt
import androidx.room.*
import java.io.Serializable

@Entity(tableName = "Recipes")
data class Recipes (
    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @ColumnInfo(name = "dishName")
    var dishName: String
    ):Serializable
