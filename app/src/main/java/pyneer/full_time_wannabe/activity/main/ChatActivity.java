package pyneer.full_time_wannabe.activity.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pyneer.full_time_wannabe.R;
import pyneer.full_time_wannabe.adapter.ChatAdapter;
import pyneer.full_time_wannabe.model.ChatData;

/**
 * Created by ddjdd on 2018-11-04.
 */

public class ChatActivity extends AppCompatActivity {
    private String CHAT_NAME;
    private String USER_NAME;
    private static final int ITEM_VIEW_TYPE_MYCHAT = 0;
    private static final int ITEM_VIEW_TYPE_OTHERCHAT = 1;
    private static final int ITEM_VIEW_TYPE_OTHERCHAT_SERIES = 2;

    @BindView(R.id.lv_chat) ListView lv_chat;
    @BindView(R.id.ed_chat) EditText ed_chat;
    @BindView(R.id.btn_send) ImageButton btn_send;

    private FirebaseDatabase fbDB = FirebaseDatabase.getInstance();
    private DatabaseReference dbRef = fbDB.getReference();

    ChatAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);

        CHAT_NAME = "Test";
        USER_NAME = "pyneer";

        openChat(CHAT_NAME);
    }

    private String tmp = "";

    private void addMessage(DataSnapshot dataSnapshot, ChatAdapter adapter) {
        ChatData chatData = dataSnapshot.getValue(ChatData.class);
        // 내 chat 인지 확인
        String tUserName = chatData.getUserName();
        if(tUserName.equals(USER_NAME)) {
            chatData.setType(ITEM_VIEW_TYPE_MYCHAT);
        }
        else if (tUserName.equals(tmp)) {
            chatData.setType(ITEM_VIEW_TYPE_OTHERCHAT_SERIES);
        }
        else {
            chatData.setType(ITEM_VIEW_TYPE_OTHERCHAT);
            tmp = tUserName;
        }
        adapter.add(chatData);
    }

    // 채팅방 열었을때 내용 표시
    private void openChat(String chatName) {
        adapter = new ChatAdapter();
        lv_chat.setAdapter(adapter);

        // 데이터 받아오기 및 어댑터 데이터 추가 및 삭제 등..리스너 관리
        dbRef.child("chat").child(chatName).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                addMessage(dataSnapshot, adapter);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @OnClick(R.id.btn_send)
    public void onBtnSendClick() {
        if (ed_chat.getText().toString().equals(""))
            return;

        ChatData chat = new ChatData(USER_NAME, ed_chat.getText().toString()); //ChatDTO를 이용하여 데이터를 묶는다.
        dbRef.child("chat").child(CHAT_NAME).push().setValue(chat); // 데이터 푸쉬
        ed_chat.setText(""); //입력창 초기화
    }
}