package fr.northborders.trendingrepos.ui.screens.repos

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import fr.northborders.trendingrepos.ui.model.RepoViewModel
import fr.northborders.trendingrepos.ui.screens.repodetail.view.RepoDetailActivity
import kotlinx.android.synthetic.main.item_repo.view.*

class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun renderRepo(repoViewModel: RepoViewModel) {
        itemView.repo_owner_avatar.load(repoViewModel.owner.avatarUrl)
        itemView.repo_name.text = repoViewModel.name
        itemView.repo_desc.text = repoViewModel.description
        itemView.repo_stars.text = String.format("Stars: %d", repoViewModel.starGazersCount)
        itemView.setOnClickListener {
            val intent = RepoDetailActivity.newIntent(itemView.context, repoViewModel)
            itemView.context.startActivity(intent)
        }
    }
}