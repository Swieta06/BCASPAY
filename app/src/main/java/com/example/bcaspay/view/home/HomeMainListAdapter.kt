package com.example.bcaspay.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bcaspay.databinding.ItemNewsBinding
import com.example.bcaspay.databinding.ItemNewsLatesBinding
import com.example.bcaspay.model.ListModel
import com.example.bcaspay.model.NewsModel

class HomeMainListAdapter(
    private val dataNewsList: List<ListModel>,
    private val onclickNews: (ListModel) -> Unit,
) :
    RecyclerView.Adapter<HomeMainListAdapter.HomeMainViewOlder>() {
    inner class HomeMainViewOlder(val binding: ItemNewsLatesBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bindView(data:ListModel,onclickNews:(ListModel)->Unit) {
            binding.ivItemNewsIconLates.setImageResource(data.image?:0)
            binding.tvTitleCardNewsLates.text=data.title
            binding.tvDescCardNewsLates.text=data.subtitle
            binding.cvItemList.setOnClickListener {
                onclickNews(data)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeMainListAdapter.HomeMainViewOlder =
        HomeMainViewOlder(
            ItemNewsLatesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount():Int=dataNewsList.size

    override fun onBindViewHolder(holder:HomeMainListAdapter.HomeMainViewOlder, position: Int) {
        holder.bindView(dataNewsList[position],onclickNews)
    }


}