package com.example.yibber2

import android.widget.Button

class PostEvents(val post: Post) {
    fun onBtnReactClick(view: Button) {
        val reactedAlready = YibberPostApi.react(post.id!!, YibberPostApi.CURRENT_USER_ID)
        var drawable: Int
        val count = view.text.toString().toInt()
        if (reactedAlready) {
            drawable = R.drawable.ic_heart_white
            view.text = (count - 1).toString()
        } else {
            drawable = R.drawable.ic_heart_red
            view.text = (count + 1).toString()
        }
        view.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, 0, 0, 0)
    }
}