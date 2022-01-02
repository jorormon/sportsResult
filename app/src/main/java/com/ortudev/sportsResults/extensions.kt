package com.ortudev.sportsResults

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide

fun ViewGroup.inflate(@LayoutRes resource: Int): View =
    LayoutInflater.from(context).inflate(resource, this, false)

fun ImageView.loadUrl(url:String){
    Glide.with(this).load(url).into(this)
}