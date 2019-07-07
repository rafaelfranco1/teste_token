package franco.rafael.teste_token

import franco.rafael.teste_token.Contants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitConfig {

        private val retrofit: Retrofit

        init {
            this.retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    fun getTMDBService(): TMDBService{
        return this.retrofit.create(TMDBService::class.java)
    }

}