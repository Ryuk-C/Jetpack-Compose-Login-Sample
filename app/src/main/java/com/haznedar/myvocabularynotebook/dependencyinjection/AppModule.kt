package com.haznedar.myvocabularynotebook.dependencyinjection

import com.haznedar.myvocabularynotebook.data.remote.WordsApi
import com.haznedar.myvocabularynotebook.data.repository.WordsRepository
import com.haznedar.myvocabularynotebook.data.repository.WordsRepositoryInterface
import com.haznedar.myvocabularynotebook.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun wordApiRepository(api: WordsApi) = WordsRepository(api) as WordsRepositoryInterface

    @Singleton
    @Provides
    fun injectBackendRetrofitApi() : WordsApi {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.TYPEONE)
            .build()
            .create(WordsApi::class.java)
    }


}