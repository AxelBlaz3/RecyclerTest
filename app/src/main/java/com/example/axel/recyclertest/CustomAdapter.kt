package com.example.axel.recyclertest

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_model.view.*

/**
 * Created by Axel on 01-03-2018.
 */
class CustomAdapter(val list: News) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val currentNews = list.articles.get(position)
        holder?.itemView?.textView_name?.text = currentNews.source.name + " • "
        holder?.itemView?.textView_author?.text = currentNews.author
        holder?.itemView?.textView_title?.text = currentNews.title
        holder?.itemView?.textView_desc?.text = currentNews.description
        holder?.itemView?.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(currentNews.url))
            holder?.itemView?.context?.startActivity(intent)
        }
        val imageView = holder?.itemView?.imageView
        Picasso
                .with(imageView!!.context)
                .load(currentNews.urlToImage)
                .placeholder(R.drawable.placeholder)
                .resize(1600, 900)
                .centerCrop()
                .into(imageView)
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