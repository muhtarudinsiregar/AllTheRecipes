package com.example.ardin.alltherecipes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.ardin.alltherecipes.R.id.*
import com.squareup.picasso.Picasso


class RecipeAdapter(context: Context, items: ArrayList<Recipe>) : BaseAdapter() {
    var mContext: Context = context
    var mInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater;
    var mDataSource: ArrayList<Recipe> = items


    //getView() creates a view to be used as a row in the list.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        //init
        val rowView = mInflater.inflate(R.layout.list_item_recipe, parent, false)
        val titleTextView = rowView.findViewById(R.id.recipe_list_title) as TextView
//        val titleTextView = recipe_list_title as TextView
        val subtitleTextView = rowView.findViewById(recipe_list_subtitle) as TextView
        val detailTextView = rowView.findViewById(recipe_list_detail) as TextView
        val thumbnailImageView = rowView.findViewById(recipe_list_thumbnail) as ImageView

        //get item recipe by position
        val recipe = getItem(position) as Recipe

        //set row with data to display data recipe
        titleTextView.setText(recipe.title)
        subtitleTextView.setText(recipe.description)
        detailTextView.setText(recipe.label)
        Picasso.with(mContext).load(recipe.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView)

        return rowView
    }

    override fun getItem(position: Int): Any {
        return mDataSource.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return mDataSource.size
    }
}