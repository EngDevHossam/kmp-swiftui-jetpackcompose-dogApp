package com.hossam.dogify.repository

import com.hossam.dogify.model.Breed
import kotlinx.coroutines.flow.Flow

interface BreedsLocalSource {

    val breeds: Flow<List<Breed>>

    suspend fun selectAll(): List<Breed>

    suspend fun insert(breed: Breed)

    suspend fun update(breed: Breed)

    suspend fun clear()
}