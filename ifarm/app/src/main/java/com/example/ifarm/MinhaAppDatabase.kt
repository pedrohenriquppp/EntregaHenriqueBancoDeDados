package com.example.ifarm

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class MinhaAppDatabase(context: Context) :
    ManagedSQLiteOpenHelper(ctx = context, name = "minhaApp.db", version = 1) {

    companion object{
        private  var instance: MinhaAppDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): MinhaAppDatabase {
            if (instance == null) {
                instance = MinhaAppDatabase(ctx.applicationContext)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable("email", true,
               "id" to INTEGER + PRIMARY_KEY + UNIQUE,
                "email" to TEXT
            )
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}

val Context.database: MinhaAppDatabase
    get() = MinhaAppDatabase.getInstance(applicationContext)