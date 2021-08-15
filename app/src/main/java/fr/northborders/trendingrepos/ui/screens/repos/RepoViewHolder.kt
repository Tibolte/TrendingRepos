package fr.northborders.trendingrepos.ui.screens.repos

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.northborders.trendingrepos.ui.model.RepoViewModel
import fr.northborders.trendingrepos.ui.screens.repodetail.view.RepoDetailActivity
import kotlinx.android.synthetic.main.item_repo.view.*

class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun renderRepo(repoViewModel: RepoViewModel) {
        Picasso.get().load(repoViewModel.owner.avatarUrl).into(itemView.repo_owner_avatar)
        itemView.repo_name.text = repoViewModel.name
        itemView.repo_desc.text = repoViewModel.description
        itemView.repo_stars.text = String.format("Stars: %d", repoViewModel.starGazersCount)
        itemView.setOnClickListener {
            val intent = RepoDetailActivity.newIntent(itemView.context, repoViewModel)
            itemView.context.startActivity(intent)
        }
    }
}