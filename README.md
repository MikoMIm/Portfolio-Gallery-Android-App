# Portfolio Gallery Android App 

## Introduction

Portfolio Gallery's Android app, ESGallery, showcases the work of photographer Roger Fenton

## Features

Main Gallery: Users can explore a curated collection of Roger Fenton's photographs. This feature is implemented in GalleryActivity.kt and uses a ViewPager2 for image display. Each image is accompanied by details such as the title, artist, medium, and date.

Biography: A dedicated section provides an in-depth look at Roger Fenton's life and contributions to photography, as outlined in BiographyActivity.kt. This feature loads an image of Roger Fenton and offers a link to a full article on Wikipedia.

Contact Us: This feature, implemented in SendEmail.kt, allows users to send emails directly from the app, facilitating easy contact and feedback.

Web View: WebViewActivity.kt offers additional online resources through an integrated web view.

## Technical Details
The app checks for internet connectivity and handles scenarios with no internet access.
Firebase is used for app services.
