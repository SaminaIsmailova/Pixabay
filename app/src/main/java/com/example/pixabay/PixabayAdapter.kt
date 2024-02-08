package com.example.pixabay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pixabay.databinding.ItemImageBinding

class  PixaViewHolder(private var binding:ItemImageBinding): RecyclerView.ViewHolder(binding.root){
    fun onBind(image: ImageModel) {
        with(binding){
            likeTV.text = image.likes.toString()
            pixaImage.load(image.largeImageURL)
        }
    }

}

class PixaAdapter( var list: ArrayList<ImageModel>): RecyclerView.Adapter<PixaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixaViewHolder {
        return PixaViewHolder(
            ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PixaViewHolder, position: Int) {
        holder.onBind(list [position])
    }
}