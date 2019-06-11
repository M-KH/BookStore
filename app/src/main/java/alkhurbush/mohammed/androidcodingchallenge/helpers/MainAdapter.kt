package alkhurbush.mohammed.androidcodingchallenge.helpers

import alkhurbush.mohammed.androidcodingchallenge.R
import alkhurbush.mohammed.androidcodingchallenge.models.Book
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*


class MainAdapter(private val books: List<Book>): RecyclerView.Adapter<MainAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(view: CustomViewHolder, position: Int) {
        view.textViewBookName.text = books[position].title
        val bookImage = view.imageViewBook?.imageView_Book
        Picasso.get().load(books[position].imageURL).into(bookImage)
        view.textViewAuthor.text = books[position].author

    }


    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textViewBookName: TextView = itemView.textView_book
        val imageViewBook: ImageView? = itemView.imageView_Book
        val textViewAuthor: TextView = itemView.textView_author
    }
}