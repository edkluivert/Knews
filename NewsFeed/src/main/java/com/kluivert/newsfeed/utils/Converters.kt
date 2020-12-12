package com.kluivert.newsfeed.utils

import androidx.room.TypeConverter
import com.kluivert.newsfeed.data.model.Source


class Converters {

    @TypeConverter
    fun fromSource(source : Source):String{
        return source.name
    }

    @TypeConverter
    fun toSource(name : String):Source{
        return Source(name,name)
    }

}