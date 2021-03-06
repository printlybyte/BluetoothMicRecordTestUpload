package com.bluetoothmicrecord;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.bluetoothmicrecord.bean.RecordAudioFile;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "RECORD_AUDIO_FILE".
*/
public class RecordAudioFileDao extends AbstractDao<RecordAudioFile, Long> {

    public static final String TABLENAME = "RECORD_AUDIO_FILE";

    /**
     * Properties of entity RecordAudioFile.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property FileName = new Property(1, String.class, "fileName", false, "FILE_NAME");
        public final static Property FileDir = new Property(2, String.class, "fileDir", false, "FILE_DIR");
        public final static Property FilePath = new Property(3, String.class, "filePath", false, "FILE_PATH");
        public final static Property UpLoadStatus = new Property(4, String.class, "upLoadStatus", false, "UP_LOAD_STATUS");
        public final static Property RecordTime = new Property(5, String.class, "recordTime", false, "RECORD_TIME");
        public final static Property UploadProgress = new Property(6, Integer.class, "uploadProgress", false, "UPLOAD_PROGRESS");
        public final static Property FileNameFromFtp = new Property(7, String.class, "FileNameFromFtp", false, "FILE_NAME_FROM_FTP");
        public final static Property Position = new Property(8, Integer.class, "position", false, "POSITION");
    }


    public RecordAudioFileDao(DaoConfig config) {
        super(config);
    }
    
    public RecordAudioFileDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"RECORD_AUDIO_FILE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"FILE_NAME\" TEXT," + // 1: fileName
                "\"FILE_DIR\" TEXT," + // 2: fileDir
                "\"FILE_PATH\" TEXT," + // 3: filePath
                "\"UP_LOAD_STATUS\" TEXT," + // 4: upLoadStatus
                "\"RECORD_TIME\" TEXT," + // 5: recordTime
                "\"UPLOAD_PROGRESS\" INTEGER," + // 6: uploadProgress
                "\"FILE_NAME_FROM_FTP\" TEXT," + // 7: FileNameFromFtp
                "\"POSITION\" INTEGER);"); // 8: position
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"RECORD_AUDIO_FILE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, RecordAudioFile entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String fileName = entity.getFileName();
        if (fileName != null) {
            stmt.bindString(2, fileName);
        }
 
        String fileDir = entity.getFileDir();
        if (fileDir != null) {
            stmt.bindString(3, fileDir);
        }
 
        String filePath = entity.getFilePath();
        if (filePath != null) {
            stmt.bindString(4, filePath);
        }
 
        String upLoadStatus = entity.getUpLoadStatus();
        if (upLoadStatus != null) {
            stmt.bindString(5, upLoadStatus);
        }
 
        String recordTime = entity.getRecordTime();
        if (recordTime != null) {
            stmt.bindString(6, recordTime);
        }
 
        Integer uploadProgress = entity.getUploadProgress();
        if (uploadProgress != null) {
            stmt.bindLong(7, uploadProgress);
        }
 
        String FileNameFromFtp = entity.getFileNameFromFtp();
        if (FileNameFromFtp != null) {
            stmt.bindString(8, FileNameFromFtp);
        }
 
        Integer position = entity.getPosition();
        if (position != null) {
            stmt.bindLong(9, position);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, RecordAudioFile entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String fileName = entity.getFileName();
        if (fileName != null) {
            stmt.bindString(2, fileName);
        }
 
        String fileDir = entity.getFileDir();
        if (fileDir != null) {
            stmt.bindString(3, fileDir);
        }
 
        String filePath = entity.getFilePath();
        if (filePath != null) {
            stmt.bindString(4, filePath);
        }
 
        String upLoadStatus = entity.getUpLoadStatus();
        if (upLoadStatus != null) {
            stmt.bindString(5, upLoadStatus);
        }
 
        String recordTime = entity.getRecordTime();
        if (recordTime != null) {
            stmt.bindString(6, recordTime);
        }
 
        Integer uploadProgress = entity.getUploadProgress();
        if (uploadProgress != null) {
            stmt.bindLong(7, uploadProgress);
        }
 
        String FileNameFromFtp = entity.getFileNameFromFtp();
        if (FileNameFromFtp != null) {
            stmt.bindString(8, FileNameFromFtp);
        }
 
        Integer position = entity.getPosition();
        if (position != null) {
            stmt.bindLong(9, position);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public RecordAudioFile readEntity(Cursor cursor, int offset) {
        RecordAudioFile entity = new RecordAudioFile( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // fileName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // fileDir
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // filePath
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // upLoadStatus
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // recordTime
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // uploadProgress
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // FileNameFromFtp
            cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8) // position
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, RecordAudioFile entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setFileName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFileDir(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setFilePath(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setUpLoadStatus(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setRecordTime(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setUploadProgress(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
        entity.setFileNameFromFtp(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setPosition(cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(RecordAudioFile entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(RecordAudioFile entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(RecordAudioFile entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
