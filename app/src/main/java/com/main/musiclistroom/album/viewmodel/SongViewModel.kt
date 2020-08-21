package com.main.musiclistroom.album.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.main.musiclistroom.album.room_database.AppRoomDatabase
import com.main.musiclistroom.album.room_database.song.Song
import com.main.musiclistroom.album.room_database.song.SongRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SongViewModel(application: Application) : AndroidViewModel(application) {
    private val songRepository: SongRepository

    init {
        val songDao = AppRoomDatabase.getDatabaseInstance(application).songDao()
        songRepository = SongRepository(songDao)

    }

    fun songList(musicId: Int) = songRepository.allSong(musicId)

    fun addSongList(song: Song) {
        viewModelScope.launch(Dispatchers.IO) {
            songRepository.createSong(song)
        }
    }
}