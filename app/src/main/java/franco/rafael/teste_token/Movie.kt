package franco.rafael.teste_token

import java.io.Serializable

data class Movie(
    val title : String,
    val poster_path : String,
    val overview : String
) : Serializable