package com.example.axel.recyclertest

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recycler_model.view.*

/**
 * Created by Axel on 01-03-2018.
 */
class CustomAdapter(val list: News) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        var currentNews = list.articles.get(position)
        holder?.itemView?.textView_name?.text = currentNews.source.name
        holder?.itemView?.textView_author?.text = currentNews.author
        holder?.itemView?.textView_title?.text = currentNews.title
        holder?.itemView?.textView_desc?.text = currentNews.description
    }

    override fun getItemCount(): Int {
        return list.totalResults
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val eachRow = LayoutInflater.from(parent?.context).inflate(R.layout.recycler_model, parent, false)
        return ViewHolder(eachRow)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}