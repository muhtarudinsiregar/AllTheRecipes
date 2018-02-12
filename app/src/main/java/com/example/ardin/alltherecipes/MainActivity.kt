package com.example.ardin.alltherecipes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var mListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recipeList: ArrayList<Recipe> = Recipe.getRecipesFromFile("recipes.json", this)


        // 4 memasukkan data ke dalam view
        val adapter = RecipeAdapter(this, recipeList)
        mListView = recipe_list_view
        mListView.adapter = adapter
    }
}
