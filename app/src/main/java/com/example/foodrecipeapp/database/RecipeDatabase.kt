package com.example.foodrecipeapp.database

import android.content.Context
import androidx.room.*
import com.example.foodrecipeapp.dao.RecipeDao
import com.example.foodrecipeapp.entities.*
import com.example.foodrecipeapp.entities.converter.CategoryListConverter
import com.example.foodrecipeapp.entities.converter.MealListConverter
import kotlin.coroutines.CoroutineContext


@Database(entities = [Recipes::class,CategoryItems::class,Category::class, Meal::class,MealsItems::class],version = 1,exportSchema = false)
@TypeConverters(CategoryListConverter::class, MealListConverter::class)
abstract class RecipeDatabase: RoomDatabase(){

    companion object{

        var recipesDatabase:RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase{
            if (recipesDatabase == null){
                recipesDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).build()
            }
            return recipesDatabase!!
        }

    }

    abstract fun recipeDao():RecipeDao
}