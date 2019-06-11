package alkhurbush.mohammed.androidcodingchallenge.activities

import alkhurbush.mohammed.androidcodingchallenge.R
import alkhurbush.mohammed.androidcodingchallenge.helpers.MainAdapter
import alkhurbush.mohammed.androidcodingchallenge.models.Book
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_book_list.*
import okhttp3.*
import java.io.IOException

class BookListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        setSupportActionBar(toolbar)
        toolbar.title = title
    }

    override fun onResume() {
        super.onResume()

        loadBooks()
    }

    private fun loadBooks() {
        val url = "https://de-coding-test.s3.amazonaws.com/books.json"

        val request = Request.Builder()
            .url(url)
            .build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute $e")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = String(response?.body?.bytes()!!)
//                println("This is the response :::::::::::: ${body}")
                val gson = Gson()
                val listType = object : TypeToken<List<Book>>() { }.type
                val bookList = gson.fromJson<List<Book>>(body, listType)
//                println(bookList)
                runOnUiThread {
                    book_recycler_view.adapter = MainAdapter(bookList)
                    (book_recycler_view.adapter as MainAdapter).notifyDataSetChanged()
                }
            }

        })

    }
}
