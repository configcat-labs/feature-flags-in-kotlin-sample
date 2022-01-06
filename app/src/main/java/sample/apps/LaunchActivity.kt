package sample.apps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.launch_screen.*
import kotlin.coroutines.coroutineContext

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launch_screen)

        Glide.with(applicationContext)
            .load(R.drawable.black_bg_coffee)
            .centerCrop()
            .into(launcher_image_bg)

        just_text.bringToFront()
        coffee_text.bringToFront()

        launch_app_button.setOnClickListener(View.OnClickListener { view ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }
}
