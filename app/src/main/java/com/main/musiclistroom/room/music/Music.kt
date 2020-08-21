package com.main.musiclistroom.room.music

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Music(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var musicId: Int=0,
    @ColumnInfo(name = "musicArtistName")
    var musicArtistName: String,
    @ColumnInfo(name = "musicTitle")
    var musicTitle:String,
    @ColumnInfo(name = "musicImage")
    var musicImage:String
){}