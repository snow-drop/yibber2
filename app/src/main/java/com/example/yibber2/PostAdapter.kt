package com.example.yibber2

import android.content.Context
import android.text.Html
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post.view.*
import kotlinx.android.synthetic.main.post_actions.view.*

class PostAdapter(val context: Context, val posts: List<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(post: Post?) {
            post?.let {
                itemView.imgProfilePhoto.setImageResource(post.profilePhotoUrl!!.toInt())
                itemView.txtUsername.text = post.username
                itemView.txtStatus.text =
                    "${getRelativeTime(post)} \uA78F${getLocation(post)} ${post.playCount} Plays"
                itemView.imgPhoto.setImageResource(post.photoUrl!!.toInt())
                itemView.txtTitle.text = post.title
                itemView.txtCaption.text = Html.fromHtml(post.caption)
                itemView.btnReact.text = post.reactCount.toString()
                itemView.btnComment.text = post.commentCount.toString()
                itemView.btnShare.text = post.shareCount.toString()
            }
        }

        private fun getLocation(post: Post): String {
            var location = ""
            post.location?.let {
                location = " ${post.location} \uA78F"
            }
            return location
        }

        private fun getRelativeTime(post: Post): String {
            val due = System.currentTimeMillis() + 864000
            return DateUtils.getRelativeTimeSpanString(
                due,
                post.timePosted,
                DateUtils.DAY_IN_MILLIS,
                DateUtils.FORMAT_ABBREV_ALL
            )
                .toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.post, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.setData(post)
    }
}