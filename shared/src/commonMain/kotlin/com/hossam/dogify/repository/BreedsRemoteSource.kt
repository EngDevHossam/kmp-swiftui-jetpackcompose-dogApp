package com.hossam.dogify.repository

interface BreedsRemoteSource {

    suspend fun getBreeds(): List<String>

    suspend fun getBreedImage(breed: String): String
}