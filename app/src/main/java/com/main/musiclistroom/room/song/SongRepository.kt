package com.main.musiclistroom.room.song

class SongRepository(private val songDao: SongDao){
    fun allSong(musicId: Int) = songDao.getAllSong(musicId)

    fun createSong(song: Song){
        songDao.createSong(song)
    }

    fun getSongById(id:Int){
        songDao.getSongByID(id)
    }
}