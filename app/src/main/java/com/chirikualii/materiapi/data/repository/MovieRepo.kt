package com.chirikualii.materiapi.data.repository

import com.chirikualii.materiapi.data.remote.model.Movie

interface MovieRepo {
   suspend fun getPopularMovie() : List<Movie>
}