package com.bluetoothmicrecord.interfaces;

import com.bluetoothmicrecord.bean.RecordAudioFile;

/**
 * Created by ${王sir} on 2017/9/15.
 * application
 */

public interface RecordAudiosActivityAdapterInterface {

    void itemClick(RecordAudioFile bean);

    void itemLongClick(RecordAudioFile bean);

    void uploadFile(RecordAudioFile bean,int position);

    void startPlayAudio(RecordAudioFile bean);
}
