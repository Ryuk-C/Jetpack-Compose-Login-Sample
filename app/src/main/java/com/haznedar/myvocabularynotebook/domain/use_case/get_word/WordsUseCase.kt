package com.haznedar.myvocabularynotebook.domain.use_case.get_word

import com.haznedar.kelimedefterim.model.KelimelerModel
import com.haznedar.myvocabularynotebook.data.repository.WordsRepository
import com.haznedar.myvocabularynotebook.util.Resource
import com.haznedar.myvocabularynotebook.util.internetCheck
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WordsUseCase @Inject constructor(

    private val repository: WordsRepository

) {

    operator fun invoke(
        Url: String,
        AppCode: String,
        UserLanguageID: String,
        UserID: String
    ): Flow<Resource<KelimelerModel>> = flow {

        try {

            emit(Resource.Loading())

            val process = repository.listAllWords(Url, AppCode, UserLanguageID, UserID)

            coroutineScope {

                emit(Resource.Success(process))

            }

        } catch (e: HttpException) {

            emit(Resource.Error(e.localizedMessage ?: "Beklenmedik bir hata oluştu!"))

        } catch (e: IOException) {

            if (!internetCheck()) {

                emit(Resource.Internet("Sunucuya ulaşılamadı. İnternet bağlantınızı kontrol ediniz!"))

            }
        }
    }
}