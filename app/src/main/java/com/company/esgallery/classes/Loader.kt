package com.company.esgallery.classes

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class Loader(private val context: Context) {

    fun loadImage(imageView: ImageView, imageIndex: String) {
        val storageRef = FirebaseStorage.getInstance().reference.child("Picture/$imageIndex.jpg")
        val localFile = File.createTempFile("tempImage", "jpg")

        storageRef.getFile(localFile).addOnSuccessListener {
            Glide.with(context)
                .load(localFile)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView)
        }.addOnFailureListener {}
    }
}