package com.habiture;

import android.graphics.Bitmap;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Yeh on 2015/5/16.
 */
public class MockNetworkChannel implements NetworkInterface {

    @Override
    public InputStream createGetProfileConnection(String account, String password, String gcmRegisterId) {
        throw new RuntimeException("wrong call");
    }

    @Override
    public PhotoInputStream createGetPhotoConnection(String url) {
        throw new RuntimeException("wrong call");
    }

    @Override
    public void closeConnection() {
        throw new RuntimeException("wrong call");
    }

    @Override
    public InputStream createGetFriendsConnection(int uid) {
        throw new RuntimeException("wrong call");
    }

    @Override
    public InputStream createGetGroupsConnection(int uid) {
        throw new RuntimeException("wrong call");
    }

    @Override
    public List<Habiture> httpGetHabitures(int uid) {
        throw new RuntimeException("wrong call");
    }

    @Override
    public boolean httpPostDeclaration(int uid, String frequency, String declaration, String punishment, String goal, String do_it_time) {
        throw new RuntimeException("wrong call");
    }

    @Override
    public boolean httpSendSound(int from_id, int to_id, int pid, int sound_id) {
        throw new RuntimeException("wrong call");
    }

    @Override
    public boolean httpUploadProofImage(int uid, int pid, String imageType, String imageData) {
        throw new RuntimeException("wrong call");
    }

    @Override
    public PokeData httpGetPokePage(int pid) {
        throw new RuntimeException("wrong call");
    }

    @Override
    public Bitmap httpGetBitmapUrl(String url) {
        throw new RuntimeException("wrong call");
    }

    @Override
    public boolean httpSendRegisterId(int uid, String reg_id) {
        throw new RuntimeException("wrong call");
    }

    @Override
    public List<GroupHistory> httpGetGropuHistory(int pid) {
        throw new RuntimeException("wrong call");
    }
}
