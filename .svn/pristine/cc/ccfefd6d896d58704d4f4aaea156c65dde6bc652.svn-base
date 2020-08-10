
package edu.skku.finalproject.studyhelper;

        import android.support.annotation.NonNull;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.TextView;

        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Map;

        import edu.skku.finalproject.studyhelper.dto.Location;
        import edu.skku.finalproject.studyhelper.dto.Member;
        import edu.skku.finalproject.studyhelper.dto.Study;

public class FirebaseTestActivity extends AppCompatActivity {
    TextView tvTest;
    /*
        FirebaseDatabase 객체로 database 불러온 후,
        노드 하나하나를 getReference로 불러온다.
        예를 들어, memeber 노드를 불러오고싶다면 DatabaseReference memberRef = database.getReference("member");
        그 후에 DatabaseReference객체에 addValueEventListener 메소드로 맨 처음 불러올 때와 데이터가 변경될 때 호출되는 리스너를 등록한다.
     */
    static FirebaseDatabase database = FirebaseDatabase.getInstance();
    static DatabaseReference myRef = database.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_test);
        tvTest = findViewById(R.id.tv_test);

        /*
        멤버 추가
        setMembers( 멤버번호, Member객체 );

        Member 객체: 이름, 참석 여부, MemberLocation 객체

        Location 객체: 장소명, 위경도

        스터디 회차 추가
        setStudy( 회차번호, Study 객체);

        Study 객체: 스터디 날짜, StudyLocation객체, Location객체, Member 리스트( Arrays.asList(Member객체1, Member객체2..) 이용 )
         */

//        initDB();


//        tvTest.setText(memberRef..toString());
//        memberRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot dt : dataSnapshot.getChildren()){
//                    members.add(dt.getValue(Member.class));
//                    Log.d("snap: ", dt.toString());
//                }
//                showMember();
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//        // 데이터가 변경될 때와 맨 처음 데이터를 불러들일 때 호출된다.
//        myRef.addValueEventListener(new ValueEventListener() {
//
//            @Override           // 데이터 스냅샷은, 현재 상태에서 데이터들을 캡처한 것이다.
//            public void onDataChange(DataSnapshot dataSnapshot) {
////                dataSnapshot.getChildren(); // 현재 노드의 자식 노드들 모두가 iterative한 Datasnapshot 객체로 반환된다.
////                Member member = dataSnapshot.getValue(Member.class); // 현재 노드의 값이 Member클래스에 매핑되어 반환된다. 이 경우 member.name처럼 값을 불러올 수 있다.
////                Member member = dataSnapshot.getValue(Member.class);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//            }
//        });

    }
//    static
//    static
//    public static void setStudyRoom(String studyName, String memberName, String locationName, String latlng){
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference();
//        ArrayList<Member> members = new ArrayList<>();
//        ArrayList<Study> studies = new ArrayList<>();
//        Member member = new Member(memberName,"불참", new Location(locationName,latlng), new Location(locationName, latlng));
//        members.add(member);
//
//    }
    public static void initDB() {

        ArrayList<Member> members = new ArrayList<>();
        Member m1 = new Member("스터디원1", "불참", new Location("서울특별시 중구 회현동2가 3-1","37.560151, 126.982918"),new Location("서울특별시 중구 회현동2가 3-1","37.560151, 126.982918"));
        Member m2 = new Member("스터디원2", "불참", new Location("대학로14길","37.583948, 127.002660"),new Location("대학로14길","37.583948, 127.002660"));

        members.add(m1);
        members.add(m2);
        myRef.child("test").child("members").setValue(members);

        ArrayList<Study> studies = new ArrayList<>();

        Study s1 = new Study("2018-10-09 12:00", new Location("대학로14길","37.583948, 127.002660"), members,"완료");
        Study s2 = new Study("2018-12-12 21:00", new Location("대학로14길","37.583948, 127.002660"), members,"진행");
        Study s3 = new Study("2018-12-15 22:00", new Location("대학로14길","37.583948, 127.002660"), members,"예정");

        studies.add(s1);
        studies.add(s2);
        studies.add(s3);
        myRef.child("test").child("studies").setValue(studies);



    }
//
//    public static void setMember(final String studyName, final Member member){
//
//        myRef.child(studyName).child("studies").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String studyIdx = dataSnapshot.child("currentIdx").getValue(String.class);
//                String memberIdx = Long.toString(dataSnapshot.child("members").getChildrenCount() -1);
//                // members에 추가
//                myRef.child(studyName).child("members").child(memberIdx).setValue(member);
//                Map<String, Object> childUpdates = new HashMap<>();
//                childUpdates.put("/"+memberIdx, member);
//                myRef.child(studyName).child("studies").child(studyIdx).child("members").updateChildren(childUpdates);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
//
//
//    public static void setStudy(final String studyName, final Study study){
//        myRef.child(studyName).child("studies").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String studyIdx = dataSnapshot.child("currentIdx").getValue(String.class);
//                myRef.child(studyName).child("studies").child(studyIdx).setValue(study);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//    }



}
