package com.main.musiclistroom.room.music

import androidx.lifecycle.LiveData

class MusicRepository(private val musicDao: MusicDao){
    val allMusic: LiveData<List<Music>> = musicDao.getAllMusic()

    fun createMusic(music: Music){
        musicDao.createMusic(music)
    }

    fun getMusicById(id: Int){
        musicDao.getMusicByID(id)
    }
}