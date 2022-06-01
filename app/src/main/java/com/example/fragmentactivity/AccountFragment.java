package com.example.fragmentactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {
 private  static final int GALLERY_INTENT=1000;

    public FirebaseUser currentUser;
    public FirebaseAuth mAuth;
    TextView about , security , support , notification ,log_out , next;





    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment notificationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        // Inflate the layout for this fragment

       ;
        next = view.findViewById(R.id.storage);
        log_out = view.findViewById(R.id.text_logout);
        about = view.findViewById(R.id.text_about);
        security = view.findViewById(R.id.text_security);
        support = view.findViewById(R.id.text_support);
        notification = view.findViewById(R.id.notification);

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();

                Intent i = new Intent(getContext(),LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);



            }
        });



        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),NotificationActivity.class);
                startActivity(intent);

            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),AboutActivity.class);
                startActivity(intent);

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),StorageActivity.class);
                startActivity(intent);

            }
        });

        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://support.google.com/android/?hl=ar#topic=7313011"));
                startActivity(intent);
            }
        });

        security.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://developer.android.com/training/articles/security-tips"));
                startActivity(intent);
            }
        });



     


        mAuth=FirebaseAuth.getInstance();
        currentUser=mAuth.getCurrentUser();



//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Intent.ACTION_PICK);
//                intent.setType("*/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(intent, "Select file"), GALLERY_INTENT);
//            }
//        });


//        ImageView image_notification = view.findViewById(R.id.image_notification);
//       image_notification.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               Intent intent = new Intent(getContext(),NotificationActivity.class);
//               startActivity(intent);
//
//           }
//       });


//        ImageView image_about_next = view.findViewById(R.id.image_about_next);
//        image_about_next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(),AboutActivity.class);
//                startActivity(intent);
//
//            }
//        });


//        ImageView image_support_next = view.findViewById(R.id.image_next_support);
//        image_support_next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("https://www.merriam-webster.com/dictionary/support"));
//                startActivity(intent);
//
//            }
//        });



//        ImageView image_security_next = view.findViewById(R.id.image_next_security);
//        image_security_next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("https://www.techtarget.com/searchsecurity/definition/security"));
//                startActivity(intent);
//
//            }
//        });





        return view;
    }
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK && data != null && data.getData() != null) {
//            mainImageURI = data.getData();
//            Glide.with(this).load(currentUser.getPhotoUrl()).into(imageButton);
//
//            if (mainImageURI.getPath() != null)
//                updateProfile();
//        }
//    }
//    private void updateProfile() {
//
//        UserProfileChangeRequest userProfileChangeRequest = new UserProfileChangeRequest.Builder()
////                .setDisplayName(nameEd.getText().toString())
//                .setPhotoUri(mainImageURI)
//                .build();
//        currentUser.updateProfile(userProfileChangeRequest)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//
//                        if (task.isSuccessful()) {
//                            currentUser.reload();
//                            Toast.makeText(getActivity(), "Profile Update for" , Toast.LENGTH_SHORT).show();
//                        } else {
//                            task.getException().printStackTrace();
//                            Toast.makeText(getActivity(), "null", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                })
//
//        ;
//
//
//    }
}