package franco.rafael.teste_token

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import franco.rafael.teste_token.Contants.API_KEY
import franco.rafael.teste_token.Contants.LANGUAGE
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Top filmes"
        recycler_view.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)


        //configurações de servidor
        RetrofitConfig().getTMDBService().getTopRated(API_KEY, LANGUAGE)
            .enqueue(object : Callback<MoviesList>{
                override fun onFailure(call: Call<MoviesList>, t: Throwable) {
                    t.printStackTrace()
                }

                override fun onResponse(call: Call<MoviesList>, response: Response<MoviesList>) {
                    recycler_view.adapter = MoviesAdapter(response.body()!!.results,this@MainActivity)
                }

            })

    }

}
