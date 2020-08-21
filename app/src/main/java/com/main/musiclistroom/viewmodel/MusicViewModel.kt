package com.main.musiclistroom.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.main.musiclistroom.room.AppRoomDatabase
import com.main.musiclistroom.room.music.Music
import com.main.musiclistroom.room.music.MusicRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MusicViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: MusicRepository
    val musicList: LiveData<List<Music>>

    init {
        val musicDao = AppRoomDatabase.getDatabaseInstance(application).musicDao()
        repository = MusicRepository(musicDao)
        musicList = repository.allMusic
    }

    fun addMusicList(music: Music) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createMusic(music)
        }
    }
}