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
    private val bottomSheet = BottomSheet(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val imageView = createImageView()
        return ImageViewHolder(imageView)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageInfo = imageInfoList[position]
        loadImage(holder.imageView, imageInfo.imageIndex)
        setItemClick(holder, imageInfo)
    }

    override fun getItemCount(): Int = imageInfoList.size

    private fun createImageView(): ImageView {
        return ImageView(context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
    }

    private fun loadImage(imageView: ImageView, imageIndex: String) {
        loader.loadImage(imageView, imageIndex)
    }

    private fun setItemClick(holder: ImageViewHolder, imageInfo: ImageInfo) {
        holder.itemView.setOnClickListener {
            bottomSheet.show(imageInfo.title, imageInfo.description)
        }
    }

    inner class ImageViewHolder(val imageView: ImageView) : RecyclerView.ViewHolder(imageView)
}