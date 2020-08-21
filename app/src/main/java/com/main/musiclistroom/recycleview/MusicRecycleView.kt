package com.main.musiclistroom.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.main.musiclistroom.R
import com.main.musiclistroom.room.music.Music
import kotlinx.android.synthetic.main.music_list_recycle_view_layout.view.*

class MusicRecycleView(
    private val musicList: List<Music>
) :
    RecyclerView.Adapter<MusicViewHolder>() {
    lateinit var navController: NavController
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.music_list_recycle_view_layout, parent, false)
        return MusicViewHolder(view)
    }

    override fun getItemCount(): Int {
        return musicList.size
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val musicTitle = musicList[position].musicTitle
        val musicArtistName = musicList[position].musicArtistName
        val musicImageURL = musicList[position].musicImage
        val musicId = musicList[position].musicId.toString()
        println("INI $musicId $musicTitle $musicArtistName $musicImageURL")
        holder.musicTitle.text = musicTitle
        holder.musicArtistName.text = musicArtistName
        holder.musicImage.load(musicImageURL)
        holder.itemView.musicClick.setOnClickListener {
            navController = Navigation.findNavController(it)
            navController.navigate(
                R.id.action_musicHomeFragment_to_detailMusicFragment, bundleOf(
                    "musicTitle" to musicTitle,
                    "musicArtistName" to musicArtistName,
                    "musicImageURL" to musicImageURL,
                    "musicId" to musicId
                )
            )
        }
    }
}

class MusicViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val musicImage = v.findViewById<ImageView>(R.id.musicImage)
    val musicTitle = v.findViewById<TextView>(R.id.musicTitle)
    val musicArtistName = v.findViewById<TextView>(R.id.musicArtistName)
}