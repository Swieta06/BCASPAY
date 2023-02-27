package com.example.bcaspay.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bcaspay.databinding.ItemNewsBinding
import com.example.bcaspay.model.NewsModel

class HomeMainAdapter(private val dataNews:List<NewsModel>
) : RecyclerView.Adapter<HomeMainAdapter.HomeMainViewOlder>() {

    inner class HomeMainViewOlder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bindView(data:NewsModel) {
            binding.ivItemNews.setImageResource(data.image?:0)
            binding.ivItemNewsIcon.setImageResource(data.icon?:0)
            binding.tvTitleCard.text=data.title
            binding.tvDescCard.text=data.subtitle

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeMainViewOlder =
        HomeMainViewOlder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount():Int=dataNews.size

    override fun onBindViewHolder(holder: HomeMainViewOlder, position: Int) {
        holder.bindView(dataNews[position])
    }


}