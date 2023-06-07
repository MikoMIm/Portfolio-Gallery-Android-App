package com.company.esgallery.classes

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView


class ImageAdapter(
    private val context: Context,
    private val imageInfoList: List<ImageInfo>,
    private val loader: Loader
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    private val bottomSheet: BottomSheet by lazy {
        BottomSheet(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val imageView = ImageView(context)
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        imageView.layoutParams = layoutParams
        return ImageViewHolder(imageView)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageInfo = imageInfoList[position]
        loader.loadImage(holder.imageView, imageInfo.imageIndex)

        holder.itemView.setOnClickListener {
            bottomSheet.show(imageInfo.title, imageInfo.description)
        }
    }

    override fun getItemCount(): Int {
        return imageInfoList.size
    }

    inner class ImageViewHolder(val imageView: ImageView) : RecyclerView.ViewHolder(imageView)
}