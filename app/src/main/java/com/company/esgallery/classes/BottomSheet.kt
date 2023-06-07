package com.company.esgallery.classes

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.company.esgallery.R

@SuppressLint("InflateParams")
class BottomSheet (private val context: Context) {
    private val bottomSheetView: View by lazy {
        LayoutInflater.from(context).inflate(R.layout.bottom_sheet_layout, null)
    }

    private val imageNameTextView: TextView by lazy {
        bottomSheetView.findViewById<TextView>(R.id.imageNameTextView)
    }

    private val imageDescriptionTextView: TextView by lazy {
        bottomSheetView.findViewById<TextView>(R.id.imageDescriptionTextView)
    }

    private val bottomSheetDialog: BottomSheetDialog by lazy {
        BottomSheetDialog(context).apply {
            setContentView(bottomSheetView)
        }
    }

    fun show(imageName: String, imageDescription: String) {
        imageNameTextView.text = imageName
        imageDescriptionTextView.text = imageDescription
        bottomSheetDialog.show()
    }
}