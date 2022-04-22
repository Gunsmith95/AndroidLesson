package com.example.mylearningandriod

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mylearningandriod.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = R.drawable.image1
    private val imageIdList = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()

    }

    private fun initButtons() = with(binding) {
        btNext.setOnClickListener {
            indexImage++
            if (indexImage > imageIdList.size - 1) indexImage = 0
            imageId = imageIdList[indexImage]
            imageView.setImageResource(imageId)
        }
        btDone.setOnClickListener {
            val photo = Plant(imageId, edTitle.text.toString(), edDescription.text.toString())
            val editIntent = Intent().apply {
                putExtra("photo", photo)
            }
            setResult(RESULT_OK,editIntent)
            finish()
        }
    }

}