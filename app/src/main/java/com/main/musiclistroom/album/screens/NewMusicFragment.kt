package com.main.musiclistroom.album.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.main.musiclistroom.R
import com.main.musiclistroom.album.room_database.music.Music
import com.main.musiclistroom.album.viewmodel.MusicViewModel
import kotlinx.android.synthetic.main.fragment_new_music.*


class NewMusicFragment : Fragment(),View.OnClickListener {
    val musicViewModel by activityViewModels<MusicViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_music, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveNewMusic.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        val musicArtistName = musicArtistName.text.toString()
        val musicTitle = musicTitle.text.toString()
        val musicImage = musicImage.text.toString()
        when (v) {
            saveNewMusic -> {
                if (musicArtistName == "" || musicTitle == "" || musicImage == "") {
                    Toast.makeText(
                        activity,
                        "Cant input empty form, fill all the form",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    musicViewModel.addMusicList(
                        Music(
                            musicArtistName = musicArtistName,
                            musicTitle = musicTitle,
                            musicImage = musicImage
                        )
                    )
                    Toast.makeText(activity, "Added new music", Toast.LENGTH_SHORT).show()
                    activity?.onBackPressed()
                }
            }
        }
    }
}