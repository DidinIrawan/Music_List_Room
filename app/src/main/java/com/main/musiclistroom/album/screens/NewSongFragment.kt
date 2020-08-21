package com.main.musiclistroom.album.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.main.musiclistroom.R
import com.main.musiclistroom.album.room_database.song.Song
import com.main.musiclistroom.album.viewmodel.SongViewModel
import kotlinx.android.synthetic.main.fragment_new_song.*


class NewSongFragment : Fragment(), View.OnClickListener {
    val songViewModel by activityViewModels<SongViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_song, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveNewSong.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val songNameInput = songNameInput.text.toString()
        val songDurationInput = songDurationInput.text.toString()
        val musicId = arguments?.getString("musicId")!!.toInt()
        when (v) {
            saveNewSong -> {
                if (songNameInput == "" || songDurationInput == "") {
                    Toast.makeText(
                        activity,
                        "Cant input empty form, fill all the form",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    songViewModel.addSongList(
                        Song(
                            songName = songNameInput,
                            songDuration = songDurationInput,
                            songMusicId = musicId
                        )
                    )
                    Toast.makeText(activity, "Added new song list", Toast.LENGTH_SHORT).show()
                    activity?.onBackPressed()
                }
            }
        }
    }

}