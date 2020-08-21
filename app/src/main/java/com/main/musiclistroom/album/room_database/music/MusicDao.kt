package com.main.musiclistroom.album.room_database.music

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MusicDao{
    @Insert
    fun createMusic(music: Music)

    @Query(value = "SELECT * FROM Music")
    fun getAllMusic():LiveData<List<Music>>

    @Query(value = "SELECT * FROM Music WHERE musicId=:id")
    fun getMusicByID(id:Int): Music
}