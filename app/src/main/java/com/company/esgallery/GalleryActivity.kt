package com.company.esgallery

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.company.esgallery.classes.ImageAdapter
import com.company.esgallery.classes.ImageInfo
import com.company.esgallery.classes.Loader


class GalleryActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var imageInfoList: List<ImageInfo>
    private lateinit var loader: Loader
    private lateinit var imageCounter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        initializeImageInfoList()
        loader = Loader(this)

        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = ImageAdapter(this, imageInfoList, loader)

        imageCounter = findViewById(R.id.imageCounter)
        updateImageCounter(1, imageInfoList.size)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateImageCounter(position + 1, imageInfoList.size)
            }
        })
    }

    private fun initializeImageInfoList() {
        imageInfoList = listOf(
            ImageInfo(
                "01_valley_of_the_shadow_of_death",
                "Valley of the shadow of death\n",
                "Artist - Roger Fenton\n\nMedium: Salted paper print from glass negative\n\nDate - Made 1850s."
            ),
            ImageInfo(
                "02_lady_on_horseback",
                "Lady on horseback\n",
                "Artist - Roger Fenton\n\nMedium: Salted paper print from glass negative\n\nDate - Made 1850s."
            ),
            ImageInfo(
                "03_Newcastle_on_Tyne",
                "Newcastle on Tyne\n",
                "Artist - Roger Fenton\n\nMedium: Albumen silver print from glass negative.\n\nDate - 1850s."
            ),
            ImageInfo(
                "04_landscape_with_clouds",
                "Landscape with clouds\n",
                "Artist - Roger Fenton\n\nMedium: Salted paper print from glass negative\n\nDate - probably 1856"
            ),
            ImageInfo(
                "05_Wharfe_and_Pool",
                "Wharfe and Pool\n",
                "Artist - Roger Fenton\n\nMedium: Salted paper print\n\nDate - Made 1854"
            ),
            ImageInfo(
                "06_Landing_Place",
                "Landing Place\n",
                "Artist - Roger Fenton\n\nMedium: Salted paper print from glass negative\n\nDate - Made 1855"
            ),
            ImageInfo(
                "07_The_Refectory_of_the_Imperial_Asylum_at_Vincennes",
                "The Refectory of the Imperial Asylum at Vincennes\n",
                "Artist - Roger Fenton\n\nMedium: Salted paper print from glass negative\n\nDate - Made 1858–59"
            )
        )
    }

    @SuppressLint("SetTextI18n")
    private fun updateImageCounter(currentImageIndex: Int, totalImages: Int) {
        imageCounter.text = "$currentImageIndex / $totalImages"
    }
}