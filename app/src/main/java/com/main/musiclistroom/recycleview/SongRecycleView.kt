package com.main.musiclistroom.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.main.musiclistroom.R
import com.main.musiclistroom.room.song.SongPlaylist
import kotlinx.android.synthetic.main.song_list_recycle_view_layout.view.*

class SongRecycleView(private val songList: SongPlaylist) : RecyclerView.Adapter<SongViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.song_list_recycle_view_layout, parent, false)
        return SongViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songList.songPlaylist.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val songName = songList.songPlaylist[position].songName
        val songDuration = songList.songPlaylist[position].songDuration
        holder.songName.text = songName
        holder.songDuration.text = songDuration
        holder.songPlayButton.load(R.drawable.ic_baseline_play_arrow_24)
        holder.itemView.songClick.setOnClickListener {
            if (holder.songPlayButton.tag == null) {
                holder.songPlayButton.load(R.drawable.ic_baseline_pause_24)
                holder.songPlayButton.tag = 1
            } else {
                holder.songPlayButton.load(R.drawable.ic_baseline_play_arrow_24)
                holder.songPlayButton.tag = null
            }
        }
    }
}

class SongViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val songName = v.findViewById<TextView>(R.id.songName)
    val songDuration = v.findViewById<TextView>(R.id.songDuration)
    val songPlayButton = v.findViewById<ImageView>(R.id.songPlayButton)
}