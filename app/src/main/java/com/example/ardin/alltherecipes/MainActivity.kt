package com.example.ardin.alltherecipes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var mListView: ListView
    val context: Context? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recipeList: ArrayList<Recipe> = Recipe.getRecipesFromFile("recipes.json", this)


        // 4 memasukkan data ke dalam view
        val adapter = RecipeAdapter(this, recipeList)
        mListView = recipe_list_view
        mListView.adapter = adapter

        mListView.onItemClickListener = object : AdapterView.OnItemClickListener {

            override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // 1 get recipe by position/index
                val selectedRecipe = recipeList[position]

                // 2 create intent to navigate to RecipeDetail
                val detailIntent = Intent(context, RecipeDetailActivity::class.java)

                // 3 let RecipeDetailActivity know title and url to display by passing data via intent
                detailIntent.putExtra("title", selectedRecipe.title)
                detailIntent.putExtra("url", selectedRecipe.instructionUrl)

                // 4 start/launch the actifity(RecipeDetailActivity)
                startActivity(detailIntent)
            }

        }
    }
}
