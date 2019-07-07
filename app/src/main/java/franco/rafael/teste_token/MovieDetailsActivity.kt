package franco.rafael.teste_token

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val selectedMovie = intent.extras.getSerializable("movie") as Movie

        title = selectedMovie.title

        movie_title.text = selectedMovie.title
        Picasso.get().load(Contants.IMAGES_BASE + Contants.IMAGE_CONFIG + selectedMovie.poster_path).into(img_movie)
        movie_description.text = selectedMovie.overview
    }
}
