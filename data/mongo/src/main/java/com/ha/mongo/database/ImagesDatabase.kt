package com.ha.mongo.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.ha.mongo.database.entity.ImageToDelete
import com.ha.mongo.database.entity.ImageToUpload

@Database(
    entities = [ImageToUpload::class, ImageToDelete::class],
    version = 2,
    autoMigrations = [
        AutoMigration (from = 1, to = 2)
    ],
    exportSchema = true
)
abstract class ImagesDatabase: RoomDatabase() {
    abstract fun imageToUploadDao(): ImageToUploadDao
    abstract fun imageToDeleteDao(): ImageToDeleteDao
}