package com.example.ardin.alltherecipes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var mListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mListView = recipe_list_view

        val recipeList: ArrayList<Recipe> = Recipe.getRecipesFromFile("recipes.json", this)

        // 2
        val listItems = arrayOfNulls<String>(recipeList.size)

        // 3
        for (i in 0 until recipeList.size) {
            val recipe = recipeList[i]
            listItems[i] = recipe.title
        }

        // 4 memasukkan data ke dalam view
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        mListView.adapter = adapter
    }
}
