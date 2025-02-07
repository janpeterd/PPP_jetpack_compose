package com.bawp.jetnote.repository

import com.bawp.jetnote.data.NoteDatabaseDao
import com.bawp.jetnote.model.Note
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {
  suspend fun addNote(note: Note) = noteDatabaseDao.insert(note)

  suspend fun updateNote(note: Note) = noteDatabaseDao.update(note)

  suspend fun deleteNote(note: Note) = noteDatabaseDao.deleteNote(note)

  suspend fun deleteAllNotes() = noteDatabaseDao.deleteAll()

  fun getAllNotes(): Flow<List<Note>> = noteDatabaseDao.getNotes().flowOn(Dispatchers.IO).conflate()
}

