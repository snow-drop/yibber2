package com.example.yibber2

class YibberPostApi {
    companion object {
        fun getFeedPostsByUserId(id: Long): List<Post> {
            return listOf(post1(), post2())
        }

        private fun post2(): Post {
            val post = Post()
            post.id = 1L
            post.profilePhotoUrl = R.drawable.pp_kaguya.toString()
            post.username = "lindseynguyen"
            post.timePosted = System.currentTimeMillis()
            post.playCount = 392
            post.photoUrl = R.drawable.post_img_summer_sunset.toString()
            post.title = "Summer Sunset"
            post.caption = "Sunsets are proof that no matter what happens, everyday can end " +
                    "beautifully. <font color=\"#49a1ff\">#sunset #summer</font>"
            post.reactCount = 20
            post.commentCount = 5
            post.shareCount = 2
            return post
        }

        private fun post1(): Post {
            val post = Post()
            post.id = 1L
            post.profilePhotoUrl = R.drawable.pp_kosaki.toString()
            post.username = "billauthor"
            post.timePosted = System.currentTimeMillis()
            post.location = "Boston"
            post.playCount = 138
            post.photoUrl = R.drawable.post_img_skateboard.toString()
            post.title = "Californian Vibes"
            post.caption = "Stop what you're doing! Listen to me and my mate " +
                    "<font color=\"#49a1ff\">@charlyjones</font> for the next hour. " +
                    "<font color=\"#49a1ff\">#california #venice #beach #vibes #yolo</font>"
            post.reactCount = 59
            post.commentCount = 19
            post.shareCount = 7
            return post
        }
    }
}