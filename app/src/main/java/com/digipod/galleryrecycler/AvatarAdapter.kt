package com.digipod.galleryrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.digipod.galleryrecycler.databinding.LayoutAvatarCardBinding

class AvatarAdapter(
    private val layout: Int,
    private val avatars: List<Avatar>,
    val onItemClick: (Avatar) -> Unit,
    val onIconClick: (Avatar) -> Unit
) : RecyclerView.Adapter<AvatarAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: LayoutAvatarCardBinding = LayoutAvatarCardBinding.bind(itemView)
        fun bind(item: Avatar) {
            binding.apply {
                txtTitle.text = item.title
                imgAvatar.setImageResource(item.image)
                imgFav.setImageResource(if (item.status) R.drawable.ic_fav_selected else R.drawable.ic_fav)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(avatars[position])
        holder.binding.card.setOnClickListener { onItemClick(avatars[position]) }
        holder.binding.imgFav.setOnClickListener { onIconClick(avatars[position]) }
    }

    override fun getItemCount() = avatars.size


}