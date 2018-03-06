package fr.northborders.trendingrepos.ui.repos

import android.support.v7.widget.RecyclerView
import android.view.View
import com.squareup.picasso.Picasso
import fr.northborders.trendingrepos.ui.model.RepoViewModel
import kotlinx.android.synthetic.main.item_repo.view.*

class RepoViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    fun renderRepo(repoViewModel: RepoViewModel) {
        Picasso.with(itemView.context).load(repoViewModel.owner.avatarUrl).into(itemView.repo_owner_avatar)
        itemView.repo_name.text = repoViewModel.name
        itemView.repo_desc.text = repoViewModel.description
        itemView.repo_stars.text = String.format("Stars: %d", repoViewModel.starGazersCount)
        itemView.setOnClickListener {  }
    }
}