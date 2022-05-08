package com.haznedar.myvocabularynotebook.domain.use_case.get_signin

import com.haznedar.myvocabularynotebook.data.repository.WordsRepository
import com.haznedar.myvocabularynotebook.domain.model.CrudModel
import com.haznedar.myvocabularynotebook.util.Resource
import com.haznedar.myvocabularynotebook.util.internetCheck
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SignInUseCase @Inject constructor(

    private var repository: WordsRepository

) {

    operator fun invoke(Url: String, AppCode: String, Email: String, Password: String): Flow<Resource<CrudModel>> = flow {

        try {

            emit(Resource.Loading())

            val process = repository.userRegister(Url, AppCode, Email, Password)

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