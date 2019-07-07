package franco.rafael.teste_token

import franco.rafael.teste_token.Contants.TOP_RATED
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface TMDBService {

    @GET(TOP_RATED)
    fun getTopRated(
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ) : Call<MoviesList>
}