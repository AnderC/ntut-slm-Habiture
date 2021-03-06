package com.habiture.tests;

import android.app.Activity;
import android.test.AndroidTestCase;

import com.habiture.Friend;
import com.habiture.Group;
import com.habiture.HabitureModule;
import com.habiture.MockGcmModel;
import com.habiture.NetworkInterface;
import com.habiture.StubGcmModelLogin;
import com.habiture.StubLoginFailed;
import com.habiture.StubLoginSuccessfully;
import com.habiture.StubQueryFriends;
import com.habiture.StubQueryGroups;

import java.util.List;

public class HabitureModuleTest extends AndroidTestCase {

    private HabitureModule hm = null;

    private Activity mockActivity;

    public void testLoginSuccessfully() {
        assertTrue(stubLogin(new StubLoginSuccessfully()));
    }

    public void testLoginFailed() {
        assertFalse(stubLogin(new StubLoginFailed()));
        assertNull(hm.getHeader());
    }

//    public void testGetProfileAfterLoginSuccessfully() {
//        stubLogin(new StubLoginSuccessfully());
//
//        assertEquals("testAccount", hm.getAccount());
//        assertEquals("testPassword", hm.getPassword());
//    }
//
//    public void testGetProfileAfterLoginFailed() {
//        stubLogin(new StubLoginFailed());
//
//        assertEquals(null, hm.getAccount());
//        assertEquals(null, hm.getPassword());
//
//    }
//
    public void testQueryFriends() {
        stubLogin(new StubQueryFriends());
        List<Friend> friends = hm.queryFriends();

        Friend dewei = friends.get(0);

        assertEquals(5, dewei.getId());
        assertEquals("DeWei", dewei.getName());
        assertEquals("http://140.124.144.121/Habiture/profile/11145559_786919498044885_2254052047058669334_n.jpg", dewei.getUrl());
    }
//
    public void testQueryGroups() {
        stubLogin(new StubQueryGroups());
        List<Group> groups = hm.queryGroups();

        Group group = groups.get(0);

        assertEquals(3, group.getGoal());
        assertEquals("http://140.124.144.121/Habiture/profile/11145559_786919498044885_2254052047058669334_n.jpg", group.getUrl());
        assertEquals("running", group.getSwear());
        assertEquals(7, group.getFrequency());
        assertEquals(12, group.getDoItTime());
        assertEquals(189, group.getId());
        assertEquals(0, group.getIcon());
    }
//
//    public void testPostSwearSuccessfully() {
//        stubLogin(new StubPostSwearSuccessfully());
//        assertTrue(hm.postDeclaration("1", "eat something", "hit by anyone", "12", "Pm 11"));
//    }
//
//    public void testPostSwearFailed() {
//        stubLogin(new StubPostSwearFailed());
//        List<Friend> friends = new ArrayList<>();
//        assertFalse(hm.postDeclaration("1", "eat something", "hit by anyone", "12", "Pm 11"));
//    }

    // TODO testQueryHabituresSuccessfully
    // TODO testQueryHabituresFailed

    // TODO testSendSoundToPartnerSuccessully
    // TODO testSendSoundToPartnerFailed

    // TODO testUploadProofImageSuccessfully
    // TODO testUploadProffImageFailed

    // TODO testQueryGroupHistorySuccessfully
    // TODO testQueryGroupHistoryFailed

    // TODO testQueryBitmapUrlSuccessfully
    // TODO testQueryBitmapUrlFailed

    // TODO testQueryPokeDataSuccessfully
    // TODO testQueryPokeDataFailed

    // TODO sendRegisterIdToServerSuccessfully
    // TODO sendRegisterIdToServerFailed

    private boolean stubLogin(NetworkInterface networkInterface) {
        MockGcmModel gcmModel = new StubGcmModelLogin(mockActivity);
        hm = new HabitureModule(networkInterface, gcmModel);
        boolean result = hm.login("testAccount", "testPassword");
        return result;
    }

}
