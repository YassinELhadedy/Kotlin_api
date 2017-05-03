package album2.yassinelhadedy.github.com.albumapp2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.bumptech.glide.Glide
import retrofitrx.yassinelhadedy.github.com.albumapp.model.Photo

class Details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val imageview=findViewById(R.id.imageview)as ImageView
        val photo=intent.getSerializableExtra(PHOTO)as Photo?
        photo?.webformatURL.let {
            Glide.with(this).load(photo?.webformatURL).into(imageview)

        }
        imageview.setOnClickListener { finish() }

    }
    companion object{
        val PHOTO="PHOTO"
    }
}
