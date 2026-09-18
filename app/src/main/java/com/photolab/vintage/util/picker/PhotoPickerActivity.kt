package com.photolab.vintage.util.picker

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.photolab.vintage.R
import com.photolab.vintage.activity.EditPhotoActivity

class PhotoPickerActivity : AppCompatActivity() {

    private val selectImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        if (uri != null) {
            val intent = Intent(this, EditPhotoActivity::class.java).apply {
                putExtra("SELECTED_PHOTO", uri.toString())
            }
            startActivity(intent)
        }
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.__picker_activity_photo_picker)
        selectImageLauncher.launch("image/*")
    }
}
