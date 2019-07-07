package franco.rafael.teste_token

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import franco.rafael.teste_token.Contants.IMAGE_CONFIG
import franco.rafael.teste_token.Contants.IMAGES_BASE
import kotlinx.android.synthetic.main.item_row.view.*

class MoviesAdapter(private val movies: List<Movie>,
                    private val context : Context) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = movies[position].title
        Picasso.get().load(IMAGES_BASE + IMAGE_CONFIG + movies[position].poster_path).into(holder.image)
        holder.container.setOnClickListener{
            val i = Intent(context,MovieDetailsActivity::class.java)
            i.putExtra("movie",movies[position])
            context.startActivity(i)
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val container = itemView.container
        val title = itemView.tv_title
        val image = itemView.iv_poster
    }
}
