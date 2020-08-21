package com.main.musiclistroom.album.room_database.song

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface SongDao {
    @Insert
    fun createSong(song: Song)
    @Transaction
    @Query(value = "SELECT * FROM Music WHERE musicId=:musicId")
    fun getAllSong(musicId:Int): LiveData<SongPlaylist>
    @Query(value = "SELECT * FROM Song WHERE id=:id")
    fun getSongByID(id: Int): Song
}