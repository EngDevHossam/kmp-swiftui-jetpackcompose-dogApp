package com.hossam.dogify.usecase

import com.hossam.dogify.model.Breed
import com.hossam.dogify.repository.BreedsRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class GetBreedsUseCase : KoinComponent {

    private val breedsRepository: BreedsRepository = get()

    suspend operator fun invoke(): List<Breed> = breedsRepository.get()
}