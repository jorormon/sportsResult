package com.ortudev.sportsResults

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide

fun ViewGroup.inflate(@LayoutRes resource: Int): View =
    LayoutInflater.from(context).inflate(resource, this, false)

fun ImageView.loadUrl(url:String){
    Glide.with(this).load(url).into(this)
}

inline fun <reified T: Activity> Context.startActivity(vararg pairs:Pair<String,Any?>){
    val intent = Intent(this,T::class.java)
        .apply{ putExtras(bundleOf(*pairs))
        }
    startActivity(intent)
}