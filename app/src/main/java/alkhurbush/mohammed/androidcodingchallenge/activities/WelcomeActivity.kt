package alkhurbush.mohammed.androidcodingchallenge.activities

import alkhurbush.mohammed.androidcodingchallenge.R
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        message.text = "Get 50% off when you buy your first book!"
    }

    fun getStarted(view: View) {
        val intent = Intent(this, BookListActivity::class.java)
        startActivity(intent)
        finish()
    }
}
