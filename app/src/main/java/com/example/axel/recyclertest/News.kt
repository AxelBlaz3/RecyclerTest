package com.example.axel.recyclertest

/**
 * Created by Axel on 01-03-2018.
 */
class News(val totalResults: Int, val articles: List<Articles>)

class Articles(val source: Source, val author: String, val title: String, val description: String, val url: String, val urlToImage: String)
class Source(val name: String)